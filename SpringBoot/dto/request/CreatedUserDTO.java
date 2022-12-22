package r2s.SpringBoot.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserDTO {
    private Integer userId;
    private String username;
    private String phone;
}
