package demo;

import domain.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class EndUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg=cfg.configure();
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();


        System.out.println("Enter Product ID");
        int id = sc.nextInt();
        System.out.println("Enter Product Name");
        String name = sc.next();
        System.out.println("Enter Product Price");
        double price = sc.nextDouble();
        System.out.println("Enter Product Category");
        String category = sc.next();
        product p1 = new product();
        p1.setProductID(id);
        p1.setProductName(name);
        p1.setProductPrice(price);
        p1.setProductCategory(category);

        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY");
    }
}
