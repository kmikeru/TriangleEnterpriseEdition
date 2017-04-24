package ru.kmike;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Arguments{
    /** Parse an array of arguments to number without throwing exceptions */
    public static List<Optional<BigDecimal>> parseArgs(String[] args){
        return Arrays.stream(args).map(i->parseArg(i)).collect(Collectors.toList());
    }
    
    /** Parse single argument to number without throwing exceptions */
    private static Optional<BigDecimal> parseArg(String arg){        
        try{
            return Optional.of(new BigDecimal(arg));
        }catch(Exception e){
            return Optional.empty();
        }
    }
    
    /** require exactly N numeric arguments to be present */
    /*public static Optional<List<BigDecimal>> requireNumericArgs(String[] args, int numberRequired){
        // Parse all arguments to numbers. Preserve list length just in case we want to display non-numeric arguments
        List<Optional<BigDecimal>> parsedArgs=Arguments.parseArgs(args)
        // Collect only numeric arguments, converting from optional
        List<BigDecimal> numericArgs=parsedArgs.findAll{it.isPresent()}.collect{it.get()}
        if(numericArgs.size()==numberRequired){
            Optional.of(numericArgs)
        }else{
            Optional.empty()
        }
    }*/
}