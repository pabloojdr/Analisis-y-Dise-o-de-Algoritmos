package prEjercicios;

public class Ejercicio2012 {

	public static int numInversBruto(int[] a) {
		int prim = 0;
		int ult = a.length - 1;
		int num = 0;

		if (prim >= ult) {
			return 0;
		} else {
			for (int i = prim; i <= ult; i++) {
				for (int j = i + 1; j <= ult; j++) {
					if (a[i] > a[j]) {
						num++;
					}
				}
			}
		}

		return num;
	}

	public static int numInversDyV(int[] a, int prim, int ult) {
		int sum = 0;

		if (prim >= ult) {
			return 0;
		} else if (prim + 1 == ult && a[prim] > a[ult]) {
			return 1;
		} else if (prim + 1 == ult && a[prim] < a[ult]) {
			return 0;
		} else {
			int media = (prim + ult) / 2;
			int suma1 = numInversDyV(a, prim, media);
			int suma2 = numInversDyV(a, media + 1, ult);
			sum = suma1 + suma2;
			if (a[media] > a[media + 1]) {
				sum++;
			}
		}

		return sum;
	}

	public static void main(String arg[]) {
		int[] v = { 2, 4, 1, 3, 5 };
		System.out.println("Fuerza bruta: " + numInversBruto(v));
		System.out.println("DyV: " + numInversDyV(v, 0, v.length - 1));
	}
}
