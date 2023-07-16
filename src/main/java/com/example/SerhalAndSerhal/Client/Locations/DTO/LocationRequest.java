package com.example.SerhalAndSerhal.Client.Locations.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {

    private String City;

    private String Street;

    public String getLocation() {

        return (this.City+this.Street);
    }
}
