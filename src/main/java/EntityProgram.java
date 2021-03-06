import entities.Item;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class EntityProgram {

    /*
        create database sdapol83_hibernateex;
     */

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernateex_javapol83");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Item item1 = new Item();
        item1.setInitialPrice(new BigDecimal(55.0d));

        Item item2 = new Item();
        // item2.setInitialPrice(new BigDecimal(55.0d));

        em.persist(item1);
        em.persist(item2);

        User user1 = new User("jkowalski", "IT");
        user1.setBrutto(10000.0d);

        User user2 = new User("tnowak", "HR");
        user2.setBrutto(12000.0d);

        User user3 = new User("akowalska", "IT");
        user3.setBrutto(15000.d);

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);



        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println(user1.getNetto());
    }
}
