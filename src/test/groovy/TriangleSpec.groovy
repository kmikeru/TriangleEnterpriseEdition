import spock.lang.*
import ru.kmike.Triangle
import ru.kmike.Triangle.TriangleType
import ru.kmike.TriangleSide

class TriangleSpec extends Specification{
     
    def "only correct triangle could be created"(){
        when:
        def sideA=TriangleSide.createSide(a).get()
        def sideB=TriangleSide.createSide(b).get()
        def sideC=TriangleSide.createSide(c).get()
        def t=Triangle.createTriangle(sideA,sideB,sideC)
        then:
        t.isPresent()==expected
        
        where:
        a|b|c|expected
        3|3|3|true
        3.0000000000000000001|3.0000000000000000001|3.0000000000000000001|true        
        3|5|10|false
    }
    
    def "triangle type should be determined correctly"(){
        when:
        def sideA=TriangleSide.createSide(a).get()
        def sideB=TriangleSide.createSide(b).get()
        def sideC=TriangleSide.createSide(c).get()
        def t=Triangle.createTriangle(sideA,sideB,sideC)
        then:
        t.get().determineType()==expectedType
        
        where:
        a|b|c|expectedType
        3|3|3|TriangleType.EQUILATERAL
        3|3|2|TriangleType.ISOSCELES
        3|4|5|TriangleType.SCALENE
    }
}