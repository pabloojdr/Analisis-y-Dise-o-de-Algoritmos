////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: PABLO JULIÁN CAMPOY FERNÁNDEZ
// GRUPO: D
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapidaBarajada extends OrdenacionRapida {

	// Implementación de QuickSort con reordenación aleatoria inicial (para comparar
	// tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		// System.out.println("sin ordenar: " + vectorAString(v));
		barajar(v);
		// System.out.println("barajado: " + vectorAString(v));
		OrdenacionRapida.ordenar(v);
	}

	// reordena aleatoriamente los datos de un vector
	private static <T> void barajar(T v[]) {
		// A completar or el alumno
		for (int i = 0; i < v.length; i++) {
			int aleatorio = aleat.nextInt(i + 1); // le sumamos 1 para que sea un valor positivo (visto en la API)
			intercambiar(v, i, aleatorio);

		}
	}

	public static void main(String args[]) {

		// Un vector de enteros
		Integer vEnt[] = { 3, 8, 6, 5, 2, 9, 1, 1, 4 };
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = { 'd', 'c', 'v', 'b' };
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}
}
