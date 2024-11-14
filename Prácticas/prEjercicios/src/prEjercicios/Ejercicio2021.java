package prEjercicios;

/*
 * 
 */
public class Ejercicio2021 {
	public static int entradaErronea(int[] v, int inf, int sup) {
		int res = -1;
		int medio = (sup + inf) / 2;
		
		if (sup > inf) {
			if (v[medio] == medio+1) {
				if (v[medio] != v[medio + 1]) {
					res = entradaErronea(v, medio + 1, sup);
				} else {
					res = v[medio];
				}
			} else if (v[medio] < medio + 1) {
				if (v[medio] != v[medio - 1]) {
					res = entradaErronea(v, inf, medio - 1);
				} else {
					res = v[medio];
				}
			}
		}
		return res;
	}
}
