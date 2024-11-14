
/**
 * 
 * @author ***** Jose A. Onieva ******* Asumimos que: a) Todos los items tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = new SolucionMochila();
		int[] u = pm.getUnidades();
		int[] p = pm.getPesos();
		int[] v = pm.getValores();
		int permutaciones = 1;
		for (int i = 0; i < pm.size(); i++) {
			permutaciones *= (pm.getUnidad(i) + 1);
		}

		for (int per = 0; per < permutaciones; per++) {
			int auxp = per;
			int[] actual = new int[u.length];
			int pesoActual = 0;
			int beneficioActual = 0;
			for (int i = 0; i < u.length; i++) {
				actual[i] = (auxp % (u[i] + 1));
				pesoActual += p[i] * actual[i];
				beneficioActual += v[i] * actual[i];
				auxp /= (u[i] + 1);
			}
			if (pm.getPesoMaximo() >= pesoActual) {
				if (sm == null || sm.getSumaValores() < beneficioActual) {
					sm = new SolucionMochila(actual, pesoActual, beneficioActual);
				}
			}
		}
		return sm;
	}

}

