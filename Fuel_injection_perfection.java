package com.google.challenges;

import java.math.BigInteger;

public class Fuel_injection_perfection {

	public static int answer(String n) {
		BigInteger pellets = null;
		int count = 0;
		final BigInteger TWO = new BigInteger("2");
		try {
			pellets = new BigInteger(n);
		} catch (Exception e) {
			return 0;
		}

		while (pellets.compareTo(BigInteger.ONE) > 0) {
			if (pellets.mod(TWO).equals(BigInteger.ZERO)) {
				pellets = pellets.divide(TWO);
				count++;
			} else {
				if(pellets.equals(new BigInteger("3"))){
					pellets = pellets.subtract(BigInteger.ONE);
					count += 1;
				}else
				if(pellets.add(BigInteger.ONE).divide(TWO).mod(TWO).equals(BigInteger.ZERO)){
					pellets = pellets.add(BigInteger.ONE).divide(TWO);
					count += 2;
				}else{
					pellets = pellets.subtract(BigInteger.ONE);
					count++;
				}
			}
		}
		return count;
	}
}
