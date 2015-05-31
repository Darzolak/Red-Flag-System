package model;

import output.OutputWriter;

// IS

public class BasicFlag extends Flag {

	public BasicFlag(Person pRequester, OutputWriter pOutputWriter) {
		super(pRequester, pOutputWriter);
	}

	@Override
	public Boolean isResolved() {
		return null;
	}

}
