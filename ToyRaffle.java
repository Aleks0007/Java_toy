public class ToyRaffle {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        store.addNewToys();

        for (int i = 0; i < 10; i++) {
            int toy_id = store.organizeRaffle();
            store.getPrizeToy(toy_id);
        }
    }
}
