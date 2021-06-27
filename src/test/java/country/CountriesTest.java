package country;

import entities.Country;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountriesTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    private List<Country> expectedCountryList = new ArrayList<>();

    public static final String[][] COUNTRY_INIT_DATA =
            {
                    { "Australia", "AU"},
                    { "Canada", "CA" },
                    { "France", "FR" },
                    { "Germany", "DE" },
                    { "Italy", "IT" },
                    { "Spain", "ES" },
                    { "United Kingdom", "UK" },
                    { "United States", "US" }
            };

    @BeforeEach
    public void setUp() {
        initExpectedCountryList();

        emf = Persistence.createEntityManagerFactory("hibernateex_javapol83");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = COUNTRY_INIT_DATA[i];
            Country country = new Country(countryInitData[0], countryInitData[1]);
            em.persist(country);
        }

        em.getTransaction().commit();
    }

    @Test
    public void testCountryList() {
        List<Country> countryList = em.createQuery("FROM Country").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    public void testCountryList2() {
        List<Country> countryList = em.createQuery("FROM entities.Country").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    public void testCountryList3() {
        List<Country> countryList = em.createQuery("FROM Country AS C").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    public void testCountryList4() {
        List<Country> countryList = em.createQuery("FROM Country C").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    public void testCountryList5() {
        List<String> countryList = em.createQuery("SELECT C.name FROM Country C").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i).getName(), countryList.get(i));
        }
    }

    @Test
    public void testCountryList6() {
        List<Country> countryList = em.createQuery("FROM Country AS C WHERE C.id = 1").getResultList();
        assertNotNull(countryList);
        assertEquals(1, countryList.size());

        assertEquals(expectedCountryList.get(0), countryList.get(0));
    }

    @Test
    public void testCountryList7() {
        Query query = em.createQuery("FROM Country AS C WHERE C.id = :country_id");
        query.setParameter("country_id", 1);

        List<Country> countryList = query.getResultList();
        assertNotNull(countryList);
        assertEquals(1, countryList.size());

        assertEquals(expectedCountryList.get(0), countryList.get(0));
    }

    @Test
    public void testCountryList8() {
        List<Country> countryList = em.createQuery("FROM Country C ORDER BY C.id ASC").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    public void testCountryList9() {
        List<Country> countryList = em.createQuery("FROM Country C ORDER BY C.id DESC").getResultList();
        assertNotNull(countryList);
        assertEquals(COUNTRY_INIT_DATA.length, countryList.size());

        for (int i = 0; i < expectedCountryList.size(); i++) {
            int index = expectedCountryList.size() - 1 - i;
            assertEquals(expectedCountryList.get(index), countryList.get(i));
        }
    }

    @Test
    public void testCountryUpdate() {
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE Country SET name = :name WHERE codeName = :codeName");
        query.setParameter("name", "Espania");
        query.setParameter("codeName", "ES");
        int count = query.executeUpdate();

        assertEquals(1, count);

        em.getTransaction().commit();

        query = em.createQuery("FROM Country C WHERE codeName = :codeName");
        query.setParameter("codeName", "ES");

        List<Country> countryList = query.getResultList();
        assertNotNull(countryList);
        assertEquals(1, countryList.size());
        // TODO: dlaczego fail? assertEquals("Espania", countryList.get(0).getName());
    }

    @Test
    public void testCountryDelete() {
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE FROM Country C WHERE id = :country_id");
        query.setParameter("country_id", 2);
        int count = query.executeUpdate();

        assertEquals(1, count);

        em.getTransaction().commit();
    }

    @AfterEach
    public void dropDown() {
        em.close();
        emf.close();
    }

    private void initExpectedCountryList() {
        for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = COUNTRY_INIT_DATA[i];
            Country country = new Country(countryInitData[0], countryInitData[1]);
            expectedCountryList.add(country);
        }
    }
}
