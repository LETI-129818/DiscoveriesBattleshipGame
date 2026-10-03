package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Fragata no jogo da Batalha Naval.
 *
 * @author Jorge Fernandes
 * @version 1.0
 */
public class Frigate extends Ship {
    private static final Integer SIZE = 4;
    private static final String NAME = "Fragata";

    /**
     * @param bearing orientação do navio (NORTE, SUL, ESTE ou OESTE)
     * @param pos pos posição inicial do navio
     * @throws IllegalArgumentException se a orientação fornecida for nula ou inválida
     *
     *
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * @return O numero de celulas ocupadas pelo navio (4)
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}

