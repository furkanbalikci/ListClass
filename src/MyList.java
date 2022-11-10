public class MyList<T> {

    private T[] arr;
    private int index = 0;
    private int capacity;

    public MyList(int capacity) {
        this.capacity = capacity + (10 - (capacity % 10));
        this.arr = (T[]) new Object[capacity];
    }
    public MyList(){
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];

    }

    public int size(){
        return this.index;
    }

    public int getCapacity() {
        return this.capacity;
    }

    //listeye aynı anda birden fazla eleman eklemeyi deneyebiliriz. add(1,2,3,4,6)
    public void add(T data){
        if(this.index == this.capacity){
            this.capacity +=10;
            T[] tempArr = (T[]) new Object[this.capacity-10];
            tempArr = this.arr.clone();
            this.arr = (T[]) new Object[this.capacity];

            int temp = 0;
            for (T element : tempArr){
                this.arr[temp] = element;
                temp++;
            }
            this.arr[this.index] = data;
            }
        else{
            this.arr[this.index] = data;

            }
        this.index++;
    }

    public T get(int index){
        if (this.index > index) {
            return this.arr[index];
        }
        return null;
    }

    public T remove(int index){
        if (this.index > index) {
            T temp = this.arr[index];
            for (int i = 0; this.index > index ; i++) {
                this.arr[index] = this.arr[index+1];
                this.index--;
                return temp;
            }
        }
        return null;
    }
    public void set(int index, T data){
        if (this.index > index) {
            this.arr[index] = data;
        }
    }

    @Override
    public String toString(){
        String res = "[";
        for (int i = 0; i < this.index; i++) {
            if (i == this.index - 1) {
                res += this.arr[i].toString();
            }else {
                res += this.arr[i].toString() + ",";
            }
        }
        res += "]";
        return res;
    }

    public int indexOf(T data){
        int index = 0;
        for (T element : this.arr){
            if (element == data){
                return index;
            }
            index++;
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for(int idx = this.index-1; idx >= 0; idx--){
            if(this.arr[idx] == data)
                return idx;
        }
        return -1;
    }

    public boolean isEmpty(){
        return this.index == 0;
    }

    public T[] toArray(){
        return this.arr.clone();
    }

    public void clear(){
        this.index = 0;
        this.capacity = 10;
        this.arr = (T[]) new Object[this.capacity];
    }

    public MyList<T> subList(int start, int finish){
        MyList arr = new MyList(finish-start+1);

        for(int idx = 0;start<=finish;start++, idx++){
            arr.add(this.arr[start]);
        }
        return arr;
    }

    public boolean contains(T data){
        return indexOf(data) != -1;
    }


}
