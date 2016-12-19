package com.danielcotter.collatz.thread;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

@Controller
public class ThreadController {

	private Map<Integer, Integer> knownIntegers = new HashMap<>();

	public void init() throws InterruptedException {
		int i = 1;

		while (true) {
			i = newNumber(i);
			computeCollatz(i);
			if (i >= 1000)
				break;
		}

		System.out.println(knownIntegers);
	}

	private void computeCollatz(int integer) {
		int computation = 0;

		while (integer != 1 && !knownIntegers.containsKey(integer)) {
			computation = (integer % 2 == 0) ? (integer / 2) : (3 * integer + 1);
			knownIntegers.put(integer, computation);
			integer = computation;
		}
	}

	private int newNumber(int integer) {
		integer++;

		if (knownIntegers.containsKey(integer))
			return newNumber(integer);

		return integer;
	}
}
