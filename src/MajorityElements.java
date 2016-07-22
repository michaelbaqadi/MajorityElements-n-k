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
	
    public static List<Integer> findElement(List<Integer> list, int k){
    	/*
    	 * nums array to keep track of the latest k numbers visited
    	 * counters to keep count of each number in nums array
    	 * */
    	Integer[] nums = new Integer[k];
    	Integer[] counters = new Integer[k]; 
    	
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
    	List<Integer> result = new ArrayList<Integer>();
    	for(int i = 0; i < nums.length ;i++){
    		 
    		int valCounter = 0;
    		for(int j = 0; j < list.size();j++){
    			if(list.get(j) == nums[i]){
    				valCounter++;
    			}
    		}
        	if(valCounter > list.size()/k){
        		result.add(nums[i]);
        	}
    	}
    	return result;
    	
    }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.addAll(Arrays.asList(5, 5, 3, 5, 3, 8, 5, 6, 5, 7, 3,1));
		System.out.println(findElement(list, 3));
	}

}
