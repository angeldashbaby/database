package angelbaby.database.service;

import angelbaby.database.model.Product;
import angelbaby.database.repository.ProductRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product update(String payload) {
        JSONObject obj = new JSONObject(payload);
        Product product = productRepository.findById(Long.valueOf((Integer) obj.get("itemID"))).get();
        if (obj.has("name")) product.setName((String) obj.get("name"));
        if (obj.has("description")) product.setDescription((String) obj.get("description"));
        if (obj.has("supplierName")) product.setSupplierName((String) obj.get("supplierName"));
        return productRepository.save(product);
    }

    public Product findByID(Long id) {
        return productRepository.findById(id).get();
    }

}
