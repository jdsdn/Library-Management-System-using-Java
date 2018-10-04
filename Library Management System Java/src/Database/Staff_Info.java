package Database;

public class Staff_Info 
{
	private int Staff_ID;
	private String Staff_Name;
	private String Designation;
	private String Department;
	private String Password;
	
	public Staff_Info(int staff_ID, String staff_Name, String designation, String department, String password) 
	{
		this.Staff_ID = staff_ID;
		this.Staff_Name = staff_Name;
		this.Designation = designation;
		this.Department = department;
		this.Password = password;
	}
	
	public int getStaff_ID() { return Staff_ID; }
	public String getStaff_Name() { return Staff_Name; }
	public String getDesignation() { return Designation; }
	public String getDepartment() { return Department; }
	public String getPassword() { return Password; }
	
	public void setStaff_ID(int staff_ID) { this.Staff_ID = staff_ID; }
	public void setStaff_Name(String staff_Name) { this.Staff_Name = staff_Name; }
	public void setDesignation(String designation) { this.Designation = designation; }
	public void setDepartment(String department) { this.Department = department; }
	public void setPassword(String password) { this.Password = password; }
}