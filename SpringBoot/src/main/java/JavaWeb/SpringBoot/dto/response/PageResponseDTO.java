package JavaWeb.SpringBoot.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageResponseDTO implements Serializable {
    private Integer page;
    private Integer size;
    private String sort;
}
