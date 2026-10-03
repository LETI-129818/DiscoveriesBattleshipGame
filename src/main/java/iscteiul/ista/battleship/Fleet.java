
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;
/**
 * esta classe representa um frota de navios no jogo da Batalha Naval
 *
 *  @author Jorge Fernandes
 * @version 1.0
 */

public class Fleet implements IFleet {
    /**
     * This operation prints all the given ships
     *
     * @param ships The list of ships
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    public Fleet() {
        ships = new ArrayList<>();
    }

    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota, desde que a capacidade máxima não tenha sido atingida,
     * o navio fique totalmente contido no tabuleiro e não colida nem fique adjacente a outros.
     *
     * @param s O navio a ser adicionado à frota
     * @return {@code true} se o navio foi adicionado com sucesso; {@code false} caso contrário
     + @see battleship.IFleet#addShip(battleship.IShip)
     *
     * @see battleship.IFleet#addShip(battleship.IShip)
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * @param category Nome da categoria de navios pretendida (ex.: "Galeao", "Fragata")
     * @return Lista de navios correspondentes à categoria especificada
     * @see battleship.IFleet#getShipsLike(java.lang.String)
     *
     * @see battleship.IFleet#getShipsLike(java.lang.String)
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * (non-Javadoc)
     *
     * @return Lista de navios que continuam a flutuar
     * @see battleship.IFleet#getFloatingShips()
     *
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     *
     *@param pos Posição do tabuleiro a consultar
     *@return A instância de {@link IShip} presente na posição, se a posição estiver desocupada
     * @see battleship.IFleet#shipAt(battleship.IPosition)
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }
    /**
     * Verifica se todas as posições ocupadas pelo navio se encontram dentro dos limites do tabuleiro.
     *
     * @param s Navio a verificar
     * @return  se o navio estiver totalmente dentro do tabuleiro; {@code false} caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }
    /**
     * Verifica se o navio a colocar colide ou fica encostado a algum dos navios já existentes na frota.
     *
     * @param s Navio a validar
     * @return se existir risco de colisão ou sobreposição; {@code false} se o posicionamento for válido
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }


    /**
     * This operation shows the state of a fleet
     *
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * This operation prints all the ships of a fleet belonging to a particular
     * category
     *
     * @param category The category of ships of interest
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * This operation prints all the ships of a fleet but not yet shot
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * This operation prints all the ships of a fleet
     */
    void printAllShips() {
        printShips(ships);
    }

}
