public class IntMatrix {
    private int array[][];
    private int numRows;
    private int numCols;

    public IntMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.array = new int[numRows][numCols];
    }

    public void set(int row, int col, int value) {
        if(row>=0 && row<numRows && col>=0 && row<numRows){
            this.array[row][col] = value;
        }
        if(row<0 || row >=numRows){
            System.out.println("Error: No " + row + " row");
        }
        if(col<0 || col >=numCols){
            System.out.println("Error: No " + col + " column");
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int sum(){
        int sum = 0;
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                sum += array[rows][cols];
            }
        }
        return sum;
    }

    public int rowSum(int row){
        int sum = 0;
        for (int col = 0; col < array[row].length; col++) {
            sum += array[row][col];
        }
        return sum;
    }

    @Override
    public String toString(){
        String s = "\n";
        for (int row = 0; row < array.length; row++) { // x = rows
            for (int col = 0; col < array[0].length; col++) { // y = cols
                s += '[';
                s+=array[row][col];
                s += ']';
            }
            s+= "\n";
        }
        return s;
    }

    public int min(){
        int min = array[0][0];
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                if(array[rows][cols] < min)
                    min = array[rows][cols];
            }
        }
        return min;
    }

    public int max(){
        int max = array[0][0];
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                if(array[rows][cols] > max)
                    max = array[rows][cols];
            }
        }
        return max;
    }

    public boolean equals(IntMatrix other){
        if(numCols != other.numCols || numRows != other.numRows)
            return false;
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                if(array[rows][cols] != other.array[rows][cols])
                    return false;
            }
        }
        return true;
    }

    public int det(){
        if(numRows != numCols){
            System.out.println("Not a square matrix");
            return -1;
        }
        if(numRows == 2 && numCols == 2){
            int diag1 = array[0][0] * array[1][1];
            int diag2 = array[0][1] * array[1][0];
            return diag1 - diag2;
        }
        if(numRows == 3 && numCols ==3){
            int LRdiag1 = array[0][0] * array[1][1] * array[2][2];
            int LRdiag2 = array[0][1] * array[1][2] * array[2][0];
            int LRdiag3 = array[0][2] * array[1][0] * array[2][1];
            int RLdiag1 = array[2][0] * array[1][1] * array[0][2];
            int RLdiag2 = array[2][1] * array[1][2] * array[0][0];
            int RLdiag3 = array[2][2] * array[1][0] * array[0][1];
            return LRdiag1+LRdiag2+LRdiag3-RLdiag1-RLdiag2-RLdiag3;
        }
        else{
            System.out.println("I don't know how to solve that determinant");
        }
        return -1;
    }

    public IntMatrix addRows(int rows){
        IntMatrix matrix2 = new IntMatrix(numRows+rows,numCols);
        for (int rows1 = 0; rows1 < numRows; rows1++) {
            for (int cols = 0; cols < numCols; cols++) {
                matrix2.array[rows1][cols] = array[rows1][cols];
            }
        }
        numRows = numRows+rows;
        array = matrix2.array;
        return this;
    }

    public IntMatrix addCols(int cols){
        IntMatrix matrix2 = new IntMatrix(numRows,numCols+cols);
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols1 = 0; cols1 < numCols; cols1++) {
                matrix2.array[rows][cols] = array[rows][cols1];
            }
        }
        numCols = numCols + cols;
        array = matrix2.array;
        return this;
    }

    public static void main(String[] args) {
        IntMatrix matrix = new IntMatrix(2,3);
        matrix.set(0,0,99);
        matrix.set(1,1,88);
        matrix.set(0,2,-50);
        matrix.set(5,3,77); // should print out error
        System.out.println("matrix is: "+matrix);
        System.out.println("matrix numRows is "+matrix.getNumRows());
        System.out.println("matrix numCols is " + matrix.getNumCols());
        System.out.println("matrix sum is "+matrix.sum());
        System.out.println("matrix sum of first row is "+matrix.rowSum(0));
        System.out.println("matrix min is "+matrix.min());
        System.out.println("matrix max is " + matrix.max());
        matrix.addCols(3);
        matrix.addRows(5);
        System.out.println(matrix);
        IntMatrix matrix2= new IntMatrix(2,3);
        matrix2.set(0,0,99);
        matrix2.set(1,1,88);
        matrix2.set(0,2,-50);
        matrix2.set(5,3,77);
        IntMatrix matrix3= new IntMatrix(3,3);
        matrix3.set(0,0,4);
        matrix3.set(0,1,2);
        matrix3.set(0,2,6);
        matrix3.set(1,0,8);
        matrix3.set(1,1,3);
        matrix3.set(1,2,4);
        matrix3.set(2,0,1);
        matrix3.set(2,1,8);
        matrix3.set(2,2,6);
        System.out.println(matrix3);
        System.out.println("Determinant is " + matrix3.det());
        if (matrix.equals(matrix2))
            System.out.println("matrix equals matrix2");  // should print
        if (matrix.equals(matrix3))
            System.out.println("matrix equals matrix3");  // should not print
    }
}
