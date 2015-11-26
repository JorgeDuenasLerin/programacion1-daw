public class Banner {

	private static String[] LETRA_ESPACIO = { "  ", "  ", "  ", "  ", "  ", "  ", "  ", };

	private static String[] LETRA_A = { "   ##   ", "  #  #  ", " #    # ", " ###### ", " #    # ", " #    # ", };
	private static String[] LETRA_B = { " #####  ", " #    # ", " #####  ", " #    # ", " #    # ", " #####  ", };
	private static String[] LETRA_C = { "  ####  ", " #    # ", " #      ", " #      ", " #    # ", "  ####  ", };
	private static String[] LETRA_D = { " #####  ", " #    # ", " #    # ", " #    # ", " #    # ", " #####  ", };
	private static String[] LETRA_E = { " ###### ", " #      ", " #####  ", " #      ", " #      ", " ###### ", };
	private static String[] LETRA_F = { " ###### ", " #      ", " #####  ", " #      ", " #      ", " #      ", };
	private static String[] LETRA_G = { "  ####  ", " #    # ", " #      ", " #  ### ", " #    # ", "  ####  ", };
	private static String[] LETRA_H = { " #    # ", " #    # ", " ###### ", " #    # ", " #    # ", " #    # ", };
	private static String[] LETRA_I = { " # ", " # ", " # ", " # ", " # ", " # ", };
	private static String[] LETRA_J = { "      # ", "      # ", "      # ", "      # ", " #    # ", "  ####  ", };
	private static String[] LETRA_K = { " #    # ", " #   #  ", " ####   ", " #  #   ", " #   #  ", " #    # ", };
	private static String[] LETRA_L = { " #      ", " #      ", " #      ", " #      ", " #      ", " ###### ", };
	private static String[] LETRA_M = { " #    # ", " ##  ## ", " # ## # ", " #    # ", " #    # ", " #    # ", };
	private static String[] LETRA_N = { " #    # ", " ##   # ", " # #  # ", " #  # # ", " #   ## ", " #    # ", };
	private static String[] LETRA_O = { "  ####  ", " #    # ", " #    # ", " #    # ", " #    # ", "  ####  ", };
	private static String[] LETRA_P = { " #####  ", " #    # ", " #    # ", " #####  ", " #      ", " #      ", };
	private static String[] LETRA_Q = { "  ####  ", " #    # ", " #    # ", " #  # # ", " #   #  ", "  ### # ", };
	private static String[] LETRA_R = { " #####  ", " #    # ", " #    # ", " #####  ", " #   #  ", " #    # ", };
	private static String[] LETRA_S = { "  ####  ", " #      ", "  ####  ", "      # ", " #    # ", "  ####  ", };
	private static String[] LETRA_T = { " ##### ", "   #   ", "   #   ", "   #   ", "   #   ", "   #   ", };
	private static String[] LETRA_U = { " #    # ", " #    # ", " #    # ", " #    # ", " #    # ", "  ####  ", };
	private static String[] LETRA_V = { " #    # ", " #    # ", " #    # ", " #    # ", "  #  #  ", "   ##   ", };
	private static String[] LETRA_W = { " #    # ", " #    # ", " #    # ", " # ## # ", " ##  ## ", " #    # ", };
	private static String[] LETRA_X = { " #    # ", "  #  #  ", "   ##   ", "   ##   ", "  #  #  ", " #    # ", };
	private static String[] LETRA_Y = { " #   # ", "  # #  ", "   #   ", "   #   ", "   #   ", "   #   ", };
	private static String[] LETRA_Z = { " ###### ", "     #  ", "    #   ", "   #    ", "  #     ", " ###### ", };

	private static final int ALTO_LETRA = LETRA_ESPACIO.length;
	private static final int ANCHO_MAXIMO_LETRA = LETRA_A[0].length();

	private static String[][] LETRAS = { LETRA_A, LETRA_B, LETRA_C, LETRA_D, LETRA_E, LETRA_F, LETRA_G, LETRA_H,
			LETRA_I, LETRA_J, LETRA_K, LETRA_L, LETRA_M, LETRA_N, LETRA_O, LETRA_P, LETRA_Q, LETRA_R, LETRA_S, LETRA_T,
			LETRA_U, LETRA_V, LETRA_W, LETRA_X, LETRA_Y, LETRA_Z };

	/**
     * Devuelve la letra asociada a un caracter
     * 
     * @param caracter
     *            La letra solicitada
     * @return El array de String que forma la letra
     */
    private static String[] letraParaCaracter( char caracter ){
    	if( caracter == ' '){
    		return LETRA_ESPACIO;
    	}
    	
    	return LETRAS[caracter-'a'];
    }

	/**
     * Escribe una letra en la pantalla, en cierta posicion horizontal
     * 
     * @param letra
     *            Un array de cadenas que definen una letra en pantalla
     * @param columna
     *            La posicion horizontal (columna) donde se escribira la letra
     * @param pantalla
     *            La primera dimension es la columna, y la segunda las filas
     * @return El array de String que forma la letra
     */
    private static void escribeLetraEnPantalla( String[] letra, int columna, char[][] pantalla ){
        for (int f = 0; f < letra.length; f++) {
        	for (int c = 0; c < letra[f].length(); c++) {
				char cs = letra[f].charAt(c);
				pantalla[c+columna][f] = cs;
			}
		}
    }

	/**
	 * Imprime un array bidimensional rectangular de char en la consola
	 * 
	 * @param pantalla
	 *            La primera dimension es la columna, y la segunda las filas
	 * @return El array de String que forma la letra
	 */
	private static void imprimePantalla(char[][] pantalla) {
		for (int f = 0; f < pantalla[0].length; f++) {
			for (int c = 0; c < pantalla.length; c++) {
				System.out.print(pantalla[c][f]);
			}
			System.out.println();
		}
	}

	/**
         *
         */
    public static void main( String[] args ){
    	
    	if( args.length == 0 ){
    		args = new String[]{ "argumentos", "de", "prueba" };
    	}
    	
        String cadenaAImprimir = calculaCadenaAImprimir(args);
        int longitudCadenaAImprimir = cadenaAImprimir.length();

        // 1 DIMENSION: ANCHO (COLUMNAS)
        // 2 DIMENSION: ALTO (FILAS)
        char[][] pantalla = new char[ANCHO_MAXIMO_LETRA*longitudCadenaAImprimir][ALTO_LETRA];
        

		int columna = 0;
        for( int i = 0 ; i < longitudCadenaAImprimir; i++ ){
            char c = cadenaAImprimir.charAt(i);
            /* USO letraParaCaracter Y escribeLetraEnPantalla */
            
            String[] plantilla = letraParaCaracter(c);
			escribeLetraEnPantalla(plantilla, columna, pantalla);
			columna += anchoDePlantilla(plantilla);
        }
        
        /* USO imprimePantalla */

        imprimePantalla(pantalla);
    }

	private static int anchoDePlantilla(String[] plantilla) {
		return plantilla[0].length();
	}

	private static String calculaCadenaAImprimir(String[] args) {
		String ret = "";
		for (String s : args) {
			ret  += s + " ";
		}
		return ret;
	}
}
