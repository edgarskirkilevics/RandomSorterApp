import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ek.sorter.logic.Sorting;
import com.ek.sorter.model.SortResult;

public class RandomSorterTest {
	 
	@Autowired
	private SortResult sortResult;
	
    @Test
    public void testSorter(){
    	
    	String givenString = "1;2;4;3;10;5;11";
    	String positionString = "1;2;3;4;5;6;7";
    	
    	sortResult = new SortResult(givenString, positionString);
    	Sorting sorting = new Sorting();    	
    	Assert.assertEquals("1;2;3;4;5;10;11", sorting.getSortResult(sortResult));
    }
}
