import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //default constructor size 10
  @SuppressWarnings("unchecked")
  public MyDeque(){
    size = 0;
    data = (E[])new Object[10];
    //start&end in middle of array
    start = data.length/2;
    end = data.length/2;
  }

  //constructor with input amount capacity
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    size = 0;
    data = (E[])new Object[initialCapacity];
    //start&end in middle of array
    start = data.length/2;
    end = data.length/2;
  }

  public int size(){
    //returns number of values in data
    return size;
  }

  public String toString(){
    String s = "{";
    //if standard start to end
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
      //if end is before start, then it must still loop to end from start
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

  //standard resize will place all values in order starting from index of new array
  private void resize(){
    @SuppressWarnings("unchecked")
    //new array is double original size
    E[] copy = (E[])new Object[size*2];
    //index of new array;
    int idx = 0;
    //standard start to end copy
    if (start < end) {
      for (int i = start; i < end+1; i++){
        copy[idx] = data[i];
        idx++;
      }
    } else if (start > end) {
      //if end is before start, then the array copy must still copy from start to end
      for (int i = start; i < data.length; i++) {
        copy[idx] = data[i];
        idx++;
      }
      idx=0;
      for (int i = 0; i < end + 1; i++) {
        copy[idx+(data.length-start)] = data[i];
        idx++;
      }
    }
    //resetting start and end
    start = 0;
    end = data.length - 1;
    data = copy;
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    //check if an element is already in array
    if (size > 0) {
      //if capacity is exceeded, resize
      if (size + 1 > data.length) {
        resize();
      }
      //if start goes to the other end, it must wrap around the array
      if (start - 1 >= 0) {
        start--;
        data[start] = element;
      } else {
        start = data.length-1;
        data[start] = element;
      }
    } else {
      //if is empty then just make start the element
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    //check if an element is already in array
    if (size > 0){
      //if capacity is exceeded, resize
      if (size+1 > data.length) {
        resize();
      }
      //if start goes to the other end, it must wrap around the array
      if (end + 1 < data.length) {
        end++;
        data[end] = element;
      } else {
        end = 0;
        data[end] = element;
      }
    } else {
      //if is empty then just make start the element
      data[end] = element;
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException();
    //to store the removed value
    E removed = getFirst();
    //check if more than one element is already in array
    if (size > 1) {
      if (start+1 < data.length) {
        data[start] = null;
        start++;
      } else {
        //to wrap around array
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
    //to store the removed value
    E removed = getLast();
    //check if more than one element is already in array
    if (size > 1) {
      if (end - 1 >= 0) {
        data[end] = null;
        end--;
      } else {
        //to wrap around array
        data[end] = null;
        end = data.length - 1;
      }
    } else {
      data[end] = null;
    }
    size--;
    return removed;
  }

  //returns beginning of deque
  public E getFirst(){
    if (size == 0) throw new NoSuchElementException();
    return data[start];
  }
  //returns end of deque
  public E getLast(){
    if (size == 0) throw new NoSuchElementException();
    return data[end];
  }


}
