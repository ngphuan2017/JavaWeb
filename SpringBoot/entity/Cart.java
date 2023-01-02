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
@Entity(name = "CARTS")
public class Cart {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TOTALPRICE")
    private String price;
    @Column(name = "STATUS")
    private Integer status;
}
