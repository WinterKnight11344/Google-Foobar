package com.google.challenges;

import java.math.BigInteger;

public class Bomb_baby {
	
    public static String answer(String M, String F) { 
    	BigInteger bigM = null;
    	BigInteger bigF = null;
    	BigInteger count = BigInteger.ZERO;
    	try{
    		bigM = new BigInteger(M);
    		bigF = new BigInteger(F);
    	}catch(Exception e){
    		return "impossible";
    	}
    	while(!bigM.equals(BigInteger.ONE) || !bigF.equals(BigInteger.ONE)){
    		BigInteger mult = BigInteger.ZERO;
	    	if(!isSolvable(bigM, bigF)){
	    		return "impossible";
	    	}else{
	    		if(bigF.compareTo(new BigInteger("50")) == 1 || bigM.compareTo(new BigInteger("50")) == 1){
		    		if(bigF.compareTo(bigM) == 1){
		    			mult = bigF.divide(bigM);
		    			count = count.add(mult);
		    			bigF = bigF.subtract(bigM.multiply((mult)));
		    		}else{
		    			mult = bigM.divide(bigF);
		    			count = count.add(mult);
		    			bigM = bigM.subtract(bigF.multiply((mult)));
		    		}
	    		}else
	    			if(bigF.compareTo(bigM) == 1){
		    			count = count.add(BigInteger.ONE);
		    			bigF = bigF.subtract(bigM);
		    		}else{
		    			count = count.add(BigInteger.ONE);
		    			bigM = bigM.subtract(bigF);
		    		}
	    	}
    	}
    	return count.toString();
    }
    
    private static boolean isSolvable(BigInteger M, BigInteger F){
		return !(F.equals(M) || F.equals(BigInteger.ZERO) || M.equals(BigInteger.ZERO));    	
    }
}
