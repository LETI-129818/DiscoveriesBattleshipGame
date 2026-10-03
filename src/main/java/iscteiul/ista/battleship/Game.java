
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;
/**
 * Gere o estado do jogo da Batalha Naval, tiros efetuados e embarcações.
 *
 * @author Jorge Fernandes
 * @version 1.0
 */
public class Game implements IGame {
    /**
     * A frota sobre a qual os disparos sÃ£o efetuados.
     */
    private IFleet fleet;

    /**
     * HistÃ³rico de posiÃ§Ãµes onde jÃ¡ foram efetuados disparos vÃ¡lidos.
     */

    private List<IPosition> shots;
    /**
     * Contador de tiros disparados para fora dos limites do tabuleiro.
     */

    private Integer countInvalidShots;
    /**
     * Contador de tiros efetuados em posiÃ§Ãµes onde jÃ¡ se tinha disparado anteriormente.
     */
    private Integer countRepeatedShots;
    /**
     * Contador de tiros que atingiram com sucesso uma posiÃ§Ã£o ocupada por um navio.
     */
    private Integer countHits;
    /**
     * Contador do nÃºmero total de navios completamente afundados durante a partida.
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
     * Efetua um disparo numa determinada posiÃ§Ã£o do tabuleiro.
     * Valida os limites e se a jogada Ã© repetida; caso atinja um navio,
     * aplica o dano e verifica se a embarcaÃ§Ã£o afundou.
     *
     * @param pos PosiÃ§Ã£o do tabuleiro onde o tiro Ã© desferido
     * @return O navio atingido se este tiver acabado de ser afundado pelo tiro; se o tiro for invÃ¡lido, repetido, acertar na Ã¡gua ou nÃ£o afundar o navio
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
     * @return Lista contendo as posiÃ§Ãµes dos tiros registados
     * @see battleship.IGame#getShots()
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Devolve o nÃºmero total de tiros repetidos efetuados na partida.
     *
     * @return NÃºmero de tiros repetidos
     * @see battleship.IGame#getRepeatedShots()
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Devolve o nÃºmero total de tiros invÃ¡lidos efetuados na partida.
     *
     * @return NÃºmero de tiros invÃ¡lidos
     * @see battleship.IGame#getInvalidShots()
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Devolve o nÃºmero total de tiros acertados efetuados na partida.
     *
     * @return NÃºmero de tiros acertados
     * @see battleship.IGame#getHits()
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Devolve o nÃºmero total de navios afundados na partida.
     *
     * @return NÃºmero de navios afundados
     * @see battleship.IGame#getSunkShips()
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Devolve o nÃºmero total de navios que ainda nÃ£o afundaram na partida.
     *
     * @return NÃºmero de navios restantes
     * @see battleship.IGame#getRemainingShips()
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * verifica se a posiÃ§Ã£o fornecida estÃ¡ dentro dos limites do tabuleiro
     * @param pos posiÃ§Ã£o a verificar
     * @return  true se a posiÃ§Ã£o estiver dentro dos limites do tabuleiro; false caso contrÃ¡rio
     */

    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * verifica se a posiÃ§Ã£o fornecida jÃ¡ foi alvo de um tiro anterior
     * @param pos posiÃ§Ã£o a verificar
     * @return true se a posiÃ§Ã£o jÃ¡ tiver sido alvo de um tiro anterior; false caso contrÃ¡rio
     */

    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * imprime o tabuleiro mostrando as posiÃ§Ãµes fornecidas marcadas com o caracter fornecido
     * @param positions Lista de posiÃ§Ãµes a serem marcadas
     * @param marker Caracter para marcar as posiÃ§Ãµes
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
     * imprime o tabuleiro mostrando os tiros vÃ¡lidos efetuados
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }


    /**
     * imprime o tabuleiro mostrando a frota de navios
     *  as posiÃ§Ãµes ocupadas pelos navios sÃ£o marcadas com o caracter '#'
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}



