package com.homework3.homework3.repository;

import com.homework3.homework3.model.Duck;
import com.homework3.homework3.model.DuckType;
import com.homework3.homework3.model.MallardDuck;
import com.homework3.homework3.model.RedheadDuck;
import com.homework3.homework3.model.RubberDuck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

class DucksRepositoryTests {

    private DucksRepository ducksRepository;

    @BeforeEach
    void setUp() {
        // Assuming DucksRepository does not require any arguments for its constructor
        // If it does, you'll need to provide the necessary dependencies here.
        ducksRepository = new DucksRepository();
    }


    @Test
    void addDuckTest() {
        Duck duck = new MallardDuck(); // Assuming MallardDuck extends Duck
        duck.setType(DuckType.MALLARD);
        Duck addedDuck = ducksRepository.addDuck(duck);
        assertNotNull(addedDuck);
        assertEquals(addedDuck.getId(), addedDuck.getId());
        assertEquals(DuckType.MALLARD, addedDuck.getType());
    }
    
    @Test
    void getDuckTest() {
        Duck duck = new RedheadDuck(); // Assuming RedheadDuck extends Duck
        duck.setType(DuckType.REDHEAD);
        Duck addedDuck = ducksRepository.addDuck(duck);
        Duck retrievedDuck = ducksRepository.getDuck(addedDuck.getId());
        assertNotNull(retrievedDuck);
        assertEquals(addedDuck.getId(), retrievedDuck.getId());
        assertEquals(DuckType.REDHEAD, retrievedDuck.getType());
    }

    @Test
    void getAllDucksTest() {
        ducksRepository.addDuck(new MallardDuck()); // Assuming MallardDuck extends Duck
        ducksRepository.addDuck(new RubberDuck()); // Assuming RubberDuck extends Duck
        Iterable<Duck> allDucks = ducksRepository.getAllDucks();
        assertNotNull(allDucks);
        assertTrue(((Collection<?>) allDucks).size() >= 2);
    }

    @Test
    void searchDucksTest() {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.setType(DuckType.MALLARD);
        Duck addedMallardDuck = ducksRepository.addDuck(mallardDuck);

        Duck rubberDuck = new RubberDuck();
        rubberDuck.setType(DuckType.RUBBER_DUCK);
        Duck addedRubberDuck = ducksRepository.addDuck(rubberDuck);

        Iterable<Duck> searchedDucks = ducksRepository.search(DuckType.RUBBER_DUCK.toString());
        assertNotNull(searchedDucks);
        assertEquals(1, ((Collection<?>) searchedDucks).size());
    }
}