package com.skate.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data

public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAdmin;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    public Admin(Integer idAdmin, String email, String password, String name) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Admin() {
    }

    
}
