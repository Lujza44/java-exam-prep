public class Tests2 {
    public static void main(String[] args) {
        int START = 2000000000;
        int count = 0;
        for (float f = START; f < START + 50; f++) {
            count++;
        }
        System.out.println(count); // vypise 0, lebo float je nepresny, cyklus sa neprevedie
    }
}
