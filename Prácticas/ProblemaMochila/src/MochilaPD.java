
/**
 * 
 * @author ***** Jose A. Onieva *******
 *
 */
import java.util.ArrayList;

public class MochilaPD extends Mochila {
	public SolucionMochila resolver(ProblemaMochila pm) {

		int longitud = pm.getItems().size();
		int columnas = pm.getPesoMaximo() + 1;
		int filas = longitud + 1;

		SolucionMochila[][] sol = new SolucionMochila[filas][columnas];
		int[][] tabla = new int[filas][columnas];

		for (int i = 0; i < filas; ++i) {
			for (int j = 0; j < columnas; ++j) {
				if (i == 0 || j == 0) {
					tabla[i][j] = 0;
					sol[i][j] = new SolucionMochila(new int[pm.getItems().size()], 0, 0);
				} else if (j < pm.getPeso(i - 1)) {
					tabla[i][j] = tabla[i - 1][j];
					sol[i][j] = sol[i - 1][j];
				} else {
					int aux = tabla[i - 1][j];
					SolucionMochila auxs1 = sol[i - 1][j];
					int maxk = 0;

					for (int k = 0; k <= pm.getUnidad(i - 1); k++) {
						if (j >= k * pm.getPeso(i - 1)) {
							int kaux = tabla[i - 1][j - (k * pm.getPeso(i - 1))] + k * pm.getValor(i - 1);
							SolucionMochila auxs2 = sol[i - 1][j - (k * pm.getPeso(i - 1))];
							if (aux < kaux) {
								auxs1 = auxs2;
								aux = kaux;
								maxk = k;
							}
						}
					}

					@SuppressWarnings("unchecked")
					ArrayList<Integer> solucion = (ArrayList<Integer>) auxs1.getSolucion().clone();
					solucion.set(i - 1, maxk);

					sol[i][j] = new SolucionMochila(solucion, auxs1.getSumaPesos() + maxk * pm.getPeso(i - 1),
							auxs1.getSumaValores() + maxk * pm.getValor(i - 1));
					tabla[i][j] = aux;
				}
			}
		}
		return sol[pm.getItems().size()][pm.getPesoMaximo()];
	}
}