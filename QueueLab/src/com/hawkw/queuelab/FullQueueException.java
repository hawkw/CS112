package com.hawkw.queuelab;
@SuppressWarnings("serial")
public class FullQueueException extends Exception {

	public FullQueueException() {
	}

	public FullQueueException(String message) {
		super(message);
	}
}
