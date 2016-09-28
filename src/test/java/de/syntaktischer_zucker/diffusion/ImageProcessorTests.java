/// package's name
package de.syntaktischer_zucker.diffusion;

/// imports
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Log4j2
/**
 * @brief
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 */
public class ImageProcessorTests {
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * @brief tests loadImage
	 */
	@Test
	public void loadImage() {
		URL url = null;
		
		/// the usual case - resource available
		try {
			url = new URL("https://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png");
		} catch (MalformedURLException ex) {
			log.error(ex);
		}
		
		ImageProcessor processor = new ImageProcessor();
		processor.loadImage(url);
		assertNotNull(processor.getImage());

		/// see if we catch the exception if image could no be loaded
		try {
			url = new URL("https://upload.wikimedia.org/wikipedia/en/2/24/LennaXYZ.png");
		} catch (MalformedURLException ex) {
			log.error(ex);
		}

		processor = new ImageProcessor();
		processor.loadImage(url);
		Assert.assertNull(processor.getImage());
	}
	
	@Test
	public void saveImage() {
		URL url = null;
		
		/// the usual case - resource available
		try {
			url = new URL("https://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png");
		} catch (MalformedURLException ex) {
			log.error(ex);
		}
		
		/// save image to known location
		ImageProcessor processor = new ImageProcessor();
		processor.loadImage(url);
		try {
			assertTrue(processor.saveImage(new File("test.png").toURI().toURL()));
		} catch (MalformedURLException ex) {
			log.error(ex);
		}

		/// save image to unknown / unavailable location
		assertFalse(processor.saveImage(url));
	}
}
