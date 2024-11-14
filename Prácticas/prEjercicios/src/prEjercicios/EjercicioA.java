package prEjercicios;

public class EjercicioA {

	public static int malPos(int[] v, int inf, int sup) {
		int pos = -1;
		if (inf >= sup) {
			return pos;
		} else if (inf + 1 == sup) {
			if (v[inf] > v[sup]) {
				return inf;
			}
			return pos;
		} else {
			int medio = (sup + inf) / 2;
			if (!isSorted(v, medio + 1, sup)) {
				pos = malPos(v, medio + 1, sup);
			} else if (!isSorted(v, inf, medio)) {
				pos = malPos(v, inf, medio);
			} else {
				pos = medio;
			}
		}
		return pos;
	}

	public static boolean isSorted(int[] array, int inf, int sup) {
		for (int i = inf; i < sup; i++) {
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}

	public static void main(String arr[]) {
		int A[] = { 1, 2, 3, 4, 5, 6, 9 };

		System.out.println("ELEEMNTO EN POSICION: " + malPos(A, 0, A.length - 1));

	}

}
