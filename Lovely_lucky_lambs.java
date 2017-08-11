package com.google.challenges;

import java.util.ArrayList;
import java.util.List;

public class Lovely_lucky_lambs {

	public static void answer(int total_lambs) {
		System.out.println("Difference: " + (mostStingy(total_lambs) - mostGenerous(total_lambs)));
	}

	public static int mostGenerous(int total_lambs) {
		List<Integer> henchmen = new ArrayList<Integer>();
		int pool = total_lambs;
		int currentPayout = 1;
		int minimumNext = 1;
		while (pool >= currentPayout) {
			int prev = 1;
			if (henchmen.size() - 1 >= 0)
				prev = henchmen.get(henchmen.size() - 1);
			int temp = currentPayout;
			pool -= currentPayout;
			henchmen.add(currentPayout);
			minimumNext = temp + prev;
			currentPayout *= 2;
		}
		if (minimumNext <= pool) {
			henchmen.add(minimumNext);
		}
		System.out.println("Generous: ");
		System.out.println("\t" + henchmen.size());
		System.out.println("\t" + henchmen);
		return henchmen.size();
	}

	public static int mostStingy(int total_lambs) {
		List<Integer> henchmen = new ArrayList<Integer>();
		int pool = total_lambs;
		int currentPayout = 1;
		int prev = 1;
		int prev2 = 0;
		while (pool >= prev + prev2) {
			if (henchmen.size() - 1 >= 0)
				prev = henchmen.get(henchmen.size() - 1);
			if (henchmen.size() - 2 >= 0)
				prev2 = henchmen.get(henchmen.size() - 2);

			currentPayout = prev + prev2;
			pool -= currentPayout;
			if (pool >= 0)
				henchmen.add(currentPayout);
		}
		System.out.println("Stingy: ");
		System.out.println("\t" + henchmen.size());
		System.out.println("\t" + henchmen);
		System.out.println();
		return henchmen.size();
	}

	public static void main(String[] args) {

	}

}
