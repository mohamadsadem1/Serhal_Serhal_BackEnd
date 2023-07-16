package com.example.SerhalAndSerhal.Product;

import com.example.SerhalAndSerhal.Brand.Brand;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


    @UpdateTimestamp
    private LocalDateTime timeCreated;

    @CreationTimestamp
    private LocalDateTime timeUpdated;

    @ManyToOne
    private Brand brand;

    public String localTimeCreatedToString(){
        if(this.timeCreated!=null)
            return this.timeCreated.toString();
        else
            return null;
    }

    public String localTimeUpdatedToString(){
        if(this.timeUpdated!=null)
            return this.timeUpdated.toString();
        else return null;
    }

    public String BrandName(){
        return brand.getName();
    }
}
