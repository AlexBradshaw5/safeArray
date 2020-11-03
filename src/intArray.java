public class intArray {
    private int array[];
    private int capacity;
    private int numElements;

    public intArray() {
        array = new int[10];
        capacity = 10;
        numElements =0;
    }

    public intArray(int capacity){
        array = new int[capacity];
        this.capacity = capacity;
        numElements = 0;
    }

    public int[] getArray() {
        return array;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getNumElements() {
        return numElements;
    }

    public void add(int x){
        numElements++;
        if(numElements>capacity){
            int array2[] = new int[capacity+capacity];
            System.arraycopy(array, 0, array2, 0, array.length);
            array = array2;
            capacity = capacity+capacity;
        }
        array[numElements-1] = x;
    }
    public void add(int index,int x){
        if(index>=capacity || index<0){
            System.out.println("Error. 'add' index out of range");
        }
        if(index<capacity && index >= 0){
            numElements++;
            if (numElements >capacity) {
                int array2[] = new int[capacity + capacity];
                System.arraycopy(array, 0, array2, 0, array.length);
                array = array2;
                capacity = capacity + capacity;
            }
            for (int i = array.length-1; i > index; i--) {
                array[i] = array[i-1];

            }
            array[index] = x;
        }
    }

    public void set(int index, int x){
        if(index>=0 && index<capacity) {
            if (x == 0 && array[index] != 0)
                numElements--;
            if (x != 0 && array[index] == 0)
                numElements++;
            array[index] = x;
        }
        if(index<0 || index>=capacity)
            System.out.println("Error: 'set' index out of range");
    }

    public void remove(int index){
        if(index<0 || index >= capacity){
            System.out.println("Error: 'remove' index out of range");
        }
        if(index>=0 && index < capacity) {
            numElements--;
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            if(numElements<=capacity/2){ //resizes if the array gets smaller
                int array2[] = new int[capacity/2];
                for (int a = 0; a < numElements; a++) {
                    array2[a] = array[a];
                }
                array = array2;
                capacity = capacity/2;
            }
            if(numElements != capacity)
                array[array.length - 1] = 0;
        }
    }

    public String toString(){
        String numElem = "Number of Elements: " + numElements;
        String Cap = " Capacity: " + capacity;
        String arrayS = "";
        for (int index = 0; index < array.length; index++) {
            arrayS += "[";
            arrayS += array[index];
            arrayS += "]";
        }
//        System.out.println(numElem);
//        System.out.println(Cap);
        return arrayS;
    }

    public boolean equals(intArray other){
        if(this.capacity != other.capacity)
            return false;
        if(this.numElements != other.numElements){
            return false;
        }
        for (int elem = 0; elem < array.length; elem++) {
            if(this.array[elem] != other.array[elem]){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        intArray array1 = new intArray(5);
        intArray array2 = new intArray();
        for (int index = 1; index < 9; index++) {
            array1.add(index);
        }
        for (int index = 1; index < 9; index++) {
            array2.set(index-1,index);
        }
        System.out.println(array1);
        System.out.println(array2);
        System.out.println(array1.equals(array2));
        array1.add(9);
        array1.add(9,10);
        array1.add(11);
        array1.set(5,77);
        array1.remove(0);
        array1.remove(5);
        System.out.println(array1);
        System.out.println(array1.numElements);
        System.out.println(array1.capacity);
        //error section
        array2.add(-1,69);
        array2.add(10,69);
        array2.set(-1,69);
        array2.set(10,69);
        array2.remove(-1);
        array2.remove(10);
        System.out.println(array2);
    }

}
