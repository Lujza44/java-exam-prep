public class Examples1 {

    static void plusOne(int a) { // preda sa kopia hodnoty parametra a
        a = a + 1; // modifikuje sa kopia "a"
    }

    static void appendA(StringBuilder sb) { // preda sa KOPIA REFERENCIE na objekt
        sb.append("A"); // modifikuje sa objekt "sb"
    }

    static void iterateArray() {
        int[] array = {1, 2, 3, 4};
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Hello");
        StringBuilder s2 = s1; // referencia
        s1.append(" world!");
        System.out.println(s2); // vypise sa Hello world!

        int i1 = 42;
        int i2 = i1; // nie referencia !
        i1++;
        System.out.println(i2); // vypise sa 42!
        System.out.println(i1); // 43

        int a = 5;
        plusOne(a);
        System.out.println(a); // vypise sa 5, "a" je nezavisle na tom co sa deje vnutri metody plusOne

        StringBuilder sb = new StringBuilder("A");
        appendA(sb);
        System.out.println(sb); // vypise sa AA, kopia referencie na "sb" sa preda metode appendA
        // objekt sa modifikuje v metode

        int x = 5;
        System.out.println(x++); // vypise sa "x", potom inkrementacia
        System.out.println(++x); // inkrementacia najprv, potom sa vypise "x"

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str1 == str2 ? "YES" : "NO"); // vypise sa "NO", lebo iny objekt
        // use .equals instead
        // vyraz ? if_true : if_false

        iterateArray();
    }
}
