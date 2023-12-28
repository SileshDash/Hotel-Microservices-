package com.org.user.exception;
public class ResourceNotFoundException extends RuntimeException{
	 String resourceName;
	 String fieldName;
	 Integer fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s :%s", resourceName,fieldName,fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
}