package com.gurung.authentication.controllers.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 10:53 PM
 */

@Getter
@Setter
public class UserNameAndPasswordLoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
