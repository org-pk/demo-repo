package com.inttestdemo.demo.repository;

import com.inttestdemo.demo.model.Item;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Repository layer simulating data access from a static array.
 */
@Repository
public class ItemRepository {
    private final List<Item> items = Arrays.asList(
            new Item(1, "Apple"),
            new Item(2, "Banana"),
            new Item(3, "Cherry")
    );

    public List<Item> findAll() {
        return items;
    }

    public Item findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
