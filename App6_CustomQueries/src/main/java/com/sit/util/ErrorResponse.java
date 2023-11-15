package com.sit.util;

public class ErrorResponse {
	private boolean flag;
	private String message;

	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [flag=" + flag + ", message=" + message + "]";
	}

}
