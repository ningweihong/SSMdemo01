import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwua.dao.ItemsMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-tx.xml")
public class Itemstest {
	@Autowired
private ItemsMapper idao;
	@Test
	public void test() {
		idao.selectByPrimaryKey(1);
	}

}
