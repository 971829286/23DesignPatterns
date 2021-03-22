package com.design22;

public class MementoPattern {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}

//备忘录
class Memento {
    private String state;

    Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

//发起人
class Originator {
    private String state;

    void setState(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }

    Memento createMemento() {
        return new Memento(state);
    }

    void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento memento;

    void setMemento(Memento m) {
        memento = m;
    }

    Memento getMemento() {
        return memento;
    }
}