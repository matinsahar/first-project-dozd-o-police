import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" this is a game where in a matrix of dimensions m*n there are a number of cops trying to catch a thief " +
                "and every 2.5 seconds that goes by cops and the thief move or stay in their place\n according to the rules. the game ends if: \n" +
                "1: the thief goes to the last position of one of the polices , which is shown by 'o' in map \n" +
                "2: one of the cops goes to the current position of the thief , which is shown by '*' in map \n to start the game enter the dimensions and the number of cops in this order : 1-m 2-n 3-number of cops \n" +
                "have fun !!! ");
        int m = scan.nextInt();
        int n = scan.nextInt();
        int num = scan.nextInt();
        int DozdTotalmoves = 0;
        int PolTotalmoves = 0;
        Dozd d = new Dozd(m, n);
        Police[] polices = new Police[num];

        for (int i = 0; i < num; i++) {
            polices[i] = new Police(m, n, num, d );
            polices[i].setPolices(polices);
        }
        Zamin zamin = new Zamin(m, n, num, polices,d);
        zamin.Print();
        for (int i = 0; i < num; i++) {
            polices[i].setZamin(zamin);
        }
        boolean t = false;
        boolean same = false;
        boolean lastpos = false ;
        while ( !t ) {
            d.move();
            DozdTotalmoves++;
            zamin.SetPos(d.getX() , d.getY() , 'D');
            if(d.getLastx() != d.getX() || d.getLasty() != d.getY())
                zamin.SetPos(d.getLastx() , d.getLasty() , '-');
            for (int i = 0; i < num; i++) {
                if (polices[i].getLastx() == d.getX() && polices[i].getY() == d.getY()) {
                    t = true;
                    lastpos = true;
                    break;
                }
                else
                    polices[i].notifyall();
            }
            for (int i = 0; i < num; i++) {
                polices[i].move();
                polices[i].setPolices(polices);
                zamin.SetPos(polices[i].getX() , polices[i].getY() , 'P');
                if (polices[i].getLastx() != polices[i].getX() || polices[i].getLasty() != polices[i].getY())
                    zamin.SetPos(polices[i].getLastx() , polices[i].getLasty() , '-');
            }
            PolTotalmoves += num;
            for (int i = 0; i < num && !t; i++) {
                if (polices[i].getY() == d.getY() && polices[i].getX() == d.getX()) {
                    zamin.SetPos(d.getX(), d.getY(), '*');
                    same = true;
                    t = true;
                    break;
                }
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            if(same)
            {
                zamin.clrscr();
                System.out.println( " cops catch The Dozd by going to his current position and Game over ");
                zamin.Print();
                System.out.println("# Dozd's total number of moves = " + DozdTotalmoves);
                System.out.println("# Polices total number of moves = " + PolTotalmoves);
            }
            else if (lastpos)
            {
                zamin.SetPos(d.getX() , d.getY() , 'o');
                zamin.clrscr();
                System.out.println( " Dozd Went to the last position of one of the cops and Game Over");
                zamin.Print();
                System.out.println("# Dozd's total number of moves = " + DozdTotalmoves);
                System.out.println("# Polices total number of moves = " + PolTotalmoves);
            }
            else
            {
                zamin.clrscr();
                zamin.Print();
            }

        }

    }
}
