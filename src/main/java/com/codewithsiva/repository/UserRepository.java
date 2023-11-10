package com.codewithsiva.repository;

import com.codewithsiva.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("from user_app u WHERE u.username=:username AND u.password=:password")
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
