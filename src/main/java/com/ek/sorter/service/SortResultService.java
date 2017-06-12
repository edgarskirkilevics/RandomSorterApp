package com.ek.sorter.service;

import com.ek.sorter.model.SortResult;

import java.util.List;

/**
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */
public interface SortResultService {

    List<SortResult> getAllSortResults();
    
    void addRandomSorting(SortResult sortResult);
}
