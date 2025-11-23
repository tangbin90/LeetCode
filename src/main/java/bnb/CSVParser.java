package bnb;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<List<String>> parse(Reader in) throws IOException {
        List<List<String>> ans = new ArrayList<>();
        PushbackReader reader = new PushbackReader(in, 10);
        boolean inQuote = false;

        StringBuilder line = new StringBuilder();
        int ch;
        while((ch = reader.read()) != -1){
            char c = (char) ch;
            if(c =='"'){
                if(inQuote){
                    int next= reader.read();
                    if(next == '"'){
                        line.append('"');
                    } else
                }
            }
            if(inQuote)
        }
    }

}
