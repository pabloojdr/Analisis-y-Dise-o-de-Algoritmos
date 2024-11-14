
public class Analizador {

	/*
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de salida que
	 * deberia tener la solucion a este ejericio. Esta clase debe modificarse
	 * completamente para cumplir mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */

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
			//System.out.println(ratio);
		} else {
			n1 = 4500;
			n2 = 9000;

			ratio = analizador(n2) / analizador(n1);

			if (6.0 <= ratio && ratio < 10) {
				System.out.println("N3");
				//System.out.println(ratio);
			} else if (3.25 <= ratio && ratio < 6.0) {
				System.out.println("N2");
				//System.out.println(ratio);
			} else if (2.5 <= ratio && ratio < 3.25) {
				System.out.println("NLOGN");
				//System.out.println(ratio);
			} else {
				n1 = 1000;
				n2 = 2000000;

				ratio = analizador(n2) / analizador(n1);

				if (ratio > 100) {
					System.out.println("N");
					//System.out.println(ratio);
				} else if (ratio < 1.01) {
					System.out.println("1");
					//System.out.println(ratio);
				} else {
					System.out.println("LOGN");
					//System.out.println(ratio);
				}
			}
		}

	}

	private static double analizador(long t) {
		double media = 0.0;
		Temporizador temp = new Temporizador();
		for (int i = 0; i < 5; i++) {
			temp.reiniciar();
			temp.iniciar();
			Algoritmo.f(t);
			temp.parar();
			media += temp.tiempoPasado();
		}

		return media / 5;
	}
}


/*
 * n=1; do{ n = n * 10 t_incio = tiempo(); for(int i = 0; i < 10; i++){ f(n*i);
 * }
 * 
 * T_total=tiempo()-t_inicio }while(T_total < 10000) }
 */