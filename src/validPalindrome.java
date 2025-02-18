
public class validPalindrome {

    public static void main(String[] args) {

        System.out.println(validPalindromeTwoPointerOne("race a car"));
        System.out.println("===========");
        System.out.println(validPalindromeReverseString("race a car"));
    }

    /* 
     * [The main of Algorithm => (valid Palindrome Two Pointer One)]
     * [1] Name: validPalindromeTwoPointerOne ;
     * [2] Assumptions: S consists only of printable ASCII characters ;
     * [3] Inputs: String S ;
     * [4] processes: 
     *  (1) validation: 
     *      1- Filter out non-alphanumeric characters
     *      2- convert to lowercase
     *  (2) Memory Using (variable) => declaration & initialization:
     *      1- String filteredString => to store string after filtered & converted to lowercase
     *      2- int right = length - 1  
     *      3- int left = 0  
     *  (3) main Function:
     *      1- declaration & initialization filteredString by ""
     *      2- Filter out non-alphanumeric characters and convert to lowercase:
     *          - loop for every character after converted S to Character Array
     *              - check if character non-alphanumeric or not
     *              - if true add in filteredString after convert it to lowercase
     *      3- Two-pointer Technique:
     *          - declaration & initialization => left & right
     *          - Do pase case => loop while (left < right)
     *              - check if filteredString(left) != filteredString(right) return false
     *              - left++ , right-- 
     * [5] complicity:
     *  (1) time complicity => O(n^2)
     *      - The time complexity of the filtering step is O(n^2) due to string concatenation.
     *      - The time complexity of the palindrome check is O(n).
     *  (2) memory complicity => O(n)
     * [6] OutPuts: true if it (palindrome), or false otherwise
     */
    public static boolean validPalindromeTwoPointerOne(String s) {
        String filString = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filString += Character.toLowerCase(c);
            }
        }

        int left = 0, right = filString.length() - 1;

        while (left < right) {
            if (filString.charAt(left) != filString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /* 
     * [The main of Algorithm => (Reverse String)]
     * [1] Name: validPalindromeReverseString ;
     * [2] Assumptions: S consists only of printable ASCII characters, 
     * [3] Inputs: String S ;
     * [4] processes: 
     *  (1) validation: 
     *      1- Filter out non-alphanumeric characters
     *      2- convert to lowercase
     *  (2) Memory Using (variable) => declaration & initialization:
     *      - make object from stringBuilder class, 
     *  (3) main Function:
     *      1- declaration the object 
     *      2- loop on every character on string after convert to character array 
     *          - check if character is alphanumeric characters
     *          - if true append this character to object after convert it to lowercase
     *      3- convert the object to string 
     *      4- reverse the same object then convert to string
     *      5- check of equals or not 
     * [5] complicity:
     *  (1) time complicity => O(n)
     *  (2) memory complicity => O(n)
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
