package com.homework3.homework3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.homework3.homework3.repository.DucksRepository;

@SpringBootTest
class Homework3ApplicationTests {

    @MockBean
    private DucksRepository ducksRepository;

    @Test
    void contextLoads() {
    }
}
