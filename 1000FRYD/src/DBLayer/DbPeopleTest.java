package DBLayer;

import static org.junit.Assert.*;

import org.junit.Test;

public class DbPeopleTest {
	@Test
	public void testGetPerson() {
		DbPeople dbCon = new DbPeople();
		if(dbCon.getPerson("aaa@a.aa") != null)
		{
			
		}
		else
		{
			fail("Not yet implemented");
		}
	}

}