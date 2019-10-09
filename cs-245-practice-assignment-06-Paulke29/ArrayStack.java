import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack {
    private int size ;
    private T [] array;
    // having value for array and size;
    public ArrayStack() {
        array = (T[]) (new Object[10]);
        size = 0;
    }


    // adding item to stack
    @Override
    public void push(Object item) {
        if (size == array.length) {
            DoubleSize();
        }
        array[size] = (T)item;
        size++;
    }
    // removing the top item in the stack
    @Override
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T top = array[size - 1];
        array[size - 1] = null;
        size--;
        return top;
    }


    // taking look at the top one in the stack
    @Override
    public Object peek() {
        if (size == 0) {
            return new EmptyStackException();
        }
        return array[size - 1];
    }


    // having checking the stack is empty or not
    @Override
    public boolean empty() {
        return size == 0;
    }

    // having more double size array than old one
    private void DoubleSize() {
        T[] newElements = (T[]) (new Object[2 * array.length]);
        for (int i = 0; i < size; i++) {
            newElements[i] = array[i];
        }
        array = newElements;
    }
}
