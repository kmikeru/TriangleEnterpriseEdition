package ru.kmike;
import java.util.Optional;

public class TriangleFactory {

    public TriangleFactory(){
        
    }
    
    public Optional<Triangle> getTriangle(TriangleSideSet sideSet){
        return Triangle.createTriangle(sideSet);
    }
}
