package com.baufest.ingreso.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores){
	    //TODO: resolver

        Comparator<Jugador> ordenarJugadores = (p, o) -> Integer.compare(o.getPuntuacion(), p.getPuntuacion());
        ordenarJugadores = ordenarJugadores.thenComparing(p -> p.getNombre());
        Stream<Jugador> jugadorStream = jugadores.stream().sorted(ordenarJugadores);
        List<Jugador> jugadoresList = jugadorStream.collect(Collectors.toList());
        return jugadoresList;

        //throw new UnsupportedOperationException();
	}

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores){

        Comparator<Jugador> orderPlayers = (p, o) -> Integer.compare(o.getPuntuacion(), p.getPuntuacion());
        orderPlayers.thenComparing((p, o) -> Integer.compare(o.getPerdidas(), p.getPerdidas()));
        orderPlayers.thenComparing(p -> p.getNombre());

        Stream<Jugador> playerStream = jugadores.stream().sorted(orderPlayers);
        List<Jugador> playersList = playerStream.collect(Collectors.toList());

        return playersList;

	}
}
