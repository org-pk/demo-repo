package com.inttestdemo.demo.controller;

import com.inttestdemo.demo.model.Item;
import com.inttestdemo.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * REST controller exposing the /api/items endpoint.
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * GET /api/items - Returns a list of items.
     */
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    /**
     * GET /api/items/{id} - Returns an item by its ID, or 404 if not found.
     * Validates that the ID is a numerical value.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        // Validate that id is a numerical value
        try {
            int itemId = Integer.parseInt(id);
            Item item = itemService.getItemById(itemId);
            if (item != null) {
                return ResponseEntity.ok(item);
            } else {
                // Return 404 with empty object
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Item(0, ""));
            }
        } catch (NumberFormatException e) {
            // Invalid id format
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Item(0, ""));
        }
    }
}
