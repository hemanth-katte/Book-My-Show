package com.example.BookMyShow.Book.My.Show.Repository;

import com.example.BookMyShow.Book.My.Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
