package org.makson.cell;

import org.makson.Coordinates;

public class Cell implements Comparable<Cell> {
    private int lengthFromStartToCurrent;
    private int manhattanDistance;
    private int totalWeight;
    private final Cell previousCell;
    private final Coordinates coordinates;
    private boolean isLock;

    public Cell(Coordinates coordinates, Cell previousCell) {
        this.coordinates = coordinates;
        this.previousCell = previousCell;
        this.isLock = false;
        setLengthFromStartToCurrent();
    }

    public void findManhattanDistance(Coordinates coordinatesTo) {
        manhattanDistance = (Math.abs((this.coordinates.x()) - coordinatesTo.x())
                + Math.abs((this.coordinates.y()) - coordinatesTo.y())) * 10;

        calculateTotalWeight();
    }

    public void lock() {
        isLock = true;
    }

    public boolean isLock() {
        return isLock;
    }

    public int getLengthFromStartToCurrent() {
        return lengthFromStartToCurrent;
    }

    public Cell getPreviousCell() {
        return previousCell;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    private void calculateTotalWeight() {
        totalWeight = lengthFromStartToCurrent + manhattanDistance;
    }

    private void setLengthFromStartToCurrent() {
        if (previousCell == null) {
            lengthFromStartToCurrent = 0;
        } else if ((previousCell.coordinates.x() == coordinates.x()) || (previousCell.coordinates.y() == coordinates.y())) {
            lengthFromStartToCurrent = previousCell.getLengthFromStartToCurrent() + 10;
        } else {
            lengthFromStartToCurrent = previousCell.getLengthFromStartToCurrent() + 14;
        }
    }

    @Override
    public int compareTo(Cell cell) {
        return Integer.compare(this.getTotalWeight(), cell.getTotalWeight());
    }
}
