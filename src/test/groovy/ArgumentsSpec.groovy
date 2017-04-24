import spock.lang.*
import static ru.kmike.Arguments.*

class ArgumentsSpec extends Specification{
    
    def "parsing single command line argument should not throw exceptions"(){
        when:
        def n=parseArg(arg)
        then:
        noExceptionThrown()        
        println n
        
        where:
        arg << ['1','a','3c']
    }
    
    def "single command line argument should parse numbers correctly"(){
        when:
        def n=parseArg(arg)
        then:
        n.isPresent()
        println n
        
        where:
        arg << ['1','3.0','.3','0.5','-5']
    }
    
    def "parsing multiple arguments should not throw exceptions"(){
        when:
        def n=parseArgs(args)
        then:
        noExceptionThrown()        
        println n
        
        where:
        args<<[['1','2','a'] as String[],
                ['2','3','4'] as String[]  ]
    }
    
    def "parsing multiple arguments should parse numbers correctly"(){
        when:
        def n=parseArgs(args)
        then:
        noExceptionThrown()
        n.every{it.isPresent()}
        println n
        
        where:
        args<<[['1','2.0','-3'] as String[],
                ['2','3','4'] as String[]  ]
    }
}
