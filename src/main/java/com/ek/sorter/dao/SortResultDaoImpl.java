package com.ek.sorter.dao;

import com.ek.sorter.model.SortResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */


@Transactional
@Repository
public class SortResultDaoImpl implements SortResultDao {
    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    @Override
    public List<SortResult> getAllSortResults() {
        String query = "SELECT res FROM SortResult res ORDER BY res.id";
        return (List<SortResult>) entityManager.createQuery(query).getResultList();
    }


	@Override
	public void addRandomSorting(SortResult sortResult) {
		
		long startTime = System.nanoTime();
		
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
    	sortResult.setResultString(String.join(";", resultList));
    	
		long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
       
        sortResult.setExpendedTime(estametedTimeCalc(totalTime));
		
		entityManager.persist(sortResult);
	}
	
	/*
	 * Method process spent time and result
	 */
    public String estametedTimeCalc (long totalTime){
    	if (totalTime < 1000000) {
            return totalTime + " ns";
        }
        if (totalTime >= 1000000 && totalTime < 1000000000) {
            return totalTime/1000000 + " ms";
        }
        if (totalTime >= 1000000000 && totalTime < 60000000000L) {
            return totalTime/1000000000 + " s";
        }
        if (totalTime >= 60000000000L && totalTime < 3600000000000L) {
            return totalTime/60000000000L + " min";
        }
        return totalTime/3600000000000L + " hours";
    }
}
