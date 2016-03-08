package futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Estadistica {

    
    private MapaConAutocreacion<String, Set<String>> _equipoToGoleadores = new MapaConAutocreacion<String, Set<String>>(){
		@Override
		protected Set<String> creaUnoNuevo() {
			return new HashSet<String>();
		}
    };
	private List<String> _clasificacionPichichi = new ArrayList<String>();
	private List<String> _clasificacionEquipos = new ArrayList<String>();
	private Map<String, Integer> _jugadorToGoles = new HashMap<String,Integer>();
	private MapaConAutocreacion<String, Integer> _equipoToGanados = new MapaConAutocreacion<String,Integer>(){
		@Override
		protected Integer creaUnoNuevo() {
			return 0;
		}
	};
	

	/**
     * Añade más datos a la estadística
     * @param partido
     * @param goles
     */
    public void agregaPartido( Partido partido, List<Gol> goles ){
        actualizarEquipoToGoleadores(partido,goles);
        actualizarEquipoToGanados(partido,goles);
        actualizarJugadorToGoles(partido,goles);
        actualizarClasificacionEquipos(partido,goles);
        actualizarClasificacionPichichi(partido,goles);
    }
    
    public String equipoGanador( Partido partido, List<Gol> goles ){
    	assert( partido != null );
    	assert( goles != null );
    	int golesLocal = 0;
    	int golesVisitante = 0;
    	for (Gol gol : goles) {
			String equipoMarcador = gol.equipoMarcador();
			if( equipoMarcador.equals( partido.equipoLocal() ) ){
				golesLocal += 1;
			}
			else if(equipoMarcador.equals( partido.equipoVisitante() ) ){
				golesVisitante += 1;
			}
			else{
				throw new IllegalArgumentException("No puede marcar un equipo que no juega:" + equipoMarcador );
			}
		}
    	if( golesLocal == golesVisitante ){
    		return "";
    	}
    	else if( golesLocal > golesVisitante ){
    		return partido.equipoLocal();
    	}
    	else{
    		return partido.equipoVisitante();
    	}
    }
    


	private void actualizarEquipoToGanados(Partido partido, List<Gol> goles) {
		_equipoToGanados.dameYSiNoCrealo(partido.equipoLocal());
		_equipoToGanados.dameYSiNoCrealo(partido.equipoVisitante());

		String ganador = equipoGanador(partido, goles);
		if( ganador.equals("") ){
			return;
		}
		
		int ganados = _equipoToGanados.dameYSiNoCrealo(ganador);
		_equipoToGanados.put(ganador, ganados+1);
	}


	private abstract class MapaConAutocreacion<K,V> extends HashMap<K,V>{
		
		public V dameYSiNoCrealo( K key ){
			if( containsKey(key) ){
				return get(key);
			}
			V value = creaUnoNuevo();
			put( key, value );
			return value;
		}

		protected abstract V creaUnoNuevo();
		
	}


    private class ComparadorDeStringsConHashMap implements Comparator<String>{

		private Map<String, Integer> _mapaDeOrdenacion;

		public ComparadorDeStringsConHashMap( Map<String,Integer> mapaDeOrdenacion){
			_mapaDeOrdenacion = mapaDeOrdenacion;
		}
		
		@Override
		public int compare(String s1, String s2) {
			int i1 = _mapaDeOrdenacion.get(s1);
			int i2 = _mapaDeOrdenacion.get(s2);
			if( i1 > i2 ){
				return -1;
			}
			else if( i1 < i2 ){
				return 1;
			}
			else{
				return s1.compareTo(s2);
			}

		}
		
	}
	
	
	private void actualizarClasificacionEquipos(Partido partido, List<Gol> goles) {
    	final Map<String, Integer> equiposToGanados = numeroDePartidosGanadosPorEquipo();
    	
    	_clasificacionEquipos.clear();
    	_clasificacionEquipos.addAll( equiposToGanados.keySet() );
    	
		Collections.sort(_clasificacionEquipos, new ComparadorDeStringsConHashMap(equiposToGanados) );
	}




	private void actualizarClasificacionPichichi(Partido partido, List<Gol> goles) {
    	final Map<String, Integer> jugadorToGoles = numeroDeGolesMarcadosPorJugador();
    	
    	_clasificacionPichichi.clear();
    	_clasificacionPichichi.addAll( jugadorToGoles.keySet() );
    
		Collections.sort(_clasificacionPichichi,new ComparadorDeStringsConHashMap(jugadorToGoles) );
    	
	}

   
    private void actualizarEquipoToGoleadores(Partido partido, List<Gol> goles) {
    	_equipoToGoleadores.dameYSiNoCrealo(partido.equipoLocal());
    	_equipoToGoleadores.dameYSiNoCrealo(partido.equipoVisitante());

    	for (Gol gol : goles) {
			String equipo = gol.equipoMarcador();
			String jugador = gol.jugador();
			Set<String> goleadores = _equipoToGoleadores.dameYSiNoCrealo(equipo);
			goleadores.add(jugador);
		}
	}
    
    private void actualizarJugadorToGoles(Partido partido, List<Gol> goles) {
		for( Gol gol: goles ){
			String jugador = gol.jugador();
			int golesDeJugador = 0;
			if( _jugadorToGoles.containsKey(jugador) ){
				golesDeJugador = _jugadorToGoles.get(jugador);
			}
			_jugadorToGoles.put(jugador, golesDeJugador+1);
		}
	}


	/**
     * 
     * @param partido
     * @param goles
     * @return El nombre del equipo ganador, o la cadena vacía si se produjo empate
     */

    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor el número de partidos que ha ganado
     */
    public Map<String,Integer> numeroDePartidosGanadosPorEquipo(){
        return Collections.unmodifiableMap(_equipoToGanados);
    }
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de jugador y como valor el número de goles que ha marcado
     */
    public Map<String,Integer> numeroDeGolesMarcadosPorJugador(){
    	return Collections.unmodifiableMap(_jugadorToGoles);
    }
    
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor una conjunto de sus jugadores que hayan marcado un gol.
     *          Si no ha marcado ningún gol, será un conjunto vacía.
     */
    public Map<String,Set<String>> goleadoresPorEquipo(){
        return Collections.unmodifiableMap( _equipoToGoleadores );
    }
    
    /**
     * Lista ordenada con la clasificación de los equipos.
     * Entre dos equipos, va primero el que:
     * - Haya ganado más partidos
     * - Orden alfabético del nombre del equipo
     */
    public List<String> clasificacionEquipos(){
        return Collections.unmodifiableList(_clasificacionEquipos);
    }

    /**
     * Lista ordenada con la clasificación del pichichi.
     * Entre dos jugadores, va primero el que:
     * - Haya metido más goles
     * - Orden alfabético del nombre del jugador
     */
    public List<String> clasificacionPichichi(){
        return Collections.unmodifiableList(_clasificacionPichichi);
    }
    
    /**
     * 
     * @return Un mapa con clave el minuto de partido (0 a ???), 
     *   		y con valores la lista de goles metidos en ese minutos 
     */
    public Map<Integer,List<Gol>> golesPorMinutoDePartido(){
    	throw new UnsupportedOperationException();
    }

}
