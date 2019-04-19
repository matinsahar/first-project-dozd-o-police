import java.util.*;
import java.util.Random;
public class Police {
    private int x , y , lastx = -1 , lasty = -1;
    private int m,n;
    public int status = 0; // 0 for not seen
    private int num ;
    private Police [] polices = new Police[num];
    Dozd d ;
    private Zamin zamin;

    public void setZamin(Zamin zamin) {
        this.zamin = zamin;
    }

    public Police(int m , int n , int num , Dozd d ){
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
            boolean check = false;
            lastx = x;
            lasty = y;
            while ( !check ) {
                Random random = new Random();
                x = random.nextInt(3 ) + lastx - 1;;
                if( x == -1)
                    x++;
                if(x == m)
                    x--;
                y = random.nextInt(3 ) + lasty - 1;
                if( y == -1)
                    y++;
                if(y == n)
                    y--;
                if(zamin.getZamin()[x][y] != 'P'){
                    check = true ;
                    break;
                }
            }
        }
        else //agar polica dozd ro bebinan
        {
            lastx =x;
            lasty = y;
            int xdoz = d.getLastx();
            int ydoz = d.getLasty();
            boolean check = false;
            while (!check){
                if( x < xdoz && y<ydoz && zamin.getZamin()[x+1][y+1] != 'P' ){
                    x ++;
                    y++;
                    check = true;
                    break;
                }

                else if( x == xdoz && y < ydoz && zamin.getZamin()[x][y+1] != 'P'){
                    x=x;
                    y++;
                    check = true;
                    break;
                }
                else if( x > xdoz && y < ydoz && zamin.getZamin()[x-1][y+1] != 'P'){
                    x--;
                    y++;
                    check = true;
                    break;
                }

                else if(y == ydoz && x < xdoz && zamin.getZamin()[x+1][y] != 'P'){
                    x++;
                    y=y;
                    check = true;
                    break;
                }

                else if( y == ydoz && x == xdoz){
                    check = true;
                    break;
                }
                else if( y == ydoz && x > xdoz && zamin.getZamin()[x-1][y] != 'P'){
                    x--;
                    check = true;
                    break;
                }
                else if( y > ydoz && x < xdoz && zamin.getZamin()[x+1][y-1] != 'P'){
                    y--;
                    x++;
                    check = true;
                    break;
                }
                else if( y > ydoz && x == xdoz && zamin.getZamin()[x][y-1] != 'P'){
                    y--;
                    check = true;
                    break;
                }
                else if( y > ydoz && x > xdoz && zamin.getZamin()[x-1][y-1] != 'P'){
                    y--;
                    x--;
                    check = true;
                    break;
                }
                else {
                    check = true;
                    break;
                }

            }

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
