package classes;
import org.junit.Test;
import products.KindOfProduct;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class WarehouseTest {
    @Test
    public void testPurchasablePriceWithNonEmptyWarehouse() {

        Warehouse warehouse = new Warehouse();

        Warehouse.fillUpWarehouse(warehouse);

        BigDecimal result = warehouse.purchasablePrice(KindOfProduct.SMARTPHONE);

        BigDecimal expected = BigDecimal.valueOf(400.00);

        assertEquals(expected, result);
    }
}

