import java.util.LinkedList;

public class TaskQueue {
    private LinkedList<Integer> taskQueue;

    public TaskQueue(LinkedList<Integer> taskQueue){
        this.taskQueue = taskQueue;
    }

    public int getSize() {
        return taskQueue.size();
    }
    
    public synchronized void addTask(int i) {
        taskQueue.add(i);
    }

    public synchronized int popTask() {;
        return taskQueue.pop();
    }

}
