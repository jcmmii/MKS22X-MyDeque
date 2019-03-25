import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //two constructors: with and without initial capacity
  //Suppresses warnings
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

  public String toString(){
    String ret = "";
    if (size == 0) return "{}";
    //when start <= end, just prints left to write
    if (start <= end) {
      for (int i = start; i < end; i++) {
        ret = ret + data[i] + " ";
      }
    } else { //when end < start, which means wrapping around the array is required
             //goes to the end of the array first, then starts back at 0, goes up to the "end" index
      for (int i = start; i < data.length; i++) {
        ret = ret + data[i] + " ";
      }
      for (int i = 0; i < end; i++) {
        ret = ret + data[i] + " ";
      }
    }
    return "{" + ret + "}";
  }

  public void addFirst(E element){
    //can't add nulls
    if (element == null) throw new NullPointerException();
    positionCheckup();
    data[start] = element;
    size = size + 1;
  }

  private void positionCheckup(){
    if (size >= data.length) resize(); //the size count is >= than actual size of array, resize required.
    if (size == 0) {
      if (end != data.length) {
        end = end + 1;
      } else { //if the end == data.length, sets end to 1
        end = 1;
      }
    } else if (start == 0) { //if start is 0, go back and wrap around to the end
      start = data.length -1;
    } else {
      start = start -1;
    }
  }

  public void addLast(E element){
    //can't add nulls
    if (element == null) throw new NullPointerException();
    if (size >= data.length) resize();
    if (end == data.length) {
      end = 1;
      data[0] = element; //wraps around to the front, end is 1
    } else {
      end = end + 1; //else increase the end, set the prev(original) val of end to the element
      data[end-1] = element;
    }
    size = size + 1;
  }

  public E removeFirst(){
    //if deque is empty
    if (size <= 0) throw new NoSuchElementException();
    size = size -1; //remove decreases size
    E ret = data[start];
    start = start + 1; //increase the start by 1 to get rid of the first
    if (start == data.length) start = 0; //wrap back
    return ret; //removing returns
  }

  public E removeLast(){
    //if deque is empty
    if (size <= 0) throw new NoSuchElementException();
    size = size -1; //remove decreases size
    end = end -1; //end index is always right one index, so shift back one
    E ret = data[end];
    if (end == 0) end = data.length; //wrap back
    return ret; //removing returns
  }


  //accessor methods 
  public E getFirst(){
    if (size <= 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (size <= 0) throw new NoSuchElementException();
    return data[end-1];
  }

  public int size(){
    return size;
  }


  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[])new Object[size*2];
    int index = -1;
    if (start < end) {
      for (int i = start; i < size; i++) {
        index++;
        resize[index] = data[i];
      }
    }
    else {
      for (int i = start; i < size; i++) {
        index++;
        resize[index] = data[i];

      }
      for (int i = 0; i < end; i++) {
        index++;
        resize[index] = data[i];
      }
    }
    data = resize;
    start = 0;
    end = index + 1;
  }
}
