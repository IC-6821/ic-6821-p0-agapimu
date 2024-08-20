package org.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EasyAI implements MoveMaker {

    public Coordinate placeToken(Board board) {
        final List<Coordinate> freePoints = new ArrayList<>();
        for (int i = 0; board.isBoundRow(i); ++i) {
            for (int j = 0; board.isBoundColumn(j); ++j) {
                final Coordinate coordinate = new Coordinate(Row.values()[i], Column.values()[j]);
                if (board.isFree(coordinate)) {
                    freePoints.add(coordinate);
                }
            }
        }
        if (freePoints.isEmpty()) {
            return null;
        }
        Collections.shuffle(freePoints);
        return freePoints.getFirst();
    }

}
