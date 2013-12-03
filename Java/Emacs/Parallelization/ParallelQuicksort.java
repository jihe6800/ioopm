import java.util.concurrent.RecursiveAction;

public class ParallelQuicksort extends RecursiveAction {
	
	int[] arr;
	int start;
	int end;
	int sequentialThreshold;

	
	public ParallelQuicksort(int[] arr) {
		this(arr, 0, arr.length-1, 1000);
	}
	
	public ParallelQuicksort(int[] arr, int start, int end) {
		this(arr, start, end, 1000);
	}
	
	public ParallelQuicksort(int[] arr, int start, int end, int sequentialThreshold){
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.sequentialThreshold = sequentialThreshold;
	}

    /**
     * Uses fork and join to sort an array. 
     */

	@Override
	public void compute() {
    
		if(end - start < 30){
			insertionSort(arr, start, end);
		}
		else if(end - start < sequentialThreshold){
    		sQsort(arr, start, end);
		} 
		else if(start < end) {
    		int pivotIndex = start + ((end - start)/2);
    		
    		pivotIndex = partition(pivotIndex);
       		invokeAll(new ParallelQuicksort(arr, start, pivotIndex-1),
    				  new ParallelQuicksort(arr, pivotIndex+1, end));
    		
    	}
    }


    /**
     * Arranges so every int which is less than the int at index 'pivotIndex'
     * in arr is to the left of pivotIndex and every int which is equal or greater is
     * to the right.
     *
     * @param The index which the pivot-value is located at.
     * @return
     */

	
	private int partition(int pivotIndex){
		int pivotValue = arr[pivotIndex];
		
		swap(pivotIndex, end);
		
		int storeIndex = start;
		for(int i=start;i<end;i++){
			if(arr[i]<pivotValue){
				swap(i, storeIndex);
				storeIndex++;
			}
		}
		
		swap(storeIndex, end);
		return storeIndex;
	}

    /**
     * Swap places on the value at index 'i' with index 'j' in arr, if
     * i != j. 
     *
     * @param The first index.
     * @param The second index.
     */
	
	private void swap(int i, int j){
		if(i != j){
			int iValue = arr[i];
			
			arr[i] = arr[j];
			arr[j] = iValue;
		}
	}
	

    /**
     * Sorts 'arr' from index 'start' to index 'end' with an insertion sort.
     *
     * @param The array to be sorted.
     * @param Will be sorted from this index.
     * @param Will be sorted to this index.
     */
    
    private static void insertionSort(final int[] arr, final int start, final int end) {
        for (int i = start + 1; i < end; ++i) {
         int j = i;
         int tmp = arr[i];
         while (j > 0 && arr[j-1] > tmp) {
                arr[j] = arr[j-1];
                j--;
         }
         arr[j] = tmp;
        }
    }



    /**
     * Sorts 'arr' from index 'start' to index 'end' with a quicksort. If
     * (end - start) < 30, the function sorts it with an insertion sort.
     *
     * @param The array to be sorted.
     * @param Will be sorted from this index.
     * @param Will be sorted to this index.
     */    

    private static void sQsort(final int[] arr, final int start, final int end) {
        
    	if((end - start) < 30) {	
    		insertionSort(arr, start, end+1);
        } else {
    	int left = start;
        int right = end + 1;

        final int pivot = arr[start];
        int tmp;
        
        do {
                
         do {
                left++;
         } while (left <= end && arr[left] < pivot);
        
         do {
                right--;
         } while (arr[right] > pivot);

         if (left < right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
         }

        } while (left <= right);
        

        tmp = arr[start];
        arr[start] = arr[right];
        arr[right] = tmp;
        
        if (start < right) {
         sQsort(arr, start, right);
        }
        
        if (left < end) {
        	sQsort(arr, left, end);
        }
        }
    }

    /**
     * Sorts 'arr'.
     *
     * @param The array to be sorted.
     */

    public static void sQsort(final int[] arr) {
        sQsort(arr, 0, arr.length-1);
    }
    
    
    
    public static void pQsort(final int[] arr) {
        // TODO: implement a parallel quicksort
    }

}

