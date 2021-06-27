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

        em.getTransaction().begin();

        em.persist(john);
        em.persist(accounting);

        em.getTransaction().commit();

        Query query = em.createQuery("FROM Manager");
        List<Manager> managerList = query.getResultList();

        emf.close();
    }
}
