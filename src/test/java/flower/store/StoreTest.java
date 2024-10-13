package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StoreTest {
    
    private Store store;
    private Flower flower1;
    private Flower flower2;
    private Flower flower3;
    private FlowerTypeAndColor typeAndColor1;
    private FlowerTypeAndColor typeAndColor2;

    @BeforeEach
    public void setUp() {
        store = new Store();
        typeAndColor1 = new FlowerTypeAndColor(ROSE, "#FF0000");
        flower1 = new Flower(typeAndColor1);
        flower2 = new Flower(typeAndColor1);

        typeAndColor2 = new FlowerTypeAndColor(TULIP, "#0000FF");
        flower3 = new Flower(typeAndColor2);

        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlower(flower3);
    }

    @Test
    public void testAddFlower() {
        Flower newFlower = new Flower(typeAndColor1);
        store.addFlower(newFlower);

        ArrayList<Flower> flowers = store.search(typeAndColor1);
        assertTrue(flowers.contains(newFlower), "The flower should be added to the store.");
    }

    @Test
    public void testSearchFlowersByTypeAndColor_Found() {
        ArrayList<Flower> result = store.search(typeAndColor1);
        assertEquals(2, result.size(), "There should be 2 flowers matching type and color.");
        assertTrue(result.contains(flower1));
        assertTrue(result.contains(flower2));
    }

    @Test
    public void testSearchFlowersByTypeAndColor_NotFound() {
        FlowerTypeAndColor nonExistentTypeAndColor = new FlowerTypeAndColor("Lily", "White");
        ArrayList<Flower> result = store.search(nonExistentTypeAndColor);
        assertEquals(0, result.size(), "There should be no flowers matching the non-existent type and color.");
    }

    @Test
    public void testSearchForSingleMatch() {
        ArrayList<Flower> result = store.search(typeAndColor2);
        assertEquals(1, result.size(), "There should be 1 flower matching the given type and color.");
        assertTrue(result.contains(flower3));
    }
}
