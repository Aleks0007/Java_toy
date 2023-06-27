import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyStore {
    private final ArrayList<Toy> toys;
    private final PriorityQueue<Toy> queue;
    private final String prizeFilePath;

    public ToyStore() {
        toys = new ArrayList<>();
        queue = new PriorityQueue<>(Comparator.comparingDouble(Toy::getFrequency));
        prizeFilePath = "prize_toys.txt";
    }

    public void addNewToys() {
    Scanner in = new Scanner(System.in);
    System.out.print("Введите количество новых игрушек (максимум 4): ");
    int numOfToys = Math.min(in.nextInt(), 4);
    
        for (int i = 0; i < numOfToys; i++) {
            System.out.print("Введите название игрушки: ");
            String toyName = in.next();
            System.out.print("Введите количество игрушек: ");
            int toyQuantity = in.nextInt();
            System.out.print("Введите частоту выпадения игрушки (вес): ");
            double toyFrequency = in.nextDouble();
            Toy newToy = new Toy(toyName, toyQuantity, toyFrequency);
            toys.add(newToy);
            for (int j = 0; j < toyFrequency; j++) {
                queue.add(newToy);
            }
        }
    }


    public int organizeRaffle() {
        Toy prizeToy = queue.poll();
        if (prizeToy != null) {
            queue.offer(prizeToy); // return the toy back to the queue
            return prizeToy.getId();
        }
        throw new RuntimeException("Больше нет игрушек");
    }

    public void getPrizeToy(int toy_id) {
        Toy prizeToy = toys.get(toy_id);
        if (prizeToy.getQuantity() != 0) {
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.getId() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при записи в файл");
            }
        } else {
            System.out.println("Игрушка закончилась");
        }
    }
}
