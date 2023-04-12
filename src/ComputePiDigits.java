public class ComputePiDigits implements Runnable {
    private TaskQueue taskQueue;
    private ResultTable resultTable;
    
    public ComputePiDigits(TaskQueue testQueue, ResultTable resultTable) {
        this.taskQueue = testQueue;
        this.resultTable = resultTable;
    }

    public void run() {
        Bpp bpp = new Bpp();

        while(taskQueue.getSize() > 0) {
            long key = taskQueue.popTask();
            long piDigit = bpp.getDecimal(key);
            resultTable.addElement(key, piDigit);
            resultTable.getElement(key);
        }
    }
}
