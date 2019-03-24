import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    size = 0;
    data = (E[]new Object[10]);
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    size = 0;
    data = (E[]new Object[initialCapacity]);
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ret = "";
    if (start < end) {
      for (int i = start; i < end; i++) {
        ret = ret + data[i] + " ";
      }
    } else { //end < start
      for (int i = start; i < data.length; i++) {
        ret = ret + data[i] + " ";
      }
      for (int i = 0; i < end; i++) {
        ret = ret + data[i] + " ";
      }
    }
    ret = "{" + ret + "}";
    return ret;
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    size = size + 1;
    data[start-1] = element;
    //move
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    size = size + 1;
    data[size] = element;
  }

  public E removeFirst(E element){
    if (size = 0) throw new NoSuchElementException();
    E ret = data[element];
    data[element] = null;
    size = size - 1;
    start = start + 1;
    return ret;
  }

  public E removeLast(E element){
    if (size = 0) throw new NoSuchElementException();
    E ret = data[element];
    data[element] = null;
    size = size - 1;
    end = end -1;
    return ret;
  }

  public E getFirst(E element){
    if (size = 0) throw new NoSuchElementException();
    return data[start];
  }
  public E getLast(E element){
    if (size = 0) throw new NoSuchElementException();
    return data[last];
  }
}
