import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangbin1 on 2017/7/3.
 */
public class NO22_GenerateParentheses {
    public List<String> generateParentheses(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        generateParentheses(arrayList,"",0, 0, n);
        return arrayList;
    }

    public void generateParentheses(ArrayList<String> list, String str, int open, int close, int n){
        if(str.length()==n*2) {
            list.add(str);
            return;
        }

        if(open<n) {
            generateParentheses(list, str+"(", open+1, close, n);
        }
        if(close<open){

            generateParentheses(list, str+")", open, close+1, n);
        }

    }

    public static void main(String[] args){
        NO22_GenerateParentheses gen = new NO22_GenerateParentheses();
        System.out.println(gen.generateParentheses(2));
    }
}
