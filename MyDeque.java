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
    if (size > 0){
      if (size <= data.length) {
        if (end + 1 < data.length) {
          end++;
          data[end] = element;
        } else {
          end = 0;
          data[end] = element;
        }
      }
    } else {
      data[end] = element;
    }
    size++;
  }
  public E removeFirst(){
    E removed = getFirst();
    if (size > 1) {
      if (size <= data.length) {
        if (start+1 < data.length) {
          data[start] = null;
          start++;
        } else {
          data[start] = null;
          start = 0;
        }
      }
    } else {
      data[start] = null;
    }
    size--;
    return removed;
  }
  
  public E removeLast(){
    E removed = getLast();
    if (size > 1) {
      if (size <= data.length) {
        if (end - 1 >= 0) {
          data[end] = null;
          end--;
        } else {
          data[end] = null;
          end = data.length - 1;
        }
      }
    }
    size--;
    return removed;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
