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
    if (size == 0) return "{}";
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
    return "{" + ret + "}";
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
    data[start] = null;
    size = size - 1;
    check0();
    if (size == 1) {
      start = end;
    } else if (start == data.length-1) {
        start = 0;
      } else {
        start = start + 1;
      }
    return ret;
  }

  public E removeLast(){
    //if deque is empty
    if (size <= 0) throw new NoSuchElementException();
    E ret = data[end];
    data[end] = null;
    size = size - 1;
    check0();
    if (size == 1) {
      end = start;
    } else if (end == 0) {
        end = data.length-1;
      } else {
        end = end -1;
      }
    return ret;
  }

  public E getFirst(){
    if (size <= 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (size <= 0) throw new NoSuchElementException();
    return data[end-1];
  }

  private void positionCheckup(){
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

  private void positionCheckup2(){
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

  private void check0() {
    if (size == 0) {
      start = 0;
      end = 0;
    }
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[])new Object[(data.length-1)*2];
    int index = 0;
    if (start < end) {
      for (int i = start; i < size; i++) {
        resize[index] = data[i];
        index++;
      }
    }
    else {
      for (int i = start; i < data.length; i++) {
        resize[index] = data[i];
      }
      for (int i = 0; i < end; i++) {
        resize[index] = data[i];
      }
    }
    data = resize;
    start = 0;
    end = index + 1;
  }

}
