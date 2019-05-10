package ATMv2;

import java.util.Scanner;

public class ATMTest {

	public static Scanner unos = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		System.out.println(" --- BANKOMAT APLIKACIJA ---");
		System.out.println("Odaberite radnju: ");
		System.out.println("1. Kreiranje racuna.");
		System.out.println("2. Prebacivanje novca sa jednog racuna na drugi (transfer novca).");
		System.out.println("3. Ispisivanje detalja postojecih racuna.");

		int korisnikovUnos = unos.nextInt();

		switch (korisnikovUnos) {
		case 1:
			kreiranjeRacuna();
			break;

		case 2:
			transferNovca();
			break;

		case 3:
			ispisRacuna();
			break;
		}

	}

	public static void kreiranjeRacuna() {

		System.out.println("Unesite broj racuna: ");
		int brojRacuna = unos.nextInt();
		while (Validacija.kreiraniRacunSaNegativnimBrojem(brojRacuna)) {
			brojRacuna = unos.nextInt();
		}

		System.out.println("Unesite ime vlasnika racuna: ");
		String imeVlasnikaRacuna = unos.next();

		System.out.println("Unesite iznos racuna: ");
		double iznosNaRacunu = unos.nextDouble();
		while (Validacija.kreiraniRacunSaNegativnimIznosom(iznosNaRacunu)) {
			iznosNaRacunu = unos.nextDouble();
		}

		new Racun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu);
		System.out.println("Racun je uspjesno napravljen!");
		System.out.println();

		menu();

	}

	public static void transferNovca() {

		System.out.println("Unesite broj source racuna: ");
		int sourceRacun = unos.nextInt();
		Validacija.provjeraZaSourceRacun(sourceRacun);

		System.out.println("Unesite broj target racuna: ");
		int targetRacun = unos.nextInt();
		Validacija.provjeraZaTargetRacun(targetRacun);

		System.out.println("Unesite broj novca koji zelite da prebacite: ");
		double iznosKojiSePrebacuje = unos.nextDouble();
		Validacija.provjeraZaNovac(iznosKojiSePrebacuje);

		Validacija.provjeraZaTransfer(sourceRacun, targetRacun,
				iznosKojiSePrebacuje);

		Racun.transferNovca(sourceRacun, targetRacun, iznosKojiSePrebacuje);

		menu();

	}

	public static void ispisRacuna() {
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = unos.nextInt();

		Racun.ispisRacuna(brojRacuna);
		System.out.println();

		menu();
	}

}
