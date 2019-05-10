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
				return false;
			System.out.println("Broj racuna vec postoji!");
		}
		return true;
	}

	public static boolean ispisRacuna(int brojRacuna) {
		for (int i = 0; i < racunArrayLista.size(); i++)
			if (racunArrayLista.get(i).brojRacuna == brojRacuna) {
				System.out.println(racunArrayLista.get(i).toString());
				return true;
			}
		return false;
	}
	
	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + imeVlasnikaRacuna + "\n Trenutno stanje: " + iznosNaRacunu;
	}

	public static void transferNovca(int sourceRacun, int targetRacun,
			double iznosKojiSePrebacuje) {

		if (Validacija.provjeraZaTransfer(sourceRacun, targetRacun, iznosKojiSePrebacuje)) {

			for (int i = 0; i < racunArrayLista.size(); i++) {

				if (racunArrayLista.get(i).brojRacuna == sourceRacun) {
					racunArrayLista.get(i).iznosNaRacunu -= iznosKojiSePrebacuje;
				}

				if (racunArrayLista.get(i).brojRacuna == targetRacun) {
					racunArrayLista.get(i).iznosNaRacunu += iznosKojiSePrebacuje;
				}

				System.out.println("Transfer je uspjesno izvrsen!");
				System.out.println("Iznos na vasem racunu: " +racunArrayLista.get(i).iznosNaRacunu);
				System.out.println();
			}
		}

	}

}
