package Database;

public class Student_Info 
{
	private String student_name;
	private int student_year;
	private String student_course;
	private int student_id;
	private String student_gender;
	private String student_contact;
	private String student_status;
	
	public Student_Info(String student_name, int student_year, String student_course, int student_id, String student_gender, String student_contact, String student_status) 
	{
		this.student_name = student_name;
		this.student_year = student_year;
		this.student_course = student_course;
		this.student_id = student_id;
		this.student_gender = student_gender;
		this.student_contact = student_contact;
		this.student_status = student_status;
	}
	
	public void setStudent_year(int student_year) { this.student_year = student_year; }
	public void setStudent_course(String student_course) { this.student_course = student_course; }
	public void setStudent_id(int student_id) { this.student_id = student_id; }
	public void setStudent_name(String student_name) { this.student_name = student_name; }
	public void setStudent_gender(String student_gender) { this.student_gender = student_gender; }
	public void setStudent_contact(String student_contact) { this.student_contact = student_contact; }
	public void setStudent_status(String student_status) { this.student_status = student_status; }
	
	public int getStudent_year() { return student_year; }
	public String getStudent_course() { return student_course; }
	public int getStudent_id() { return student_id; }
	public String getStudent_name() { return student_name; }
	public String getStudent_gender() { return student_gender; }
	public String getStudent_contact() { return student_contact; }
	public String getStudent_status() { return student_status; }

	public String toString() {
		return "Student_Info [student_name=" + student_name + ", student_year="
				+ student_year + ", student_course=" + student_course
				+ ", student_id=" + student_id + ", student_gender="
				+ student_gender + ", student_contact=" + student_contact
				+ ", student_status=" + student_status + "]";
	}
}