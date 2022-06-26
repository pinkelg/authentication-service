package com.gurung.authentication.user.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 9:40 PM
 */

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "EMAIL")
    @NotBlank
    @Size(min = 5, max = 64)
    private String email;

    @Column(name = "FIRST_NAME")
    @NotBlank
    @Size(min = 1, max = 30)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    @Size(max = 30)
    private String middleName;

    @Column(name = "LAST_NAME")
    @NotBlank
    @Size(max = 30)
    private String lastName;

    @Column(name = "PASSWORD")
    @Size(min = 8, max = 50)
    private String password;

    @CreationTimestamp
    @Column(name = "CREATED_TIMESTAMP")
    private Date createdTimestamp;

    @UpdateTimestamp
    @Column(name = "MODIFIED_TIMESTAMP")
    private Date modifiedTimestamp;
}
