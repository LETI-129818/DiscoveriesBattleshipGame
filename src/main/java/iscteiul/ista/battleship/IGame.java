package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa o motor do jogo Batalha Naval.
 * Define os métodos para efetuar disparos e acompanhar as estatísticas da partida,
 * tais como tiros válidos, repetidos, inválidos e acertos efetuados.
 */
public interface IGame {

    /**
     * Efetua um disparo numa posição específica do tabuleiro.
     *
     * @param pos a posição ({@link IPosition}) visada pelo tiro.
     * @return o navio atingido ({@link IShip}) se o tiro acertar num alvo, ou {@code null} se acertar na água ou for inválido.
     */
    IShip fire(IPosition pos);

    /**
     * Obtém a lista de todas as posições onde foram efetuados disparos durante o jogo.
     *
     * @return uma lista de objetos {@link IPosition} correspondentes aos tiros disparados.
     */
    List getShots();

    /**
     * Obtém o número total de tiros repetidos (disparos efetuados em posições previamente atingidas).
     *
     * @return o número de tiros repetidos.
     */
    int getRepeatedShots();

    /**
     * Obtém o número total de tiros inválidos (disparos fora dos limites do tabuleiro ou que violam as regras).
     *
     * @return o número de tiros inválidos.
     */
    int getInvalidShots();

    /**
     * Obtém o número total de tiros bem-sucedidos que atingiram um navio.
     *
     * @return o número total de acertos.
     */
    int getHits();

    /**
     * Obtém o número total de navios da frota que já foram completamente afundados.
     *
     * @return o número de navios afundados.
     */
    int getSunkShips();

    /**
     * Obtém o número de navios da frota que ainda se encontram a flutuar/operacionais.
     *
     * @return o número de navios restantes.
     */
    int getRemainingShips();

    /**
     * Imprime na consola uma representação visual da grelha do tabuleiro contendo apenas os tiros válidos.
     */
    void printValidShots();

    /**
     * Imprime na consola uma representação visual do tabuleiro mostrando a localização e o estado de todos os navios da frota.
     */
    void printFleet();
}