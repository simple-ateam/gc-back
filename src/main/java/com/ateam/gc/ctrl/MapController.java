package com.ateam.gc.ctrl;

import com.ateam.gc.common.AjaxResult;
import com.ateam.gc.dto.GoCampDetailResDTO;
import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;
import com.ateam.gc.service.MapService;
import com.ateam.gc.common.EmptyDataException;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
@Validated
public class MapController {

	private final MapService mapService;

	@GetMapping(value = "/find")
	public ResponseEntity<AjaxResult<List<GoCampSearchResDTO>>> main(@Valid @ModelAttribute GoCampSearchReqDTO param) {
		AjaxResult<List<GoCampSearchResDTO>> data = AjaxResult.<List<GoCampSearchResDTO>>builder().data(mapService.findResult(param)).build();
		log.info("/find Params:{}", param.toString());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/detail/{contentId}")
	public ResponseEntity<AjaxResult<GoCampDetailResDTO>> main(
			@Valid @Positive(message = "콘텐츠 ID는 양수로 입력해주세요.")
			@PathVariable("contentId") @ApiParam(value = "콘텐츠 ID", example = "7323") Integer contentId) throws EmptyDataException {
		log.info("/detail/{} Params:{}", contentId, contentId);
		return new ResponseEntity<>(AjaxResult.<GoCampDetailResDTO>builder().data(mapService.getDetail(contentId)).build(), HttpStatus.OK);
	}
}
