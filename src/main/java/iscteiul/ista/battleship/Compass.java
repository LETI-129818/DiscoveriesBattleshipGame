package iscteiul.ista.battleship;

/**
 * Representa os pontos cardeais da rosa dos ventos para orientação no jogo Batalha Naval.
 * Mapeia cada direção (Norte, Sul, Este, Oeste ou Desconhecido) para o respetivo
 * caráter identificador.
 *
 * @author fba
 */
public enum Compass {
    /**
     * Direção Norte ('n').
     */
    NORTH('n'),

    /**
     * Direção Sul ('s').
     */
    SOUTH('s'),

    /**
     * Direção Este/Leste ('e').
     */
    EAST('e'),

    /**
     * Direção Oeste ('o').
     */
    WEST('o'),

    /**
     * Direção Desconhecida ou inválida ('u').
     */
    UNKNOWN('u');

    private final char c;

    /**
     * Construtor interno do enumerado Compass.
     *
     * @param c o caráter associado à direção cardeal.
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Obtém o caráter correspondente à direção deste ponto cardeal.
     *
     * @return o caráter associado à direção (ex.: 'n', 's', 'e', 'o', 'u').
     */
    public char getDirection() {
        return c;
    }

    /**
     * Devolve a representação em texto do ponto cardeal (o próprio caráter da direção).
     *
     * @return uma {@link String} contendo o caráter representativo da direção.
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um caráter num valor correspondente do enumerado {@link Compass}.
     *
     * @param ch o caráter a converter ('n', 's', 'e', 'o').
     * @return o ponto cardeal ({@link Compass}) associado ao caráter, ou {@link Compass#UNKNOWN} caso seja inválido.
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}