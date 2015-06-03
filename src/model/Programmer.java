package model;

import java.util.Comparator;

public class Programmer extends Person {

	public Programmer(String pName, String pLocation) {
		super(pName, pLocation);
	}

	/**
	 * A comparator that returns the comparison of two Programmers's names
	 */
	//Task 1
	public static Comparator<Programmer> ProgrammerNameComparator = (programmer1, programmer2) -> {
		return programmer1.getName().compareTo(programmer2.getName());
	};
}
