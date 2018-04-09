package CoreJava.Models;

public class Attending {
	
	private int courseID;
	private String studentEmail;
	
	public Attending() {
		courseID = 0;
		studentEmail = "";
	}
	
    /**
	 * @param courseID
	 * @param studentEmail
	 */
	public Attending(int courseID, String studentEmail) {
		this.courseID = courseID;
		this.studentEmail = studentEmail;
	}

	public void setCourseID(int courseID){
		this.courseID = courseID;
    }

    public int getCourseID(){
    	return courseID;
    }

    public void setStudentEmail(String studentEmail){
    	this.studentEmail = studentEmail;
    }

    public String getStudentEmail(){
    	return studentEmail;
    }
}
