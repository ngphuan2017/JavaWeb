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
@Entity(name = "USERS")
public class User {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IMGLINK")
    private String imgLink;
}

