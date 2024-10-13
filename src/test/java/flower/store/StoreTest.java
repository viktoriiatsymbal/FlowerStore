package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StoreTest {
    
    private Store store;
    private Flower firstFlower;
    private Flower secondFlower;
    private Flower thirdFlower;
    private FlowerTypeAndColor firstTypeAndColor;
    private FlowerTypeAndColor secondTypeAndColor;

    @BeforeEach
    public void setUp() {
        store = new Store();
        firstTypeAndColor = new FlowerTypeAndColor(ROSE, "#FF0000");
        firstFlower = new Flower(firstTypeAndColor);
        secondFlower = new Flower(firstTypeAndColor);

        secondTypeAndColor = new FlowerTypeAndColor(TULIP, "#0000FF");
        thirdFlower = new Flower(secondTypeAndColor);

        store.addFlower(firstFlower);
        store.addFlower(secondFlower);
        store.addFlower(thirdFlower);
    }

    @Test
    public void testAddFlower() {
        Flower newFlower = new Flower(firstTypeAndColor);
        store.addFlower(newFlower);

        ArrayList<Flower> flowers = store.search(firstTypeAndColor);
        assertTrue(flowers.contains(newFlower),
                   "The flower should be added to the store.");
    }

    @Test
    public void testSearchFlByTypeAndColorFound() {
        ArrayList<Flower> result = store.search(firstTypeAndColor);
        assertEquals(2, result.size(),
                     "There should be 2 flowers matching type and color.");
        assertTrue(result.contains(firstFlower));
        assertTrue(result.contains(secondFlower));
    }

    @Test
    public void testSearchFlByTypeAndColorNotFound() {
        FlowerTypeAndColor nonExistentTypeAndColor = new FlowerTypeAndColor(
            "Lily", "White");
        ArrayList<Flower> result = store.search(nonExistentTypeAndColor);
        assertEquals(0, result.size(), 
        "There should be no flowers matching the non-existent type and color.");
    }

    @Test
    public void testSearchForSingleMatch() {
        ArrayList<Flower> result = store.search(secondTypeAndColor);
        assertEquals(1, result.size(), 
        "There should be 1 flower matching the given type and color.");
        assertTrue(result.contains(thirdFlower));
    }
}
