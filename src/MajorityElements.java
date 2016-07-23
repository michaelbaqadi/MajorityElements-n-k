import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author Michael
 */
public class MajorityElements {
	
    public static int findElement(List<Integer> list, int k){
    	/*
    	 * nums array to keep track of the latest k numbers visited
    	 * counters to keep count of each number in nums array
    	 * */
    	Integer[] nums = new Integer[k-1];
    	Integer[] counters = new Integer[k-1]; 
    	
    	// init all values to zero in both arrays
    	for(int i = 0 ; i < nums.length;i++){
    		nums[i] = 0;
    		counters[i] = 0;
    	}
    	

    	for(int j = 0; j < list.size();j++){
    		boolean elementFound = false;
    		for(int i=0 ; i < nums.length;i++){
    	    	/*
    	    	 * Search for element in nums array
    	    	 * if found then increment the counter array at i
    	    	 * */
    			if(nums[i] == list.get(j)){
    				counters[i] = counters[i] + 1;
    				elementFound = true; 
    			}
    		}
    		/*
    		 * If element not found then we will need either to add it 
    		 * to num array if one of the spots in the counter have a value of 
    		 * zero.
    		 * */
    		if(elementFound == false){
    			boolean isNumAdded = false;
    			for(int y = 0; y < nums.length;y++){
    				if(counters[y] == 0 && isNumAdded == false){
    					nums[y] = list.get(j);
    					counters[y] = 1;
    					isNumAdded = true;
    				}
    			}
    			/*
    			 *  If the number can not be added because all values in 
    			 *  the counter arrays are more than zero. Then decrement the counter value by one
    			 * */
    			if(isNumAdded == false){
	    			for(int y = 0; y < nums.length; y++){
	    				if(counters[y] > 0){
	    					counters[y]--;
	    				}
	    			}
    			}
    		}
    	}
    	int index = 0;
    	int maxValue =  counters[0];
    	for(int i = 1; i < nums.length ;i++){
    		if(counters[i] > counters[i-1]){
    			index = i;
    		}
    	}
    	return nums[index];
    	
    }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.addAll(Arrays.asList(0,0,1,7,1,1));
		System.out.println(findElement(list, 3));
	}

}
