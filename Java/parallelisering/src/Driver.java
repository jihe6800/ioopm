import java.util.concurrent.ForkJoinPool;

public class Driver {

	public static void main(String[] args) {
		
		int[] array = Quicksort.arrayGenerator(1000000);
		int[] arrayClone = Quicksort.clone(array);
		int[] array3 = Quicksort.clone(array);
		
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Equals: " + Quicksort.equals(array, arrayClone));
		System.out.println("Equals: " + Quicksort.equals(array, array3));
	
		
		long startTime = System.currentTimeMillis();
			Quicksort.sQsort(array);	
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		
		System.out.println("Time: " + time);
		
		long startTime2 = System.currentTimeMillis();
			QuicksortOriginal.sQsortOriginal(arrayClone);
		long endTime2 = System.currentTimeMillis();
		long time2 = endTime2 - startTime2;
		
		
		System.out.println("TimeOriginal: " + time2);
		

		ParallelQuicksort pq = new ParallelQuicksort(array3);
   		ForkJoinPool pool = new ForkJoinPool(processors);
   		
		long startTime3 = System.currentTimeMillis();
			pool.invoke(pq);
		long endTime3 = System.currentTimeMillis();
		long time3 = endTime3 - startTime3;
		
	
		System.out.println("TimeParallel: " + time3);
		System.out.println(Quicksort.sortCheck(array3));
	
	}

}
