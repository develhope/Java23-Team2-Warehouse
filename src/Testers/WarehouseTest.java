package Testers;

import product.Product;
import warehouse.Warehouse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    @Test
    public void checkIfEmptyMapTest() {
        Map<Product, Integer> testMap = new HashMap<>();
        int result = 0;
        if (!testMap.isEmpty()) {
            result++;
        }
        assertEquals(0, result);
    }

    @Test
    public void checkIfIsNotEmptyMapTest() {
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1, 1);
        int result = 0;
        if (!testMap.isEmpty()) {
            result++;
        }
        assertEquals(result, 1);
    }

    @Test
    public void checkIfEmptyMapThrowTest() {
        Map<Product, Integer> testMap = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> Warehouse.checkIfEmptyMap(testMap));
    }

    @Test
    public void checkIfEmptyMapThrowMessageTest() {
        Map<Product, Integer> testMap = new HashMap<>();
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Warehouse.checkIfEmptyMap(testMap));
        String expectedMessage = "Non è stato trovato nessun elemento corrispondente.\n";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}