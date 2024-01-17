package com.ashishCode.demo.hello;

public class StudentErrorResponse {

	private int Status;
	private String message;
	private long timeStamp;

	public StudentErrorResponse(int status, String message, long timeStamp) {
		super();
		Status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public StudentErrorResponse() {
		super();
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
