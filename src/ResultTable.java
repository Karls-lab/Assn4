import java.util.HashMap;

public class ResultTable extends HashMap{
    private HashMap<Long, Long> ht;

    public ResultTable(HashMap<Long, Long> ht){
        this.ht = ht;
    }

    public synchronized void addElement(long key, long value) {
        ht.put(key, value);
    }

    public synchronized long getElement(long key) {
        return ht.get(key);
    }
}
