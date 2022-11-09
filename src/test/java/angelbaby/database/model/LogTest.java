package angelbaby.database.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test
    void getLogID() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getLogID(), 1L);
    }

    @Test
    void getType() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getType(), "inbound");
    }

    @Test
    void getProductInDate() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getProductInDate(), new Date(2022,11,4));
    }

    @Test
    void getProductOutDate() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getProductOutDate(), null);
    }

    @Test
    void getIOQuantity() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getIOQuantity(), 100);
    }

    @Test
    void getTotalQuantity() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getTotalQuantity(), 850);
    }

    @Test
    void getStockId() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getStock().getStockID(), 1L);
    }

    @Test
    void getUser() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        assertEquals(log.getUser().getUserID(), 1L);
    }

    @Test
    void setLogID() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setLogID(2L);
        assertEquals(log.getLogID(), 2L);
    }

    @Test
    void setType() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setType("outbound");
        assertEquals(log.getType(), "outbound");
    }

    @Test
    void setProductInDate() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setProductInDate(new Date(2022,11,8));
        assertEquals(log.getProductInDate(), new Date(2022,11,8));

    }

    @Test
    void setProductOutDate() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setProductOutDate(new Date(2022,12,5));
        assertEquals(log.getProductOutDate(), new Date(2022,12,5));
    }

    @Test
    void setIOQuantity() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setIOQuantity(55);
        assertEquals(log.getIOQuantity(), 55);
    }

    @Test
    void setTotalQuantity() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.setTotalQuantity(500);
        assertEquals(log.getTotalQuantity(), 500);
    }

    @Test
    void setStockId() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.getStock().setStockID(2L);
        assertEquals(log.getStock().getStockID(), 2L);
    }

    @Test
    void setUserId() {
        Date productInDate = new Date(2022,11,4);
        Product product = new Product(1L,"book", "book test", "aungpor");
        Date date = new Date(2020,11,4);
        Stock stock = new Stock(1L, date,50, product);
        User user = new User(1L, "user01", "userpass");
        Log log = new Log(1L, "inbound",productInDate, null, 100, 850, stock, user);
        log.getUser().setUserID(2L);
        assertEquals(log.getUser().getUserID(), 2L);
    }
}