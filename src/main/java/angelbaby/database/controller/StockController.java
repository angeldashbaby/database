package angelbaby.database.controller;

import angelbaby.database.model.Location;
import angelbaby.database.model.Stock;
import angelbaby.database.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService service;

    @GetMapping
    public List<Stock> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Stock create(@RequestBody String payload) throws ParseException {
        return service.create(payload);
    }

    @PutMapping
    public Stock update(@RequestBody String payload) throws ParseException {
        return service.update(payload);
    }

    @GetMapping("/{id}")
    public Stock findByID(@PathVariable Long id) {
        return service.findByID(id);
    }
}
