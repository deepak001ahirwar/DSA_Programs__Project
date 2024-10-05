package programs.string;

import java.util.ArrayList;

public class GenerateIPAddresses {

    public static void main(String[] args) {
//        For string 11211 the IP address possible are
//        1.1.2.11
//        1.1.21.1
//        1.12.1.1
//        11.2.1.1
        String address = "11211";
        System.out.println("IP addresses possible are: " + address);
        System.out.println(generateIPAddress(address));
        generateIPAddress(address);
    }

    private static ArrayList<String> generateIPAddress(String address) {
        ArrayList<String> ip = new ArrayList<String>();
        int len = address.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    String subStr = generateSubString(address, len, i, j, k);
                    if (subStr.length() > 0) {
                        ip.add(subStr);
                    }
                }
            }
        }
        return ip;
    }

    private static String generateSubString(String address, int len, int i, int j, int k) {
        String s1 = address.substring(0, i);
        String s2 = address.substring(i, j);
        String s3 = address.substring(j, k);
        String s4 = address.substring(k, len);
        String res = "";
        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res = s1 + "." + s2 + "." + s3 + "." + s4;
            return res;
        } else {
            return res;
        }
    }

    private static boolean isValid(String str) {
        int len = str.length();
        if (len == 0 || len > 3) {
            return false;
        } else if (len > 1 && str.charAt(0) == '0') {
            return false;
        } else {
            int num = Integer.parseInt(str);
            if (num > 255) {
                return false;
            } else {
                return true;
            }
        }
    }
}
