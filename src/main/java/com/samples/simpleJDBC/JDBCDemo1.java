package com.samples.simpleJDBC;


/**
 * Created by edara on 8/4/16.
 */
public class JDBCDemo1 {
    public static void main(String[] args) {
        Circle circle = new JDBCDao().getCircleByID(2);
        System.out.println(circle.getName());
    }
}
