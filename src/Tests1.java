public class Tests1 {
    public static void main(String[] args) {
        int b = 2147483647;
        System.out.println(b);
        b++;
        System.out.println(b); // vypise -2147483648

        System.out.println("url:");
        http://google.com/      // "http:" je unused label, zvysok komentar
        System.out.println(":url");

        int x = 10;
        int y = 20;
        x ^= y ^= x ^= y;
        System.out.println(x);
        System.out.println(y);
        System.out.println("\n");

        int j = 0;
        for (int i = Integer.MAX_VALUE - 10; i <= Integer.MAX_VALUE; i++) {
            j++;
        }
        System.out.println(j); // zacne sa to cyklit, bezi donekonecna
    }
}
