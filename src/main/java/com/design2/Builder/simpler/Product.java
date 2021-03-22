package com.design2.Builder.simpler;

class Product {
    private String partA;
    private String partB;
    private String partC;
    void setPartA(String partA) {
        this.partA = partA;
    }
    void setPartB(String partB) {
        this.partB = partB;
    }
    void setPartC(String partC) {
        this.partC = partC;
    }
    private String getPartA() {
        return partA;
    }
    private String getPartB() {
        return partB;
    }
    private String getPartC() {
        return partC;
    }

    void show() {
        //显示产品的特性
        System.out.println(getPartA()+getPartB()+getPartC());
    }
}