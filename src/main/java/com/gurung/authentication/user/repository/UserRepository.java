package com.gurung.authentication.user.repository;

import com.gurung.authentication.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 9:57 PM
 */

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

}
