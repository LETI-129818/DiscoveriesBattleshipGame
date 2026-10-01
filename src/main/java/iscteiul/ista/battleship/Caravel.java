package iscteiul.ista.battleship;

/**
 * Representa uma embarcação do tipo Caravela no jogo da Batalha Naval.
 * <p>
 * A Caravela ocupa 2 posições consecutivas no tabuleiro, organizadas
 * verticalmente (Norte/Sul) ou horizontalmente (Este/Oeste).
 * </p>
 *
 * @author Grupo
 * @version 1.0
 */
public class Caravel extends Ship {

    /** Tamanho/comprimento da Caravela (2 células). */
    private static final Integer SIZE = 2;

    /** Nome descritivo da embarcação. */
    private static final String NAME = "Caravela";

    /**
     * Constrói uma nova Caravela com a orientação e posição inicial especificadas,
     * ocupando as posições subsequentes consoante a orientação.
     *
     * @param bearing A orientação/rosa dos ventos da Caravela (Norte, Sul, Este ou Oeste).
     * @param pos     A posição inicial (ponto de origem) da Caravela no tabuleiro.
     * @throws NullPointerException     Se {@code bearing} ou {@code pos} for nulo.
     * @throws IllegalArgumentException Se a orientação facultada for inválida.
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Obtém o tamanho da Caravela.
     *
     * @return O número de posições ocupadas pela Caravela no tabuleiro (sempre 2).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
