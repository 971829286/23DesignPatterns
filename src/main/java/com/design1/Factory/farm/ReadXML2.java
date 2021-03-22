package com.design1.Factory.farm;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
class ReadXML2 {
    static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\QMDownload\\config2.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName("com.design1.Factory.farm.HorseFarm");
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}