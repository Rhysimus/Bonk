import java.util.*;
//https://gist.github.com/unnikked/cfad836abd9e4619a1b1
public class Brainf {
    private Scanner sc = new Scanner(System.in);
    private final int LENGTH = 65535;
    private byte[] mem = new byte[LENGTH];
    private int dataPointer;

    public void interpret(String code) {
        int l = 0;
        for(int i = 0; i < code.length(); i++) {
            if(code.charAt(i) == '>') {
                dataPointer = (dataPointer == LENGTH-1) ? 0 : dataPointer + 1;
            } else if(code.charAt(i) == '<') {
                dataPointer = (dataPointer == 0) ? LENGTH-1 : dataPointer - 1;
            } else if(code.charAt(i) == '+') {
                mem[dataPointer]++;
            } else if(code.charAt(i) == '-') {
                mem[dataPointer]--;
            } else if(code.charAt(i) == '.') {
                System.out.print((char) mem[dataPointer]);
            } else if(code.charAt(i) == ',') {
                mem[dataPointer] = (byte) sc.next().charAt(0);
            } else if(code.charAt(i) == '[') {
                if(mem[dataPointer] == 0) {
                    i++;
                    while(l > 0 || code.charAt(i) != ']') {
                        if(code.charAt(i) == '[') l++;
                        if(code.charAt(i) == ']') l--;
                        i++;
                    }
                }
            } else if(code.charAt(i) == ']') {
                if(mem[dataPointer] != 0) {
                    i--;
                    while(l > 0 || code.charAt(i) != '[') {
                        if(code.charAt(i) == ']') l++;
                        if(code.charAt(i) == '[') l--;
                        i--;
                    }
                    i--;
                }
            }
        }
    }

    public static String brainfToBonk(String code)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '>') {builder.append("BONK ");}
            else if (code.charAt(i) == '<') {builder.append("KNOB ");}
            else if (code.charAt(i) == '+') {builder.append("BONKBONK ");}
            else if (code.charAt(i) == '-') {builder.append("KNOBKNOB ");}
            else if (code.charAt(i) == '.') {builder.append("BONKED ");}
            else if (code.charAt(i) == ',') {builder.append("KNOBED ");}
            else if (code.charAt(i) == '[') {builder.append("BOINK ");}
            else if (code.charAt(i) == ']') {builder.append("KNIOB ");}
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Brainf().brainfToBonk(scanner.nextLine()));
    }
}