package angelbaby.database.service;

import angelbaby.database.dto.LocationDto;
import angelbaby.database.model.Location;
import angelbaby.database.repository.LocationRepository;
import angelbaby.database.repository.ProductRepository;
import angelbaby.database.repository.StockRepository;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LocationDto> getAll() {
        List<LocationDto> loli = new ArrayList<>();
        for (Location i: locationRepository.findAll()) {
            loli.add(new LocationDto(i));
        }
        return loli;
    }

    public Location create(String payload) {
        JSONObject obj = new JSONObject(payload);
        Location location = new Location();
        location.setShelfID((Integer) obj.get("shelfID"));
        location.setPosition((String) obj.get("position"));
        if (obj.has("stockID")) location.setStockID(stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get());
        return locationRepository.save(location);
    }

    public Location update(String payload) {
        JSONObject obj = new JSONObject(payload);
        Location location = locationRepository.findById(Long.valueOf((Integer) obj.get("locationID"))).get();
        if (obj.has("shelfID")) location.setShelfID((Integer) obj.get("shelfID"));
        if (obj.has("position")) location.setPosition((String) obj.get("itemID"));
        if (obj.has("stockID")) location.setStockID(stockRepository.findById(Long.valueOf((Integer) obj.get("stockID"))).get());
        return locationRepository.save(location);
    }

    public Location findByID(Long id) {
        return locationRepository.findById(id).get();
    }
}
