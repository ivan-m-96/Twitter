package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa omogucava unos i pregleda poruka na Twitteru
 * @author Bojan Tomic
 * @version 1.0
 */
public class Twitter {
	/**
	 * Oznacava listu gde ce se cuvati poruke klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Metoda vraca sve unesene poruke
	 * @return poruke
	 */
	
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda koja unosi poruku i korisnika koji ju je napravio na Twitter
	 * @param korisnik teskt koji predstavlja korisnika koji unosi poruku
	 * @param poruka tekst koji predstavlja poruku koju unosi korisnik
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);//ispravljena greska uz pomoc testa
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
		/**
		 * Metoda vraca poruke koje imaju neki zadati tag
		 * @param maxBroj broj poruka koje se traze
		 * @param tag tekst koji oznacava neki tag koji se trazi u porukama
		 * @return lista pronadjenih poruka klase TwitterPoruka[]
		 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i); //ispravljena greska nadjena testom
					brojac++;
				} else
					break;
		return rezultat;
	}
}