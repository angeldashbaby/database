package angelbaby.database.service;

import angelbaby.database.model.Location;
import angelbaby.database.model.Product;
import angelbaby.database.repository.LocationRepository;
import angelbaby.database.repository.ProductRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(String payload) {

        JSONObject obj = new JSONObject(payload);
        Product product = new Product();
        product.setName((String) obj.get("name"));
        product.setDescription((String) obj.get("description"));
        product.setSupplierName((String) obj.get("supplierName"));
        return productRepository.save(product);
    }

}
