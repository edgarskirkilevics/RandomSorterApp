package com.ek.sorter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ek.sorter.model.SortResult;

/**
 * Description: Error processing service
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */

@Service
public class ErrorCheckingServiceImpl implements ErrorCheckingService {
	
	public String getError(SortResult randomSort){		
			/*
			 * Checking max value in possition array and size-1 in given String list,
			 * checking is needed for deny situations when number in position string are 
			 * bigger than max list size
			 */
			String givedString = randomSort.getGivenString();
	    	List<String> givedStringNumbers = new ArrayList<String>(Arrays.asList(givedString.split(";")));
	    	List<Integer> intListGivenNumbers = new ArrayList<Integer>();
	    	givedStringNumbers.add(0, "0");
	    	try {
	    		for(String s : givedStringNumbers) intListGivenNumbers.add(Integer.valueOf(s));

		    	//Get string of positions and parse it to array
		       	String postions = randomSort.getPositionString();
		    	String[] ary = postions.split(";");
		    	int[] array = Arrays.stream(ary).mapToInt(Integer::parseInt).toArray();
		    	
		    	int max = Integer.MIN_VALUE, maxIndex = 0;
		    	for (int i = 0; i < array.length; i++) {
		    	     if ((array[i]) > max) {
		    	         max = (array[i]);
		    	         maxIndex = i;
		    	     }
		    	}
		    	int itemCount = givedStringNumbers.size()-1;
	
		    	if(itemCount < max){
					return "error1";
		    	
				}else{
					return "noErrors";
				}
	    } catch (NumberFormatException e) {
	    	return "error2";
	    }
	}
}
