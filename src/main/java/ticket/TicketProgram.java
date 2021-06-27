package ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class TicketProgram {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernateex_javapol83");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("AA1234");
        oneWayTicket.setLatestDepartureDate(LocalDate.of(2021, 7, 1));

        ReturnTicket returnTicket = new ReturnTicket();
        returnTicket.setNumber("BB5678");
        returnTicket.setLastReturnDate(LocalDate.of(2021, 8, 1));

        em.persist(oneWayTicket);
        em.persist(returnTicket);

        em.getTransaction().commit();

        Query query = em.createQuery("FROM TicketBase");
        List<TicketBase> ticketBaseList = query.getResultList();

        Query query1 = em.createQuery("FROM OneWayTicket");
        List<OneWayTicket> oneWayTicketList = query1.getResultList();

        Query query2 = em.createQuery("FROM ReturnTicket");
        List<ReturnTicket> returnTicketList = query2.getResultList();

        emf.close();
    }
}
