import java.util.*;

public class Zamin  {
    private int m , n , num;
    private char zamin [][];

    public char[][] getZamin() {
        return zamin;
    }

    public Zamin (int m , int n , int num) {
        m = this.m;
        n = this.n;
        num = this.num;
        zamin = new char[m][n];
        Police polices [] = new Police [num];
        Dozd d = new Dozd(m , n);

        for (int i = 0; i < num + 1; )
        {
            int x = (int) Math.floor( Math.random() * m);
            int y = (int) Math.floor( Math.random() * n);
            if( zamin[x][y] != 'P' && zamin[x][y] !='D' && i < num){
                zamin [x][y] = 'P';
                polices [i].setX() =  x;
                polices [i].setY() = y;
                i++;
            }

            else if ( zamin[x][y] != 'P' && zamin[x][y] !='D' && i < num){
                zamin [x][y] = 'D';
                d.setX(x);
                d.setY(y);
                i++;
            }
            else
            {
                x = (int) Math.floor( Math.random() * m);
                y = (int) Math.floor( Math.random() * n);
            }
        }
    }
    public void Print ( ){
        for( int i = 0 ; i < m ; i++ ){
            for (int j = 0 ; j < n ; j++){
                if (zamin [i][j] != 'D' && zamin[i][j] != 'P') {
                    if (i != m - 1)
                        System.out.print('-');
                    else
                        System.out.println('-');
                }
                else if( i != m-1)
                    System.out.print( zamin[i][j] );
                else
                    System.out.println( zamin[i][j] );
                }
            }
        }
        public void SetPos (int x , int y , char c){ zamin [x][y] = c;}
    }


