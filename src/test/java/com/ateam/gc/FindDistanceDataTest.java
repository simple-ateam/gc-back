package com.ateam.gc;

import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;
import com.ateam.gc.service.MapService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class FindDistanceDataTest {
	@Autowired
	private MapService mapService;

	@Test
	@DisplayName(value = "0km 조회")
	void find0Km() {
		GoCampSearchReqDTO reqDTO = new GoCampSearchReqDTO();
		reqDTO.setKilometer(0);
		reqDTO.setMapY(37.4922173);
		reqDTO.setMapX(126.8849478);
		reqDTO.setScale(5);

		List<GoCampSearchResDTO> data = mapService.findResult(reqDTO);

		assertTrue(data.isEmpty());
	}

	@Test
	@DisplayName(value = "20km 조회")
	void find20Km() {
		GoCampSearchReqDTO reqDTO = new GoCampSearchReqDTO();
		reqDTO.setKilometer(20);
		reqDTO.setMapY(37.4922173);
		reqDTO.setMapX(126.8849478);
		reqDTO.setScale(5);

		List<GoCampSearchResDTO> data = mapService.findResult(reqDTO);

		assertEquals(60, data.size());
	}

	@Test
	@DisplayName(value = "50km 조회")
	void find50Km() {
		GoCampSearchReqDTO reqDTO = new GoCampSearchReqDTO();
		reqDTO.setKilometer(50);
		reqDTO.setMapY(37.4922173);
		reqDTO.setMapX(126.8849478);
		reqDTO.setScale(5);

		List<GoCampSearchResDTO> data = mapService.findResult(reqDTO);

		assertEquals(396, data.size());
	}
}
