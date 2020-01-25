package com.techelevator;

public class FruitTree {

	private String typeOfFruit;
	private int piecesOfFruitLeft;

	// Constructor

	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}

	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

	public boolean pickFruit(int numberOfPiecesToRemove) {
		int fruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
		if (fruitLeft >= 0) {
			this.piecesOfFruitLeft = fruitLeft;
			return true;
		}
		this.piecesOfFruitLeft = 0;
		return false;
	}

}
