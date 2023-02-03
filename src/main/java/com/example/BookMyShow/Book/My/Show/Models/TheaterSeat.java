package com.example.BookMyShow.Book.My.Show.Models;

import com.example.BookMyShow.Book.My.Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats_of_theater")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int price;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    public TheaterSeat(String seatNo, SeatType seatType, int price) {
        this.seatNo =seatNo;
        this.seatType = seatType;
        this.price = price;
    }
}
