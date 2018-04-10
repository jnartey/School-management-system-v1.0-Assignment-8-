package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {
	
	final String filePath = "src/database/attending.csv";
	
    public List<Attending> getAttending(){
    	File file = new File(filePath);
    	
    	ArrayList<Attending> data = new ArrayList<Attending>();
    	
    	try {
			Scanner read = new Scanner(file);
			
			while(read.hasNextLine()) {
				
				//storing the line in a String array.
				String line[] = read.nextLine().split(",");
				
				//immediately storing the data from that array in a Attending object.
				data.add(new Attending(Integer.parseInt(line[0]), line[1]));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
    	
    	return data;
    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID){
    	boolean isAttending = false;
    	File file = new File(filePath);
    	
    	for(Attending list : attending) {
    		if(list.getStudentEmail().equals(studentEmail) && list.getCourseID() == courseID) {
    			isAttending = true;
    		}
    	}
    	
    	//If the Student is not attending that Course, add a new Attending object with the Student's Email and Course ID to the List attending.csv.
    	if(isAttending == false) {
    		attending.add(new Attending(courseID, studentEmail));
			this.saveAttending(attending);
    	}
    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
    	ArrayList<Course> data = new ArrayList<Course>();
    	
    	for(Attending listAttending : attending) {
    		if(listAttending.getStudentEmail().equals(studentEmail)) {
    			for(Course listCourse : courseList) {
    				if(listAttending.getCourseID() == listCourse.getID()) {
    					data.add(new Course(listCourse.getID(), listCourse.getName(), listCourse.getInstructor()));
    				}
    			}
    		}
    	}
    	
    	return data;
    }

    public void saveAttending(List<Attending> attending){
    	
    	try {	
			//Instantiating FileWriter to write to file
			FileWriter writer = new FileWriter(filePath); //Overwrite is true
			
			//Clearing data
			writer.write("");
			writer.close();
			
			writer = new FileWriter(filePath);
			
			//Writing to file in CSV format line by line using a for loop
			for(Attending data : attending) {
				writer.write(data.getCourseID() + "," + data.getStudentEmail() + "\r\n");
			}
			
			//Close file after writing
			writer.close(); 	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
