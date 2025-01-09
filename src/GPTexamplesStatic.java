public class GPTexamplesStatic {

    private static int count;

    static { // kod ktory sa prevedie pri spusteni tohto programu

        System.out.println("Static block executed.");
        count = 10;
    }

    public static void main(String[] args) {
        // Accessing the static variable after class loading
        System.out.println("Count: " + count);
    }

}
