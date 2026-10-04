package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa a frota de navios no jogo Batalha Naval.
 * Define as dimensões do tabuleiro, o limite do tamanho da frota e as
 * operações para gerir e consultar os navios pertencentes à frota.
 */
public interface IFleet {
    /**
     * Tamanho padrão da grelha do tabuleiro (10x10).
     */
    Integer BOARD_SIZE = 10;

    /**
     * Número máximo de navios permitidos na frota.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Obtém a lista completa de navios que constituem a frota.
     *
     * @return uma lista contendo todos os objetos {@link IShip} da frota.
     */
    List getShips();

    /**
     * Adiciona um novo navio à frota caso este cumpra as regras de validação e posicionamento.
     *
     * @param s o navio ({@link IShip}) a ser adicionado à frota.
     * @return {@code true} se o navio foi adicionado com sucesso; {@code false} caso contrário.
     */
    boolean addShip(IShip s);

    /**
     * Retorna uma lista com os navios da frota pertencentes a uma categoria específica.
     *
     * @param category a categoria/tipo de navio a procurar (ex.: "Barca", "Fragata").
     * @return uma lista de objetos {@link IShip} que correspondem à categoria especificada.
     */
    List getShipsLike(String category);

    /**
     * Obtém apenas os navios da frota que ainda se encontram a flutuar (não afundados).
     *
     * @return uma lista contendo todos os objetos {@link IShip} ativos/operacionais.
     */
    List getFloatingShips();

    /**
     * Procura e devolve o navio que ocupa uma posição específica no tabuleiro.
     *
     * @param pos a posição ({@link IPosition}) a verificar no tabuleiro.
     * @return o navio ({@link IShip}) presente nessa posição, ou {@code null} se a posição estiver vazia.
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime o estado atual da frota na consola (ex.: navios restantes, atingidos ou afundados).
     */
    void printStatus();
}