import java.util.*;
import java.io.IOException;
import static java.lang.System.out;

public class Zamin  {
    private int m , n , num;
    private char zamin [][];
    private Police polices [] = new Police [num];
    Dozd d;
    public char[][] getZamin() {
        return zamin;
    }

    public Zamin (int m , int n , int num , Police [] polices , Dozd d) {
        this.m = m;
        this.n = n;
        this.num = num;
        this.polices = polices;
        zamin = new char[m + 1][n + 1];
        this.d = d;

        for (int i = 0; i < num + 1; )
        {
            Random random = new Random();
            int x = random.nextInt(m );
            int y = random.nextInt(n );;
            if( zamin[x][y] != 'P' && zamin[x][y] !='D' && i < num){
                zamin [x][y] = 'P';
                polices [i].setX(x) ;
                polices [i].setY(y) ;
                polices [i].setLastx(x);
                polices [i].setLasty(y);
                i++;
            }

            else if ( zamin[x][y] != 'P' && i == num){
                zamin [x][y] = 'D';
                d.setX(x);
                d.setY(y);
                d.setLastx(x);
                d.setLasty(x);
                i++;
            }
            else
            {
                 x = random.nextInt(m );
                 y = random.nextInt(n );
            }
        }
    }
    public void Print ( ) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zamin[i][j] == 'D' || zamin[i][j] == 'P' || zamin[i][j] == '*' || zamin[i][j] == 'o')
                    System.out.print(zamin[i][j] + " ");
                else
                    out.print('-' + " ");
            }
                System.out.println();
            }
        }


        public void SetPos (int x , int y , char c){ this.zamin [x][y] = c;}

    public void clrscr(){
        try {

              if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
                	      Runtime.getRuntime().exec("cls");
                  } else {
                        Runtime.getRuntime().exec("clear");
                	  }


            	} catch (IOException e) {

            	  for(int i = 0; i < 10; i++) {
                	    System.out.println();
                  }

            }

    }
    }


