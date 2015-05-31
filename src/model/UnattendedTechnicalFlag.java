package model;

import output.OutputWriter;

public class UnattendedTechnicalFlag extends TechnicalFlag {

	public UnattendedTechnicalFlag(Person pSender, OutputWriter pOutputWriter) {
		super(pSender, pOutputWriter);
	}

	@Override
	public Boolean isResolved() {
		return false;
	}

	public String toString(){
		return super.toString() + " Flag is unattended.";
	}
}
