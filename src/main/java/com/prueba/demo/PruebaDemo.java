package com.prueba.demo;


import com.prueba.demo.Util.Demo;

public class PruebaDemo {

    public static void main(String[] args) {
        System.out.println("hola");

        try {
            Demo demo = new Demo(true,true,true,true,true,true);
            Demo.LogMessage("MENSAJE Docker", true, false, false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
