package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa um navio abstrato do jogo, definido pela categoria, orientação e
 * posição inicial, e pelas posições que ocupa no tabuleiro.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Cria um navio do tipo indicado.
     *
     * @param shipKind identificador do tipo de navio
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     * @return navio correspondente ao identificador, ou {@code null} se o tipo
     *         não for reconhecido
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Inicializa um navio com a categoria, orientação e posição indicadas.
     * As posições ocupadas são preenchidas pela subclasse concreta.
     *
     * @param category categoria do navio
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Obtém a categoria deste navio.
     *
     * @return categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Obtém a lista das posições ocupadas por este navio.
     * A lista devolvida é a lista interna e pode ser alterada.
     *
     * @return lista mutável das posições ocupadas
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Obtém a posição inicial deste navio.
     *
     * @return posição inicial
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Obtém a orientação deste navio.
     *
     * @return orientação do navio
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se pelo menos uma das posições ocupadas ainda não foi atingida.
     *
     * @return {@code true} se o navio ainda estiver a flutuar;
     *         {@code false} se todas as posições estiverem atingidas
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Obtém o índice da linha mais acima ocupada pelo navio.
     *
     * @return menor índice de linha entre as posições ocupadas
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Obtém o índice da linha mais abaixo ocupada pelo navio.
     *
     * @return maior índice de linha entre as posições ocupadas
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Obtém o índice da coluna mais à esquerda ocupada pelo navio.
     *
     * @return menor índice de coluna entre as posições ocupadas
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Obtém o índice da coluna mais à direita ocupada pelo navio.
     *
     * @return maior índice de coluna entre as posições ocupadas
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Verifica se este navio ocupa a posição indicada.
     *
     * @param pos posição a verificar
     * @return {@code true} se o navio ocupar essa posição; {@code false} caso
     *         contrário
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Verifica se este navio está adjacente a alguma posição de outro navio.
     * A adjacência inclui diagonais e posições coincidentes.
     *
     * @param other navio a verificar
     * @return {@code true} se pelo menos uma posição dos navios for adjacente
     *         ou coincidente; {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Verifica se alguma posição ocupada por este navio está adjacente ou
     * coincide com a posição indicada. A adjacência inclui diagonais.
     *
     * @param pos posição a verificar
     * @return {@code true} se houver adjacência ou coincidência;
     *         {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /**
     * Marca como atingidas as posições deste navio que coincidam com a posição
     * indicada.
     *
     * @param pos posição atingida
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }


    /**
     * Devolve uma representação textual da categoria, orientação e posição
     * inicial deste navio.
     *
     * @return representação textual do navio
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}
