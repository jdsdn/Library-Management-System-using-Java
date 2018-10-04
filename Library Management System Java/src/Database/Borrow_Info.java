package Database;

public class Borrow_Info {
	
	private int issue_code;
	private int student_id;
	private int book_id;
	private String borrow_date;
	private String return_date;
	
	public Borrow_Info(int issue_code, int student_id, int book_id, String borrow_date, String return_date) 
	{
		super();
		this.issue_code = issue_code;
		this.student_id = student_id;
		this.book_id = book_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}

	public int getIssue_code() {
		return issue_code;
	}

	public void setIssue_code(int issue_code) {
		this.issue_code = issue_code;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
}