package CoreJava.Models;

public class Course {
	
	private int ID;
	private String name;
	private String instructor;
	
	public Course() {
		ID = 0;
		name = "";
		instructor = "";
	}
	
    /**
	 * @param iD
	 * @param name
	 * @param instructor
	 */
	public Course(int iD, String name, String instructor) {
		this.ID = iD;
		this.name = name;
		this.instructor = instructor;
	}

	public void setID(int ID){
		this.ID = ID;
    }

    public int getID(){
    	return ID;
    }

    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setInstructor(String instructor){
    	this.instructor = instructor;
    }

    public String getInstructor(){
    	return instructor;
    }

}
