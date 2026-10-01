package iscteiul.ista.battleship;

/**
 * Representa os pontos cardeais (rosa dos ventos) e a orientação no jogo da Batalha Naval.
 * <p>
 * Cada direção está associada a um caráter identificador ('n', 's', 'e', 'o', 'u').
 * </p>
 *
 * @author fba
 * @version 1.0
 */
public enum Compass {

    /** Orientação Norte ('n'). */
    NORTH('n'),

    /** Orientação Sul ('s'). */
    SOUTH('s'),

    /** Orientação Este/Leste ('e'). */
    EAST('e'),

    /** Orientação Oeste ('o'). */
    WEST('o'),

    /** Orientação desconhecida ou inválida ('u'). */
    UNKNOWN('u');

    /** Caráter que representa a direção. */
    private final char c;

    /**
     * Constrói uma constante da rosa dos ventos associada a um caráter específico.
     *
     * @param c O caráter correspondente à direção.
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Retorna a representação em texto do caráter da direção.
     *
     * @return String contendo o caráter da direção.
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um caráter na respetiva constante do tipo {@link Compass}.
     *
     * @param ch O caráter a converter ('n', 's', 'e', 'o').
     * @return A constante {@link Compass} correspondente, ou {@link Compass#UNKNOWN} se o caráter for inválido.
     */
    static Compass charToCompass(char ch) {
        Compass bearing = switch (ch) {
            case 'n' -> NORTH;
            case 's' -> SOUTH;
            case 'e' -> EAST;
            case 'o' -> WEST;
            default -> UNKNOWN;
        };

        return bearing;
    }
}