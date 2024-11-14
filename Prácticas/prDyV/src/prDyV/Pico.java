package prDyV;

public class Pico {
	public static Integer picoDyV(int a[]) {
		return picoR(a, 0, a.length);
	}

	private static Integer picoR(int a[], int izq, int der) {
		Integer valor = null;

		int medio = (izq + der) / 2;

		if (a[medio] > a[medio - 1] && a[medio] > a[medio + 1]) {
			valor = a[medio];
		} else if (a[medio - 1] < a[medio]) { //estamos subiendo
			valor = picoR(a, medio + 1, der);
		} else { //estamos bajando
			valor = picoR(a, izq, medio - 1);
		}
		
		return valor;
	}
}

/* Complejidad del algoritmo
 * Tm(n) = 2      (n = der - izq + 1)
 * Tp(n) = 3 + Tp(n/2)  (es n/2 porque cuando llamamos a la función picoR, no estamos quedando aproximadamente con la mitad de los elementos del array).
 * 
 * Si aplicamos el Teorema Maestro, a = 1, b =2, f(n) = 3 polinomio de grado 0 => a = 1 = 2^0 = b^d
 * Tp(n) pertenece a 0(1*log n)
*/