import java.util.*;

public class Dozd {
    private int x , y , lastx , lasty;
    private int m,n;

    public void setLastx(int lastx) {
        this.lastx = lastx;
    }

    public void setLasty(int lasty) {
        this.lasty = lasty;
    }

    public Dozd(int m , int n ){
        this.m = m;
        this.n = n;
    }
    public void move(){
        Random random = new Random();
        lastx = x;
        lasty = y;
        x = random.nextInt(3 ) + x - 1;
        if( x == -1)
            x++;
        if(x == m)
            x--;
        random = new Random();
        y = random.nextInt(3 ) + y - 1;
        if( y == -1)
            y++;
        if(y == n)
            y--;
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

    public int getLastx() {
        return lastx;
    }

    public int getLasty() {
        return lasty;
    }

    public void setY(int y) {
        this.y = y;
    }
}
