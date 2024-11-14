package prEjercicios;

/* 3. (4 ptos) Dado un array ordenado, se desea calcular el número de veces que aparece el valor
 * x, siendo x unos de los valores presentes en el array.
 * a) Utilizar la estrategia Divide y Vencerás para diseñar un algoritmo de coste O(log n)
 * que resuelva el problema indicado.
 * b) Analizar la complejidad del programa para demostrar que se ajusta al orden de
 * crecimiento requerido. Se puede utilizar el Teorema Maestro si se considera necesario.
 */

public class Ejercicio2020 {
	public int numApariciones(int[] v, int inf, int sup, int x) {
		int sum = 0;
		if (inf >= sup) {
			if (v[inf] == x) {
				sum = 1;
			}
			return sum;
		} else {
			int pos = busqBinaria(v, inf, sup, x);
			sum = 1;
			if(v[pos+1] == x) {
				sum++;
				pos++;
			}
			

		}
	}

	public static int busqBinaria(int[] a, int inf, int sup, int x) {
		int pos = -1;
		if (inf <= sup) {
			int medio = (inf + sup) / 2;
			if (x == a[medio]) {
				pos = medio;
			} else if (a[medio] > x) {
				pos = busqBinaria(a, inf, medio - 1, x);
			} else {
				pos = busqBinaria(a, medio + 1, sup, x);
			}
		}
		return pos;
	}
}
