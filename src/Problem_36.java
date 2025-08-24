//The decimal number, 585 = 1001001001₂ (binary), is palindromic in both bases.
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//(Please note that the palindromic number, in either base, may not include leading zeros.)

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
