public class Analizador {
	public static void main(String arg[]) {
		long n1 = 10;
		long n2 = 20;

		double ratio = analizador(n2) / analizador(n1);

		if (ratio > 1000) {
			if (ratio < 3000000) {
				System.out.println("2N");
			} else {
				System.out.println("NF");
			}
		} else {
			n1 = 4500;
			n2 = 9000;

			ratio = analizador(n2) / analizador(n1);

			if (6.0 <= ratio && ratio < 10) {
				System.out.println("N3");
			} else if (3.25 <= ratio && ratio < 6.0) {
				System.out.println("N2");
			} else if (2.5 <= ratio && ratio < 3.25) {
				System.out.println("NLOGN");
			} else {
				n1 = 1000;
				n2 = 2000000;

				ratio = analizador(n2) / analizador(n1);

				if (ratio > 100) {
					System.out.println("N");
				} else if (ratio < 1.01) {
					System.out.println("1");
				} else {
					System.out.println("LOGN");
				}
			}
		}

	}

	private static double analizador(long t) {
		double suma = 0.0;
		Temporizador temp = new Temporizador();
		for (int i = 0; i < 5; i++) {
			temp.reiniciar();
			temp.iniciar();
			Algoritmo.f(t);
			temp.parar();
			suma += temp.tiempoPasado();
		}

		return suma / 5;
	}
}