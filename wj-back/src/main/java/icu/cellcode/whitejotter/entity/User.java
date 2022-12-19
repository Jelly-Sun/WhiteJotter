package icu.cellcode.whitejotter.entity;


import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
}
