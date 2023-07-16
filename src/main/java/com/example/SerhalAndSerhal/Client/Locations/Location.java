package com.example.SerhalAndSerhal.Client.Locations;


import com.example.SerhalAndSerhal.Client.Client;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String City;

    @Column(name = "street")
    private String Street;

    @ManyToOne
    private Client client;
    
}
