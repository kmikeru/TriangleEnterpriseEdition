import spock.lang.*
import ru.kmike.TriangleSide

class TriangleSideSpec extends Specification{
    def "creation of triangle side should not throw exception"(){
        when:
        def s=TriangleSide.createSide(l)
        then:
        noExceptionThrown()        
        println s
        
        where:
        l << ([1, 2.0, 0, -999999] as List<BigDecimal>)
    }
    
    def "only sides with positive could be created"(){
        when:
        Optional<TriangleSide> s=TriangleSide.createSide(l)
        then:        
        println s
        s.isPresent()==expected
        
        where:
        l|expected
        1.0|true
        999999999.9999|true
        0|false
        -9999|false
        
    }
       
    
}
