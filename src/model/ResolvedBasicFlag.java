package model;

import java.time.LocalDateTime;

import output.OutputWriter;

public class ResolvedBasicFlag extends BasicFlag {

	private LocalDateTime timeResolved;
	
	public ResolvedBasicFlag(Person pSender, OutputWriter pOutputWriter) {
		super(pSender, pOutputWriter);
		timeResolved = LocalDateTime.now();
	}
	
	public ResolvedBasicFlag(Flag pFlag, OutputWriter pOutputWriter){
		this (pFlag.getRequester(), pOutputWriter);
		this.setQuestion(pFlag.getQuestion());
		this.setPriority(pFlag.getPriority());
	}
	
	public LocalDateTime getTimeResolved(){
		return timeResolved;
	}

	@Override
	public Boolean isResolved() {
		return true;
	}

	public String toString(){
		return super.toString() + " Flag is resolved.";
	}
}
