package CoreJava.MainEntryPoint;

import java.util.List;

import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Student;

public class TestRunner {
    public static void main(String[] args) {
        
    	
    	//Test Your Code Here!
    	StudentDAO testDAO = new StudentDAO();
    	//Student studentL = new Student();
    	List<Student> studentList = testDAO.getStudents();
    	
    	Student studentL = testDAO.getStudentByEmail(studentList, "tom@gmail.com");
    	
    	for(Student list : studentList) {
    		System.out.println(list.getEmail() + ", " + list.getName() + ", " + list.getPass());
    	}
    	    	
    	System.out.println("Got you by email " + studentL.getEmail() + ", " + studentL.getName() + ", " + studentL.getPass());
    	
    	boolean test = testDAO.validateUser(studentList, "tom@gmail.com", "tommyw2003");
    	
    	System.out.println(test);
    	
    }
}
