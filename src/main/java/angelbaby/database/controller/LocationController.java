package angelbaby.database.controller;

import angelbaby.database.model.Location;
import angelbaby.database.model.Product;
import angelbaby.database.service.LocationService;
import angelbaby.database.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
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

//    @PostMapping
//    public Location create(@RequestBody Location location) {
//        return service.create(location);
//    }

    @PostMapping
    public Location create(@RequestBody String payload) {
        return service.create(payload);
    }
}
