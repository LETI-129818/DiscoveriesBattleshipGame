package iscteiul.ista.battleship;

/**
 * Representa uma Barca no jogo Batalha Naval.
 * A Barca é um navio de dimensão mínima (ocupa apenas 1 posição/célula no tabuleiro).
 */
public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

    /**
     * Constrói uma nova Barca com a orientação e posição inicial especificadas.
     * Adiciona a posição inicial à lista de posições ocupadas pelo navio.
     *
     * @param bearing a orientação/direção da rosa dos ventos ({@link Compass}) da barca.
     * @param pos     a posição inicial/célula ({@link IPosition}) ocupada pela barca no tabuleiro.
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Obtém o tamanho da barca (número de células ocupadas no tabuleiro).
     *
     * @return o tamanho fixo da barca (1).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}