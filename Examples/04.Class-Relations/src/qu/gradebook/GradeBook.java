package qu.gradebook;

import java.util.ArrayList;
import java.util.List;

//GradeBook class storing and managing test grades 
public class GradeBook {
	private Course course; // Course for this GradeBook
	private List<Student> students; // list of student grades

	public void addStudent(Student student) {
		students.add(student);
	}
	
	public GradeBook(Course course) {
		this.course = course;
		this.students = new ArrayList<>();
	}

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	//Returns the minimum grade
	public double getMinimum() {
		double lowGrade = students.get(0).getGrade(); // assume 1st grade is the smallest
		// loop through grades array
		for (var student : students) {
			double grade = student.getGrade();
			// if grade lower than lowGrade, assign it to lowGrade
			if (grade < lowGrade) {
				lowGrade = grade; // new lowest grade
			}
		}
		return lowGrade;
	}

	//Returns the maximum grade
	public double getMaximum() {
		double maxGrade =students.get(0).getGrade(); // assume 1st grade is the largest
		// loop through grades array
		for (var student : students) {
			double grade = student.getGrade();
			// if grade greater than highGrade, assign it to highGrade
			if (grade > maxGrade) {
				maxGrade = grade; // new highest grade
			}
		}
		return maxGrade;
	}

	//Return the average grade
	public double getAverage() {
		double total = 0;
		// sum grades for one student
		for (var student : students) {
			total += student.getGrade();
		}

		// return the average grade
		return (double) total / students.size();
	}

	// output the contents of the grades list
	public void displayGrades() {
		System.out.printf("The grades for %s %s %n", course.getCode(), course.getName());
		System.out.println("Id \t Firstname \t Lastname \t Grade");
		System.out.println("-- \t --------- \t -------- \t -----");
		// output each student's grade
		for (var student: students) {
			System.out.printf("%2d \t %s \t %s \t %3.2f%n",student.getId(), student.getFirstname(), student.getLastname(), student.getGrade());
		}
	}

}
