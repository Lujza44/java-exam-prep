public class Tests3 {
    public static void main(String[] argv) {
        System.out.println(test());

        try {
            System.out.println("Hello world!");
            System.exit(0); // skonci program, vypise sa Hello world!
        } finally {
            System.out.println("Goodbye");
        }
    }

    public static boolean test() {
        try {
            return true;
        } finally { // pred ukoncenim try sa skoci sem, vypise sa false
            return false;
        }
    }
}
