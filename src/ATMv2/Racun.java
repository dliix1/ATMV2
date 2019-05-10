package ATMv2;

import java.util.ArrayList;

public class Racun {

	int brojRacuna;
	String imeVlasnikaRacuna;
	double iznosNaRacunu;
	public static ArrayList<Racun> racunArrayLista = new ArrayList<Racun>();

	public Racun() {

	}

	public Racun(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;

		racunArrayLista.add(this);

	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnikaRacuna() {
		return imeVlasnikaRacuna;
	}

	public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) {
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
	}

	public double getIznosNaRacunu() {
		return iznosNaRacunu;
	}

	public void setIznosNaRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = iznosNaRacunu;
	}

	public static boolean provjeraDaLiPostojiRacunSaIstimBrojem(int brojRacuna) {
		for (int i = 0; i < racunArrayLista.size(); i++) {
			if (racunArrayLista.get(i).brojRacuna == brojRacuna)
				return true;
		}
		return false;
	}

	public static String ispisRacuna(int brojRacuna) {
		for (int i = 0; i < racunArrayLista.size(); i++)
			if (brojRacuna == racunArrayLista.get(i).brojRacuna) {
				return "Broj racuna: " + racunArrayLista.get(i).brojRacuna
						+ " Ime vlasnika racuna: "
						+ racunArrayLista.get(i).imeVlasnikaRacuna
						+ " Iznos na racunu: "
						+ racunArrayLista.get(i).iznosNaRacunu;
			}

		return "Unijeti broj racuna ne postoji.";
	}

}
