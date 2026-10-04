package iscteiul.ista.battleship;

/**
 * Representa uma Caravela no jogo Batalha Naval.
 * A Caravela é um navio de dimensão intermédia que ocupa 2 posições/células consecutivas no tabuleiro,
 * alinhadas verticalmente (Norte/Sul) ou horizontalmente (Este/Oeste) consoante a sua orientação.
 */
public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * Constrói uma nova Caravela com a orientação e posição inicial especificadas.
     * Calcula e adiciona as 2 posições ocupadas pelo navio à lista de posições com base na orientação ({@link Compass}).
     *
     * @param bearing a orientação/direção da rosa dos ventos ({@link Compass}) para onde a caravela está voltada.
     * @param pos     a posição inicial/célula de ancoragem ({@link IPosition}) para o posicionamento da caravela.
     * @throws NullPointerException     se a orientação ({@code bearing}) for nula.
     * @throws IllegalArgumentException se a orientação ({@code bearing}) for inválida para o cálculo das posições.
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
     * Obtém o tamanho da caravela (número de células ocupadas no tabuleiro).
     *
     * @return o tamanho fixo da caravela (2).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}