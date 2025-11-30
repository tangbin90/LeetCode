package bnb.firstround;

import java.util.*;

public class DisplayPage {
    public static List<List<String>> paginate(List<String> input, int pageSize) {
        List<List<String>> pages = new ArrayList<>();
        List<String> records = new ArrayList<>(input);

        while(!records.isEmpty()){
            Set<String> hosts = new HashSet<>();
            List<String> page = new ArrayList<>();

            Iterator<String> iter = records.iterator();
            while(iter.hasNext() && page.size() < pageSize){
                String record = iter.next();
                String host = getHostId(record);
                if(!hosts.contains(host)){
                    hosts.add(host);
                    page.add(record);
                    iter.remove();;
                }
            }

            if(page.size() < pageSize){
                Iterator<String> it = records.iterator();
                while (it.hasNext() && page.size() < pageSize) {
                    String record = it.next();
                    page.add(record);
                    it.remove(); // 放进页面就删
                }
            }

            pages.add(page);
        }

        return pages;


    }

    private static String getHostId(String record) {
        // host_id 在逗号前面
        int idx = record.indexOf(',');
        return record.substring(0, idx);
    }
}
