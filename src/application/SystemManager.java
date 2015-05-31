package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import output.TextWriter;
import model.ResolvedBasicFlag;
import model.Flag;
import model.Student;
import model.UnattendedBasicFlag;
import model.WebAlert;

public class SystemManager{

	private PeopleManager peopleManager;
	
	private Queue <Flag> currentFlags = new LinkedList<Flag>();
	private List <Flag> resolvedFlags = new ArrayList<Flag>();
	
	public SystemManager() {
		peopleManager = new PeopleManager();
	}

	public void addToCurrentMessageQueue(Flag pMessage){
		currentFlags.add(pMessage);
	}
	
	public void respondToFlag(Flag pFlag){
		Flag resolvedFlag = new ResolvedBasicFlag(pFlag, new TextWriter("outputs/flagOutput"));
		resolvedFlags.add(resolvedFlag);
	}
	
	public void startThis() throws InterruptedException{
		
		//Let's create a mini simulation. Feel free to add/modify commands below. 
		
		// Create flags and add them to the queue
		for (int i=0; i<10; i++){
			// get a random student
			Student student = peopleManager.getAStudent();
			// create a flag (student)
			Flag basicFlag = new UnattendedBasicFlag(student, new TextWriter("outputs/flagOutput"));
			// set the responder
			basicFlag.setResponder(peopleManager.getAResponder());
			// set the alert type for the flag
			basicFlag.setAlert(new WebAlert());
			// add the flag to the queue
			currentFlags.add(basicFlag);
			// sleep for a bit
			Thread.sleep(2000);
		}
		
		// Task 1a
		// Print out the currentFlags
		System.out.println(currentFlags);
		
		// for each thing in the queue
		    // alert the responder
		for (Flag flag : currentFlags){
			flag.alertResponder();
		}
		
		// for each Flag in the queue
		    // resolve the flag
		for (int i=0;  i<currentFlags.size(); i++){
			Flag resolvedFlag = new ResolvedBasicFlag(currentFlags.poll(), new TextWriter("outputs/flagOutput"));
			resolvedFlags.add(resolvedFlag);
		}
		
		// Print out the currentFlags
		System.out.println("Current Flags: " + currentFlags);
		
		// Print out the resolvedFlags
		System.out.println("Resolved Flags: " + resolvedFlags);
	}

}
