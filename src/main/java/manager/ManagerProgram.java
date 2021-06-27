package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ManagerProgram {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernateex_javapol83");
        EntityManager em = emf.createEntityManager();

        Manager john = new Manager("John Smith");

        Department accounting = new Department();
        accounting.setName("Accounting");

        john.setDepartment(accounting);

        Manager2 john2 = new Manager2("John Smith");

        Department2 accounting2 = new Department2();
        accounting2.setName("Accounting");

        john2.setDepartment(accounting2);

        em.getTransaction().begin();

        em.persist(john);
        em.persist(accounting);

        em.persist(john2);
        em.persist(accounting2);

        em.getTransaction().commit();

        Query query = em.createQuery("FROM Manager");
        List<Manager> managerList = query.getResultList();

        Query query2 = em.createQuery("FROM Manager2");
        List<Manager2> managerList2 = query2.getResultList();

        emf.close();
    }
}
