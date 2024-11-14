
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */

public class MochilaAV extends Mochila {

	static class Objeto implements Comparable<Objeto> {
		int peso;
		int valor;
		int indice;
		int unidades;
		double densidad;

		public Objeto(int p, int v, int u, int i) {
			this.peso = p;
			this.valor = v;
			this.unidades = u;
			this.indice = i;

			this.densidad = (double) valor / (double) peso;
		}

		public int compareTo(Objeto o2) {
			if (this.densidad == o2.densidad && this.indice == o2.indice) {
				return 0;
			} else if (this.densidad == o2.densidad && this.indice > o2.indice) { //indice tiene que ser mayor que o2.indice porque queremos ordenarlo de manera descendente
				return 1;
			} else if (this.densidad < o2.densidad) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	public SolucionMochila resolver(ProblemaMochila pm) {
		int[] pesos = pm.getPesos();
		int[] unidades = pm.getUnidades();
		int[] valores = pm.getValores();
		int[] soluciones = new int[pesos.length];
		Objeto[] objetos = new Objeto[pesos.length];

		int sumaPesos = 0;
		int sumaValores = 0;
		int maxP = pm.getPesoMaximo();

		for (int i = 0; i < pesos.length; i++) {
			objetos[i] = new Objeto(pesos[i], valores[i], unidades[i], i);
		}

		for (int i = 0; i < soluciones.length; i++) {
			soluciones[i] = 0;
		}

		Arrays.sort(objetos);

		int i = 0;
		while (i < objetos.length && sumaPesos < maxP) {
			if (objetos[i].peso <= maxP - sumaPesos && objetos[i].unidades > 0) {
				soluciones[objetos[i].indice]++;
				sumaPesos += objetos[i].peso;
				sumaValores += objetos[i].valor;
				objetos[i].unidades--;
			} else {
				i++;
			}
		}

		ArrayList<Integer> solucionesF = new ArrayList<Integer>();
		solucionesF = ArrayUtils.toArray(soluciones);
		return new SolucionMochila(solucionesF, sumaPesos, sumaValores);
	}
}