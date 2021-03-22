package com.design2.Builder.simpler;

public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteABuilder();
        BuildComputer(builder);

        Builder builderB = new ConcreteBBuilder();
        BuildComputer(builderB);
    }

    private static void BuildComputer(Builder builderB) {
        Director directorB = new Director(builderB);
        Product productB = directorB.construct();
        productB.show();
    }
}