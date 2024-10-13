package flower.store;

public class FlowerTypeAndColor {
    private FlowerType flowerType;
    private FlowerColor colour;

    public FlowerTypeAndColor(FlowerType type, FlowerColor color) {
        flowerType = type;
        colour = color;
    }

    public Boolean matches(FlowerTypeAndColor tandc) {
        return flowerType.equals(tandc.flowerType)
            && colour.equals(tandc.colour);
    }
}
