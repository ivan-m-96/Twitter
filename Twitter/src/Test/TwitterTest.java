package Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	private Twitter t;
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testVratiSvePoruke() {
		LinkedList<TwitterPoruka> rezult = t.vratiSvePoruke();
		assertTrue(rezult instanceof LinkedList<?>);
	}

	@Test
	public void testUnesi() {
		t.unesi("Marko", "Test");
		assertTrue(t.vratiSvePoruke().getLast().getKorisnik().equals("Marko"));
		assertTrue(t.vratiSvePoruke().getLast().getPoruka().equals("Test"));
	}

	@Test
	public void testVratiPoruke() {
		t.unesi("Marko", "Poruka koja sadrzi tag.");
		t.unesi("Marko", "Poruka koja sadrzi tag na neki drugi nacin.");
		t.unesi("Marko", "tag Poruka koja sadrzi tag.");
		TwitterPoruka[] pompor = t.vratiPoruke(2, "tag");
		assertEquals("Marko", pompor[1].getKorisnik() );
		assertEquals("Poruka koja sadrzi tag na neki drugi nacin.", pompor[1].getPoruka());

	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		t.unesi("Marko", "Poruka koja sadrzi tag.");

		
		t.vratiPoruke(2, null);

	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag() {
		
		t.unesi("Marko", "Poruka koja sadrzi tag.");

		
		t.vratiPoruke(2, "");

	}
	@Test
	public void testVratiPorukeMaxManjiOdNule() {
		
		t.unesi("Marko", "Poruka koja sadrzi tag.");

	
	
		assertEquals(100, t.vratiPoruke(-4, "tag").length);
	}

	
}
