package model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import output.OutputWriter;

public abstract class Flag{
	private Person requester;
	private LocalDateTime timeCreated;
	private Person responder; // person allocated to fix this problem
	private String question;
	private Long priority;
	private Alert alert;
	private List<OutputWriter>outputWriters;
	

	
	public Flag (Person pRequester, OutputWriter pOutputWriter){
		requester = pRequester;
		timeCreated = LocalDateTime.now();
		priority = timeCreated.toEpochSecond(ZoneOffset.UTC);
		outputWriters = new ArrayList<OutputWriter>();
		addOutputWriter(pOutputWriter);
		notifyOutputWriters();
	}
	
	public Person getRequester(){
		return requester;
	}
	
	public LocalDateTime getTimeCreated(){
		return timeCreated;
	}
	
	public void setQuestion(String pQuestion){
		question = pQuestion;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public void setResponder(Person pResponder){
		responder = pResponder;
	}
	
	public Person getResponder(){
		return responder;
	}
	
	public abstract Boolean isResolved();
	
	public void setPriority(Long pPriority){
		priority = pPriority;
	}
	
	public Long getPriority(){
		return priority;
	}
	
	public void setAlert(Alert pAlert){
		alert = pAlert;
	}
	
	public void alertResponder(){
		System.out.println(alert.alertTheResponder());
	}

	public void addOutputWriter(OutputWriter pOutputWriter){
		outputWriters.add(pOutputWriter);
	}
	
	public void deleteOutputWriter(OutputWriter pOutputWriter){
		outputWriters.remove(pOutputWriter);
	}
	
	public void notifyOutputWriters(){
		for (OutputWriter outputWriter: outputWriters){
			outputWriter.update(this);
		}
	}
	
	public String toString(){
		return getClass().getSimpleName() + ": Priority is " + getPriority() + ", Requester is " + getRequester() + ".";
	}

	/**
	 * A comparator that returns the comparison of two Flags Priorities
	 */
	//Task 1
	public static Comparator<Flag> flagPriorityComparitor = (flag1, flag2) -> {
		return flag1.getPriority().compareTo(flag2.getPriority());
	};
	
}
