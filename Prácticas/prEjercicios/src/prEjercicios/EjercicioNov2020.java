package prEjercicios;

public class EjercicioNov2020 {
	public static boolean estaContFB(int[] v, int[] a) {
		int sum = 0;

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] == v[i]) {
					sum++;
				}
			}
		}
		return sum == a.length;
	}
	
	public static boolean estaContDyV(int [] v, int [] a, int vinf, int vsup, int ainf, int asup) {
		
	}

	public static void main(String[] arg) {
		int[] V = { -10, -3, 0, 4, 7, 19, 33 };
		int[] A = { 4, 7, 19 };

		System.out.println("Fuerza bruta: " + estaContFB(V, A));
	}
}
