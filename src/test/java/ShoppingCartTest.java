import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public void testCalculateItemCost() {
        double price = 2.5;
        int quantity = 4;
        double expected = 10.0;
        double actual = ShoppingCart.calculateItemCost(price, quantity);
        assertEquals("calculateItemCost should return price * quantity", expected, actual, 1e-9);
    }

}
