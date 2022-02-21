package com.zenigma.blogpostapi.exception;

public class PostException extends Exception {
	
	public PostException() {}
	
	public PostException(String message) {
		super(message);
	}

	public PostException(String message, Throwable cause) {
		super(message, cause);
	}
}
