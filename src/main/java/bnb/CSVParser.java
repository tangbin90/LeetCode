package bnb;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<List<String>> parse(Reader inreader) throws IOException {
        boolean inQuote = false;
        int cin;
        List<List<String>> ans = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        StringBuilder currentRecord = new StringBuilder();
        PushbackReader reader = new PushbackReader(inreader, 10);
        while( (cin = reader.read()) != -1){
            char c = (char) cin;

            if(c == '"'){
                if(inQuote){
                    int next = reader.read();
                    if(next == '"'){
                        currentRecord.append('"');
                    } else {
                        inQuote = false;
                        if(next != -1){
                            reader.unread(next);
                        }
                    }
                } else {
                    inQuote = true;
                }
            } else if((c == '\n'||c == '\r') && !inQuote){
                currentLine.add(currentRecord.toString());
                currentRecord.setLength(0);
                if(c == '\r'){
                    int next = reader.read();
                    if(next != '\n'){
                        reader.unread(next);
                    }
                }
                ans.add(currentLine);
                currentLine = new ArrayList<>();
            } else if(c == ',' && !inQuote){
                currentLine.add(currentRecord.toString());
                currentRecord.setLength(0);
            } else {
                currentRecord.append(c);
            }
        }

        if(inQuote){
            System.out.println("Illegal format!");
            return ans;
        }

        if(currentLine.size() > 0 || currentRecord.length() > 0){
            if(currentRecord.length() > 0){
                currentLine.add(currentRecord.toString());
            }

            ans.add(currentLine);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception{
        String csv = ""
                + "name,age,city\n"
                + "John,25,\"New York, USA\"\n"
                + "\"Alex \"\"Crazy\"\" Smith\",30,London\n"
                + "\"Multi-line user\",40,\"Hello\nWorld\"\n";

        List<List<String>> records = parse(new StringReader(csv));
        for (List<String> row : records) {
            System.out.println(row);
        }
    }

}
