package entity;

/**
 * @author TangBin
 * @version V1.0
 * @date 03/04/2018 11:22 PM
 */
public class BIT {
    private int[] orgin;
    private int[] bit;

    public BIT(int[] inArray){
        orgin = new int[inArray.length+1];
        bit = new int[inArray.length+1];
        for(int i=1;i<inArray.length+1;i++){
            orgin[i] = inArray[i-1];
            bit[i] = inArray[i-1];
        }
        establishBIT();

    }

    private BIT(){}

    private void establishBIT() {
        for (int i = 1; i < orgin.length; i++) {
            if(i + lowBit(i)<orgin.length)
                bit[i + lowBit(i)] += bit[i];
        }
    }

    public String showBIT(){
        StringBuilder sb = new StringBuilder();
        for(int num : bit){
            sb.append(num);
            sb.append(" ");
        }
        return sb.toString();
    }

    private int lowBit(int i){
        return -i&i;
    }

    public void update(int pos, int num){
        if(pos<0||pos>orgin.length-1)
            return;
        int temp = orgin[pos+1];
        orgin[pos+1] = num;
        int delta = num-temp;
        pos = pos+1;
        while(pos<orgin.length){
            bit[pos]+=delta;
            pos = pos+lowBit(pos);
        }
    }

    public int sum(int p){
        int res= 0;
        while(p>0){
            res+=bit[p];
            p = p-lowBit(p);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1,2,4,5,2,6,8,9};
        BIT bit = new BIT(input);
        System.out.println(bit.showBIT());
        System.out.println(bit.sum(1));
        bit.update(0,4);
        System.out.println(bit.showBIT());
    }

}
