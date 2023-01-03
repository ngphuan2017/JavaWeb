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
@Entity(name = "CATEGORIES")
public class Category {
    @Id
    @Column(name = "CATEGORYID")
    private Integer categoryId;
    @Column(name = "CATEGORYNAME")
    private String categoryName;
    @Column(name = "CATEGORYIMAGE")
    private String categoryImg;
}
