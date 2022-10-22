package angelbaby.database.service;

import angelbaby.database.model.Location;
import angelbaby.database.repository.LocationRepository;
import angelbaby.database.repository.ProductRepository;
import angelbaby.database.repository.StockRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location create(String payload) {
        JSONObject obj = new JSONObject(payload);
        Location location = new Location();
        location.setShelfID((Integer) obj.get("shelfID"));
        if (obj.has("stockID")) location.setStockID(stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get());
        if (obj.has("itemID")) location.setItemID(productRepository.findById(Long.valueOf((Integer) obj.get("itemID"))).get());
        return locationRepository.save(location);
    }

    public Location update(String payload) {
        JSONObject obj = new JSONObject(payload);
        Location location = locationRepository.findById(Long.valueOf((Integer) obj.get("locationID"))).get();
        if (obj.has("shelfID")) location.setShelfID((Integer) obj.get("shelfID"));
        if (obj.has("stockID")) location.setStockID(stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get());
        if (obj.has("itemID")) location.setItemID(productRepository.findById(Long.valueOf((Integer) obj.get("itemID"))).get());
        return locationRepository.save(location);
    }

    public Location findByID(Long id) {
        return locationRepository.findById(id).get();
    }
}
