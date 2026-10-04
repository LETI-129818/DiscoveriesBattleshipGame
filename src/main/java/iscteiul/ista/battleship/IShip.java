package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa um navio no jogo Batalha Naval.
 * Define os atributos do navio (categoria, tamanho, posição, orientação)
 * e as operações para verificar ocupação, proximidade e registar disparos sofridos.
 */
public interface IShip {

    /**
     * Obtém a categoria ou tipo de navio (ex.: "Barca", "Fragata", "Nao").
     *
     * @return o nome da categoria do navio.
     */
    String getCategory();

    /**
     * Obtém o número de posições/células ocupadas pelo navio no tabuleiro.
     *
     * @return o tamanho do navio.
     */
    Integer getSize();

    /**
     * Obtém a lista de todas as posições ocupadas por este navio.
     *
     * @return uma lista de objetos {@link IPosition} que constituem o navio.
     */
    List<IPosition> getPositions();

    /**
     * Obtém a posição de referência (posição inicial/âncora) do navio no tabuleiro.
     *
     * @return a {@link IPosition} de origem do navio.
     */
    IPosition getPosition();

    /**
     * Obtém a orientação/direção da rosa dos ventos para a qual o navio está voltado.
     *
     * @return o ponto cardeal {@link Compass} que indica a orientação.
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda se encontra a flutuar (i.e., se tem pelo menos uma posição não atingida).
     *
     * @return {@code true} se o navio ainda estiver operacional; {@code false} se tiver sido afundado.
     */
    boolean stillFloating();

    /**
     * Obtém o menor índice de linha ocupado pelo navio (posição mais a norte/topo).
     *
     * @return o índice da linha limite superior.
     */
    int getTopMostPos();

    /**
     * Obtém o maior índice de linha ocupado pelo navio (posição mais a sul/fundo).
     *
     * @return o índice da linha limite inferior.
     */
    int getBottomMostPos();

    /**
     * Obtém o menor índice de coluna ocupado pelo navio (posição mais a oeste/esquerda).
     *
     * @return o índice da coluna limite esquerda.
     */
    int getLeftMostPos();

    /**
     * Obtém o maior índice de coluna ocupado pelo navio (posição mais a este/direita).
     *
     * @return o índice da coluna limite direita.
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma posição específica no tabuleiro.
     *
     * @param pos a posição ({@link IPosition}) a testar.
     * @return {@code true} se o navio ocupar essa posição; {@code false} caso contrário.
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio está demasiado próximo de outro navio, violando as regras de espaçamento e proximidade.
     *
     * @param other o outro navio ({@link IShip}) a comparar.
     * @return {@code true} se estiverem demasiado próximos/adjacentes; {@code false} caso contrário.
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se o navio está demasiado próximo de uma posição específica.
     *
     * @param pos a posição ({@link IPosition}) a testar.
     * @return {@code true} se a posição for adjacente ou sobreposta; {@code false} caso contrário.
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Regista um disparo atingido na posição especificada do navio.
     *
     * @param pos a posição ({@link IPosition}) visada pelo tiro.
     */
    void shoot(IPosition pos);
}