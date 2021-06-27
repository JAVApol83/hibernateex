package airport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AirportProgram {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernateex_javapol83");

        EntityManager em = emf.createEntityManager();

        Passenger john = new Passenger("John Smith");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB5678");

        john.addTicket(ticket1);
        john.addTicket(ticket2);

        ticket1.setPassenger(john);
        ticket2.setPassenger(john);

        em.getTransaction().begin();

        em.persist(john);
        em.persist(ticket1);
        em.persist(ticket2);

        em.getTransaction().commit();

        // em.close();
        emf.close();
    }
}
