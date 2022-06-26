package com.gurung.authentication.controllers.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 10:58 PM
 */

@AllArgsConstructor
@Getter
@Setter
public class UserNameAndPasswordLoginResponse {
    private Long id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<String> roles;
}
