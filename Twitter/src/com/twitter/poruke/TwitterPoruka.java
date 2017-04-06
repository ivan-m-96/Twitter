package com.twitter.poruke;
/**
 * Klasa twitterPoruka omogucava slanje twitter poruka i povezivanje tih poruka sa korisnikom
 * @author Bojan Tomic
 * @version 1.0
 *
 */
public class TwitterPoruka {
	/**
	 * Atribut koji oznacava korisnika koji salje poruku
	 */
	private String korisnik;
	/**
	 * Atribut koji oznacava poruku koja treba da bude poslata od strane korisnika
	 */
	private String poruka;
	/**
	 * Metoda vraca korisnika koji je poslao poruku
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda koja postavlja korisnika koji salje poruku
	 * @param korisnik oznacava naziv korisnika
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty()) //ispravljena greska testom setKorisnikPrazString
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda koja vraca poruku
	 * @return	poruku korisnika
	 */
	public String getPoruka() {
		return this.poruka; //ispravljena greska
	}
	/**
	 * Metoda koja postavlja poruku
	 * @param poruka poruka koju korisnik postavlja
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals(new String("")) || poruka.length() > 140) //ispravljena greska testovima
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		
		this.poruka = poruka;
	}
	/**
	 * Metoda koja stampa poruku i ime korisnika na ekran
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
