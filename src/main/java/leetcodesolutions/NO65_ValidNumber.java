package leetcodesolutions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TangBin
 * @version V1.0
 * @date 12/03/2018 11:49 AM
 */
public class NO65_ValidNumber {
    public boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
