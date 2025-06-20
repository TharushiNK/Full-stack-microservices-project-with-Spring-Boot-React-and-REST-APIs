package com.example.test_twenty.repository;

import com.example.test_twenty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

      //JPQL for search user by their name and email
      @Query("select u from User u where u.name =?1 AND u.email =?2")
      public List<User> searchUserByNameEmail(String name, String email);


      //JPQL for search user by their name
      @Query("select u from User u where u.name =?1")
      public List<User> searchUserByName(String name);

      //JPQL for search user by their email
      @Query("select u from User u where u.email =?1")
      public List<User> searchUserByEmail(String email);

}
