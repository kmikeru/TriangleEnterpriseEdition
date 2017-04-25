package ru.kmike;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public class TriangleCalculator {
    public static void main(String[] args) {
        System.out.println(displayTriangleType(args));
    }

    public static String displayTriangleType(String[] args){
        if(args.length!=3){
            return "Error: must provide exactly 3 arguments";
        }
        List<Optional<BigDecimal>> numericArgs=Arguments.parseArgs(args);
        if(numericArgs.stream().filter(e->e.isPresent()).count()!=3){
            return "Error: must provide exactly 3 numeric arguments";
        }
        
        List<Optional<TriangleSide>> sidesList=numericArgs.stream() // try to create triangle sides from numeric arguments
                .map(e->TriangleSide.createSide(e.get()))
                .filter(e->e.isPresent())                
                .collect(Collectors.toList());
        
        List<TriangleSide> correctSidesList=sidesList.stream().filter(e->e.isPresent())
                .map(e->e.get())
                .collect(Collectors.toList());        
        
        Optional<TriangleSideSet> sideSet=TriangleSideSet.create(correctSidesList); // try to create a set of triangle sides
        if(! sideSet.isPresent()){
            return "Error: set of triangle sides could not be created";
        }
                
        Optional<Triangle> triangle=Triangle.createTriangle(sideSet.get()); // try to create a triangle from the set of sides
        if(! triangle.isPresent()){
            return "Error: triangle with specified sides could not exist";
        }
        switch (triangle.get().determineType()){ // if triangle was created successfuly, describe its type
            case EQUILATERAL:
                return "Triangle type is equilateral";
            case ISOSCELES:
                return "Triangle type is isosceles";
            case SCALENE:
                return "Triangle type is scalene";
            default:
                return "Unknown triangle type";
                
        }        
    }
}
