package com.chinasofti.entity;
/**
 * 
 * @author 林镕琛
 * @version 1.0
 * 书籍Book这个实体类
 */
public class Book {

	private int bookID;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;

	public Book() {
		super();
	}
	
	public Book(int bookID, String bookName, String bookAuthor, String bookPublisher) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
}
