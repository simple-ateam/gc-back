package com.ateam.gc.ctrl;

import com.ateam.gc.dto.GoCampingItem;
import com.ateam.gc.service.MapService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	private final MapService mapService;

	@GetMapping(value = "/find/{kilometer}km/{mapY}/{mapX}")
	public ResponseEntity<List<GoCampingItem>> main(@PathVariable("kilometer") double kilometer,
													@PathVariable("mapY") double mapY,
													@PathVariable("mapX") double mapX) {
		return new ResponseEntity<>(mapService.findResult(kilometer, mapY, mapX), HttpStatus.OK);
	}
}
