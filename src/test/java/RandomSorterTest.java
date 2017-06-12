import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ek.sorter.RandomSorterApp;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RandomSorterApp.class)
@WebAppConfiguration
public class RandomSorterTest {

	@Test
	public void contextLoads() {
	}
}
