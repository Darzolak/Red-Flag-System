package model;

import output.OutputWriter;

public class UnattendedBasicFlag extends BasicFlag {

	public UnattendedBasicFlag(Person pSender, OutputWriter pOutputWriter) {
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
