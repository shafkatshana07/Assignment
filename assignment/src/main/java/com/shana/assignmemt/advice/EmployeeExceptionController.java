package com.shana.assignmemt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.shana.assignemt.exception.IdNotFoundException;

@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler
	   public ResponseEntity<Object> exception(IdNotFoundException exception) {
		   return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);

	   }

	

}
