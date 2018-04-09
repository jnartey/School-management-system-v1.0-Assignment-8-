package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    public List<Student> getStudents(){
    	String filePath = "src/database/students.csv";
    	File file = new File(filePath);
    	
    	ArrayList<Student> data = new ArrayList<Student>();
    	
    	try {
			Scanner read = new Scanner(file);
			
			while(read.hasNextLine()) {
				
				//storing the line in a String array.
				String line[] = read.nextLine().split(",");
				
				//immediately storing the data from that array in a Student object.
				data.add(new Student(line[0], line[1], line[2]));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
    	
    	return data;
    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	
    	Student studentDetails = new Student();
    	
		for(Student student : studentList) {
			if(student.getEmail().equals(studentEmail.toLowerCase())) {
				studentDetails = new Student(student.getEmail(), student.getName(), student.getPass());
			}
		}
		
		return studentDetails;
    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	//Boolean validated is initially set to false
    	boolean validated = false;
    	
		for(Student student : studentList) {
			if(student.getEmail().equals(studentEmail.toLowerCase()) && student.getPass().equals(studentPass.trim())) {
				validated = true;
			}
		}
		
		return validated;
    }
}
