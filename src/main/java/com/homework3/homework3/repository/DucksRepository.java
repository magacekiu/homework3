package com.homework3.homework3.repository;


import com.homework3.homework3.model.Duck;
import com.homework3.homework3.model.DuckType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class DucksRepository {
    private List<Duck> ducks = new ArrayList<>();
    private static int lastId = 0;

    public Duck addDuck(Duck duck) {
        duck.setId(++lastId); // Increment and set the new ID
        ducks.add(duck);
        return duck;
    }

    public Duck getDuck(int id) {
        return ducks.stream()
                    .filter(d -> d.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public Iterable<Duck> search(String type) {
        return ducks.stream()
                    .filter(d -> d.getType().name().equals(type))
                    .collect(Collectors.toList());
    }

    public Duck updateDuck(int id, DuckType newType) {
    Duck duck = getDuck(id);
    if (duck != null) {
        duck.setType(newType);
    }
    return duck;
    }



    public Iterable<Duck> getAllDucks() {
        return ducks;
    }


}
