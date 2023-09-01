package com.nunam.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

//A Dto class for better viewing when exception happens
@AllArgsConstructor
@Data
public class MyExceptionHandler {
	private LocalDateTime time;
	private String message;
	private String details;
}
