package org.example.designPatterns.factory;

/**
 * @author dragos.cosmin
 **/
public class CarFactory {

    public static Car getCar(String color, String engSize, String style, String type){
//        if ("RangeRover".equalsIgnoreCase(type)) return new RangeRover(color,engSize,style,type);
//        else if ("RollsRoyce".equalsIgnoreCase(type)) return new RollsRoyce(color,engSize,style,type);
//
//        return null;
        return switch (type.toLowerCase()){
            case "rangerover"-> new RangeRover(color,engSize,style,type);
            case "rollsroyce"-> new RollsRoyce(color,engSize,style,type);
            default -> null;
        };
    }
}
