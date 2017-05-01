package ru.kmike;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import ru.kmike.TriangleSide;

public class Triangle {
    public enum TriangleType{
        EQUILATERAL,ISOSCELES,SCALENE
    }
    private TriangleSide a,b,c;
    
    private Triangle(TriangleSide a, TriangleSide b, TriangleSide c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    private BigDecimal[] getLengths(){
        return new BigDecimal[]{ a.getLength(), b.getLength(), c.getLength() };
    }
    /** Check if the triangle with specified sides could exist */
    private static boolean validateInequality(TriangleSide a, TriangleSide b, TriangleSide c){
        BigDecimal al=a.getLength(),bl=b.getLength(),cl=c.getLength();
                        
        if( (al.add(bl).compareTo(cl)>0 )&& // Validate if triangle sides conform to triangle inequality rule https://en.wikipedia.org/wiki/Triangle_inequality
            (bl.add(cl).compareTo(al)>0 )&&
            (cl.add(al).compareTo(bl)>0 ) ){
            return true;
        }else{
            return false;
        }
    }
    
    public TriangleType determineType(){
        HashSet lengthsSet=new HashSet(Arrays.asList(getLengths()));
        switch (lengthsSet.size()) {
            case 1:     // all sides are equal in length
                return TriangleType.EQUILATERAL;
            case 2:     // only 2 different side lengths exist, so two sides are equal
                return TriangleType.ISOSCELES;                        
            default:
                return TriangleType.SCALENE ;
        }
    }

    public String toString(){
        return "Triangle["+a+","+b+","+c+"]";
    }
        
    private static Optional<Triangle> createTriangle(TriangleSide a,TriangleSide b,TriangleSide c){
        if(validateInequality(a,b,c)){ // impossible objects should not exist
            return Optional.of(new Triangle(a,b,c));
        }else{
            return Optional.empty();
        }
    }
    
    /** Create Triangle from TriangleSideSet */
    static Optional<Triangle> createTriangle(TriangleSideSet sideSet){
        final TriangleSide[] sideArray=sideSet.toArray();
        return createTriangle(sideArray[0],sideArray[1],sideArray[2]);
    }
}
