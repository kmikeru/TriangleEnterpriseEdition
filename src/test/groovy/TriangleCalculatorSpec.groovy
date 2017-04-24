import spock.lang.*
import ru.kmike.TriangleCalculator

class TriangleCalculatorSpec extends Specification{
    def "Correct triangle type or error message must be shown"(){
        when:
        println l
        def s=TriangleCalculator.displayTriangleType(l)
        then:
        noExceptionThrown()        
        s==message
        
        where:
        l|message
        (["3.0","3.0","3.0"] as String[])|"Triangle type is equilateral"
        (["3","3","5"] as String[])|"Triangle type is isosceles"
        (["3","4","5"] as String[])|"Triangle type is scalene"
        (["3","5","10"] as String[])|"Error: triangle with specified sides could not exist"
        (["3","5"] as String[])|"Error: must provide exactly 3 arguments"
        (["3","5","a"] as String[])|"Error: must provide exactly 3 numeric arguments"
        (["3","5","6","7"] as String[])|"Error: must provide exactly 3 arguments"
        (["3","5","6","-7"] as String[])|"Error: must provide exactly 3 arguments"
        (["3","5","6","a"] as String[])|"Error: must provide exactly 3 arguments"
        (["3","5","-1"] as String[])|"Error: set of triangle sides could not be created"
    }
}
