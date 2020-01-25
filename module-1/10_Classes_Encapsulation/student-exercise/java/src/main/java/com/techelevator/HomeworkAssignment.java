package com.techelevator;

public class HomeworkAssignment {

	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;

	// Constructor below

	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}

	public int getEarnedMarks() {
		return earnedMarks;
	}

	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}

	public String getSubmitterName() {
		return submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	public int getPossibleMarks() {
		return possibleMarks;
	}

	public String getLetterGrade() {
		int result = (earnedMarks * 100) / possibleMarks;
		if (result >= 90) {
			return "A";
		}
		if (result >= 80 && result <= 89) {
			return "B";
		}
		if (result >= 70 && result <= 79) {
			return "C";
		}
		if (result >= 60 && result <= 69) {
			return "D";
		} else {
			return "F";
		}

	}

}
