package flower.store;

public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower fl, int q) {
        flower = fl;
        quantity = q;
    }

    public FlowerPack(FlowerPack other) {
        flower = new Flower(other.flower);
        quantity = other.quantity;
    }
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
