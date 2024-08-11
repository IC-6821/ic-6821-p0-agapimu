package org.example;
import java.util.*;

public class EasyIA implements ArtificialIntelligence {

    public EasyIA artificialIntelligence;

    public EasyIA getArtificialIntelligence(){
        if(artificialIntelligence == null) artificialIntelligence = new EasyIA();
        return artificialIntelligence;
    }
    
//--------------------------------------------------------------------------------------------------------
    
    public Coordinate selectCell(Board board) {
        List<Coordinate> freePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) 
            for (int j = 0; j < 3; ++j) {
                Coordinate coordinate = new Coordinate(i, j);
                if (board.isFree(coordinate)) freePoints.add(coordinate);
            }
        if (freePoints.isEmpty()) return null;
        Collections.shuffle(freePoints);
        return freePoints.getFirst();
    }

}