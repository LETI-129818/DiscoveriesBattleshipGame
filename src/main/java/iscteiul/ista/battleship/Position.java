package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma posição do tabuleiro, identificada por uma linha e uma coluna.
 * Mantém também os estados de ocupação e de acerto da posição.
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Cria uma posição com as coordenadas indicadas, inicialmente livre e não atingida.
     *
     * @param row linha da posição
     * @param column coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Obtém a linha desta posição.
     *
     * @return índice da linha
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Obtém a coluna desta posição.
     *
     * @return índice da coluna
     */
    @Override
    public int getColumn() {
        return column;
    }


    /**
     * Calcula o código hash desta posição.
     *
     * @return código hash da posição
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outra posição pelas respetivas coordenadas.
     *
     * @param otherPosition objeto a comparar
     * @return {@code true} se o objeto representar a mesma linha e coluna;
     *         {@code false} caso contrário
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se outra posição está nesta célula ou numa das oito células
     * vizinhas, incluindo as diagonais.
     *
     * @param other posição a comparar
     * @return {@code true} se a diferença entre cada coordenada for, no máximo,
     *         uma unidade; {@code false} caso contrário
     * @throws NullPointerException se {@code other} for {@code null}
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca esta posição como ocupada.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marca esta posição como atingida.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Verifica se esta posição está ocupada.
     *
     * @return {@code true} se estiver ocupada; {@code false} caso contrário
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se esta posição foi atingida.
     *
     * @return {@code true} se tiver sido atingida; {@code false} caso contrário
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Devolve uma representação textual das coordenadas desta posição.
     *
     * @return texto com a linha e a coluna
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
