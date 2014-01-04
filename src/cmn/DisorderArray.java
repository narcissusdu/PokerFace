package cmn;

import java.util.Date;
import java.util.Random;

public class DisorderArray {	
	static public int[] Disorder(int range){
		int times = range*4;		
		int result[] = new int[range];
		int tmp;
		int index_a = 0;
		int index_b = 0;		
		
		for(int i = 0;i<result.length;i++){
			result[i] = i;
		}		
		
		Random random = new Random();
		random.setSeed(new Date().getTime());
		while(times-->0){
			index_a = Math.abs(random.nextInt())%range;
			do{
				index_b= Math.abs(random.nextInt())%range;
			}while(index_a==index_b);
			
			tmp = result[index_a];
			result[index_a] = result[index_b];
			result[index_b] = tmp;
		}
		
		return result;		
	}
}
