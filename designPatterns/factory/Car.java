package org.example.designPatterns.factory;

/**
 * @author dragos.cosmin
 **/
abstract class Car {
    String color;
    String engineSize;
    String style;
    String type;

    public abstract String getColor();

    public abstract String getEngineSize();

    public abstract String getStyle();

    public abstract String getType();

    @Override
    public String toString() {
        return "Color='" + this.color +
                ", EngineSize='" + this.engineSize +
                ", Style='" + this.style +
                ", Type='" + this.type;
    }
}
