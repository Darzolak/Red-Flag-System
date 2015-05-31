package model;

import output.OutputWriter;

// IS

public class TechnicalFlag extends Flag {

	public TechnicalFlag(Person pRequester, OutputWriter pOutputWriter) {
		super(pRequester, pOutputWriter);
	}

	@Override
	public Boolean isResolved() {
		return false;
	}

}
