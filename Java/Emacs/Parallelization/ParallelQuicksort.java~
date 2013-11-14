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
	
	private void swap(int i, int j){
		if(i != j){
			int iValue = arr[i];
			
			arr[i] = arr[j];
			arr[j] = iValue;
		}
	}
	
    
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
    

    private static void sQsort(final int[] arr, final int start, final int end) {
        
    	if((end - start) < 30) {	
    		insertionSort(arr, start, end+1);
        } else {
    	int left = start;
        int right = end + 1;
        // We simply pick the first element as pivot..
        final int pivot = arr[start];
        int tmp;
        
        // Rearranging the elements around the pivot, so that
        // elements smaller than the pivot end up to the left
        // and elements bigger than the pivot end up to the
        // right.
        do {
                
         // As long as elements to the left are less than
         // the pivot we just continue.
         do {
                left++;
         } while (left <= end && arr[left] < pivot);
        
         // As long as the elements to the right are
         // greater than the pivot we just continue.
         do {
                right--;
         } while (arr[right] > pivot);
        
         // If left is less than right we have values on
         // the wrong side of the pivot, so we swap them.
         if (left < right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
         }
        
         // We continue doing this until all elements are
         // arranged correctly around the pivot.
        } while (left <= right);
        
        // Now put the pivot in the right place.
        tmp = arr[start];
        arr[start] = arr[right];
        arr[right] = tmp;
        
        // We have now "split" the range arr[start, end] into
        // two parts around the pivot value. We recurse to
        // sort those parts.
        
        if (start < right) {
         sQsort(arr, start, right);
        }
        
        if (left < end) {
        	sQsort(arr, left, end);
        }
        }
    }

    public static void sQsort(final int[] arr) {
        sQsort(arr, 0, arr.length-1);
    }
    
    
    
    public static void pQsort(final int[] arr) {
        // TODO: implement a parallel quicksort
    }

}

