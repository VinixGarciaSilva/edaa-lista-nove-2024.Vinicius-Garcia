import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Drinks> drinks = new ArrayList<>();
        Drinks.archive(drinks);
        Drinks.list(drinks);
    }
}
