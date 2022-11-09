package angelbaby.database.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void getLocationID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        assertEquals(location.getLocationID(),1L);
    }

    @Test
    void getShelfID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        assertEquals(location.getShelfID(),1);
    }

    @Test
    void getPosition() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        assertEquals(location.getPosition(),"position1");
    }

    @Test
    void getStockID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        assertEquals(location.getStockID().getStockID(),1L);
    }

    @Test
    void setLocationID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        location.setLocationID(2l);
        assertEquals(location.getLocationID(),2l);
    }

    @Test
    void setShelfID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        location.setShelfID(2);
        assertEquals(location.getShelfID(),2);
    }

    @Test
    void setPosition() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        location.setPosition("position2");
        assertEquals(location.getPosition(),"position2");

    }

    @Test
    void setStockID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        Location location = new Location(1L, 1, "position1", stock);
        location.getStockID().setStockID(2l);
        assertEquals(location.getStockID().getStockID(),2l);
    }
}