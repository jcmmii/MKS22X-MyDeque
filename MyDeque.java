import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    size = 0;
    data = (E[])new Object[10];
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    size = 0;
    data = (E[])new Object[initialCapacity];
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

//ACCOUNT FOR SIZING

  public void addFirst(E element){
    //can't add nulls
    if (element == null) throw new NullPointerException();
    size = size + 1;
    start = start - 1;
    positionCheckup();
    data[start] = element;
  }

  public void addLast(E element){
    //can't add nulls
    if (element == null) throw new NullPointerException();
    size = size + 1;
    end = end + 1;
    positionCheckup2();
    data[end] = element;
  }

  public E removeFirst(){
    //if deque is empty
    if (size <= 0) throw new NoSuchElementException();
    E ret = data[start];
    size = size - 1;
    start = start + 1;
    return ret;
  }

  public E removeLast(){
    //if deque is empty
    if (size <= 0) throw new NoSuchElementException();
    E ret = data[end];
    size = size - 1;
    end = end -1;
    return ret;
  }

  public E getFirst(E element){
    if (size <= 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(E element){
    if (size <= 0) throw new NoSuchElementException();
    return data[end-1];
  }

  public void positionCheckup(){
    if (start < 0) {
      if (data[data.length-1] == null) {
        start = data.length-1;
      }
      else if (data[data.length-1] != null || data[start-1] != null) {
        resize();
        start = data.length-1;
      }
    }
  }

  public void positionCheckup2(){
    if (end > data.length-1) {
      if (data[0] == null) {
        end = 0;
      }
      else if (data[0] != null || data[end+1] != null) {
        resize();
        end = size;
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[])new Object[size*2];
    if (start < end) {
      for (int i = 0; i < size; i++) {
        resize[i] = data[start+1];
      }
    }
    else {
      int index = 0;
      for (int i = 0; i < size; i++) {
        if (start + i < data.length) resize[i] = data[start+i];
        else {
          resize[i] = data[index];
          index++;
        }
      }
    }
  }


}
