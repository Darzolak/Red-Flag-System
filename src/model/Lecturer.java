package model;

public class Lecturer extends Person {

	private String course;
	
	public Lecturer(String pName, String pLocation) {
		super(pName, pLocation);
	}
	
	public void setCourse(String pCourse){
		course = pCourse;
	}

	public Boolean isLecturerOfCourse (String pCourse){
		return course.equalsIgnoreCase(pCourse);
	}

}
