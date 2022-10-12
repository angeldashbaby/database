package angelbaby.database.controller;

import angelbaby.database.model.Log;
import angelbaby.database.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping
    public List<Log> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Log create(@RequestBody String payload) throws ParseException {
        return service.create(payload);
    }
}
