package bnb.second;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 1.  Each record is located on a separate line, delimited by a line
 break (CRLF).  For example:

 aaa,bbb,ccc CRLF
 zzz,yyy,xxx CRLF

 2.  The last record in the file may or may not have an ending line
 break.  For example:

 aaa,bbb,ccc CRLF
 zzz,yyy,xxx

 3.  There maybe an optional header line appearing as the first line
 of the file with the same format as normal record lines.  This
 header will contain names corresponding to the fields in the file
 and should contain the same number of fields as the records in
 the rest of the file (the presence or absence of the header line
 should be indicated via the optional "header" parameter of this
 MIME type).  For example:

 field_name,field_name,field_name CRLF
 aaa,bbb,ccc CRLF
 zzz,yyy,xxx CRLF

 4.  Within the header and each record, there may be one or more
 fields, separated by commas.  Each line should contain the same
 number of fields throughout the file.  Spaces are considered part
 of a field and should not be ignored.  The last field in the
 record must not be followed by a comma.  For example:

 aaa,bbb,ccc

 5.  Each field may or may not be enclosed in double quotes (however
 some programs, such as Microsoft Excel, do not use double quotes
 at all).  If fields are not enclosed with double quotes, then
 double quotes may not appear inside the fields.  For example:

 "aaa","bbb","ccc" CRLF
 zzz,yyy,xxx

 6.  Fields containing line breaks (CRLF), double quotes, and commas
 should be enclosed in double-quotes.  For example:

 "aaa","b,"" CRLF
 bb","ccc" CRLF
 zzz,yyy,xxx

 7.  If double-quotes are used to enclose fields, then a double-quote
 appearing inside a field must be escaped by preceding it with
 another double quote.  For example:

 "aaa","b""bb","ccc"

 */

public class CSVParser {

    public static List<List<String>> csvParser(Reader reader) throws IOException {
        PushbackReader pr = new PushbackReader(reader);
        int cin;
        boolean inQuote = false;
        StringBuilder column = new StringBuilder();
        List<String> line = new ArrayList<>();
        List<List<String>> lines = new ArrayList<>();
        while((cin = pr.read()) != -1){
            char c = (char) cin;

            if(c == '"'){
                if(inQuote){
                    int next = pr.read();
                    if(next == '"'){
                        column.append('"');
                    } else {
                        if (next != -1) {
                            pr.unread(next);
                        }
                        inQuote = false;
                    }
                } else {
                    inQuote = true;
                }
            } else if(!inQuote && c == ','){
                String tmp = column.toString();
                line.add(tmp);
                column.setLength(0);
            } else if(!inQuote && (c == '\r' || c=='\n')){
                line.add(column.toString());
                lines.add(line);

                if(c == '\r'){
                    int ch = pr.read();
                    if (ch != '\n' && ch != -1) {
                        pr.unread(ch);
                    }
                }

                line = new ArrayList<>();
                column.setLength(0);
            } else {
                column.append(c);
            }
        }

        if(!column.isEmpty()){
            line.add(column.toString());
            lines.add(line);
        }

        return lines;

    }

    public static void main(String[] args) throws Exception{
        String csv = ""
                + "name,age,city\n"
                + "John,25,\"New York, USA\"\n"
                + "\"Alex \"\"Crazy\"\" Smith\",30,London\n"
                + "\"Multi-line user\",40,\"Hello\nWorld\"\n";

        List<List<String>> records = csvParser(new StringReader(csv));
        for (List<String> row : records) {
            System.out.println(row);
        }
    }
}
