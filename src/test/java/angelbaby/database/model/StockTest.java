package angelbaby.database.model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void useQuantity() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        stock.useQuantity(10);
        assertEquals(stock.useQuantity(10), true);
    }

    @Test
    void getStockID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        assertEquals(stock.getStockID(), 1L);
    }

    @Test
    void getExpire() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        assertEquals(stock.getExpire(), new Date(2020,11,4));
    }

    @Test
    void getQuantity() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        assertEquals(stock.getQuantity(), 50);
    }

    @Test
    void getItemId() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        assertEquals(stock.getItem().getItemID(), 1L);
    }

    @Test
    void setStockID() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        stock.setStockID(2L);
        assertEquals(stock.getStockID(), 2L);
    }

    @Test
    void setExpire() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        stock.setExpire(new Date(2020,11,4));
        assertEquals(stock.getExpire(), new Date(2020,11,4));
    }

    @Test
    void setQuantity() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        stock.setQuantity(100);
        assertEquals(stock.getQuantity(), 100);
    }

    @Test
    void setItemId() {
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        stock.getItem().setItemID(3L);
        assertEquals(stock.getItem().getItemID(), 3L);
    }

}