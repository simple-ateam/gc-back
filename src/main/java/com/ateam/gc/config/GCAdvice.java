package com.ateam.gc.config;

import com.ateam.gc.common.AjaxResult;
import com.ateam.gc.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GCAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<AjaxResult<String>> exceptionAjaxResult(Exception e) {
		return new ResponseEntity<>(AjaxResult.<String>builder().result(false).status(400).data(e.getMessage()).desc(e.getClass().getName()).build(), HttpStatus.BAD_REQUEST);
	}
}
