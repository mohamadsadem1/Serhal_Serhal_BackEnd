package com.example.SerhalAndSerhal.Client;


import com.example.SerhalAndSerhal.Account.Account;
import com.example.SerhalAndSerhal.Client.Locations.Location;
import com.example.SerhalAndSerhal.Client.PhoneNumbers.PhoneNumber;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Location> location;

    @OneToOne
    private Account account;

    @OneToMany
    private List<PhoneNumber> phoneNumbersList;

}
