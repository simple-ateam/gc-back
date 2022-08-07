package com.ateam.gc.ctrl;

import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampingDetailItem;
import com.ateam.gc.dto.GoCampingItem;
import com.ateam.gc.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
public class MapController {

	private final MapService mapService;

	@GetMapping(value = "/find")
	public ResponseEntity<List<GoCampingItem>> main(GoCampSearchReqDTO param) {
		return new ResponseEntity<>(mapService.findResult(param), HttpStatus.OK);
	}

	@GetMapping(value = "/detail/{contentId}")
	public ResponseEntity<GoCampingDetailItem> main(@PathVariable("contentId") String contentId) {
		return new ResponseEntity<>(mapService.getDetail(contentId), HttpStatus.OK);
	}
}
