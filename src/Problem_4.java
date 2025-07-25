//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
// 9009 = 91 * 99. Find the largest palindrome made from the product of two 4-digit numbers.

public class Problem_4 {
    public static void main(String[] args) {
        System.out.println(largestPalinrome());
    }

    //My Solution
    public static int largestPalinrome(){
        int max =0;
        for (int i=1000;i<=9999;i++){
            for (int j=1000;j<=9999;j++){
                int x= i*j;
                if (isPalindrome(x)){
                    max = x;
                }
            }
        }
        return max;
    }
    public static boolean isPalindrome(int num){
        String str = numToString(num);
        for (int i=0;i<=str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static String numToString(int num){
        String str ="";
        while (num >0){
            int c = num%10;
            str += c;
            num/=10;
        }
        return  str;
    }



}
//AI's Solution
class LargestPalindromeProduct {

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Method to find the largest palindrome from product of two 4-digit numbers
    public static int findLargestPalindrome() {
        int maxPalindrome = 0;

        for (int i = 9999; i >= 1000; i--) {
            for (int j = i; j >= 1000; j--) {
                int product = i * j;

                if (product <= maxPalindrome) {
                    break; // Further products will be smaller
                }

                if (isPalindrome(product)) {
                    maxPalindrome = product;
                }
            }
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        int result = findLargestPalindrome();
        System.out.println("The largest palindrome made from the product of two 4-digit numbers is: " + result);
    }
}