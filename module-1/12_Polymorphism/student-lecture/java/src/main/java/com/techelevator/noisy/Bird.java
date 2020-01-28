package com.techelevator.noisy;

public class Bird implements INoise{

	@Override
	public String makeNoise() {
		// TODO Auto-generated method stub
		return "Chirp!";
	}
	
	public void poop() {
		System.out.println("Make mess");
	}

}
