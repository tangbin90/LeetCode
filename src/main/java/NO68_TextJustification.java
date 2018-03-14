import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 12/03/2018 4:41 PM
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
"This    is    an",
"example  of text",
"justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */

public class NO68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strs = new LinkedList<>();
        int length = 0;
        int wordsCount = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (length+words[i].length()+ wordsCount <= maxWidth) {
                length += words[i].length();
                wordsCount++;
            } else {
                int avg;
                StringBuilder sb = new StringBuilder();

                if(wordsCount>1) {
                    avg = (maxWidth - length) / (wordsCount - 1);
                    int rest = (maxWidth - length) % (wordsCount - 1);
                    sb.append(words[start]);
                    for (int j = start+1; j < start+wordsCount; j++) {
                        for (int k = 0; k < avg; k++) {
                            sb.append(" ");
                        }
                        sb.append(rest <= 0 ? "" : " ");
                        rest--;
                        sb.append(words[j]);
                    }
                }else{
                    sb.append(words[start]);
                    for(int k=words[start].length();k<maxWidth;k++)
                        sb.append(" ");
                }
                strs.add(sb.toString());
                length = words[i].length();
                wordsCount = 1;
                start = i;
            }
        }
        length = 0;
        StringBuilder sb = new StringBuilder();
        if(length<=maxWidth){
            for(int i=start;i<words.length;i++){
                sb.append(words[i]);
                length+=words[i].length();
                if(length<maxWidth) {
                    sb.append(" ");
                    length++;
                }
            }
            while(length<maxWidth) {
                sb.append(" ");
                length++;
            }
        }
        strs.add(sb.toString());

        return strs;
    }

    public static void main(String[] args){
        String[] words = {"a","b","c","d","e"};
        NO68_TextJustification textJustification = new NO68_TextJustification();
        List<String> ls = textJustification.fullJustify(words,3);

        for(String str : ls){
            System.out.println(str);
        }
    }

}
