package flower.store;

import java.util.ArrayList;

public class FlowerBucket {
    private ArrayList<FlowerPack> flowers;

    public FlowerBucket() {
        flowers = new ArrayList<FlowerPack>();
    }

    public FlowerBucket(ArrayList<FlowerPack> flowerPack) {
        this.flowers = flowerPack;
    }

    public double getPrice() {
        double totalPrice = 0;
        for (FlowerPack flowerPack : flowers) {
            totalPrice += flowerPack.getPrice();
        }
        return totalPrice;
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowers.add(flowerPack);
    }
}
