public class NumUtil{

private static boolean isWhitespace(char c) {
    if(c==0x20 || c==0x09 || c==0x0B ||c==0x0D || c==0x0C || c==0x0A)
        return true;
    return false;
}

private static boolean isNumber(char c){
    return c >= 0x30 && c <= 0x39;
}

/**
 * Determine the position of the first non-whitespace character
 * in the given string.
 * @param source the string to examine.
 * @return the position of the first non-whitespace character
 * in the given string.
 */
private static int skipWhitespace(String source) {
    if(source != null){
        for (int i = 0; i < source.length(); i++) {
            if(!isWhitespace(source.charAt(i)) ){
                return i;
            }
        }
    }
    return -1;
}



/**
 * Try to convert the given string to a long integer.
 * @param source the string to convert.
 * @return the converted long integer.
 */
public static long atol(String source) {
    int sign = 1, i;	 	 // sign of the result long integer, i current position in source
    long res = 0;	 	 // the final result long integer
    // skip the whitespaces
    int pos = skipWhitespace(source);
    if(pos < 0)
        return 0;
    // process the sign symbol
    if(source.charAt(pos) == '-'){
        sign = -1;
        pos ++;
    }else {
        if(source.charAt(pos) == '+'){
            pos ++;
        }
    }
    // process any digit characters
    for(i = pos; i<source.length(); i++){
        char c = source.charAt(i);
        if(isNumber(c)) {
            res = 10 * res + (c - 0x30);
        }else {
            return res * sign;
        }
    }
    // return the converted result long integer
    return res * sign;
}


/**
 * Try to convert the given string to an integer.
 * @param source the string to convert.
 * @return the converted integer.
 */
public static int atoi(String source) {
    return Math.toIntExact(atol(source));
}
/**
 19/21
 * Determine if the given test had passed and output the result
 * according to the following format:
 * <pre>
 * Test case: n -> passed|failed
 * where n is the number of the test case.
 * </pre>
 * @param test the number of the test case.
 * @param factual the converted integer.
 * @param expected the expected integer.
 */
public static void check(int test, int factual, int expected) {
    String result = factual == expected ?"true" : "false";
    System.out.println("Test case: " + test + " -> " + result);
}

public static String helpTest(){
        char[] cArray = new char[6];
        cArray[0] = 0x20;
        cArray[1] = 0x09;
        cArray[2] = 0x0B;
        cArray[3] = 0x0D;
        cArray[4] = 0x0C;
        cArray[5] = 0x0A;
        return  new String(cArray);
}
// Just for test!
public static void main(String[] args) {
    // test case 1
    String source = "";
    String helpString = helpTest();
    int res = atoi(source);
    check(1, res, 0);
    // test case 2
    source = helpString;
    res = atoi(source);
    check(2, res, 0);
    // test case 3
    source = helpString + "12345a8";
    res = atoi(source);
    check(3, res, 12345);
    // test case 4
    source = helpString + "+12345a8";
    res = atoi(source);
    check(4, res, 12345);
    // test case 5
    source = helpString + "-12345a8";
    res = atoi(source);
    check(5, res, -12345);
    // test case 6
    source = helpString + "--12345a8";
    res = atoi(source);
    check(6, res, 0);
 }

}
