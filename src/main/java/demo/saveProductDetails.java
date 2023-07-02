package demo;

import domain.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class saveProductDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step 1 - Activate Hibernate Framework.
        cfg=new Configuration();

        //step 2 - Read data from .cfg.xml file.
        cfg=cfg.configure();

        //step 3 - Establish Connection with database.
        factory=cfg.buildSessionFactory();

        //step 4 - Start Session with database.
        ses=factory.openSession();

        //step 5 - create object of domain class.
        product p1 = new product();
        p1.setProductID(2);
        p1.setProductName("LAPTOP");
        p1.setProductPrice(30000.25);
        p1.setProductCategory("GADGETS");

        //step 6 - start the transaction.
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY");
    }
}
