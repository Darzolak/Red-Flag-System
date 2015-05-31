package model;

public class Tutor extends Person {

	private String course;
	
	public Tutor(String pName, String pLocation) {
		super(pName, pLocation);
	}

	public void setCourse(String pCourse){
		course = pCourse;
	}
	
	public Boolean isTutorOfCourse (String pCourse){
		return course.equalsIgnoreCase(pCourse);
	}
}
