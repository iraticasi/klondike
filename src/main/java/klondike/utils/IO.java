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
                writeFormatError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }

    public static int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(readString(title));
                ok = true;
            } catch (Exception ex) {
                writeFormatError("integer");
            }
        } while (!ok);
        return input;
    }

    public static int readInt(String title, ClosedInterval closedInterval) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(readString(title));
                ok = closedInterval.includes(input);
            } catch (Exception ex) {
                writeFormatError("integer");
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
                writeFormatError("caracter");
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
                writeFormatError("caracter");
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

    public static void writeError(String title, String msg) {
        writeln("!!!! " + title.toUpperCase() + ": " + msg);
        writeln();
    }

    private static void writeFormatError(String formato) {
        System.out.println("ERROR DE FORMATO! "
                + "Introduzca un valor con formato " + formato + ".");
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
