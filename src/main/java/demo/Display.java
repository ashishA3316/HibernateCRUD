package demo;

import domain.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id = sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        product p = ses.get(product.class, id);
        System.out.println(p.getProductID());
        System.out.println(p.getProductName());
        System.out.println(p.getProductPrice());
        System.out.println(p.getProductCategory());

    }
}
