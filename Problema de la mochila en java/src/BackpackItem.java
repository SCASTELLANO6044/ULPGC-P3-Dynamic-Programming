public class BackpackItem {
    private final int weight;
    private final int benefit;
    private final int position;

    public BackpackItem(int weight, int benefit, int position) {
        this.weight = weight;
        this.benefit = benefit;
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }

    public int getBenefit() {
        return benefit;
    }

    @Override
    public String toString() {
        return "BackpackItem{" +
                "weight=" + weight +
                ", benefit=" + benefit +
                ", position=" + position +
                '}';
    }
}
