package com.ek.sorter.dao;

import com.ek.sorter.logic.Sorting;
import com.ek.sorter.model.SortResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		Sorting sorting = new Sorting();	
		
		long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;        
        
        sortResult.setResultString(sorting.getSortResult(sortResult));
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
