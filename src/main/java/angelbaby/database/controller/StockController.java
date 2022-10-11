package angelbaby.database.controller;

import angelbaby.database.model.Product;
import angelbaby.database.model.Stock;
import angelbaby.database.service.ProductService;
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
}
