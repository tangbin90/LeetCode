import java.lang.*;

public class LongestPalindromicSubstring {
	private int start;
	private int maxLength;
	private String string;
	private String longestPalindromicSubstring(String str){
		if(str.length()<2)
			return str;
		this.string=str;
		start=0;
		maxLength=0;
		for(int i=0;i<str.length()-1;i++){
			extendStr(i,i+1);
			extendStr(i,i);
		}
		return str.substring(start,start+maxLength);
	}

	private void extendStr(int low, int high){
		int length;
		while(low>=0&&high<string.length()){
			if(string.charAt(low)==string.charAt(high)){
				length=high-low+1;
			}else
				break;
			if(maxLength<length){
				maxLength=length;
				start=low;
			}
			low--;
			high++;
		}
	}

	public static void main(String[] args){
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String str="aabaaaaaa";
		System.out.println(lps.longestPalindromicSubstring(str));
		System.out.println(lps.maxLength);

	}
}