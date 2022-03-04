import Labs.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo bi = null;

    @Before
    public void setUp() throws Exception {
        bi = new BuddyInfo("J","home","905",22);
    }

    @Test
    public void getAddress() {
        bi.setAddress("school");
        assertEquals("Address should be school", "school", bi.getAddress());
    }

    @Test
    public void getName() {
        bi.setName("jay");
        assertEquals("Name should be jay", "jay", bi.getName());
    }

    @Test
    public void getPhonenumber() {
        bi.setPhonenumber("123");
        assertEquals("their phone number should be 123", "123", bi.getPhonenumber());
    }

    @Test
    public void getAge() {
        bi.setAge(23);
        assertEquals("age should be 23.", 23, bi.getAge());
    }

    @Test
    public void persistence(){
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();


        Integer testID = addTestObjects(em);
        BuddyInfo buddyInfo = em.find(BuddyInfo.class, testID);

        assertNotNull(buddyInfo);

        assertEquals("J",buddyInfo.getName());
        assertEquals(22,buddyInfo.getAge());
        assertEquals(testID, buddyInfo.getId());

        em.getTransaction().begin();
        em.remove(buddyInfo);
        em.getTransaction().commit();
        assertNull(em.find(BuddyInfo.class, testID));
    }

    private Integer addTestObjects(EntityManager em){
        BuddyInfo buddyInfo = new BuddyInfo("J","home","905",22);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(buddyInfo);

        tx.commit();
        return buddyInfo.getId();
    }

}