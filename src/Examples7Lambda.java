public class Examples7Lambda {
    // static Runnable r = () -> System.out.println("funguje to :D"); // toto je lambda vyraz

    // () reprezentuju parametre metody run
    // v () budu vzdy parametre tej jednej metody nasho funkcionalneho interfacu
    static Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("funguje to :D");
        }
    }; // toto je anonymna vnutorna trieda

    public static void main(String[] args) {
        r.run();
    }
    //toto je ekvivalentne



    // Thread t = new Thread(() -> System.out.println("hello"));

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("hello");
        }
    });
    //toto je ekvivalentne
}
