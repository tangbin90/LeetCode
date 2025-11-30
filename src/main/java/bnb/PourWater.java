package bnb;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class PourWater {
    public int[] pourWater(int[] heights, int volume, int k) {
        //left lowest
        //right lowest
        for(int i=1; i < volume; i++){
            heights = pourWaterHelp(heights, k);
        }

        return heights;

    }

    public int[] pourWaterHelp(int[] heights, int k){
        Deque<Integer> left= new ArrayDeque<>();
        left.add(heights[k]);
        Deque<Integer> right = new ArrayDeque<>();
        right.add(heights[k]);
        int finalPos = k;
        int leftPos = k;
        int rightPos = k;
        for(int i=k - 1; i >= 0; i--){
            if(!left.isEmpty() && heights[i] <= left.peekFirst()){
                left.push(heights[i]);
                leftPos = i;
            } else
                break;
        }

        for(int j = k+1; j < heights.length; j++){
            if(!right.isEmpty() && heights[j] <= right.peekFirst()) {
                right.push(heights[j]);
                rightPos = j;
            } else
                break;
        }

        if(heights[leftPos] <= heights[rightPos]){
            finalPos = leftPos;
            while(!left.isEmpty() && left.peekFirst() == heights[finalPos]){
                finalPos++;
                left.pop();
            }
        } else {
            finalPos = rightPos;
            while(!right.isEmpty() &&right.peekFirst() == heights[finalPos]){
                finalPos--;
                right.pop();
            }
        }

        if(heights[finalPos] == heights[k])
            finalPos = k;

        heights[finalPos]++;

        return heights;

    }
}
