public class PrintArgsMorse {

    public static int findIndex(char[] array, char c) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        throw new IllegalArgumentException("neznamy znak: " + c);
    }

    private static String letterToMorse(char c) {
        String[] code
                = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--..", ".----", "..---", "...--",
                "....-", ".....", "-....", "--...",
                "---..", "----.", "-----"};
        char[] letters
                = {'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0'};


        int index = findIndex(letters, c);
        return code[index];
    }


    public static void main(String[] args) {
        for (String arg : args) {
            for (char ch : arg.toCharArray()) {
                try {
                    System.out.print(letterToMorse(ch) + " ");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println();
            // String.charAt(int index)
        }
    }
}

