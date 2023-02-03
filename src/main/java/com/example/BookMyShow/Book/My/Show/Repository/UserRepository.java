package com.example.BookMyShow.Book.My.Show.Repository;

import com.example.BookMyShow.Book.My.Show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByname(String name);
}
