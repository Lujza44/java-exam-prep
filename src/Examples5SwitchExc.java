public class Examples5SwitchExc {
    public enum Color {BLUE, RED, GREEN}

    public Color clr = Color.BLUE;

    public enum Operation {
        PLUS, MINUS, TIMES, DIVIDE;

        double eval(double x, double y) {
            return switch (this) { // musi pokryt vsetky moznosti comu sa moze "this" rovnat
                case PLUS -> x + y;
                case MINUS -> x - y;
                case TIMES -> x * y;
                case DIVIDE -> x / y;
            };
        }
    }

    public static void day(String day) {
        switch (day) {
            case "mon", "tue", "wed", "thu", "fri" -> System.out.println("Working day.");
            case "sat", "sun" -> System.out.println("Weekend.");
            default -> throw new IllegalArgumentException("Not known."); // message s ktorym sa vynimka vyhodi
        }
    }

    public static void main(String[] args) {
        Operation op = Operation.PLUS;
        double result = op.eval(3, 5);
        System.out.println(result);
        try {
            day("hello");
        } catch (IllegalArgumentException e){ //
            System.out.println(e.getMessage());
            //throw e;
        }
    }
}
