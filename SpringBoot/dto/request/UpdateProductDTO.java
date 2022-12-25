package JavaWeb.SpringBoot.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDTO {
    private String productName;
    private Double price;
    private Integer quantity;
    private Integer categoryId;
}
