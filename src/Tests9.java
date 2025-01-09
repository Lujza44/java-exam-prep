public class Tests9 {
    public static void main(String[] args) { // nic sa nevypise, ide to len do buffru
        System.out.write(48);

        String greeting = "Hello world";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.write(greeting.charAt(i));
        }

        String fullClassName = "cz.cuni.mff.java.io.Slasher";
        String fileName = fullClassName.replaceAll(".", "/") + ".java";
        // vsetko sa nahradi lomitkami lebo regex "." je vsetko xd
        System.out.println("Trida " + fullClassName + " musi byt v souboru " + fileName);
    }
}
