package Labs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyInfoInfo extends CrudRepository<BuddyInfo,Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(Integer id);
    BuddyInfo findByAddress(String address);
    BuddyInfo findByPhonenumber(String address);
    BuddyInfo findByAge(int age);
}
