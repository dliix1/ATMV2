package ATMv2;

public class Validacija {

	public static boolean kreiraniRacunSaNegativnimBrojem(int brojRacuna) {
		if (brojRacuna < 0){
			System.out.println("Unijeti broj racuna ne smije biti negativan broj!");
			return true;
		}
		return false;
	}

	public static boolean kreiraniRacunSaNegativnimIznosom(double iznosNaRacunu) {
		if (iznosNaRacunu < 0) {
			System.out.println("Unijeti iznos na racunu ne smije biti negativan broj!");
			return true;
		}
		return false;
	}

	public static void provjeraZaSourceRacun(int sourceRacun) {
		if (sourceRacun < 0) {
			System.out.println("Unesite ispravan broj source racuna!");
		}
	}

	public static void provjeraZaTargetRacun(int targetRacun) {
		if (targetRacun < 0) {
			System.out.println("Unesite ispravan broj target racuna!");
		}
	}

	public static void provjeraZaNovac(double iznosKojiSePrebacuje) {
		if (iznosKojiSePrebacuje < 0) {
			System.out.println("Unesite valjan iznos koji se prebacuje!");

		}
	}

	public static boolean provjeraZaTransfer(int sourceRacun, int targetRacun,
			double iznosKojiSePrebacuje) {

		boolean sourcePostoji = false;
		boolean targetPostoji = false;
		boolean dovoljnoNovca = false;

		for (int i = 0; i < Racun.racunArrayLista.size(); i++) {

			if (Racun.racunArrayLista.get(i).brojRacuna == sourceRacun) {
				sourcePostoji = true;

				if ((Racun.racunArrayLista.get(i).iznosNaRacunu - iznosKojiSePrebacuje) >= 0)
					dovoljnoNovca = true;

				if (Racun.racunArrayLista.get(i).brojRacuna == targetRacun)
					targetPostoji = true;
			}
		}
		if (!sourcePostoji){
			System.out.println("Unijeti broj racuna za slanje ne postoji.");
		
		if (!targetPostoji)
			System.out.println("Unijeti broj racuna za primanje ne postoji.");
		
		if (!dovoljnoNovca)
			System.out.println("Nema dovoljno novca za transfer.");
		return false;
		}
		else
			return true;

	}
}
