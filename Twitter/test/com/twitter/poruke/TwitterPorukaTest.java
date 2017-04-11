package com.twitter.poruke;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	
	private TwitterPoruka a;
	@Before
	public void setUp() throws Exception {
		a = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		a.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazString() {
		a.setKorisnik("");
	}

	@Test
	public void testSetKorisnikPravaVred() {
		a.setKorisnik("Pera");
		assertEquals("Pera", a.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		a.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPraz() {
		a.setPoruka("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaViseOd140Kar() {
		char[] ch = new char[145];
		Arrays.fill(ch, 's');

		a.setPoruka(new String(ch));
	}

	@Test
	public void testSetPoruka() {

		a.setPoruka("bilo sta");
		assertEquals("bilo sta", a.getPoruka());
	}

	@Test
	public void testToString() {
		a.setKorisnik("Pera");
		a.setPoruka("Testira kod.");
		assertTrue(a.toString().equals("KORISNIK:Pera PORUKA:Testira kod."));
		
	}

}
