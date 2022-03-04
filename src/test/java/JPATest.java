import Labs.BuddyInfo;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPATest {

    @Test
    public void performJPA() {

        // Creating objects representing some products
        BuddyInfo buddy = new BuddyInfo();
        buddy.setId(1);
        buddy.setName("J");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT p FROM Labs.BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }
}