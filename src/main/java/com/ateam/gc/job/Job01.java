package com.ateam.gc.job;

import com.ateam.gc.common.Constant;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RequiredArgsConstructor
@Component
public class Job01 {

	private static final Logger logger = LoggerFactory.getLogger(Job01.class);

	@Scheduled(fixedDelay = Constant.COMMON_JOB_SEC)
	public void runJob() throws IOException {
		int pageNo = 1;
		int numOfRows = 100;
		JSONArray array = new JSONArray();
		JSONObject data;
		do {
			data = getData(pageNo, numOfRows);
			pageNo++;
			array.put(data.getJSONObject("response").getJSONObject("body"));
		} while (data.getJSONObject("response").getJSONObject("body").getInt("totalCount") > numOfRows * (pageNo - 1));
		System.out.println(array);
	}

	private JSONObject getData(int pageNo, int numOfRows) throws IOException {
		String urlBuilder = "http://apis.data.go.kr/B551011/GoCamping/basedList" + "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "TbIS7ipyYQWeitTLMuJMGD0fyh5UmDfN%2BPLv42aVb8B7H8718yRfwkwt9E%2FxlBOkt7rY8leU2biOTRuqZ2RN5g%3D%3D" + /*Service Key*/
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(pageNo), "UTF-8") + /*현재 페이지번호*/
				"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(numOfRows), "UTF-8") + /*한 페이지 결과 수*/
				"&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8") + /*IOS(아이폰),AND(안드로이드),WIN(윈도우폰),ETC*/
				"&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("GC", "UTF-8") + /*서비스명=어플명*/
				"&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");
		URL url = new URL(urlBuilder /*거리 반경(단위:m) Max값 20000m=20km*/);
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
