package bnb.second;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class DayOne {
    public List<String> fullJustify(String[] words, int maxWidth){
        int pos = 0;
        List<String> rslt = new LinkedList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLineLength = 0;
        while(pos < words.length){
            String currWord = words[pos];
            if(currWord.length() > maxWidth){
                return null;
            }
            if(currentLineLength + currWord.length() + currentLine.size()> maxWidth){
                String line = formatLine(currentLine, currentLineLength,maxWidth, false);
                rslt.add(line);
                currentLine = new ArrayList<>();
                currentLine.add(currWord);
                currentLineLength = currWord.length();
            } else {
                currentLineLength  = currentLineLength + currWord.length();
                currentLine.add(currWord);
            }
            pos ++;
        }
        if(currentLine.size() > 0){
            String lastLine = formatLine(currentLine,currentLineLength,  maxWidth, true);
            rslt.add(lastLine);
        }

        return rslt;


    }


    public String formatLine(List<String> words, int length, int maxWidth, boolean lastLine){
        StringBuilder sb = new StringBuilder();
        if(lastLine || words.size() == 1){
            sb.append(words.get(0));
            for(int i = 1; i< words.size(); i++){
                sb.append(' ').append(words.get(i));
            }
            while(sb.length() < maxWidth){
                sb.append(" ");
            }
        } else {
            int space = (maxWidth - length) / (words.size() - 1);
            int left= (maxWidth- length) % (words.size() - 1);
            String spaces = " ".repeat(space);
            for(int i=0; i < words.size() - 1; i++){
                if(i < left){
                    sb.append(words.get(i)).append(spaces).append(" ");
                } else {
                    sb.append(words.get(i)).append(spaces);
                }
            }
            sb.append(words.get(words.size() - 1));
        }

        return sb.toString();
    }



    public static void main(String[] args) {

    }

}
