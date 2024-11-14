import java.util.Scanner;

public class TestQuicksort {
	public static void main(String[] a) {
	
		Scanner sc= new Scanner(System.in);
		if (sc.hasNext()){
		    int tam = sc.nextInt();
		    Integer [] datos = new Integer[tam];
		    for (int i = 0; i<tam; i++){
		        datos[i] = sc.nextInt();
		    }
		    OrdenacionRapida.ordenar(datos);
		    System.out.println(Ordenacion.vectorAString(datos));        
		}
		
	}
}
