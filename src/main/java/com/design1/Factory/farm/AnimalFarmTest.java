package com.design1.Factory.farm;
import java.awt.*;
import javax.swing.*;
public class AnimalFarmTest {
    public static void main(String[] args) {
        try {
            Animal a;
            AnimalFarm af;
           Object a1=   ReadXML2.getObject();
            af = (AnimalFarm) a1;
            assert af != null;
            a = af.newAnimal();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//抽象产品：动物类
interface Animal {
    void show();
}
//具体产品：马类
class Horse implements Animal {
    private JFrame jf = new JFrame("工厂方法模式测试");
    Horse() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
        JScrollPane sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1 = new JLabel(new ImageIcon("D:\\QMDownload\\A_Horse.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //用户点击窗口关闭
    }
    public void show() {
        jf.setVisible(true);
    }
}
//具体产品：牛类
class Cattle implements Animal {
    private JFrame jf = new JFrame("工厂方法模式测试");
    Cattle() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        JScrollPane sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1 = new JLabel(new ImageIcon("D:\\QMDownload\\A_Cattle.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //用户点击窗口关闭
    }
    public void show() {
        jf.setVisible(true);
    }
}
//抽象工厂：畜牧场
interface AnimalFarm {
    Animal newAnimal();
}
//具体工厂：养马场
class HorseFarm implements AnimalFarm{
    public Animal newAnimal() {
        System.out.println("新马出生！");
        return new Horse();
    }
}
//具体工厂：养牛场
class CattleFarm implements AnimalFarm {
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        return new Cattle();
    }
}