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
}