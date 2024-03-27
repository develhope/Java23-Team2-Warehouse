package classes;
import org.junit.Test;
import products.KindOfProduct;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseTest {

    @Test
    public void purchasablePrice() {
        Warehouse warehouse = new Warehouse();
        Warehouse.fillUpWarehouse(warehouse);
        BigDecimal result = warehouse.purchasablePrice(KindOfProduct.TABLET);
        BigDecimal expected = BigDecimal.valueOf(1200.0);
        assertEquals(expected , result);
    }
}