package flower.store;

import java.util.ArrayList;

public class Store {
    private ArrayList<Flower> flowers;

    public Store() {
        flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public ArrayList<Flower> search(FlowerTypeAndColor tandc) {
        ArrayList<Flower> searchRes = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getTypeAndColor().matches(tandc)) {
                searchRes.add(flower);
            }
        }
        return searchRes;
    }
}
