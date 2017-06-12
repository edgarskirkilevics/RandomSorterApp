package com.ek.sorter.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Description: Random sorting result object
 * Author: Edgars Kirkilevics
 * Date: 11.06.2017
 */


@Entity
public class SortResult {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Pattern(regexp = "((?<!^;)\\d+(;(?!$)|$))+", message = "Wrong string of numbers! Check it!")
    private String givenString;
    @Column
    @Pattern(regexp = "((?<!^;)[1-9][0-9]*(;(?!$)|$))+", message = "Wrong string of numbers! Check it!")
    private String positionString;
    
	@Column
	private String resultString;
    
    @Column
    private String expendedTime;

    public SortResult() {
    }
    
    public SortResult(String givenString, String positionString) {
    	this.givenString = givenString;
    	this.positionString = positionString;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGivenString() {
		return givenString;
	}

	public void setGivenString(String givenString) {
		this.givenString = givenString;
	}

	public String getPositionString() {
		return positionString;
	}

	public void setPositionString(String positionString) {
		this.positionString = positionString;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getExpendedTime() {
		return expendedTime;
	}

	public void setExpendedTime(String expendedTime) {
		this.expendedTime = expendedTime;
	}
    

}