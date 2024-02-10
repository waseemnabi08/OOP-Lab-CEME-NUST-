public class Multiply implements Runnable{
    int row;
    int [][] matrixA;
    int [][] matrixB;
    int [][] result;

    public Multiply(int row, int [][] matrixA, int [][] matrixB, int [][] result){
        this.row = row;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
    }

    @Override

    public void run(){
        int colA = matrixA[0].length;
        int colB = matrixB[0].length;
        int sum = 0;
        for(int i = 0; i < colA; i++){
            for(int j = 0; j < colB; j++){
                sum += matrixA[row][i] * matrixB[i][j];
            }
            result[row][i] = sum;
            sum = 0;
        }
    }
}
