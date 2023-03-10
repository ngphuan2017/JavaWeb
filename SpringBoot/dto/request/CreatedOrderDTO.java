package JavaWeb.SpringBoot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedOrderDTO {
    private Integer orderId;
    private Date createdDate;
    private Date modifiedDate;
    private String OrderStatus;
}
