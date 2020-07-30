public class Board {
    private int x,y;
    private int[][] currentGeneration;
    private int[][] nextGeneration;

    public Board(int x,int y,int[][] zeroGeneration){
        this.x = x;
        this.y = y;
        this.currentGeneration = zeroGeneration;
        this.nextGeneration = new int[x][y];
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j < y; j++) {
                nextGeneration[i][j] = currentGeneration[i][j];
            }
        }
    }

    //Create next generation
    public void nextGeneration(){
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j < y; j++) {
                int countGreen = countGreen(i, j);
                if (currentGeneration[i][j] == 0 && (countGreen == 3 || countGreen == 6)) {
                    nextGeneration[i][j] = 1;
                } else if (currentGeneration[i][j] == 1 && (countGreen == 0 || countGreen == 1
                        || countGreen == 4 || countGreen == 5 || countGreen == 7 || countGreen == 8)) {
                    nextGeneration[i][j] = 0;
                }
            }
        }
    }

    //Go to next generation
    public void goToNextGeneration(){
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j < y; j++) {
                currentGeneration[i][j] = nextGeneration[i][j];
            }
        }
    }

    //Count all green surroundings
    public int countGreen(int X, int Y){
        int count=0;
        if (X>0 && Y==0 && X<(x-1)){
            count+=currentGeneration[X-1][Y];
            count+=currentGeneration[X+1][Y];
            count+=currentGeneration[X-1][Y+1];
            count+=currentGeneration[X+1][Y+1];
            count+=currentGeneration[X][Y+1];
        }else if(Y>0 && X==0 && Y<(y-1)){
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X][Y+1];
            count+=currentGeneration[X+1][Y+1];
            count+=currentGeneration[X+1][Y-1];
            count+=currentGeneration[X+1][Y];
        }else if(Y==0 && X==0){
            count+=currentGeneration[X+1][Y+1];
            count+=currentGeneration[X][Y+1];
            count+=currentGeneration[X+1][Y];
        }else if(Y>0 && X>0 && X<(x-1) && Y<(y-1)){
            count+=currentGeneration[X+1][Y-1];
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X-1][Y-1];
            count+=currentGeneration[X+1][Y+1];
            count+=currentGeneration[X][Y+1];
            count+=currentGeneration[X-1][Y+1];
            count+=currentGeneration[X-1][Y];
            count+=currentGeneration[X+1][Y];
        }
        else if(X==0 && Y==(y-1)){
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X+1][Y];
            count+=currentGeneration[X+1][Y-1];

        }
        else if(X==(x-1) && Y==0){
            count+=currentGeneration[X][Y+1];
            count+=currentGeneration[X-1][Y];
            count+=currentGeneration[X-1][Y+1];

        }else if(X==(x-1) && Y==(y-1)){
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X-1][Y];
            count+=currentGeneration[X-1][Y-1];

        }
        else if (Y==(y-1) && X>0){
            count+=currentGeneration[X-1][Y];
            count+=currentGeneration[X-1][Y-1];
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X+1][Y-1];
            count+=currentGeneration[X+1][Y];
        }else if(X==(x-1) && Y>0){
            count+=currentGeneration[X][Y-1];
            count+=currentGeneration[X][Y+1];
            count+=currentGeneration[X-1][Y+1];
            count+=currentGeneration[X-1][Y-1];
            count+=currentGeneration[X-1][Y];
        }
        return count;
    }

    //Count how many times value at x1 and y1 is green in all generations
    public int count(int x1,int y1,int generations){
        int count=0;
        for (int i = 0; i <generations ; i++) {
            if (currentGeneration[x1][y1]==1){
                count++;
            }
            nextGeneration();
            goToNextGeneration();

        }
        if (currentGeneration[x1][y1]==1){
            count++;
        }
        return count;
    }
}