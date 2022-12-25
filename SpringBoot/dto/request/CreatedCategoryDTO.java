package JavaWeb.SpringBoot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCategoryDTO {
    private Integer categoryId;
    private String categoryName;
}
