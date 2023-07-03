import java.awt.Color;
import java.util.Random;

class Logic {
    int size;
    GridPanel gp;
    int arr[][];
    static int c = 0;
    public Logic(int size,GridPanel gp)
    {
        this.arr = new int[size][size];
        this.gp = gp;
        this.size = size;
        gp.repaint();
        // fillCol(size);
        gun();
    }    
    public void fillCol(int size)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                Random rn = new Random();
                boolean b1 = rn.nextBoolean();
                if(b1)
                {
                    arr[i][j] = 1;
                    gp.setColor(i, j, Color.black);
                }
                else
                {
                    arr[i][j] = 0;
                    gp.setColor(i, j,Color.white);
                }
            }
        }
        gp.repaint();
       evolve();
    }

    public void gun(){
        int i = 20;
int j =0;

arr[i][j] = 1;
arr[i+1][j] = 1;
arr[i+1][j+1] = 1;
arr[i][j+1] = 1;

j+=10;

arr[i][j] = 1;
arr[i+1][j] = 1;
arr[i+2][j] = 1;
arr[i-1][j+1] = 1;
arr[i+3][j+1] = 1;
arr[i-2][j+2] = 1;
arr[i-2][j+3] = 1;
arr[i+4][j+2] = 1;
arr[i+4][j+3] = 1;
arr[i+1][j+4] = 1;
arr[i-1][j+5] = 1;
arr[i+3][j+5] = 1;
arr[i][j+6] = 1;
arr[i+1][j+6] = 1;
arr[i+2][j+6] = 1;
arr[i+1][j+7] = 1;

i-=1;
j+=10;

arr[i][j] = 1;
arr[i-1][j] = 1;
arr[i+1][j] =1;
arr[i][j+1] = 1;
arr[i-1][j+1] =1;
arr[i+1][j+1] =1;
arr[i-2][j+2] = 1;
arr[i+2][j+2] = 1;
arr[i-2][j+4] = 1;
arr[i+2][j+4] = 1;
arr[i-3][j+4] = 1;
arr[i+3][j+4] = 1;


j+=14;

arr[i][j] = 1;
arr[i-1][j] = 1;
arr[i][j+1] = 1;
arr[i-1][j+1] = 1;
gp.repaint();
       evolve();
    }

    public void manFillCol(int size)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                arr[i][j] = 0;
                gp.setColor(i, j,Color.white);
            }
        }
        for(int i=0;i<40;i++){
            for(int j=0;j<20;j++){
                Random rm = new Random();
                boolean val = rm.nextBoolean();
                if(val){arr[i][j] = 1;}else{arr[i][j] = 0;}
            }
        }
        for(int i=120;i<140;i++){
            for(int j=0;j<30;j++){
                Random rm = new Random();
                boolean val = rm.nextBoolean();
                if(val){arr[i][j] = 1;}else{arr[i][j] = 0;}
            }
        }
        for(int i=120;i<150;i++){
            for(int j=180;j<190;j++){
                Random rm = new Random();
                boolean val = rm.nextBoolean();
                if(val){arr[i][j] = 1;}else{arr[i][j] = 0;}
            }
        }
        for(int i=00;i<50;i++){
            for(int j=180;j<200;j++){
                Random rm = new Random();
                boolean val = rm.nextBoolean();
                if(val){arr[i][j] = 1;}else{arr[i][j] = 0;}
            }
        }

        gp.repaint();
       evolve();
    }

    public void evolve(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(arr[i][j]==1)
                {
                    gp.setColor(i, j, Color.black);
                }
                else
                {
                    gp.setColor(i, j,Color.white);
                }
            }
        }
        gp.repaint();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            generation();
    }

    public void generation()
    {
        int newarr[][] = new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int cnt = getCntCenter(i,j);
                if(arr[i][j]==0 && cnt==3)
                    newarr[i][j]=1;
                else if(arr[i][j]==1 && (cnt<2 || cnt>3))
                    newarr[i][j] = 0;
                else 
                    newarr[i][j] = arr[i][j];
            }
        }
        arr = newarr;
        this.evolve();
    }
    public int getCntCenter(int x,int y)
    {
        int cnt = 0;
        if(x==0 && y==0)
        {
            cnt += arr[x+1][y];
            cnt += arr[x+1][y+1];
            cnt += arr[x][y+1];
        }
        else if(x==0 && y==size-1)
        {
            cnt += arr[x+1][y];
            cnt += arr[x][y-1];
            cnt += arr[x+1][y-1];
        }
        else if(x==size-1 && y==size-1)
        {
            cnt += arr[x-1][y];
            cnt += arr[x-1][y-1];
            cnt += arr[x][y-1];
        }
        else if(x==size-1 && y==0)
        {
            cnt += arr[x-1][y];
            cnt += arr[x-1][y+1];
            cnt += arr[x][y+1];
        }
        else if(x==0)
        {
            cnt += arr[x][y-1];
            cnt += arr[x+1][y-1];
            cnt += arr[x+1][y];
            cnt += arr[x+1][y+1];
            cnt += arr[x][y+1];
        }
        else if(y==0)
        {
            cnt += arr[x-1][y];
            cnt += arr[x-1][y+1];
            cnt += arr[x][y+1];
            cnt += arr[x+1][y+1];
            cnt += arr[x+1][y];
        }
        else if(x==size-1)
        {
            cnt += arr[x][y-1];
            cnt += arr[x-1][y-1];
            cnt += arr[x-1][y];
            cnt += arr[x-1][y+1];
            cnt += arr[x][y+1];
        }
        else if(y==size-1)
        {
            cnt += arr[x-1][y];
            cnt += arr[x-1][y-1];
            cnt += arr[x][y-1];
            cnt += arr[x+1][y-1];
            cnt += arr[x+1][y];
        }
        else 
        {
            cnt += arr[x+1][y];
            cnt += arr[x+1][y+1];
            cnt += arr[x][y+1];
            cnt += arr[x-1][y-1];
            cnt += arr[x][y-1];
            cnt += arr[x+1][y-1];
            cnt += arr[x-1][y+1];
            cnt += arr[x-1][y];
        }
        return cnt;
    }
}
