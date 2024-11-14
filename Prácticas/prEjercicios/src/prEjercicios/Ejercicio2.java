package prEjercicios;

/* Dados dos vectores de n enteros cada uno y ordenados de forma creciente, escribir
 * un algoritmo para hallar la mediana del vector formado por los 2n enteros, cuya
 * complejidad sea O(lg n)
 */

public class Ejercicio2 {
	public int mediana(int[] v, int[] w, int infv, int supv, int infw, int supw) {
		if (infv >= supv && infw >= supw) {
			return Math.min(v[infv], w[infw]);
		}

		int nitems = supv - infv + 1;
		if (nitems == 2) {
			if (v[supv] < w[infw]) {
				return v[supv];
			} else if (w[supw] < v[infv]) {
				return w[supw];
			} else {
				return Math.max(v[infv], w[infw]);
			}
		}
		
		nitems = (nitems-1)/2;
		int posV = infv + nitems;
		int posW = infw + nitems;
		if(v[posV] == w[posW]) {
			return v[posV];
		}else if(v[posV] < w[posW]) {
			return mediana(v, w, supv-nitems, supv, infw, infw+nitems);
		}else {
			return mediana(v, w, infv, infv+nitems, supw-nitems, supw);
		}
	}
}
