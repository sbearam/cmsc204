import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook g1;
	private GradeBook g2;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(99);
		g1.addScore(90);
		g2.addScore(79);
		g2.addScore(70);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		g1 = null;
		g2 = null;
	}

	@Test
	void testSum() 
	{
		assertEquals(189.0, g1.sum());
		assertEquals(149.0, g2.sum());
	}
	
	@Test
	void testMinimum() 
	{
		assertEquals(90.0, g1.minimum());
		assertEquals(70.0, g2.minimum());
	}
	
	@Test
	void addScoreTest() 
	{
		assertTrue(g1.toString().equals("99.0 90.0 "));
		assertEquals(2, g1.getScoreSize());
		assertTrue(g2.toString().equals("79.0 70.0 "));
		assertEquals(2, g2.getScoreSize());
	}
	
	@Test
	void finalScoreTest()
	{
		assertEquals(99.0, g1.finalScore());
		assertEquals(79.0, g2.finalScore());
	}

}
