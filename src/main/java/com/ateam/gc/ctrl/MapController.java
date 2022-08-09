package com.ateam.gc.ctrl;

import com.ateam.gc.common.AjaxResult;
import com.ateam.gc.dto.GoCampDetailResDTO;
import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;
import com.ateam.gc.service.MapService;
import com.ateam.gc.service.common.EmptyDataException;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
@Validated
public class MapController {

	private final MapService mapService;

	@GetMapping(value = "/find")
	public ResponseEntity<AjaxResult<List<GoCampSearchResDTO>>> main(@Valid @ModelAttribute GoCampSearchReqDTO param) {
		AjaxResult<List<GoCampSearchResDTO>> data = AjaxResult.<List<GoCampSearchResDTO>>builder().data(mapService.findResult(param)).build();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/detail/{contentId}")
	public ResponseEntity<AjaxResult<GoCampDetailResDTO>> main(
			@Valid @NotBlank(message = "콘텐츠 ID를 입력해주세요.")
			@PathVariable("contentId") @ApiParam(value = "콘텐츠 ID", example = "7323") String contentId) throws EmptyDataException {
		return new ResponseEntity<>(AjaxResult.<GoCampDetailResDTO>builder().data(mapService.getDetail(contentId)).build(), HttpStatus.OK);
	}
}
