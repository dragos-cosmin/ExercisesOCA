package org.example;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author dragos.cosmin
 **/
public class NullTransformer {
    public static void main(String[] args) {
        String data="hello";

        Optional<String> opt=Optional.ofNullable(data).filter(data1->!data1.isEmpty());
        System.out.println(opt.isPresent());

        Optional<String> opt2=Optional.ofNullable(data).filter(Predicate.not(String::isEmpty));
        System.out.println(opt2.isPresent());
    }
}
