import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        
        list.add("maria");
        list.add("amanda");
        list.add("julia");
        list.add(1, "daniel");

        for (String element : list) {
            System.out.println(element);
        }
        
        list.remove("amanda");
        list.remove(0);
        list.removeIf(x -> x.charAt(0) == 'm');
    }
}
