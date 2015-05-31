package model;


public abstract class Person {

	private String name;
	private String location;
	
	public Person(String pName, String pLocation){
		name = pName;
		location = pLocation;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + ": " + this.getName();
	}
	

	
}
