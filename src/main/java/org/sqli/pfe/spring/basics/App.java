package org.sqli.pfe.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sqli.pfe.spring.mvc.prodcuctDao.ProductDapImpl;
import org.sqli.pfe.spring.basics.services.ProductServices;

public class App {




    //@Autowired
   // ProductServices productServices1;

   // public App(App app) {
    //}


    public static void main(String[] args)
    {


        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        ProductServices client = (ProductServices) appContext.getBean("productServiceImp");
        client.getAllProducts();


        ProductDapImpl client1 = (ProductDapImpl) appContext.getBean("prodcuctDtoImp");
        client1.getAll();







    }
}
