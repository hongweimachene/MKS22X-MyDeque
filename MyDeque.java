import java.util.*;
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
    if (start < end) {
      for (int i = start; i < end+1; i++) {
        if (data[i] != null) {
          if (i == end){
            s+=data[i];
          } else {
            s+=data[i] + " ";
          }
        }
      }
    } else if (start > end) {
      for (int i = start; i < data.length; i++) {
        s+=data[i] + " ";
      }
      for (int i = 0; i < end + 1; i++) {
        if (i == end) {
          s+= data[i];
        } else {
          s+=data[i] + " ";
        }
      }
    } else {
      if (data[start] != null) s+=data[start];
    }
    return s+="}";
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[size*2];
    int idx = 0;
    if (start < end) {
      for (int i = start; i < end+1; i++){
        copy[idx] = data[i];
        idx++;
      }
    } else if (start > end) {
      for (int i = start; i < data.length; i++) {
        copy[idx] = data[i];
        idx++;
      }
      idx=0;
      for (int i = 0; i < end + 1; i++) {
        copy[idx+(data.length-start)] = data[i];
        idx++;
      }
      start = 0;
      end = data.length - 1;
    }
    data = copy;
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    if (size > 0) {
      if (size + 1 > data.length) {
        resize();
      }
      if (start - 1 >= 0) {
        start--;
        data[start] = element;
      } else {
        start = data.length-1;
        data[start] = element;
      }
    } else {
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size > 0){
      if (size+1 > data.length) {
        resize();
      }
      if (end + 1 < data.length) {
        end++;
        data[end] = element;
      } else {
        end = 0;
        data[end] = element;
      }
    } else {
      data[end] = element;
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException();
    E removed = getFirst();
    if (size > 1) {
      if (start+1 < data.length) {
        data[start] = null;
        start++;
      } else {
        data[start] = null;
        start = 0;
      }
    } else {
      data[start] = null;
    }
    size--;
    return removed;
  }

  public E removeLast(){
    if (size == 0) throw new NoSuchElementException();
    E removed = getLast();
    if (size > 1) {
      if (end - 1 >= 0) {
        data[end] = null;
        end--;
      } else {
        data[end] = null;
        end = data.length - 1;
      }
    } else {
      data[end] = null;
    }
    size--;
    return removed;
  }

  public E getFirst(){
    if (size == 0) throw new NoSuchElementException();
    return data[start];
  }
  public E getLast(){
    if (size == 0) throw new NoSuchElementException();
    return data[end];
  }

  public void printdata() {
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println(" ");
  }
  
}
