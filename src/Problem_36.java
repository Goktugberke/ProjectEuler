//The decimal number, 585 = 1001001001₂ (binary), is palindromic in both bases.
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//(Please note that the palindromic number, in either base, may not include leading zeros.)

//My Solution
public class Problem_36 {
    public static void main(String[] args) {
        System.out.println(doubleBasedPalindromes(1000000));
    }

    public static int doubleBasedPalindromes(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            String binary=intToBinary(i);
            if (isPalindrome(i)&&isPalindrome2(binary)){
                sum+=i;
            }
        }
        return sum;
    }

    public static String intToBinary(int n){
            if (n == 0) return "0";
            StringBuilder binary = new StringBuilder();
            int num = Math.abs(n);
            while (num > 0) {
                binary.insert(0, num % 2);
                num /= 2;
            }
        return binary.toString();

    }

    public static boolean isPalindrome(int n){
        String str=Integer.toString(n);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String n){
        for(int i=0;i<n.length()/2;i++){
            if(n.charAt(i)!=n.charAt(n.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

//AI's Solution
//public class DoubleBasePalindromes {
//    static boolean isPalindrome(String s) {
//        int left = 0, right = s.length() - 1;
//        while (left < right) {
//            if (s.charAt(left++) != s.charAt(right--)) return false;
//        }
//        return true;
//    }
//
//    static String toBinary(int n) {
//        if (n == 0) return "0";
//        StringBuilder sb = new StringBuilder();
//        int num = n;
//        while (num > 0) {
//            sb.append(num % 2);
//            num /= 2;
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        long sum = 0;
//        for (int i = 1; i < 1000000; i++) {
//            String dec = String.valueOf(i);
//            String bin = toBinary(i);
//            if (isPalindrome(dec) && isPalindrome(bin)) {
//                sum += i;
//            }
//        }
//        System.out.println(sum);
//    }
//}