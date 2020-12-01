import java.util.*;
//https://gist.github.com/unnikked/cfad836abd9e4619a1b1
public class Bonk {
    private Scanner sc = new Scanner(System.in);
    private final int LENGTH = 65535;
    private byte[] mem = new byte[LENGTH];
    private int dataPointer;

    public static String bonkToBrainf(String code)
    {
        String[] split = code.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("BONK")) {builder.append(">");}
            else if (split[i].equals("KNOB")) {builder.append("<");}
            else if (split[i].equals("BONKBONK")) {builder.append("+");}
            else if (split[i].equals("KNOBKNOB")) {builder.append("-");}
            else if (split[i].equals("BONKED")) {builder.append(".");}
            else if (split[i].equals("KNOBED")) {builder.append(",");}
            else if (split[i].equals("BOINK")) {builder.append("[");}
            else if (split[i].equals("KNIOB")) {builder.append("]");}
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Brainf().interpret(bonkToBrainf(scanner.nextLine()));
    }
}