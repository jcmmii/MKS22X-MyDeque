public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchceked")
  public MyDeque() {
    size = 0;
    data = (E[]new Object[10]);
    start = 0;
    end = 10;
  }

  public MyDeque(int initialCapacity){
    data = (E[]new Object[initialCapacity]);
    start = 0;
    end = initialCapacity;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ret = "";
    for (int x = start; x < initialCapacity; x++) {
      ret = ret + data[x] + " ";
    }
    return ret;
  }

  public void addFirst(E element){
    size = size + 1;

  }

  public void addLast(E element){
    size = size + 1;
  }

  public E removeFirst(E element){
    size = size - 1;
  }

  public E removeLast(E element){
    size = size - 1;
  }
  public E getFirst(E element){
    return data[0];
  }
  public E getLast(E element){
    return data[last];
  }
}
