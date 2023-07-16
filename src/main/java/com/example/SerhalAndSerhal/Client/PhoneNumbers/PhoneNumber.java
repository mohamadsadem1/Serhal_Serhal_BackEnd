package com.example.SerhalAndSerhal.Client.PhoneNumbers;


import com.example.SerhalAndSerhal.Client.Client;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "phoneNumbers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;

    @OneToOne
    private Client client;
}
