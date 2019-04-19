import java.util.*;
import java.util.Random;
public class Police {
    private int x , y , lastx = -1 , lasty = -1;
    private int m,n;
    public int status = 0; // 0 for not seen
    private int num ;
    private Police [] polices = new Police[num];
    Dozd d ;
    public Police( int m , int n , int num , Dozd d ){
        this.m = m;
        this.n = n;
        this.num = num;
        this.d = d;
    }

    public void setLastx(int lastx) {
        this.lastx = lastx;
    }

    public void setLasty(int lasty) {
        this.lasty = lasty;
    }

    public void setPolices(Police[] polices) {
        this.polices = polices;
    }

    public void move( ){

        if( status == 0)
        {
            Random random = new Random();
            lastx = x;
            lasty = y;
            x = random.nextInt(3 ) + x - 1;;
            if( x == -1)
                x++;
            if(x == m)
                x--;
            y = random.nextInt(3 ) + y - 1;
            if( y == -1)
                y++;
            if(y == n)
                y--;
        }
        else
        {

            lastx =x;
            lasty = y;
            int xdoz = d.getLastx();
            int ydoz = d.getLasty();
            if( x < xdoz && x < m)
                x ++;
            else if( x == xdoz)
                x=x;
            else if( x != 0)
                x--;
            if(y < ydoz && y < n)
                y++;
            else if( y == ydoz)
                y=y;
            else if( y != 0)
                y--;
        }
    }

    public void notifyall(){
       for (int i = 0 ; i < num ; i++){
           int xpol = polices [i].getX();
           int ypol = polices [i].getY();
           int xdoz = d.getX();
           int ydoz = d.getY();
           if( (xpol - xdoz)*(xpol - xdoz) + (ypol - ydoz)*(ypol - ydoz) < 9 ){
               status = 1;
               break;
           }
       }


    }


    public int getLastx() {
        return lastx;
    }

    public int getLasty() {
        return lasty;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
