package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {

			System.out.println("Please insert a value:");
			String value = in.nextLine();
			int x = Integer.parseInt(value);
			int[] fib = new int[x];
			fib[0] = 0;
			fib[1] = 1;

			for (int i = 2; i < x - 1; i++)

			{
				fib[i] = fib[i - 1] + fib[i - 2];
				if (fib[i] > x) {
					int[] fibFinal = Arrays.copyOfRange(fib, 0, ((i + 1) - 1));
					System.out.println(Arrays.toString(fibFinal));
					break;
				}

			}

		}

	}
}
