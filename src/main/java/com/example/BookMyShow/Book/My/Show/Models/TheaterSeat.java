package com.example.BookMyShow.Book.My.Show.Models;

import com.example.BookMyShow.Book.My.Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int price;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
