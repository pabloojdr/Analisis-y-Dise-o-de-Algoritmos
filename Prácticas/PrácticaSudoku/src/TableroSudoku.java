// ALUMNO: CAMPOY FERN�NDEZ, PABLO JULI�N
// GRUPO: D

import java.util.*;

public class TableroSudoku implements Cloneable {

	// constantes relativas al n� de filas y columnas del tablero
	protected static final int MAXVALOR = 9;
	protected static final int FILAS = 9;
	protected static final int COLUMNAS = 9;

	protected static Random r = new Random();

	protected int celdas[][]; // una celda vale cero si est\u00E1 libre.

	public TableroSudoku() {
		celdas = new int[FILAS][COLUMNAS]; // todas a cero.
	}

	// crea una copia de su par\u00E1metro
	public TableroSudoku(TableroSudoku uno) {
		TableroSudoku otro = (TableroSudoku) uno.clone();
		this.celdas = otro.celdas;
	}

	// crear un tablero a parir de una configuraci\u00D3n inicial (las celdas
	// vac\u00EDas
	// se representan con el caracter ".".
	public TableroSudoku(String s) {
		this();
		if (s.length() != FILAS * COLUMNAS) {
			throw new RuntimeException("Construcci\u00D3n de sudoku no v\u00E1lida.");
		} else {
			for (int f = 0; f < FILAS; f++)
				for (int c = 0; c < COLUMNAS; c++) {
					Character ch = s.charAt(f * FILAS + c);
					celdas[f][c] = (Character.isDigit(ch) ? Integer.parseInt(ch.toString()) : 0);
				}
		}
	}

	/*
	 * Realizar una copia en profundidad del objeto
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		TableroSudoku clon;
		try {
			clon = (TableroSudoku) super.clone();
			clon.celdas = new int[FILAS][COLUMNAS];
			for (int i = 0; i < celdas.length; i++)
				System.arraycopy(celdas[i], 0, clon.celdas[i], 0, celdas[i].length);
		} catch (CloneNotSupportedException e) {
			clon = null;
		}
		return clon;
	}

	/*
	 * Igualdad para la clase
	 * 
	 * @see java.lang.Object#equals()
	 */
	public boolean equals(Object obj) {
		if (obj instanceof TableroSudoku) {
			TableroSudoku otro = (TableroSudoku) obj;
			for (int f = 0; f < FILAS; f++)
				if (!Arrays.equals(this.celdas[f], otro.celdas[f]))
					return false;
			return true;
		} else
			return false;
	}

	public String toString() {
		String s = "";

		for (int f = 0; f < FILAS; f++) {
			for (int c = 0; c < COLUMNAS; c++)
				s += (celdas[f][c] == 0 ? "." : String.format("%d", celdas[f][c]));
		}
		return s;
	}

	private static void imprimirTablero(TableroSudoku t) {
		for (int i = 0; i < FILAS; ++i) {
			for (int j = 0; j < COLUMNAS; ++j) {
				if (t.celdas[i][j] == 0)
					System.out.print("." + " ");
				else
					System.out.print(t.celdas[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	// devuelva true si la celda del tablero dada por fila y columna est\u00E1
	// vac\u00EDa.
	protected boolean estaLibre(int fila, int columna) {
		return celdas[fila][columna] == 0;
	}

	// devuelve el n�mero de casillas libres en un sudoku.
	protected int numeroDeLibres() {
		int n = 0;
		for (int f = 0; f < FILAS; f++)
			for (int c = 0; c < COLUMNAS; c++)
				if (estaLibre(f, c))
					n++;
		return n;
	}

	protected int numeroDeFijos() {
		return FILAS * COLUMNAS - numeroDeLibres();
	}

	/*
    if (fila % 3 == 0) {
        a = fila;
    } else if (fila % 3 == 1) {
        a = fila - 1;
    } else if (fila % 3 == 2) {
        a = fila - 2;
    }
    if (columna % 3 == 0) {
        b = columna;
    } else if (columna % 3 == 1) {
        b = columna - 1;
    } else if (columna % 3 == 2) {
        b = columna - 2;
    }
    */
	
	// Devuelve true si @valor ya esta en la fila @fila.
	protected boolean estaEnFila(int fila, int valor) {
		boolean est� = false;

		for (int i = 0; i < COLUMNAS; i++) {
			if (celdas[fila][i] == valor) {
				est� = true;
			}
		}

		return est�;
	}

	// Devuelve true si @valor ya esta en la columna @columna.
	protected boolean estaEnColumna(int columna, int valor) {
		boolean est� = false;

		for (int i = 0; i < FILAS; i++) {
			if (celdas[i][columna] == valor) {
				est� = true;
			}
		}

		return est�;
	}

	// Devuelve true si @valor ya esta en subtablero al que pertence @fila y
	// @columna.
	protected boolean estaEnSubtablero(int fila, int columna, int valor) {
		int a = fila - (fila % 3);
		int b = columna - (columna % 3);
		boolean est� = false;

		for (int i = a; i < a + 3; i++) {
			for (int j = b; j < b + 3; j++) {
				if (celdas[i][j] == valor) {
					est� = true;
				}
			}
		}

		return est�;
	}

	// Devuelve true si se puede colocar el @valor en la @fila y @columna dadas.
	protected boolean sePuedePonerEn(int fila, int columna, int valor) {
		return !estaEnFila(fila, valor) && !estaEnColumna(columna, valor) && !estaEnSubtablero(fila, columna, valor);
	}

	protected void resolverTodos(List<TableroSudoku> soluciones, int fila, int columna) {
		int[] huecoLibre = posicionLibre(fila, columna);

		if (huecoLibre == null) {
			soluciones.add(new TableroSudoku(this));
		} else {
			int fila1 = huecoLibre[0];
			int columna1 = huecoLibre[1];

			for (int k = 1; k <= MAXVALOR; k++) {
				if (sePuedePonerEn(fila1, columna1, k)) {
					celdas[fila1][columna1] = k;
					resolverTodos(soluciones, fila1, columna1);
				}
			}

			celdas[fila1][columna1] = 0;
		}
	}

	private int[] posicionLibre(int fila, int columna) {
		int a = fila;
		int b = columna;

		while (a < FILAS) { // poner que hacer un for recorrer�a hasta el final y empezar�amos rellenando
							// desde abajo en lugar de desde arriba que es lo m�s l�gico
			if (estaLibre(a, b)) {
				int libres[] = new int[2];
				libres[0] = a;
				libres[1] = b;
				return libres;
			}

			b++;

			if (b == COLUMNAS) {
				b = 0;
				a++;
			}
		}

		return null;
	}

	public List<TableroSudoku> resolverTodos() {
		List<TableroSudoku> sols = new LinkedList<TableroSudoku>();
		resolverTodos(sols, 0, 0);
		return sols;
	}

	public static void main(String arg[]) {
		TableroSudoku t = new TableroSudoku(
				".4....36263.941...5.7.3.....9.3751..3.48.....17..62...716.9..2...96.......312..9.");
		imprimirTablero(t);
		List<TableroSudoku> lt = t.resolverTodos();
		System.out.println(t);
		System.out.println(lt.size());
		for (Iterator<TableroSudoku> i = lt.iterator(); i.hasNext();) {
			TableroSudoku ts = i.next();
			System.out.println(ts);
			imprimirTablero(ts);

		}

	}

}
