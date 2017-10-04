package library.domain;

public class Book {
	private int id;
	private String title;
	private String publisher;
	private int year;
	private boolean isAvaiable;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isAvaiable() {
		return isAvaiable;
	}
	
	public void setisAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}
}
