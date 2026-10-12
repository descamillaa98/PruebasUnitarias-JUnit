import com.purchase.PurchaseCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseCalculatorTest {

    PurchaseCalculator funciones =new PurchaseCalculator();

    @Test
    @DisplayName("Prueba método calculateSubtotal()")
    void pruebaCalculateSubtotal(){
        
        // Producto con precio de $100 y cantidad de 3
        assertEquals(300.0, PurchaseCalculator.calculateSubtotal(100, 3));

        // Producto con cantidad de 1
        assertEquals(250.0, PurchaseCalculator.calculateSubtotal(250, 1));

        // Producto con precio de $0
        assertEquals(0.0, PurchaseCalculator.calculateSubtotal(0, 3));

    }// pruebaCalculateSubtotal

    @Test
    @DisplayName("Prueba método isValidPurchase")
    void pruebaIsValidPurchase(){

        // Precio y cantidad positivos
        assertTrue(PurchaseCalculator.isValidPurchase(100, 3));

        // Precio igual a cero
        assertFalse(PurchaseCalculator.isValidPurchase(0, 3));

        // Cantidad igual a cero
        assertFalse(PurchaseCalculator.isValidPurchase(100, 0));

        // Precio negativo
        assertFalse(PurchaseCalculator.isValidPurchase(-100, 3));

    }// pruebaIsValidPurchase

    @Test
    @DisplayName("Prueba método calculateDiscount")
    void pruebaCalculateDiscount(){

        // Subtotal inferior a $1,000
        assertEquals(0.0, PurchaseCalculator.calculateDiscount(500));

        // Subtotal exactamente igual a $1,000 (10 %)
        assertEquals(100.0, PurchaseCalculator.calculateDiscount(1000));

        // Subtotal superior a $1,000 (10 %)
        assertEquals(150.0, PurchaseCalculator.calculateDiscount(1500));

    }// pruebaCalculateDiscount

    @Test
    @DisplayName("Prueba método calculateFinalPrice()")
    void pruebaCalculateFinalPrice(){

        // Compra sin descuento
        assertEquals(500.0, PurchaseCalculator.calculateFinalPrice(500));

        // Compra con descuento del 10 %
        assertEquals(1350.0, PurchaseCalculator.calculateFinalPrice(1500));

        // Compra cuyo subtotal es exactamente $1,000
        assertEquals(900.0, PurchaseCalculator.calculateFinalPrice(1000));

    }// pruebaCalculateFinalPrice
}
