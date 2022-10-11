package angelbaby.database.service;

import angelbaby.database.model.Location;
import angelbaby.database.model.Product;
import angelbaby.database.repository.LocationRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location create(String payload) {
        JSONObject obj = new JSONObject(payload);
        Location location = new Location();
        location.setShelfID((Integer) obj.get("shelfID"));
        return locationRepository.save(location);
    }
}
