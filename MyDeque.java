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

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[size*2];
    for (int i = 0; i < data.length; i++ ){
      copy[i] = data[i];
    }
    data = copy;
  }

  public void addFirst(E element){
    if (size > 0) {
      if (size <= data.length) {
        if (start - 1 >= 0) {
          start--;
          data[start] = element;
        } else {
          start = data.length-1;
          data[start] = element;
        }
      }
    } else {
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){
    if ()
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
