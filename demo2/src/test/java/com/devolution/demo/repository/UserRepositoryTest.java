package com.devolution.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
@Sql(scripts = "classpath:sql/test-init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByIdTest() {
        assertThat(userRepository.findById(3L))
                .isPresent();
        assertThat(userRepository.findById(3L).get().getName())
                .isEqualTo("user 23");
        assertThat(userRepository.findById(5L))
                .isEmpty();
    }
}