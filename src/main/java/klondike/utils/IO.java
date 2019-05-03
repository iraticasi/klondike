package klondike.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
            System.in));

    public static String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }

    public static int readPositiveInt(String title) {
        return readPositiveInt(title, Integer.MAX_VALUE);
    }

    public static int readPositiveInt(String title, int max) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(readString(title));
                ok = (0 < input) && (input <= max);
            } catch (Exception ex) {
                writeError("entero");
            }
        } while (!ok);
        return input;
    }

    public static char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = readString(title);
            if (input.length() != 1) {
                writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }

    public static char readChar(String title, char[] options) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = readString(title);
            if (input.length() != 1) {
                writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = (new String(options).indexOf(charValue) != -1);
            }
        } while (!ok);
        return charValue;
    }

    public static void writeln() {
        System.out.println();
    }

    public static void writetab() {
        System.out.print('\t');
    }

    public static void write(String string) {
        System.out.print(string);
    }

    public static void writeln(String string) {
        System.out.println(string);
    }

    private static void writeError(String formato) {
        System.out.println("ERROR DE FORMATO! "
                + "Introduzca un valor con formato " + formato + ".");
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
