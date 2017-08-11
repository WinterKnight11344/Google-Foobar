package com.google.challenges;

import java.util.ArrayList;
import java.util.Arrays;

public class Please_pass_the_coded_messages {   
    public static int answer(int[] l) { 
        
    	if(l.length == 1)
			if(l[0] % 3 == 0)
				return l[0];
		if(l.length == 0)
			return 0;
		int[] altArray  = new int[l.length - 1];
		int[] alt2Array = new int[l.length - 2];

		Arrays.sort(l);	
		reverseArray(l);
		if(arraySum(l) % 3 != 0){
			setArrayToArray(altArray, getSmallerArray(l));
			if(arraySum(altArray) % 3 != 0){
				setArrayToArray(alt2Array, getSmallerArray(altArray));

			}
		}

			
		
		if(arraySum(altArray)%3 == 0 && arraySum(altArray) != 0)
			return intArrayToInt(altArray);
		else
		if(arraySum(alt2Array)%3 == 0 && arraySum(alt2Array) != 0)
			return intArrayToInt(alt2Array);
		else
		if(arraySum(l) % 3 == 0)
			return intArrayToInt(l);
		else
			return 0;
				
	}
	
	/*public static int[] getSmallerArray(int[] initArray){
		int[] altArray = new int[initArray.length - 1];
		boolean trip = false;
			for (int i = initArray.length-1; i >= 0; i--){
				int[] lMinusOne = new int[initArray.length-1];
				for(int j = 0; j < initArray.length; j++){
					if(j != i)
						if(j > i){
							lMinusOne[j-1] = initArray[j];
						}else
						if(j < i){
							lMinusOne[j] = initArray[j];
						}
				}
				Arrays.sort(lMinusOne);
				reverseArray(lMinusOne);
				if(intArrayToInt(lMinusOne) % 3 == 0 && intArrayToInt(altArray) < intArrayToInt(lMinusOne))
					setArrayToArray(altArray, lMinusOne);
				else
				if((i == 0 && arraySum(altArray) == 0 && trip) ){
					setArrayToArray(altArray, lMinusOne);
				}
				
				if(i == initArray.length - 1 && arraySum(altArray) == 0){
					setArrayToArray(altArray, lMinusOne);
					trip = true;
				}
			}
			if(intArrayToInt(altArray) % 3 == 0){
				return altArray;
			}
			else{
				getSmallerArray(altArray);
				return altArray;
			}
		
	}*/
    
    public static int[] getSmallerArray(int[] initArray){
    	Arrays.sort(initArray);
    	reverseArray(initArray);
    	ArrayList<Integer> altArray = new ArrayList<Integer>();
    	ArrayList<Integer> origArray = new ArrayList<Integer>();
    	ArrayList<Integer> lastArray = new ArrayList<Integer>();
    	for(int i = 0; i < initArray.length; i++){
    		altArray.add(initArray[i]);
    		origArray.add(initArray[i]);
    		lastArray.add(initArray[i]);
    	}
    	altArray.trimToSize();
    	for(int i = 0; i <= 9; i++){
    		setArrayToArray(altArray, origArray);
        	altArray.trimToSize();
    		if(i % 3 != 0 && altArray.indexOf(i) > -1){
    			altArray.remove(altArray.indexOf(i));
        	}
        			
        	if(checkArray(altArray)){
    			break;
    		}
        	
    	}
    	altArray.trimToSize();
    	int[] retArray = new int[altArray.size()];
    	for(int i = 0; i < altArray.size(); i++){
    		retArray[i] = altArray.get(i);
    	}
    	Arrays.sort(retArray);
    	reverseArray(retArray);
    	return retArray;
    }
	
	public static boolean checkArray(int[] array){
		return intArrayToInt(array) % 3 == 0;
	}
	
	public static boolean checkArray(ArrayList<Integer> array){
		return intArrayToInt(array) % 3 == 0;
	}
	
	public static void reverseArray(int[] array){
		for (int i = 0; i < array.length / 2; i++) {
			  int temp = array[i];
			  array[i] = array[array.length - 1 - i];
			  array[array.length - 1 - i] = temp;
			}
	}
	
	public static void setArrayToArray(int[] array1, int[] array2){
		if(array1.length == array2.length){
			for(int i = 0; i < array1.length; i++){
				array1[i] = array2[i];
			}	
		}
	}
	
	public static void setArrayToArray(ArrayList<Integer> array1, ArrayList<Integer> array2){
		array2.trimToSize();
		array1.clear();
		for(int i = 0; i < array2.size(); i++){
			array1.add(array2.get(i));
		}	
	}
	
	
	public static int arraySum(int[] array){
		int sumOfDigits = 0;
		for (int i = 0; i < array.length; i++){
			sumOfDigits += array[i];
		}
		return sumOfDigits;
	}
	
	public static int intArrayToInt(int[] a){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.length; i++){
			sb.append(a[i]);
		}
		if(sb.length() <= 9 && !sb.toString().isEmpty())
			return Integer.parseInt(sb.toString());
		else
		return 0;
	}
	
	public static int intArrayToInt(ArrayList<Integer> a){
		StringBuilder sb = new StringBuilder();
		a.trimToSize();
		for(int i = 0; i < a.size(); i++){
			sb.append(a.get(i));
		}
		if(sb.length() <= 9 && !sb.toString().isEmpty())
			return Integer.parseInt(sb.toString());
		else
		return 0;
	}

	
	public static void main(String[] args) {
		int[] testCase1 = {3, 1, 4, 1};
		int[] testCase2 = {3,1,4,1,5,9};
		int[] testCase3 = {1,9,9,9,9,1};
		int[] testCase4 = {3};
		int[] testCase5 = {0,3};
		int[] testCase6 = {2,1,4,7,4,8,3,6,4,7};
		int[] testCase7 = {1,9,9,9,9,4};
		System.out.println(Arrays.toString(testCase1));
		System.out.println(answer(testCase1));
		System.out.println(Arrays.toString(testCase2));
		System.out.println(answer(testCase2));
		System.out.println(Arrays.toString(testCase3));
		System.out.println(answer(testCase3));
		System.out.println(Arrays.toString(testCase4));
		System.out.println(answer(testCase4));
		System.out.println(Arrays.toString(testCase5));
		System.out.println(answer(testCase5));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Arrays.toString(testCase6));
		System.out.println(answer(testCase6));
		System.out.println(Arrays.toString(testCase7));
		System.out.println(answer(testCase7));
	}

}
