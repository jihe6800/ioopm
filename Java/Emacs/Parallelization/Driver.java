import java.util.concurrent.ForkJoinPool;

public class Driver {

	public static void main(String[] args) {
		
		
		
		int processors = Runtime.getRuntime().availableProcessors();
		//System.out.println("Equals: " + Quicksort.equals(array, array2));
		//System.out.println("Equals: " + Quicksort.equals(array, array3));
		System.out.println("Number of processors: " + processors);
	
		long time = 0;
		long time2 = 0;
		long time3 = 0;
		int numberOfTests = 30;

		for(int i=0;i<numberOfTests;i++){

		    // Creates three different equal arrays 
		    int[] array = Quicksort.arrayGenerator(100000);
		    int[] array2 = Quicksort.clone(array);
		    int[] array3 = Quicksort.clone(array);		

		    long startTime = System.currentTimeMillis();
		    Quicksort.sQsort(array);	
		    long endTime = System.currentTimeMillis();
		    time += (endTime - startTime);
	    
		    long startTime2 = System.currentTimeMillis();
		    QuicksortOriginal.sQsortOriginal(array2);
		    long endTime2 = System.currentTimeMillis();
		    time2 += (endTime2 - startTime2);

		    ParallelQuicksort pq = new ParallelQuicksort(array3);
		    ForkJoinPool pool = new ForkJoinPool(processors);
		    
		    long startTime3 = System.currentTimeMillis();
		    pool.invoke(pq);
		    long endTime3 = System.currentTimeMillis();
		    time3 += (endTime3 - startTime3);

		}

		System.out.println("Average time in milliseconds for quicksort with insertionsort " + numberOfTests + " times: " + time/numberOfTests);
		System.out.println("Average time in milliseconds for quicksort " + numberOfTests + " times: " + time2/numberOfTests);
		System.out.println("Average time in milliseconds for parallel quicksort " + numberOfTests + " times: " + time3/numberOfTests);
		//System.out.println(Quicksort.sortCheck(array3));
	}

}
