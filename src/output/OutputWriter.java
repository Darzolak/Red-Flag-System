package output;

import model.Flag;

public abstract class OutputWriter {

	// We will have a number of OutputWriters soon
	public abstract void update(Flag flag);
}
