package com.ateam.gc.job;

import com.ateam.gc.common.Constant;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
@RequiredArgsConstructor
public class Job01 {

	private static final Logger logger = LoggerFactory.getLogger(Job01.class);
	private final RedisTemplate<String, String> redisTemplate;

	@Scheduled(fixedDelay = Constant.COMMON_JOB_SEC)
	public void runJob() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());

		final ValueOperations<String, String> operations = redisTemplate.opsForValue();
		if (operations.get(Constant.API_GO_CAMP_CALL_DATE) == null
				|| !strToday.equals(operations.get(Constant.API_GO_CAMP_CALL_DATE))
		) {
			try {
				int pageNo = 1;
				int numOfRows = 100;
				JSONArray array = new JSONArray();
				JSONObject data;
				JSONObject body;
				do {
					data = getData(pageNo, numOfRows);
					body = data.getJSONObject("response").getJSONObject("body");
					pageNo++;
					array.put(body);
					operations.set(Constant.API_GO_CAMP_LIST + (pageNo - 1), body.getJSONObject("items").getJSONArray("item").toString());
				} while (body.getInt("totalCount") > numOfRows * (pageNo - 1));
				operations.set(Constant.API_TOTAL_PAGE_COUNT, String.valueOf(pageNo - 1));
				operations.set(Constant.API_GO_CAMP_CALL_DATE, strToday);
			} catch (Exception e) {
				logger.info("batch error {}", e.getMessage());
			}
		}
	}

	private JSONObject getData(int pageNo, int numOfRows) throws IOException {
		String urlBuilder = "http://apis.data.go.kr/B551011/GoCamping/basedList" + "?" + URLEncoder.encode("serviceKey", Constant.API_ENCODING_TYPE) + "=" + "TbIS7ipyYQWeitTLMuJMGD0fyh5UmDfN%2BPLv42aVb8B7H8718yRfwkwt9E%2FxlBOkt7rY8leU2biOTRuqZ2RN5g%3D%3D" + /*Service Key*/
				"&" + URLEncoder.encode("pageNo", Constant.API_ENCODING_TYPE) + "=" + URLEncoder.encode(Integer.toString(pageNo), Constant.API_ENCODING_TYPE) + /*?????? ???????????????*/
				"&" + URLEncoder.encode("numOfRows", Constant.API_ENCODING_TYPE) + "=" + URLEncoder.encode(Integer.toString(numOfRows), Constant.API_ENCODING_TYPE) + /*??? ????????? ?????? ???*/
				"&" + URLEncoder.encode("MobileOS", Constant.API_ENCODING_TYPE) + "=" + URLEncoder.encode("ETC", Constant.API_ENCODING_TYPE) + /*IOS(?????????),AND(???????????????),WIN(????????????),ETC*/
				"&" + URLEncoder.encode("MobileApp", Constant.API_ENCODING_TYPE) + "=" + URLEncoder.encode("GC", Constant.API_ENCODING_TYPE) + /*????????????=?????????*/
				"&" + URLEncoder.encode("_type", Constant.API_ENCODING_TYPE) + "=" + URLEncoder.encode("json", Constant.API_ENCODING_TYPE);
		URL url = new URL(urlBuilder /*?????? ??????(??????:m) Max??? 20000m=20km*/);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setConnectTimeout(1000000);
		conn.setReadTimeout(1000000);
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return new JSONObject(sb.toString());
	}
}
