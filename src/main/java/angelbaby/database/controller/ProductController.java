package angelbaby.database.controller;

import angelbaby.database.model.Location;
import angelbaby.database.model.Product;
import angelbaby.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Product create(@RequestBody String payload) {
        return service.create(payload);
    }

    @PutMapping
    public Product update(@RequestBody String payload) {
        return service.update(payload);
    }

    @GetMapping("/{id}")
    public Product findByID(@PathVariable Long id) {
        return service.findByID(id);
    }
}
