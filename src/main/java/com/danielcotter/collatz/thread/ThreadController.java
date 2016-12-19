package com.danielcotter.collatz.thread;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

@Controller
public class ThreadController {

	Map<Integer, Integer> knownIntegers = new HashMap<>();

	public void init() throws InterruptedException {
		int i = 1;

		while (true) {
			i = newNumber(i);
			computeCollatz(i);
			System.out.println("");
			Thread.sleep(500);
		}
	}

	private int computeCollatz(int integer) {
		if (integer == 1)
			return 1;

		return (integer % 2 == 0) ? computeCollatz(integer / 2) : computeCollatz(3 * integer + 1);
	}

	private int newNumber(int integer) {
		integer++;

		if (knownIntegers.containsKey(integer))
			return newNumber(integer);

		return integer;
	}
}
