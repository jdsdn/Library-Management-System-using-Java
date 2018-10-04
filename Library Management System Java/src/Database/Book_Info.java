package Database;

import java.io.File;

public class Book_Info
{
	private int book_id;
	private File book_image;
	private long book_isbn;
	private String book_name;
	private String book_title;
	private String book_type;
	private String book_authors;
	private int book_edition;
	private String category;
	private String subcategory;
	private String language;
	private String status;
	private int bookcopies;
	private String publication_name;
	private String publication_details;
	private String website_url;
	private String copyrightyear;
	private String purchase_date;
	private String recieve_date;
	private float book_price;
	
	public Book_Info(int book_id, File book_image, long book_isbn,
			String book_name, String book_title, String book_type,
			String book_authors, int book_edition, String category,
			String subcategory, String language, String status, int bookcopies,
			String publication_name, String publication_details,
			String website_url, String copyrightyear, String purchase_date,
			String recieve_date, float book_price) 
	{
		super();
		this.book_id = book_id;
		this.book_image = book_image;
		this.book_isbn = book_isbn;
		this.book_name = book_name;
		this.book_title = book_title;
		this.book_type = book_type;
		this.book_authors = book_authors;
		this.book_edition = book_edition;
		this.category = category;
		this.subcategory = subcategory;
		this.language = language;
		this.status = status;
		this.bookcopies = bookcopies;
		this.publication_name = publication_name;
		this.publication_details = publication_details;
		this.website_url = website_url;
		this.copyrightyear = copyrightyear;
		this.purchase_date = purchase_date;
		this.recieve_date = recieve_date;
		this.book_price = book_price;
	}

	@Override
	public String toString() {
		return "Book_Info [book_id=" + book_id + ", book_image=" + book_image
				+ ", book_isbn=" + book_isbn + ", book_name=" + book_name
				+ ", book_title=" + book_title + ", book_type=" + book_type
				+ ", book_authors=" + book_authors + ", book_edition="
				+ book_edition + ", category=" + category + ", subcategory="
				+ subcategory + ", language=" + language + ", status=" + status
				+ ", bookcopies=" + bookcopies + ", publication_name="
				+ publication_name + ", publication_details="
				+ publication_details + ", website_url=" + website_url
				+ ", copyrightyear=" + copyrightyear + ", purchase_date="
				+ purchase_date + ", recieve_date=" + recieve_date
				+ ", book_price=" + book_price + "]";
	}

	// getters and setters

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public File getBook_image() {
		return book_image;
	}

	public void setBook_image(File book_image) {
		this.book_image = book_image;
	}

	public long getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(int book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getBook_authors() {
		return book_authors;
	}

	public void setBook_authors(String book_authors) {
		this.book_authors = book_authors;
	}

	public int getBook_edition() {
		return book_edition;
	}

	public void setBook_edition(int book_edition) {
		this.book_edition = book_edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookcopies() {
		return bookcopies;
	}

	public void setBookcopies(int bookcopies) {
		this.bookcopies = bookcopies;
	}

	public String getPublication_name() {
		return publication_name;
	}

	public void setPublication_name(String publication_name) {
		this.publication_name = publication_name;
	}

	public String getPublication_details() {
		return publication_details;
	}

	public void setPublication_details(String publication_details) {
		this.publication_details = publication_details;
	}

	public String getWebsite_url() {
		return website_url;
	}

	public void setWebsite_url(String website_url) {
		this.website_url = website_url;
	}

	public String getCopyrightyear() {
		return copyrightyear;
	}

	public void setCopyrightyear(String copyrightyear) {
		this.copyrightyear = copyrightyear;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getRecieve_date() {
		return recieve_date;
	}

	public void setRecieve_date(String recieve_date) {
		this.recieve_date = recieve_date;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}
}