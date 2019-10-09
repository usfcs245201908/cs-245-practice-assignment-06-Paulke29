import java.lang.Exception;

public class ArrayQueue<T> implements Queue {
    private int default_size =10;
    private int size;
    private T [] array;
    public  ArrayQueue(){
        //having default size and size as index
        size = 0;
        array = (T[]) new Object[default_size];
    }
    @Override
    public Object dequeue() {
        if (empty()){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        T result = array[0];

        size--;

        // shift the elements
        for (int scan=0; scan < size; scan++)
            array[scan] = array[scan+1];
        // the old one is null
        array[size] = null;

        return result;
    }

    @Override
    public void enqueue(Object item) {
        // checking whether empty qquene
        if (size() == array.length) {
            DoubleSize();
        }
        // add item to quene
        array[size] = (T)item;
        size++;

    }
    public int size()
    {
        //having size of qunue
        return size;
    }

    @Override
    public boolean empty() {
        // checking whether empty or not
        return size == 0;
    }

    // having double more size than old one
    private void DoubleSize()
   {
      T[] larger = (T[])(new Object[array.length*2]);

      for (int scan=0; scan < array.length; scan++)
         larger[scan] = array[scan];

      array = larger;
   }
}
