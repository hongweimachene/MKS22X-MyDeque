public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    size = 0;
    data = (E[])new Object[10];
    start = data.length/2;
    end = data.length/2;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    size = 0;
    data = (E[])new Object[initialCapacity];
    start = data.length/2;
    end = data.length/2;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String s = "{";
    for (int i = 0; i < data.length; i++) {
      if (i == data.length-1){
        s+=data[i];
      } else {
        s+=data[i] + " ";
      }
    }
    return s+="}";
  }

  public void addFirst(E element){
    if (size > 0) {
      if (start - 1 >= 0) {
        start--;
        data[start] = element;
      }
    }

    size++;
  }
  public void addLast(E element){
    size++;
  }
  public E removeFirst(){
    size--;
  }
  public E removeLast(){
    size--;
  }
  public E getFirst(){

  }
  public E getLast(){

  }
}
