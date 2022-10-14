package angelbaby.database.controller;

import angelbaby.database.model.Location;
import angelbaby.database.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private LocationService service;

    @GetMapping
    public List<Location> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Location create(@RequestBody String payload) {
        return service.create(payload);
    }

    @PutMapping
    public Location update(@RequestBody String payload) {
        return service.update(payload);
    }

    @GetMapping("/{id}")
    public Location findByID(@PathVariable Long id) {
        return service.findByID(id);
    }
}
