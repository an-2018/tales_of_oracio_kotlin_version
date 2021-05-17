package com.kotxiposix.talesoforacio;

import java.net.URL;

public class Teste {
    public void test(){
        URL url = this.getClass().getClassLoader().getResource("path");
    }
}
