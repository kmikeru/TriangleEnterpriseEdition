package ru.kmike;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

/** @author mike */
/** Holds exactly 3 TriangleSides */
public class TriangleSideSet {    
    private final LinkedHashSet<TriangleSide> sides; // Maybe we will need to preserve order
    
    private TriangleSideSet(List<TriangleSide> sidesList){
        this.sides=new LinkedHashSet(sidesList);
    }
    
    public static Optional<TriangleSideSet> create(List<TriangleSide> sidesList){
        if(sidesList.size()==3){
            return Optional.of(new TriangleSideSet(sidesList));
        }else{
            return Optional.empty();
        }
    }
    
    public TriangleSide[] toArray(){
        return this.sides.toArray(new TriangleSide[0]);
    }
}
