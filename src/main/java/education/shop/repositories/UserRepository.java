package education.shop.repositories;


import education.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,String> {


    //============================== Admin Filters ====================================================================
    List<User> findByFirstName(String firstName);

    Optional<User> findByEmail(String email);

    List<User> findByConnected(boolean connected);

    List<User> findByLastName(String lastName);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);


    List<User> findByAgeBefore(int age);

    List<User> findByAgeAfter(int age);

    List<User> findUserByCity(String city);
    List<User> findByAgeBetween(int min, int max);

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:keyword% OR u.lastName LIKE %:keyword%")
    List<User> findByFirstNameOrLastNameLike(@Param("keyword") String keyword);






}
