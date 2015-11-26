import java.util.Scanner;

/**
 * Esta plantilla es orientativa, y no es necesario usarla
 * 
 * @author Nombres de los autores
 */
public class CuatroEnRaya {

	private static final char FUERA = 'F';
	private static final int FICHAS_EN_LINEA = 3;
	private static char VACIO = '.';

	/**
	 * Decide que ficha usa el jugador con ese turno
	 * 
	 * @return 'O' para el jugador 1, 'X' para el jugador 2
	 */
	private static char fichaDeJugador(int turno) {
		if (turno == 1)
			return 'O';
		else
			return 'X';
	}

	/**
	 * Decide si un jugador ha hecho cuatro en raya
	 * 
	 * @param tablero
	 */
	private static boolean hayCuatroEnRaya(int turno, char[][] tablero) {
		for (int c = 0; c < tablero.length; c++) {
			for (int f = 0; f < tablero[c].length; f++) {
				if (hayCuatroEnRayaEmpezandoEn(turno, tablero, f, c)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hayCuatroEnRayaEmpezandoEn(int turno, char[][] tablero, int fila, int columna) {
		return hayCuatroEnRayaVerticalEn(turno, tablero, fila, columna)
				|| hayCuatroEnRayaHorizontalEn(turno, tablero, fila, columna)
				|| hayCuatroEnRayaDiagonalAscendenteEn(turno, tablero, fila, columna)
				|| hayCuatroEnRayaDiagonalDescendenteEn(turno, tablero, fila, columna);
	}

	/**
	 * @return true si hay cuatro en raya vertical del jugador especificado
	 *         empezando en (fila,columna)
	 */
	private static boolean hayCuatroEnRayaVerticalEn(int turno, char[][] t, int f, int c) {
		return hayCuatroEnRayaConIncrementosEn(turno, t, f, c, 1, 0);
	}

	/**
	 * @return true si hay cuatro en raya horizontal del jugador especificado
	 *         empezando en (fila,columna)
	 */
	private static boolean hayCuatroEnRayaHorizontalEn(int turno, char[][] t, int f, int c) {
		return hayCuatroEnRayaConIncrementosEn(turno, t, f, c, 0, 1);
	}

	/**
	 * @return true si hay cuatro en raya diagonal ascendente del jugador
	 *         especificado empezando en (fila,columna)
	 */
	private static boolean hayCuatroEnRayaDiagonalAscendenteEn(int turno, char[][] t, int f, int c) {
		return hayCuatroEnRayaConIncrementosEn(turno, t, f, c, -1, 1);
	}

	/**
	 * @return true si hay cuatro en raya en diagonal descendente del jugador
	 *         especificado empezando en (fila,columna)
	 */
	private static boolean hayCuatroEnRayaDiagonalDescendenteEn(int turno, char[][] t, int f, int c) {
		return hayCuatroEnRayaConIncrementosEn(turno, t, f, c, 1, 1);
	}

	private static boolean hayCuatroEnRayaConIncrementosEn(int turno, char[][] t, int f, int c, int iFila,
			int iColumna) {
		char ficha = fichaDeJugador(turno);

		for (int i = 0; i < FICHAS_EN_LINEA; i += 1) {
			if (damePosicion(t, f + iFila * i, c + iColumna * i) != ficha) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param columna
	 *            La columna a inspeccionar
	 * @param tablero
	 * @return la primera fila libre de fichas en la columna especificada, o -1
	 *         si esa columna esta llena o es invalida
	 */
	private static int primeraFilaLibre(int columna, char[][] tablero) {
		for (int f = 0; f < tablero[columna].length; f += 1) {
			if (tablero[columna][f] != VACIO) {
				return f - 1;
			}
		}
		return tablero[columna].length - 1;
	}

	/**
	 * Intenta meter una ficha del jugador en la columna indicada. Si no es
	 * posible (porque la columna esta llena o la columna es invalida) devuelve
	 * false
	 * 
	 * @param tablero
	 * @return true si se puede poner la ficha, false si es un movimiento
	 *         invalido
	 */
	private static boolean meteFicha(int jugador, int columna, char[][] tablero) {
		if (columna < 1 || columna > tablero.length) {
			return false;
		}
		columna -= 1;

		int filaLibre = primeraFilaLibre(columna, tablero);
		boolean esPosibleMeterFicha = filaLibre >= 0;
		if (esPosibleMeterFicha) {
			char ficha = fichaDeJugador(jugador);
			tablero[columna][filaLibre] = ficha;
		}

		return esPosibleMeterFicha;
	}

	/**
	 * @param tablero
	 * @return true si el tablero esta lleno, por lo que la partida ha acabado
	 */
	private static boolean tableroLleno(char[][] tablero) {
		for (int c = 0; c < tablero.length; c++) {
			for (int f = 0; f < tablero[c].length; f++) {
				if (tablero[c][f] == VACIO) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Muestra el tablero por consola
	 * 
	 * @param tablero
	 */
	private static void muestraTablero(char[][] tablero) {
		for (int f = 0; f < tablero[0].length; f++) {
			for (int c = 0; c < tablero.length; c++) {
				System.out.print(tablero[c][f] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Vacia el tablero, dejando todas las casillas a VACIO
	 * 
	 * @param tablero
	 */
	private static void vaciaTablero(char[][] tablero) {
		for (int c = 0; c < tablero.length; c++) {
			for (int f = 0; f < tablero[c].length; f++) {
				tablero[c][f] = VACIO;
			}
		}
	}

	/**
	 *
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// PRIMERA DIMENSION ES COLUMNAS, SEGUNDA FILAS
		char[][] tablero = new char[7][6];

		vaciaTablero(tablero);

		// JUGADOR QUE TIENE EL TURNO, EMPIEZO CON EL DOS PORQUE AL METERME EN
		// EL BUCLE LO CAMBIO AL PRINCIPIO
		int jugador = 2;

		boolean hayGanador = false;

		while (!tableroLleno(tablero) && !hayGanador) {

			jugador = avanzaJugador(jugador);

			muestraTablero(tablero);

			/* PREGUNTAR POR LA COLUMNA E INTENTAR METER LA FICHA */
			int columna = -1;
			boolean fichaMetida = false;
			do {
				columna = preguntaPorColumna(jugador, in);
				fichaMetida = meteFicha(jugador, columna, tablero);
				if (!fichaMetida) {
					System.out.println("Columna invalida");
				}
			} while (!fichaMetida);

			/* SI EL JUGADOR HA GANADO, INDICARLO */
			hayGanador = hayCuatroEnRaya(jugador, tablero);

		}

		muestraTablero(tablero);

		boolean empate = tableroLleno(tablero) && !hayGanador;

		if (empate) {
			System.out.println("Empate");
		} else if (hayGanador) {
			System.out.printf("Ha ganado el jugador %d\n", jugador);
		}
	}

	private static char damePosicion(char[][] tablero, int fila, int columna) {
		if (columna < 0 || columna >= tablero.length) {
			// System.err.println( "AVISO: te estás saliendo del tablero");
			return FUERA;
		}
		if (fila < 0 || fila >= tablero[columna].length) {
			// System.err.println( "AVISO: te estás saliendo del tablero");
			return FUERA;
		}
		return tablero[columna][fila];
	}

	private static int avanzaJugador(int jugador) {
		return jugador % 2 + 1;
	}

	private static int preguntaPorColumna(int jugador, Scanner in) {
		while (true) {
			try {
				System.out.printf("Jugador %d: Que columna?: ", jugador);
				int columna = Integer.parseInt(in.nextLine());
				return columna;
			} catch (NumberFormatException e) {
				System.out.println("No entiendo el número");
			}
		}
	}
}
