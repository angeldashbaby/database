package angelbaby.database.service;

import angelbaby.database.model.Stock;
import angelbaby.database.repository.ProductRepository;
import angelbaby.database.repository.StockRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Stock create(String payload) throws ParseException {
        JSONObject obj = new JSONObject(payload);
        Stock stock = new Stock();
        stock.setExpire(new SimpleDateFormat("dd/MM/yyyy").parse((String) obj.get("expire")));
        stock.setQuantity((Integer) obj.get("quantity"));
        stock.setItem(productRepository.findById(Long.valueOf((Integer) obj.get("itemID"))).get());
        return stockRepository.save(stock);

    }

    public Stock update(String payload) throws ParseException {
        JSONObject obj = new JSONObject(payload);
        Stock stock = stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get();
        if (obj.has("expire")) stock.setExpire(new SimpleDateFormat("dd/MM/yyyy").parse((String) obj.get("expire")));
        if (obj.has("quantity")) stock.setQuantity((Integer) obj.get("quantity"));
        if (obj.has("itemID")) stock.setItem(productRepository.findById(Long.valueOf((Integer) obj.get("itemID"))).get());
        return stockRepository.save(stock);
    }

    public Stock findByID(Long id) {
        return stockRepository.findById(id).get();
    }

}
