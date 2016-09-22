/// package's name
package de.syntaktischer_zucker.diffusion;

/// imports
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 */
public class BaseStrategyTests {
	/**
	 * @brief
	 */
	@BeforeClass
	public static void setUpClass() {
	}
	
	/**
	 * @brief
	 */
	@AfterClass
	public static void tearDownClass() {
		
	}
	
	/**
	 * @brief
	 */
	@Before
	public void setUp() {
	}
	
	/**
	 * @brief
	 */
	@After
	public void tearDown() {
	}
	
	/**
	 * @brief test filter function
	 */
	@Test
	public void testFilter() {
		BaseStrategy baseStrategy = new BaseStrategy();
		assertNotNull(baseStrategy);
		baseStrategy.filter();
	}
}
