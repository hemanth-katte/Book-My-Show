package com.example.BookMyShow.Book.My.Show.Repository;

import com.example.BookMyShow.Book.My.Show.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
