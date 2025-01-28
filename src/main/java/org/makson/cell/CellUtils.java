package org.makson.cell;

import org.makson.Coordinates;
import org.makson.Validator;
import org.makson.field.Field;

import java.util.*;

public class CellUtils {
    private static Cell getShortPathAsCell(Coordinates from, Coordinates to, Field field) throws NoSuchElementException {
        Map<Coordinates, Cell> checkedCell = new HashMap<>();
        checkedCell.put(from, new Cell(from, null));


        while (!checkedCell.containsKey(to)) {
            Cell activeCell = checkedCell.values().stream()
                    .filter(cell -> !cell.isLock())
                    .min(Comparator.comparingInt(Cell::getTotalWeight))
                    .get();
            activeCell.lock();


            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0) || !(j == 0)) {
                        Coordinates coordinates = new Coordinates(activeCell.getCoordinates().x() + i, activeCell.getCoordinates().y() + j);

                        if (Validator.isCorrectCoordinates(coordinates, field.getSize()) && (field.isCoordinateEmpty(coordinates) || coordinates.equals(to))) {
                            Cell cell = new Cell(coordinates, activeCell);
                            cell.findManhattanDistance(to);

                            if (checkedCell.containsKey(coordinates)) {
                                if ((!checkedCell.get(coordinates).isLock()) && (cell.compareTo(checkedCell.get(coordinates)) < 0)) {
                                    checkedCell.put(coordinates, cell);
                                }
                            } else {
                                checkedCell.put(coordinates, cell);
                            }
                        }
                    }
                }
            }
        }

        return checkedCell.get(to);
    }

    public static List<Coordinates> getShortPathBetweenTwoCell(Coordinates from, Coordinates to, Field field) throws NoSuchElementException {
        Cell cell = getShortPathAsCell(from, to, field);
        List<Coordinates> path = new ArrayList<>();

        while (cell != null) {
            path.add(cell.getCoordinates());
            cell = cell.getPreviousCell();
        }

        return path.subList(0, path.size() - 1).reversed();
    }
}
