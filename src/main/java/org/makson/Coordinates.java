package org.makson;

public record Coordinates(int x, int y) {
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
