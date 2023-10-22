package com.example.student.crud.exception;

public class ResourceNotFoundException extends RuntimeException {
	String fieldName;
	Integer fieldValue;
	public ResourceNotFoundException(String fieldName, Integer studentId) {
		super(String.format("%s : %s", fieldName,studentId));
		this.fieldName=fieldName;
		this.fieldValue=studentId;
	}

}
