package application;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import model.Lecturer;
import model.Person;
import model.Programmer;
import model.Student;
import model.Tutor;

public class PeopleManager {

	private Set<Programmer>programmers;
	private Set<Lecturer>lecturers;
	private Set<Tutor>tutors;
	private Set<Student>students;
	
	public PeopleManager(){
		//Task 1
		programmers = new TreeSet<Programmer>(Programmer.ProgrammerNameComparator);
		lecturers = new HashSet<Lecturer>();
		tutors = new HashSet<Tutor>();
		students = new HashSet<Student>();
		
		importProgrammers("inputs/programmers");
		importLecturers("inputs/lecturers");
		importTutors("inputs/tutors");
		importStudents("inputs/students");
		System.out.println(programmers);
		System.out.println(lecturers);
	}
	
	private void importProgrammers(String filename){
		List<String>linesFromFile = new ArrayList<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filename),Charset.defaultCharset())) {
            stream.forEach(eachLine -> linesFromFile.add(eachLine));
            for (String personData : linesFromFile){
            	String[] pData = personData.split(";", -1);
            	String name = pData[0].trim();
            	String location = pData[1].trim();
            	Programmer programmer = new Programmer(name, location);
            	programmers.add(programmer);
            }
		} catch (IOException ex) {
			System.out.println("The file " + filename + " does not exist");
		} 
	}
	
	private void importLecturers(String filename){
		List<String>linesFromFile = new ArrayList<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filename),Charset.defaultCharset())) {
            stream.forEach(eachLine -> linesFromFile.add(eachLine));
            for (String personData : linesFromFile){
            	String[] pData = personData.split(";", -1);
            	String name = pData[0].trim();
            	String location = pData[1].trim();
            	String course = pData[2].trim();
            	Lecturer lecturer = new Lecturer(name, location);
            	lecturer.setCourse(course);
            	lecturers.add(lecturer);
            }
		} catch (IOException ex) {
			System.out.println("The file " + filename + " does not exist");
		} 
	}
	
	private void importTutors(String filename){
		Set<String>linesFromFile = new HashSet<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filename),Charset.defaultCharset())) {
            stream.forEach(eachLine -> linesFromFile.add(eachLine));
            for (String personData : linesFromFile){
            	String[] pData = personData.split(";", -1);
            	String name = pData[0].trim();
            	String location = pData[1].trim();
            	String course = pData[2].trim();
            	Tutor tutor = new Tutor(name, location);
            	tutor.setCourse(course);
            	tutors.add(tutor);
            }
		} catch (IOException ex) {
			System.out.println("The file " + filename + " does not exist");
		} 
	}
	
	private void importStudents(String filename){
		Set<String>linesFromFile = new HashSet<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filename),Charset.defaultCharset())) {
            stream.forEach(eachLine -> linesFromFile.add(eachLine));
            for (String personData : linesFromFile){
            	String[] pData = personData.split(";", -1);
            	String name = pData[0].trim();
            	String location = pData[1].trim();
            	Student student = new Student(name, location);
            	students.add(student);
            }
		} catch (IOException ex) {
			System.out.println("The file " + filename + " does not exist");
		} 
		
	}
	
	public Programmer getAProgrammer(){
		Random random = new Random(System.currentTimeMillis());
		Integer programmerNumber = random.nextInt(programmers.size());
		Integer counter = 0;
		Programmer designatedProgrammer = null;
		
		for (Programmer programmer : programmers){
			if (counter == programmerNumber){
				designatedProgrammer = programmer;
				return designatedProgrammer;
			}
			counter++;
		}
		return designatedProgrammer;
	}
	
	public Lecturer getALecturer(){
		Random random = new Random(System.currentTimeMillis());
		Integer lecturerNumber = random.nextInt(lecturers.size());
		Integer counter = 0;
		Lecturer designatedLecturer = null;
		
		for (Lecturer lecturer : lecturers){
			if (counter == lecturerNumber){
				designatedLecturer = lecturer;
				return designatedLecturer;
			}
			counter++;
		}
		return designatedLecturer;
	}
	
	public Tutor getATutor(){
		Random random = new Random(System.currentTimeMillis());
		Integer tutorNumber = random.nextInt(tutors.size());
		Integer counter = 0;
		Tutor designatedTutor = null;
		
		for (Tutor tutor : tutors){
			if (counter == tutorNumber){
				designatedTutor = tutor;
				return designatedTutor;
			}
			counter++;
		}
		return designatedTutor;
	}
	
	public Person getAResponder(){
		Random random = new Random(System.currentTimeMillis());
		Integer choiceNumber = random.nextInt(3);
		switch (choiceNumber){
		case 0: return getAProgrammer();
		case 1: return getALecturer();
		default: return getATutor();
		}
	}
	
	public Student getAStudent(){
		Random random = new Random(System.currentTimeMillis());
		Integer studentNumber = random.nextInt(students.size());
		Integer counter = 0;
		Student designatedStudent = null;
		
		for (Student student : students){
			if (counter == studentNumber){
				designatedStudent = student;
				return designatedStudent;
			}
			counter++;
		}
		return designatedStudent;
	}
}
