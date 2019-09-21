package qu.gradebook;

//GradeBookTest creates a GradeBook object and tests its methods
public class GradeBookTest {
	public static void main(String[] args) {
		Course course = new Course("CMPS 151", "Programming Concepts");
		GradeBook gradeBook = new GradeBook(course);
		
		// Initialize the gradeBook students list
		for (int i=1; i <=10; i++) {
			double randomGrade = Math.random();
			randomGrade = randomGrade * 100 + 1;
			Student student = new Student(i, "Firstname" + i, "Lastname" + i, randomGrade);
			gradeBook.addStudent(student);
		}
		
		gradeBook.displayGrades();
		
		// Display summary statistics
		System.out.printf("%nClass average: %.2f", gradeBook.getAverage());
		System.out.printf("%nLowest grade : %.2f", gradeBook.getMinimum());
		System.out.printf("%nHighest grade: %.2f", gradeBook.getMaximum());
	}
}