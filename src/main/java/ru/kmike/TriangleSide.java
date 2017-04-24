package ru.kmike;
import java.math.BigDecimal;
import java.util.Optional;

/** Represents triangle side of positive length */
class TriangleSide{
    private final BigDecimal length; // BigDecimal of arbitrary precision is used to simplify comparisons
    
    private TriangleSide(BigDecimal length){
        this.length=length;
    }
    public BigDecimal getLength(){
        return this.length;
    }
    public static Optional<TriangleSide> createSide(BigDecimal length){
        if(length.compareTo(BigDecimal.ZERO)>0){
            return Optional.of(new TriangleSide(length));
        }else {
            return Optional.empty();
        } 
    }
    
    public String toString(){
        return "TriangleSide:"+this.length.toString();
    }
}