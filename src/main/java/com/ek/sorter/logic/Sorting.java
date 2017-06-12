package com.ek.sorter.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ek.sorter.model.SortResult;

/**
 * Description: Class that manipulates with strings and return required result
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */

public class Sorting {
	
	public String getSortResult(SortResult sortResult){
		//Get String of numbers and parse it to list
    	String givedString = sortResult.getGivenString();
    	List<String> givedStringNumbers = new ArrayList<String>(Arrays.asList(givedString.split(";")));
    	List<Integer> intListGivenNumbers = new ArrayList<Integer>();
    	List<String> resultList = new ArrayList<String>();
    	givedStringNumbers.add(0, "0");
    	for(String s : givedStringNumbers) intListGivenNumbers.add(Integer.valueOf(s));
    	
    	
    	//Get string of positions and parse it to Integer array
       	String postions = sortResult.getPositionString();
    	String[] pos = postions.split(";");
    	int[] array = Arrays.stream(pos).mapToInt(Integer::parseInt).toArray();
    	
    	//Get values from list by positions from array
    	List<Integer> resInt = new ArrayList<Integer>();
    		for (int n = 0; n < pos.length; n++){
    			resInt.add(intListGivenNumbers.get(array[n]));
    		}
    	
    	//Ascending sorting
    	Collections.sort(resInt);

    	//Parse result to string and save it in object
    	for(Integer myInt : resInt) resultList.add(String.valueOf(myInt));
    	String ResultString = String.join(";", resultList);
    	//sortResult.setResultString(ResultString); 
		return ResultString;
	}

}
