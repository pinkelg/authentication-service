package com.gurung.authentication.User;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager = null;

    @Test
    public void UserCreateTest() {
        User user = new User();
        user.setEmail("pinkel@gmail.com");
        user.setPassword("pass");
        user.setFirstName("Pinkel");
        user.setLastName("Gurung");

        User savedUser = userRepository.save(user);

        User existingUser = testEntityManager.find(User.class, savedUser.getId());
        assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());

    }


}
