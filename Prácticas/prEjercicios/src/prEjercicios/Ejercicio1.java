package prEjercicios;

/* Dado un vector ordenado V de n enteros distintos, escribir un algoritmo que en
 * tiempo O(lg n) encuentre un numero i tal que 1<=i<=n y V[i] = i, siempre que exista
 */

public class Ejercicio1 {
	public int ejercicio(int [] v, int inf, int sup, int x) {
		int pos = -1;
		if(inf <= sup) {
			int m = (inf+sup)/2;
			
			if(v[m] == x) {
				pos = m;
			}else if(v[m] < x) {
				pos = ejercicio(v, m+1, sup, x);
			}else {
				pos = ejercicio(v, inf, m-1, x);
			}
		}
		
		return pos;
	}
}
