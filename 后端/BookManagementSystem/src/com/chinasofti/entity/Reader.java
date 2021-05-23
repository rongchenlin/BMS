package com.chinasofti.entity;

public class Reader {
	private int readerID;
	private String readerName;
	private String readerSex;
	private int readerAge;
	
	public Reader() {
		super();
	}

	public Reader(int readerID, String readerName, String readerSex, int readerAge) {
		super();
		this.readerID = readerID;
		this.readerName = readerName;
		this.readerSex = readerSex;
		this.readerAge = readerAge;
	}

	public int getReaderID() {
		return readerID;
	}

	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderSex() {
		return readerSex;
	}

	public void setReaderSex(String readerSex) {
		this.readerSex = readerSex;
	}

	public int getReaderAge() {
		return readerAge;
	}

	public void setReaderAge(int readerAge) {
		this.readerAge = readerAge;
	}
	
	
}
