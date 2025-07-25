package labula;

import java.util.LinkedList;
import java.util.List;

public class PanCake {
    LinkedList<Integer> res = new LinkedList<>();

    List<Integer> pancakeSort(int[] cakes){
      sort(cakes, cakes.length);
      return res;
    }

    void sort(int[] cakes, int n) {
        if(n==1) return;

        int maxCake = 0;
        int maxCakeIndex = 0;

        for(int i=0; i< n; i++){
            if(cakes[i] > maxCake){
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        reverse(cakes, 0, maxCakeIndex);

        res.add(maxCakeIndex + 1);

        reverse(cakes, 0, n-1);

        res.add(n);

        sort(cakes, n-1);
    }

    void reverse(int[] arr, int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}
