package org.minis;

import org.minis.beans.BeansException;
import org.minis.context.ClassPathXmlApplicaitonContext;
import org.minis.test.AService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        System.out.printf("Hello and welcome!");
        ClassPathXmlApplicaitonContext ctx = new ClassPathXmlApplicaitonContext("xml/beans.xml");
        AService aService = null;
        try {
            aService = (AService)ctx.getBean("aservice");
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }
        aService.sayHello();

    }
}