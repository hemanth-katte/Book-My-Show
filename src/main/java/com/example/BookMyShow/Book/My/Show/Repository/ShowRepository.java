package com.example.BookMyShow.Book.My.Show.Repository;

import com.example.BookMyShow.Book.My.Show.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShowRepository extends JpaRepository<Show, Integer> {
}
