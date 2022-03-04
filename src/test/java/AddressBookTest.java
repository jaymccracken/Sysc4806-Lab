import Labs.AddressBook;
import Labs.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private BuddyInfo bi = null;
    private BuddyInfo bi2 = null;
    private AddressBook list = null;
    private AddressBook list2 = null;
    @Before
    public void setUp() throws Exception {
        bi = new BuddyInfo ("J","home","905",22);
        bi2 = new BuddyInfo ("M","home","905",24);
        list = new AddressBook();
        list.addBuddy(bi);
    }

    @Test
    public void addBuddy() {
        assertEquals("The list should contain",1, list.size());
        list.addBuddy(bi2);
        assertEquals("The list should contain",2, list.size());
    }

    @Test
    public void removeBuddy() {
        list.addBuddy(bi2);
        assertEquals("The list should contain",2, list.size());
        list.removeBuddy(1);
        assertEquals("The list should contain",1, list.size());
    }

    @Test
    public void size() {
        assertEquals("The list should contain",1, list.size());
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals("The list should contain",0, list.size());
    }

    @Test
    public void persistence(){
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();

        Integer testID = addTestObjects(em);
        AddressBook addressBook = em.find(AddressBook.class, testID);
        assertNotNull(addressBook);
        em.getTransaction().begin();
        em.remove(addressBook);
        em.getTransaction().commit();
        assertNull(em.find(AddressBook.class, testID));
    }

    private Integer addTestObjects(EntityManager em){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo;

        for(int i =0; i<5;i++){
            buddyInfo = new BuddyInfo("J","home","905",i);
            addressBook.addBuddy(buddyInfo);
        }

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(addressBook);

        tx.commit();
        return addressBook.getId();
    }

}