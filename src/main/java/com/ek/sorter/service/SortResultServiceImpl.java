package com.ek.sorter.service;

import java.util.List;

import com.ek.sorter.dao.SortResultDao;
import com.ek.sorter.model.SortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: Random Sort service
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */

@Service
public class SortResultServiceImpl implements SortResultService {

    @Autowired
    private SortResultDao sortResultDao;

    public List<SortResult> getAllSortResults() {
        return sortResultDao.getAllSortResults();
    }

	@Override
	public void addRandomSorting(SortResult sortResult) {
		sortResultDao.addRandomSorting(sortResult);
		
	}

}
