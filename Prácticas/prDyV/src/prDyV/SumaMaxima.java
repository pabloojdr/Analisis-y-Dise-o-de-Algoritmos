package prDyV;

public class SumaMaxima {
	public static (a,b) sumaMax(int [] a){
		return sumaMax(a, 0, a.length-1);
	}

	private static (a,b) sumaMax(int [] a, int izq, int der){
		
		int m = (izq+der)/2;
		(a1, b1) = sumaMax(a, izq, m-1);
		(a2, b2) = sumaMax(a, m+1, der);
		
		int maxIzq = a[m];
		int suma = a[m];
		int ini = m;
		
		for(int  i = m-1; i >= 0; i--) {
			suma += a[i];
			if(suma > maxIzq) {
				ini = i;
				maxIzq = suma;
			}
		}
		
		int maxDer = 0;
		int suma = 0;
		int fin = m;
		
		for(int  i = m+1; i <= der; i++) {
			suma += a[i];
			if(suma > maxIzq) {
				fin = i;
				maxDer = suma;
			}
		}
		
		(ini, fin) con suma maxIzq + maxDer;
	}
}
