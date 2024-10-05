package programs.string;

public class ValidateIPAddress {
    public static void main(String[] args) {

//        Example 1:
//        Input: queryIP = "172.16.254.1"
//        Output: "IPv4"
//        Explanation: This is a valid IPv4 address, return "IPv4".
//                Example 2:
//        Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//        Output: "IPv6"
//        Explanation: This is a valid IPv6 address, return "IPv6".
        String ipAddress = "2001:0Hb8:85a3:0:0:8A2E:0370:7334";
        System.out.println( "ipAddress: "+ ipAddress);
        System.out.println(validateIPAddress(ipAddress));

    }
    private static String validateIPAddress(String ipAddress) {
        String N = "Neither";
        if (ipAddress == null || ipAddress.isEmpty()) {
            return N;
       }
        if (ipAddress.contains(".")) {
            return ipV4Address(ipAddress);
        } else if (ipAddress.contains(":")) {
            return ipV6Address(ipAddress);
        }
        return N;
    }
    private static String ipV4Address(String ipAddress) {
        String N = "Neither";
        // check if first last with .
        if(ipAddress.startsWith(".")||ipAddress.endsWith(".")){
           return N;
        }
        String[] segments = ipAddress.split("\\.");
        if (segments.length!= 4) {
            return N;
        }
        // segment by segment
        for (String segment : segments) {
            if(segment.length()==0||segment.length()>3||(segment.charAt(0)=='0'&&segment.length()>1)) {
                return N;
            }
            //itrate the loop for segment  char
            for(int i=0;i<segment.length();i++) {
                if(segment.charAt(i)<'0' || segment.charAt(i)>'9'){
                    return N;
                }
            }
            if( Integer.parseInt(segment)>255) return N;
        }
        return "IPv4";
    }
    private static String ipV6Address(String ipAddress) {
        String N = "Neither";
        // check if first last with .
        if(ipAddress.startsWith(":")||ipAddress.endsWith(":")){
            return N;
        }
        String[] segments = ipAddress.split(":");
        if (segments.length!= 8) {
            return N;
        }
        // segment by segment
        for(String segment : segments){
            if (segment.isEmpty()|| segment.length()>4){
                return N;
            }
            //itrate the loop for segment  char
            for(int i=0; i<segment.length(); i++){
                char ch=segment.charAt(i);

                // boolean isDigit =(ch >= '0' && ch <= '9');
                // boolean isLowerCaseAF =(ch >='a'&&ch<='f');
                // boolean isUppercaseAF =(ch>='A' && ch<='F');
                //     if(!(isDigit||isUppercaseAF||isLowerCaseAF)){
                //         return N;
                //     }

                if(!(ch >= '0' && ch <= '9')&&!(ch >='a'&&ch<='f')&&!(ch>='A' && ch<='F')){
                    return N;
                }
            }
        }
        return "IPv6";
    }
}
