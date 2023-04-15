import lombok.Data;

@Data
public class BackpackItem {
    private int weight;
    private int benefit;
    private int position;

    public BackpackItem(int weight, int benefit, int position) {
        this.weight = weight;
        this.benefit = benefit;
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
