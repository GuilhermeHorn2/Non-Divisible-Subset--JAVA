package misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class main_misc2 {
	
	//private static HashMap<Integer,Integer> cache = new HashMap<>();
	public static void main(String[] args) {
		
	int[]s = {1, 7, 2, 4};
	System.out.println(non_div_subset(s,3));
		
	
	
	
	}
	//I will use the fact that : (a+b) % k = ((a % k) + (b % k)) % k
	
	private static int max(int a,int b) {
		if(a > b) {
			return a;
		}
		return b;
	}
	private static int min(int a,int b) {
		if(a > b) {
			return b;
		}
		return a;
	}
	private static int non_div_subset(int[]s,int k) {
		HashMap<Integer,Integer> h = new HashMap<>();
		for(int i = 0;i < s.length;i++) {
			if(h.containsKey(s[i]%k)) {
				h.replace(s[i]%k,h.get(s[i]%k)+1);
			}
			else {
				h.put(s[i]%k,1);
			}
		}
		int max = 0;
		if(h.containsKey(0) && h.get(0) > 0) {
			//you can have only one zero
			max++;
		}
		//all values will be from 0 to k
		for(int i = 1;i < k;i++) {
			if(k % 2 == 0 && i == k/2) {
				max++;
				System.out.println(i);
			}
			else {
				//we can only have i or k-i in our subset so we get the one with most elements
				max += max(h.get(i),h.get(k-i));
				h.replace(i,0);
				h.replace(k-i,0);
				
				
			}
		}
		return max;
		
		
		
	}
	
	}

	
		

	
	
	

	
