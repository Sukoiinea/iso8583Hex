import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class iso8583 {
    private static Map<String,String> digiMap = new HashMap<>();
    private static ArrayList<Integer> useField = new ArrayList<>();
    private static StringBuffer rest;
    private static String header;
    private static HashMap<Integer,String> out;

    static {
        digiMap.put("0", "0000");
        digiMap.put("1", "0001");
        digiMap.put("2", "0010");
        digiMap.put("3", "0011");
        digiMap.put("4", "0100");
        digiMap.put("5", "0101");
        digiMap.put("6", "0110");
        digiMap.put("7", "0111");
        digiMap.put("8", "1000");
        digiMap.put("9", "1001");
        digiMap.put("A", "1010");
        digiMap.put("B", "1011");
        digiMap.put("C", "1100");
        digiMap.put("D", "1101");
        digiMap.put("E", "1110");
        digiMap.put("F", "1111");
    }

    public iso8583() {

    }

    public static void put(StringBuffer input) {
        out = new HashMap<>();
        if (useField.contains(1)) {
            String field = input.substring(0,16);
            out.put(1,field);
            rest.replace(0,16,"");
            //System.out.println("1:\t"+ out.get(1));
        }
        if (useField.contains(2)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("2:\t"+ fieldLL);
            rest.replace(0,4,"");
            String field2 = rest.substring(0,fieldLLInt);
            out.put(2,field2);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(2));
        }
        if (useField.contains(3)) {
            String field = rest.substring(0,12);
            out.put(3,field);
            rest.replace(0,12,"");
            //System.out.println("3:\t"+ out.get(3));
        }
        if (useField.contains(4)) {
            String field = rest.substring(0,24);
            out.put(4,field);
            rest.replace(0,24,"");
            //System.out.println("4:\t"+ out.get(4));
        }
        if (useField.contains(7)) {
            String field = rest.substring(0,20);
            out.put(7,field);
            rest.replace(0,20,"");
            //System.out.println("7:\t"+ out.get(7));
        }
        if (useField.contains(11)) {
            String field = rest.substring(0,12);
            out.put(11,field);
            rest.replace(0,12,"");
            //System.out.println("11:\t"+ out.get(11));
        }
        if (useField.contains(12)) {
            String field = rest.substring(0,12);
            out.put(12,field);
            rest.replace(0,12,"");
            //System.out.println("12:\t"+ out.get(12));
        }
        if (useField.contains(13)) {
            String field = rest.substring(0,8);
            out.put(13,field);
            rest.replace(0,8,"");
            //System.out.println("13:\t"+ out.get(13));
        }
        if (useField.contains(15)) {
            String field = rest.substring(0,8);
            out.put(15,field);
            rest.replace(0,8,"");
            //System.out.println("15:\t"+ out.get(15));
        }
        if (useField.contains(18)) {
            String field = rest.substring(0,8);
            out.put(18,field);
            rest.replace(0,8,"");
            //System.out.println("18:\t"+ out.get(18));
        }
        if (useField.contains(22)) {
            String field = rest.substring(0,6);
            out.put(22,field);
            rest.replace(0,6,"");
            //System.out.println("22:\t"+ out.get(22));
        }
        if (useField.contains(23)) {
            String field = rest.substring(0,6);
            out.put(23,field);
            rest.replace(0,6,"");
            //System.out.println("23:\t"+ out.get(23));
        }
        if (useField.contains(32)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("32:\t"+ fieldLL);
            rest.replace(0,4,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(32,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(32));
        }
        if (useField.contains(33)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("33:\t"+ fieldLL);
            rest.replace(0,4,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(33,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(33));
        }
        if (useField.contains(35)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("35:\t"+ fieldLL);
            rest.replace(0,4,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(35,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(35));
        }
        if (useField.contains(37)) {
            String field = rest.substring(0,24);
            out.put(37,field);
            rest.replace(0,24,"");
            //System.out.println("37:\t"+ out.get(37));
        }
        if (useField.contains(39)) {
            String field = rest.substring(0,4);
            out.put(39,field);
            rest.replace(0,4,"");
            //System.out.println("39:\t"+ out.get(39));
        }
        if (useField.contains(43)) {
            String field = rest.substring(0,80);
            out.put(43,field);
            rest.replace(0,80,"");
            //System.out.println("43:\t"+ out.get(43));
        }
        if (useField.contains(48)) {
            String fieldLL = rest.substring(0,6);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("48:\t"+ fieldLL);
            rest.replace(0,6,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(48,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(48));
        }
        if (useField.contains(49)) {
            String field = rest.substring(0,6);
            out.put(49,field);
            rest.replace(0,6,"");
            //System.out.println("49:\t"+ out.get(49));
        }
        if (useField.contains(52)) {
            String field = rest.substring(0,32);
            out.put(52,field);
            rest.replace(0,32,"");
            //System.out.println("52:\t"+ out.get(52));
        }
        if (useField.contains(55)) {
            String fieldLL = rest.substring(0,6);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("55:\t"+ fieldLL);
            rest.replace(0,6,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(55,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(55));
        }
        if (useField.contains(62)) {
            String fieldLL = rest.substring(0,6);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("62:\t"+ fieldLL);
            rest.replace(0,6,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(62,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(62));
        }
        if (useField.contains(70)) {
            String field = rest.substring(0,6);
            out.put(70,field);
            rest.replace(0,6,"");
            //System.out.println("70:\t"+ out.get(70));
        }
        if (useField.contains(102)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("102:"+ fieldLL);
            rest.replace(0,4,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(102,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(102));
        }
        if (useField.contains(103)) {
            String fieldLL = rest.substring(0,4);
            int fieldLLInt = (Integer.parseInt(hexToAscii(fieldLL)))*2;
            //System.out.print("103:"+ fieldLL);
            rest.replace(0,4,"");
            String field = rest.substring(0,fieldLLInt);
            out.put(103,field);
            rest.replace(0,fieldLLInt,"");
            //System.out.println(" "+ out.get(103));
        }
    }

    public static void turnToAscii() {
        System.out.println(" \nHeader: "+ hexToAscii(header));
        for (int i = 0; i < useField.size(); i++) {
            String askii = hexToAscii(out.get(useField.get(i)));
            if (useField.get(i) > 99) {
                System.out.println(useField.get(i)+":"+askii);
            }else{
                System.out.println(useField.get(i)+":\t"+askii);
            }
        }
    }

    public static void turnToHex() {
        System.out.println(" \nHeader: "+ header);
        for (int i = 0; i < useField.size(); i++) {
            String askii = out.get(useField.get(i));
            if (useField.get(i) > 99) {
                System.out.println(useField.get(i)+":"+askii);
            }else{
                System.out.println(useField.get(i)+":\t"+askii);
            }
        }
    }

    private static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

    public static void readBinary(String input) {
        String bits = input.substring(0,16);
        String binary = hexToBinary(bits);
        if (binary.charAt(0) == '1') {
            System.out.println("Found Field 1! Extended Map from 64 to 124 Field");
            rest = new StringBuffer(input);
            rest.replace(0,16,"");
            String sField1 = rest.substring(0,16);
            String biSField1 = hexToBinary(sField1);
            assignToBit(binary+biSField1);
            put(rest);
        }else{
            System.out.println("Not found Field1, sad, short version then.");
            rest = new StringBuffer(input);
            assignToBit(binary);
            put(rest);
        }
    }

    public static String hexToBinary(String input) {
        char[] hex = input.toCharArray();
        String binaryString = "";
        for (char h : hex) {
            binaryString = binaryString + digiMap.get(String.valueOf(h));
        }
        //System.out.println(binaryString);
        return binaryString;
    }

    public static void assignToBit(String binary) {
        System.out.print("Bits: ");
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                useField.add(i+1);
                System.out.print((i+1) +", ");
            }
        }
        System.out.println(" ");
    }

    public static String askForMap() {
        System.out.println("Welcome to ISO-8583 Cracking ITMX Edition!\nPlease provide iso-8583 ITMX.");
        Scanner bitMapIn = new Scanner(System.in);
        String input = bitMapIn.next();
        StringBuffer longInput = new StringBuffer(input);
        System.out.println("length: "+ input.length() +" /2 = "+ (input.length()/2));
        header = longInput.substring(0,26);
        System.out.println("Header:\t"+ header);
        longInput.replace(0,26,"");
        return longInput.toString();
    }

    public static void main(String[] args) {
        readBinary(askForMap());
        turnToHex();
        turnToAscii();
        System.out.println("Done, All data has been parsed correctly? I guess. ;)");
    }
}
