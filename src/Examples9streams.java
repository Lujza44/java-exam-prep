import java.util.Arrays;
import java.util.List;

public class Examples9streams {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("jablko", "hruska", "banan");

        long count = words.stream()
                .filter(w -> w.length() < 6)
                .count();

        long count1 = words.parallelStream()
                .filter(w -> w.length() > 5)
                .count();

        System.out.println(count);
        System.out.println(count1);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = numbers.parallelStream() // parallel stream z Listu
                .reduce(5,Integer::sum);
        System.out.println(sum);

    }
}
