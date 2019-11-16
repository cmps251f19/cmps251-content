package custom.exception2;

public class Course {
	
	private String courseCode; 	
	private String courseName; 
	private String departmentCode; 
	private int creditHours;

	public Course(){
		courseName = null;
		courseCode = null;
		departmentCode = null;
		creditHours = 0;	
	}
	
	public Course(String courseCode, String courseName, String departmentCode,
			int creditHours) {
		
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.departmentCode = departmentCode;
		this.creditHours = creditHours;
	}

	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	public String toString() {
		return String.format("Course Code: %s, Course Name: %s, Department: %s, Credit Hours: %d",
				courseCode, courseName,
				departmentCode, creditHours);
	}
}
