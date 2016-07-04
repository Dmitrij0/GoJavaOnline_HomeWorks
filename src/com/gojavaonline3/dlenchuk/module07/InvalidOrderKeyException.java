package com.gojavaonline3.dlenchuk.module07;

public class InvalidOrderKeyException extends Exception {

	private final ErrorCode errorCode;

	private static final long serialVersionUID = 7413308966350339662L;

	public InvalidOrderKeyException() {
		super();
		this.errorCode = ErrorCode.INTERNAL_ERROR;
	}

	public InvalidOrderKeyException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = ErrorCode.INTERNAL_ERROR;
	}

	public InvalidOrderKeyException(String message) {
		super(message);
		this.errorCode = ErrorCode.INTERNAL_ERROR;
	}

	public InvalidOrderKeyException(Throwable cause) {
		super(cause);
		this.errorCode = ErrorCode.INTERNAL_ERROR;
	}

	public InvalidOrderKeyException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public InvalidOrderKeyException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public InvalidOrderKeyException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public InvalidOrderKeyException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "[" + this.errorCode + "] " + super.toString();
	}
}