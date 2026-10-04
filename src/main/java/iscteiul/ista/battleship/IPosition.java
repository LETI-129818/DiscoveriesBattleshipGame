package iscteiul.ista.battleship;

/**
 * Representa uma posição (célula) na grelha do tabuleiro de jogo.
 * Define as coordenadas de linha e coluna, o estado de ocupação por um navio
 * e o histórico de tiros efetuados nessa célula.
 *
 * @author fba
 */
public interface IPosition {

    /**
     * Obtém o índice da linha correspondente a esta posição.
     *
     * @return o número da linha.
     */
    int getRow();

    /**
     * Obtém o índice da coluna correspondente a esta posição.
     *
     * @return o número da coluna.
     */
    int getColumn();

    /**
     * Compara esta posição com outro objeto para verificar se são iguais.
     * Duas posições são consideradas iguais se tiverem a mesma linha e coluna.
     *
     * @param other o objeto a comparar com esta posição.
     * @return {@code true} se o objeto for uma posição com coordenadas idênticas; {@code false} caso contrário.
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente (vertical, horizontal ou diagonalmente) a outra posição.
     *
     * @param other a outra posição ({@link IPosition}) para comparar a proximidade.
     * @return {@code true} se as posições forem vizinhas/adjacentes; {@code false} caso contrário.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como ocupada por um segmento de um navio.
     */
    void occupy();

    /**
     * Regista que foi efetuado um disparo nesta posição.
     */
    void shoot();

    /**
     * Verifica se esta posição se encontra atualmente ocupada por um navio.
     *
     * @return {@code true} se estiver ocupada; {@code false} se estiver livre.
     */
    boolean isOccupied();

    /**
     * Verifica se esta posição já foi atingida por um disparo.
     *
     * @return {@code true} se já tiver sido alvo de um tiro; {@code false} caso contrário.
     */
    boolean isHit();
}