package angelbaby.database.service;

import angelbaby.database.model.Log;
import angelbaby.database.model.Stock;
import angelbaby.database.model.Location;
import angelbaby.database.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<Log> getAll() {
        return logRepository.findAll();
    }

    public Log create(String payload) throws ParseException {

        JSONObject obj = new JSONObject(payload);
        Log log = new Log();
        String type = (String) obj.get("type");
        log.setType(type);

        if (type.equals("inbound")) {
            log.setProductInDate(new SimpleDateFormat("dd/MM/yyyy").parse((String) obj.get("productInDate")));

            JSONObject stockObj = obj.getJSONObject("stock");
            Stock stock = new Stock();
            stock.setExpire(new SimpleDateFormat("dd/MM/yyyy").parse((String) stockObj.get("expire")));
            int quantity = (Integer) stockObj.get("quantity");
            stock.setQuantity(quantity);
            stock.setItem(productRepository.findById(Long.valueOf((Integer) stockObj.get("itemID"))).get());
            stockRepository.save(stock);

            log.setStock(stock);
            log.setIOQuantity(quantity);
            log.setTotalQuantity(quantity); // total quantity = in quantity = stock quantity

            if (obj.has("locationID")) {
                Location location = locationRepository.findById(obj.getLong("locationID")).get();
                location.setStockID(stock);
            }
        } else if (type.equals("outbound")) {
            log.setProductOutDate(new SimpleDateFormat("dd/MM/yyyy").parse((String) obj.get("productOutDate")));

//            Stock stock = stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get();
            List<Stock> list = stockRepository.findAll();
            Integer IOQuantity = (Integer) obj.get("IOQuantity");
            Stock stock = null;
            for (Stock s : list) { // find every stock
                // if item is not the same, skip stock
                if (s.getItem().getItemID() != obj.getLong("itemID")) {
                    continue;
                }

                if (s.useQuantity(IOQuantity)) // subtract from stock
                {
                    stock = s;
                    stockRepository.save(stock);
                    break;
                }
            }

            int totalQuantity = stock.getQuantity();

            log.setStock(stock);
            log.setIOQuantity(IOQuantity);
            log.setTotalQuantity(totalQuantity);
        }
        log.setUser(userRepository.findById(Long.valueOf((Integer) obj.get("userID"))).get());
        return logRepository.save(log);
    }

    public Log findByID(Long id) {
        return logRepository.findById(id).get();
    }

}
