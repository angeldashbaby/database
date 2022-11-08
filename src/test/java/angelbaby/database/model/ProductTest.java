package angelbaby.database.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void getName() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        String name = product.getName();
        assertEquals(name ,"book");
    }

    @Test
    void getDescription() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        String description = product.getDescription();
        assertEquals(description ,"book test");
    }

    @Test
    void getSupplierName() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        String supplierName = product.getSupplierName();
        assertEquals(supplierName ,"aungpor");
    }

    @Test
    void setItemID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        product.setItemID(2L);
        assertEquals(product.getItemID() ,2L);
    }

    @Test
    void setName() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        product.setName("coffee");
        assertEquals(product.getName() ,"coffee");
    }

    @Test
    void setDescription() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        product.setDescription("book test");
        assertEquals(product.getDescription() ,"book test");
    }

    @Test
    void setSupplierName() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        product.setSupplierName("Ton");
        assertEquals(product.getSupplierName() ,"Ton");
    }
}