package iscteiul.ista.battleship;

/**
 * Representa uma embarcação do tipo Barca no jogo da Batalha Naval.
 * <p>
 * A Barca é a menor embarcação do jogo, ocupando apenas 1 posição na grelha.
 * </p>
 *
 * @author Grupo
 * @version 1.0
 */
public class Barge extends Ship {

    /** Tamanho/comprimento da Barca (1 célula). */
    private static final Integer SIZE = 1;

    /** Nome descritivo da embarcação. */
    private static final String NAME = "Barca";

    /**
     * Constrói uma nova Barca com a orientação e posição inicial especificadas.
     *
     * @param bearing A orientação/rosa dos ventos da embarcação (ex.: Norte, Sul, Este, Oeste).
     * @param pos     A posição inicial (canto superior esquerdo) da embarcação no tabuleiro.
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Obtém o tamanho da Barca.
     *
     * @return O número de posições ocupadas pela Barca no tabuleiro (sempre 1).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
