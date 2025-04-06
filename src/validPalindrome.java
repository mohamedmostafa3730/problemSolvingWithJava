
public class validPalindrome {

    public static void main(String[] args) {

        System.out.println(validPalindromeTwoPointer("\"Was it a car or a cat I saw?\""));
        System.out.println("===========");
        System.out.println(validPalindromeReverseString("tab a cat"));
    }

    /*
     * (valid Palindrome Two Pointer )]
     * [1] Name: validPalindromeTwoPointer() ;
     * [2] Assumptions:
     *      1> reads the same forward and backward
     *      2> case-insensitive
     *      3> ignores all non-alphanumeric characters
     * [3] Inputs: String S ;
     * [4] processes:
     *      (1) validation: 
     *           1- Filter out non-alphanumeric characters
     *           2- convert to lowercase
     *      (3) Main Processes:
     *          1- initialize and declare => left to start of array, and right to last of array ( String.length() - 1 )
     *          2- loop while left lesser-than right
     *              1- check if Character at index left is not letter or Dight, if true (left++);
     *              1=- check if Character at index right is not letter or Dight, if true(right--);
     *              1=- check if Character at index right not equal Character at index left, after convert Character to Lower Case, if true (return false)
     *              1=- else ( ( left++ ) , ( right-- ) );
     *          3- return true;
     *      (2) Memory Using:
     *          1) global => left:int, right:int;
     *          2) locale => (-) ;
     * [5] complicity:
     *      (1) time complicity => O(n)
     *      (2) memory complicity => O(1)
     * [6] OutPuts: true if it (palindrome), or false otherwise
     * [7] built in using:
     *      (1) using (Character) class using:
     *              1> isLetterOrDigit() => for check if character is alphanumeric or not, return true or false;
     *              2> toLowerCase() => for convert letters to lower-case, return only lower-case letters;
     *      (2) using charAt() function from (String) class for get character with index; 
     * [8] Algorithm techniques: Tow-Pointer ;
     */
    public static boolean validPalindromeTwoPointer(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) { // check if Character at index left is not letter or Dight
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) { // check if Character at index right is not letter
                                                                      // or Dight
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) { // check if Character at index right equal Character at index left, after convert  Character to Lower Case
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    /*
     * [The main of Algorithm => (Reverse String)]
     * [1] Name: validPalindromeReverseString ;
     * [2] Assumptions:
     * 1> reads the same forward and backward
     * 2> case-insensitive
     * 3> ignores all non-alphanumeric characters
     * [3] Inputs: String S ;
     * [4] processes:
     * (1) validation:
     * 1- Filter out non-alphanumeric characters
     * 2- convert to lowercase
     * (2) Memory Using (variable) => declaration & initialization:
     * - make object from stringBuilder class,
     * (3) main Function:
     * 1- declaration the object
     * 2- loop on every character on string after convert to character array
     * - check if character is alphanumeric characters
     * - if true append this character to object after convert it to lowercase
     * 3- convert the object to string
     * 4- reverse the same object then convert to string
     * 5- check of equals or not
     * [5] complicity:
     * (1) time complicity => O(n)
     * (2) memory complicity => O(n)
     * [6] OutPuts: true if it (palindrome), or false otherwise
     */
    public static boolean validPalindromeReverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }

}
