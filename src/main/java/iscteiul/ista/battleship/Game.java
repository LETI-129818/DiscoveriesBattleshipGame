/**
 *
 * @author O Teu Nome
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author O Teu Nome
 * @version 1.0
 */
public class Game implements IGame {
    /**
     * A frota sobre a qual os disparos são efetuados.
     */
    private IFleet fleet;

    /**
     * Histórico de posições onde já foram efetuados disparos válidos.
     */

    private List<IPosition> shots;
    /**
     * Contador de tiros disparados para fora dos limites do tabuleiro.
     */

    private Integer countInvalidShots;
    /**
     * Contador de tiros efetuados em posições onde já se tinha disparado anteriormente.
     */
    private Integer countRepeatedShots;
    /**
     * Contador de tiros que atingiram com sucesso uma posição ocupada por um navio.
     */
    private Integer countHits;
    /**
     * Contador do número total de navios completamente afundados durante a partida.
     */
    private Integer countSinks;


    /**
     * inicializa um novo jogo
     * coloca a zero todo o historico de tiros e todos os contadores de estatisticas
     * @param fleet A frota de navios alvo para o jogo
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     *
     * Efetua um disparo numa determinada posição do tabuleiro.
     * Valida os limites e se a jogada é repetida; caso atinja um navio,
     * aplica o dano e verifica se a embarcação afundou.
     *
     * @param pos Posição do tabuleiro onde o tiro é desferido
     * @return O navio atingido se este tiver acabado de ser afundado pelo tiro; se o tiro for inválido, repetido, acertar na água ou não afundar o navio
     *
     * @see battleship.IGame#fire(battleship.IPosition)
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @return Lista contendo as posições dos tiros registados
     * @see battleship.IGame#getShots()
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Devolve o número total de tiros repetidos efetuados na partida.
     *
     * @return Número de tiros repetidos
     * @see battleship.IGame#getRepeatedShots()
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Devolve o número total de tiros inválidos efetuados na partida.
     *
     * @return Número de tiros inválidos
     * @see battleship.IGame#getInvalidShots()
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Devolve o número total de tiros acertados efetuados na partida.
     *
     * @return Número de tiros acertados
     * @see battleship.IGame#getHits()
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Devolve o número total de navios afundados na partida.
     *
     * @return Número de navios afundados
     * @see battleship.IGame#getSunkShips()
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Devolve o número total de navios que ainda não afundaram na partida.
     *
     * @return Número de navios restantes
     * @see battleship.IGame#getRemainingShips()
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * verifica se a posição fornecida está dentro dos limites do tabuleiro
     * @param pos posição a verificar
     * @return  true se a posição estiver dentro dos limites do tabuleiro; false caso contrário
     */

    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * verifica se a posição fornecida já foi alvo de um tiro anterior
     * @param pos posição a verificar
     * @return true se a posição já tiver sido alvo de um tiro anterior; false caso contrário
     */

    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * imprime o tabuleiro mostrando as posições fornecidas marcadas com o caracter fornecido
     * @param positions Lista de posições a serem marcadas
     * @param marker Caracter para marcar as posições
     */

    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }


    /**
     * imprime o tabuleiro mostrando os tiros válidos efetuados
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }


    /**
     * imprime o tabuleiro mostrando a frota de navios
     *  as posições ocupadas pelos navios são marcadas com o caracter '#'
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
