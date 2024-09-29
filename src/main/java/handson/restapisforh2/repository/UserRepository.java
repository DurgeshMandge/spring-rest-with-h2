package handson.restapisforh2.repository;


import handson.restapisforh2.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Integer> {

}
