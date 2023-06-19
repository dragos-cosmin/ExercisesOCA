package org.example.annotations;

public class Store {
    public String desc;

    @CustomAnnotation(owner = "Sam")
    public Store(String desc) {
        this.desc = desc;
    }
}
