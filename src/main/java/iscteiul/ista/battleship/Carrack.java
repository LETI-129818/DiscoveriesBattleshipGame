package iscteiul.ista.battleship;

/**
 * Representa uma Nau no jogo Batalha Naval.
 * A Nau é um navio de grande porte que ocupa 3 posições/células consecutivas no tabuleiro,
 * alinhadas verticalmente (Norte/Sul) ou horizontalmente (Este/Oeste) consoante a sua orientação.
 */
public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova Nau com a orientação e posição inicial especificadas.
     * Calcula e adiciona as 3 posições ocupadas pelo navio à lista de posições com base na orientação ({@link Compass}).
     *
     * @param bearing a orientação/direção da rosa dos ventos ({@link Compass}) para onde a nau está voltada.
     * @param pos     a posição inicial/célula de ancoragem ({@link IPosition}) para o posicionamento da nau.
     * @throws IllegalArgumentException se a orientação ({@code bearing}) for inválida para o cálculo das posições.
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
     * Obtém o tamanho da nau (número de células ocupadas no tabuleiro).
     *
     * @return o tamanho fixo da nau (3).
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}