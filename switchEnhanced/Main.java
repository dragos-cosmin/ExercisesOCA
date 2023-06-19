package org.example.switchEnhanced;

import java.math.BigDecimal;

/**
 * @author dragos.cosmin
 **/
public class Main {
    public static void main(String[] args) {
        Product p1=new Food("burger", BigDecimal.valueOf(1.25));
        Product p2=new Drink("beer",BigDecimal.valueOf(2.50));
        Main main=new Main();
        main.consume(p1);
        main.consume(p2);

    }

    public void consume(Product product){
//  switch case unavailable in Java 17, only in preview mode
//        switch (product){
//            case (Food food && food.isFresh())->food.prepare();
//            case (Drink drink)-> drink.pour();
//            default -> throw new IllegalStateException("Unexpected value: " + product);
//        }
      if (product instanceof Food food && food.isFresh()) food.prepare();
      if (product instanceof Drink drink) drink.pour();
    }
}
