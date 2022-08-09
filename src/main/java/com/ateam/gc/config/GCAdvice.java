package com.ateam.gc.config;

import com.ateam.gc.common.AjaxResult;
import com.ateam.gc.common.Constant;
import com.ateam.gc.service.common.EmptyDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
@Slf4j
public class GCAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<AjaxResult<String>> exceptionAjaxResult(Exception e) {
		return new ResponseEntity<>(AjaxResult.<String>builder().result(false).status(400).data(e.getMessage()).desc(e.getClass().getName()).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<AjaxResult<String>> exceptionAjaxResult(EmptyDataException e) {
		return new ResponseEntity<>(AjaxResult.<String>builder().result(false).status(400).data(e.getMessage()).desc(Constant.DESC_EMPTY_ERROR).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<AjaxResult<String>> exceptionAjaxResult(MethodArgumentTypeMismatchException e) {
		return new ResponseEntity<>(AjaxResult.<String>builder().result(false).status(400).data(e.getMessage()).desc(Constant.DESC_MISMATCH_ERROR).build(), HttpStatus.BAD_REQUEST);
	}
}
