package com.ek.sorter.controller;

import com.ek.sorter.model.SortResult;
import com.ek.sorter.service.SortResultService;
import com.ek.sorter.service.ErrorCheckingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

/**
 * Description: Controller for processing requests
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */

@Controller
@RequestMapping("/sorting")
public class RandomSortController {

    @Autowired
    private
    SortResultService sortResultService;
    
    @Autowired
	private ErrorCheckingServiceImpl errorService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("randomSortResult", sortResultService.getAllSortResults());
        return "sorting/resultList";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newRandomSort(ModelAndView model) {
    	SortResult randomSort = new SortResult();
		model.addObject("randomSort", randomSort);
		model.setViewName("sorting/new");
		return model;
	}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView greetingSubmit(@Valid @ModelAttribute("randomSort") SortResult randomSort, BindingResult bindingResult, ModelAndView model) {
    	if (bindingResult.hasErrors()) {
    		 model.setViewName("sorting/new");
             return model;
         } else {
        String error = errorService.getError(randomSort).toString();
        if(error.equals("error1")){
			model.addObject("error1", "Position has larger number of elements than in Random Number String");
			model.setViewName("sorting/new");
			return model;
        }else if(error.equals("error2")){
				model.addObject("error2", "Inputed value is larger than maximum allowed for integer");
				model.setViewName("sorting/new");
				return model;
        }else{
		    	sortResultService.addRandomSorting(randomSort);
	        	return new ModelAndView("redirect:/sorting");
			}
    	}
    }
}
