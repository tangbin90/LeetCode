package bnb;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<List<String>> parse(Reader in) throws IOException {
        List<List<String>> ans = new ArrayList<>();
        PushbackReader reader = new PushbackReader(in, 10);
        boolean inQuote = false;
        List<String> record = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int ch;
        while((ch = reader.read()) != -1){
            char c = (char) ch;
            if(c =='"'){
                if(inQuote){
                    int next= reader.read();
                    if(next == '"'){
                        line.append('"');
                    } else {
                        inQuote = false;
                        if(next != -1){
                            reader.unread(next);
                        }
                    }
                } else {
                    inQuote = true;
                }
            } else if( c == ',' && !inQuote){
                record.add(line.toString());
                line.setLength(0);
            } else if((c == '\n' || c=='\r') && !inQuote){
                record.add(line.toString());
                line.setLength(0);

                if(c == '\r'){
                    int next= reader.read();
                    if(next != '\n' && next != -1 ){
                        reader.unread(next);
                    }
                }

                ans.add(record);
                record = new ArrayList<>();
            } else {
                line.append(c);
            }
        }

        if(inQuote){
            throw new RuntimeException("Illegal format");
        }

        if (line.length() > 0 || !record.isEmpty()) {
            record.add(line.toString());
            ans.add(record);
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
