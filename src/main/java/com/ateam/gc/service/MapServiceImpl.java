package com.ateam.gc.service;

import com.ateam.gc.common.Constant;
import com.ateam.gc.common.EmptyDataException;
import com.ateam.gc.dto.GoCampDetailResDTO;
import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;
import com.ateam.gc.util.DistanceComparator;
import com.ateam.gc.util.MapUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {
	private static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);
	private final RedisTemplate<String, String> redisTemplate;

	public List<GoCampSearchResDTO> findResult(GoCampSearchReqDTO param) {
		List<GoCampSearchResDTO> result = new ArrayList<>();
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		int apiTotalPageCount = Integer.parseInt(Objects.requireNonNull(operations.get(Constant.API_TOTAL_PAGE_COUNT)));
		for (int pageNo = 1; pageNo <= apiTotalPageCount; pageNo++) {
			String str = operations.get(Constant.API_GO_CAMP_LIST + pageNo);

			JSONArray array = new JSONArray(str);
			for (int j = 0; j < array.length(); j++) {
				JSONObject item = array.getJSONObject(j);
				double diff = MapUtil.distance(param.getMapX(), param.getMapY(), item.getDouble("mapX"), item.getDouble("mapY"));

				if (param.getKilometer() > diff) {
//					logger.info("{}km 떨어짐 (합격) - {}", diff, item.getString("facltNm"));
					try {
						GoCampSearchResDTO goCampSearchResDTO = mapper.readValue(item.toString(), GoCampSearchResDTO.class);
						goCampSearchResDTO.setDistance(diff);
						result.add(goCampSearchResDTO);
					} catch (JsonProcessingException e) {
						logger.error("json parse error {}", item);
					}
				}
			}
		}
		result.sort(new DistanceComparator());

		return result;
	}

	@Override
	public GoCampDetailResDTO getDetail(Integer contentId) throws EmptyDataException {
		GoCampDetailResDTO result = null;
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		int apiTotalPageCount = Integer.parseInt(Objects.requireNonNull(operations.get(Constant.API_TOTAL_PAGE_COUNT)));
		for (int pageNo = 1; pageNo <= apiTotalPageCount; pageNo++) {
			String str = operations.get(Constant.API_GO_CAMP_LIST + pageNo);

			JSONArray array = new JSONArray(str);
			for (int j = 0; j < array.length(); j++) {
				JSONObject item = array.getJSONObject(j);
				int itemContentId = item.getInt("contentId");

				if (contentId == itemContentId) {
					try {
						result = mapper.readValue(item.toString(), GoCampDetailResDTO.class);
					} catch (JsonProcessingException e) {
						logger.error("json parse error {}", item);
					}
				}
			}
		}

		if (result == null) throw new EmptyDataException();

		return result;
	}
}
