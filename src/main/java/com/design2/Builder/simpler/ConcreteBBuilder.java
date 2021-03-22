package com.design2.Builder.simpler;

public class ConcreteBBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("建造 A");
    }
    public void buildPartB() {
        product.setPartB("建造 B");
    }
    public void buildPartC() {
        product.setPartC("建造 C");
    }
}