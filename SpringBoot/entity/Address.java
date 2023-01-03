package JavaWeb.SpringBoot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ADDRESSES")
public class Address {
    @Id
    @Column(name = "ADDRESSID")
    private Integer addressId;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DISTRICT")
    private String district;
    @Column(name = "STREET")
    private String street;
}
