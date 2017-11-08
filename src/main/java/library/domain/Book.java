package library.domain;

public class Book implements IHaveId {
	private int id;
	private String title;
	private String publisher;
	private int year;
	private boolean isAvailable;
	
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
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setisAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
