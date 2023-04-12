import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Assn4Main {
    public static void main(String[] args) {

        // randomize the list of tasks
        ArrayList<Integer> queueList = new ArrayList<Integer>(); 
        for(int i = 1; i < 1001; i++) queueList.add(i);
        java.util.Collections.shuffle(queueList);

        // initialize the task queue or the places of pi to compute
        LinkedList<Integer> TaskQueue = new LinkedList<Integer>();
        for(int digit:queueList) TaskQueue.add(digit);
        TaskQueue taskQueue = new TaskQueue(TaskQueue);

        // create a hashtable to store results
        HashMap<Long, Long> resultTable = new HashMap<>();
        ResultTable testTable = new ResultTable(resultTable);
        
        try {
            // initialize threads to the number of processors
            Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
            long timeStart = System.currentTimeMillis();

            // start the max number of threads
            for (int thread = 0; thread < Runtime.getRuntime().availableProcessors(); thread++) {
                threads[thread] = new Thread(new ComputePiDigits(taskQueue, testTable));
                threads[thread].start();
            }

           for (Thread t : threads) {
               t.join();
           }

            System.out.print("3.");
            Collection<Long> values = resultTable.values();
            for(Long value : values) System.out.print(value);

            long timeEnd = System.currentTimeMillis();
            System.out.printf("\nPi Computation took: %d ms\n", (timeEnd - timeStart));
        }
        catch (Exception ex) {
            System.out.println("Something bad happened");
        }



    }
}
