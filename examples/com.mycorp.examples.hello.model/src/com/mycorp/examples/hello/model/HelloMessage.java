package com.mycorp.examples.hello.model;


public class HelloMessage {

	private String from;
	private String message;
    private int[] array = { 1 };
    private String description;

	public HelloMessage() {
	}

	public HelloMessage(String from, String message) {
		this.from = from;
		this.message = message;
	}

    public HelloMessage(String from, String message, String description) {
        this.from = from;
        this.message = message;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

	public String getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}

	public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
