package com.exam.repositories;
import com.exam.models.Employee;
import com.exam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("from User u where u.email=:email and u.password=:password")
    User findByEmailAndPassword(@Param("email")String email,@Param("password") String password);
}
