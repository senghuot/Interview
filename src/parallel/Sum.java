package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Long> {
    static final int SEQUENTIAL_THRESHOLD = 5000;

    int low;
    int high;
    int[] array;

    public Sum(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }

    protected Long compute() {
        if(high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for(int i=low; i < high; ++i) 
                sum += array[i];
            return sum;
         } else {
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(array, low, mid);
            Sum right = new Sum(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
         }
     }

     static long sumArray(int[] array) {
         return Globals.fjPool.invoke(new Sum(array,0,array.length));
     }
}