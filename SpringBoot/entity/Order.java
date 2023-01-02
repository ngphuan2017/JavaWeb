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
@Entity(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDERID")
    private Integer orderId;
    @Column(name = "TOTALPRICE")
    private String totalPrice;
    @Column(name = "STATUS")
    private Integer status;
}
