////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: PABLO JULIÁN CAMPOY FERNÁNDEZ
// GRUPO: D
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {

	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		ordRapidaRec(v, 0, v.length - 1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con
	// una implementación recursiva del método de ordenación rápida.

	// [1, 4, 7, 2, 9, 6]
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
		if (izq < der) {
			T pivote = v[izq];
			int pos = partir(v, pivote, izq, der);
			ordRapidaRec(v, izq, pos - 1);
			ordRapidaRec(v, pos + 1, der);
		}
	}

	public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
		// A completar por el alumno
		int i = izq;
		int j = der;
		int p = 0;
		do {
			while (i <= j && v[i].compareTo(pivote) <= 0) {
				if (v[i].compareTo(pivote) == 0) {
					p = i;
				}
				++i;
			}
			while (i <= j && v[j].compareTo(pivote) > 0) {
				--j;
			}
			if (i < j) {
				intercambiar(v, i, j);
			}
		} while (i <= j);
		intercambiar(v, p, j);
		return j;
	}

	// Pequeños ejemplos para pruebas iniciales.
	public static void main(String args[]) {

		// Un vector de enteros
		Integer vEnt[] = { 8, 3, 5, 1, 6, 3, 5, 5, 5, 6, 9, 3, 2 };
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = { 'd', 'c', 'v', 'b' };
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}

}
