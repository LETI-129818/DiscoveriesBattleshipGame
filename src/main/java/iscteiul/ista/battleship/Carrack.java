package iscteiul.ista.battleship;

/**
 * Representa uma embarcação do tipo Nau no jogo da Batalha Naval.
 * <p>
 * A Nau ocupa 3 posições consecutivas no tabuleiro, dispostas
 * na vertical (Norte/Sul) ou na horizontal (Este/Oeste).
 * </p>
 *
 * @author Grupo
 * @version 1.0
 */
public class Carrack extends Ship {

    /** Tamanho/comprimento da Nau (3 células). */
    private static final Integer SIZE = 3;

    /** Nome descritivo da embarcação. */
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova Nau com a orientação e posição inicial especificadas,
     * ocupando 3 posições contíguas a partir do ponto de origem.
     *
     * @param bearing A orientação/rosa dos ventos da Nau (Norte, Sul, Este ou Oeste).
     * @param pos     A posição inicial (canto superior/esquerdo) da Nau no tabuleiro.
     * @throws IllegalArgumentException Se a orientação facultada for inválida ou nula.
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Obtém o tamanho da Nau.
     *
     * @return O número de posições ocupadas pela Nau no tabuleiro (sempre 3).
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}