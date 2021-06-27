package airport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class AirportProgram {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernateex_javapol83");

        EntityManager em = emf.createEntityManager();

        Passenger john = new Passenger("John Smith");
        Address johnAddress = new Address();
        johnAddress.setCity("Boston");
        johnAddress.setStreet("Flowers street");
        johnAddress.setNumber("3");
        johnAddress.setZipCode("123456");
        john.setAddress(johnAddress);

        Passenger eve = new Passenger("Eve Stark");
        Address eveAddress = new Address();
        eveAddress.setCity("London");
        eveAddress.setStreet("Fleet street");
        eveAddress.setNumber("234");
        eveAddress.setZipCode("683530");
        eve.setAddress(eveAddress);

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB5678");
        Ticket ticket3 = new Ticket("CC9012");
        Ticket ticket4 = new Ticket("DD3456");

        john.addTicket(ticket1);
        john.addTicket(ticket2);

        eve.addTicket(ticket3);
        eve.addTicket(ticket4);

        ticket1.setPassenger(john);
        ticket2.setPassenger(john);
        ticket3.setPassenger(eve);
        ticket4.setPassenger(eve);

        Trip trip1 = new Trip("Euro trip");
        Trip trip2 = new Trip("Asia trip");
        Trip trip3 = new Trip("US trip");
        Trip trip4 = new Trip("Tranatlantic trip");

        ticket1.addTrip(trip1);
        ticket1.addTrip(trip4);
        ticket2.addTrip(trip3);
        ticket2.addTrip(trip2);
        ticket3.addTrip(trip1);
        ticket3.addTrip(trip2);
        ticket4.addTrip(trip3);
        ticket4.addTrip(trip4);

        trip1.addTicket(ticket1);
        trip1.addTicket(ticket3);
        trip2.addTicket(ticket2);
        trip2.addTicket(ticket3);
        trip3.addTicket(ticket2);
        trip3.addTicket(ticket4);
        trip4.addTicket(ticket1);
        trip4.addTicket(ticket4);

        Payment payment1 = new Payment();
        payment1.setTicket(ticket1);
        payment1.setPrice(new BigDecimal(1000));

        Payment payment2 = new Payment();
        payment2.setTicket(ticket2);
        payment2.setPrice(new BigDecimal(2000));

        Payment payment3 = new Payment();
        payment3.setTicket(ticket3);
        payment3.setPrice(new BigDecimal(3000));

        Payment payment4 = new Payment();
        payment4.setTicket(ticket4);
        payment4.setPrice(new BigDecimal(4000));

        em.getTransaction().begin();

        em.persist(john);
        em.persist(eve);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);
        em.persist(ticket4);
        em.persist(trip1);
        em.persist(trip2);
        em.persist(trip3);
        em.persist(trip4);
        em.persist(payment1);
        em.persist(payment2);
        em.persist(payment3);
        em.persist(payment4);

        em.getTransaction().commit();

        Query query = em.createQuery("FROM Passenger");
        List<Passenger> passengerList = query.getResultList();

        Query query1 = em.createQuery("FROM Payment");
        List<Payment> paymentList = query1.getResultList();

        // em.close();
        emf.close();
    }
}
