import java.util.concurrent.atomic.AtomicInteger;

public class Toy {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final String name;
    private final int id;
    private int quantity;
    private double frequency;

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", frequency=" + frequency +
                '}';
    }

    public Toy(String name, int quantity, double frequency) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}