package com.example.BookMyShow.Book.My.Show.Models;

import com.example.BookMyShow.Book.My.Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;

    @ManyToOne
    @JoinColumn
    private Show show;


    public void setBookedAt(java.util.Date date) {
    }
}
