package com.design15_common;

import javax.swing.*;

public class CookingCommand {
    public static void main(String[] args) {
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨
    }
}

//调用者：服务员
class Waiter {
    private Breakfast changFen, hunTun, heFen;

    void setChangFen(Breakfast f) {
        changFen = f;
    }

    void setHunTun(Breakfast f) {
        hunTun = f;
    }

    void setHeFen(Breakfast f) {
        heFen = f;
    }

    void chooseChangFen() {
        changFen.cooking();
    }

    void chooseHunTun() {
        hunTun.cooking();
    }

    void chooseHeFen() {
        heFen.cooking();
    }
}

//抽象命令：早餐
interface Breakfast {
    void cooking();
}

//具体命令：肠粉
class ChangFen implements Breakfast {
    private ChangFenChef receiver;

    ChangFen() {
        receiver = new ChangFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：馄饨
class HunTun implements Breakfast {
    private HunTunChef receiver;

    HunTun() {
        receiver = new HunTunChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：河粉
class HeFen implements Breakfast {
    private HeFenChef receiver;

    HeFen() {
        receiver = new HeFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//接收者：肠粉厨师
class ChangFenChef extends JFrame {
    private static final long serialVersionUID = 1L;

    ChangFenChef() {
        super("煮肠粉");
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon("src/command/ChangFen.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void cooking() {
        this.setVisible(true);
    }
}

//接收者：馄饨厨师
class HunTunChef extends JFrame {
    private static final long serialVersionUID = 1L;

    HunTunChef() {
        super("煮馄饨");
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon("src/command/HunTun.jpg"));
        this.add(l);
        this.setLocation(350, 50);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void cooking() {
        this.setVisible(true);
    }
}

//接收者：河粉厨师
class HeFenChef extends JFrame {
    private static final long serialVersionUID = 1L;

    HeFenChef() {
        super("煮河粉");
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon("src/command/HeFen.jpg"));
        this.add(l);
        this.setLocation(200, 280);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void cooking() {
        this.setVisible(true);
    }
}