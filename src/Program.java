import java.util.ArrayList;
import java.util.Vector;

public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.gameLoop();
//  eger> numbers = new bases.Vector2D<>(); // bases.Vector2D<GameObject>
//        numbers.add(1);
//        numbers.add(12);
//        numbers.add(-156);
//        for (Integer number : numbers) {
//            System.out.println(number);
//            numbers.add(2);
//        }

//        bases.Vector2D v = new bases.Vector2D(1,5);
//        bases.Vector2D v2 = new bases.Vector2D(1,1);
//        v.print();
//        v.set(10,-1);
//        v.print();
//        v.addUp(1,2);
//        v.print();
//        v.addUp(v2);
//        bases.Vector2D v7 = v.subtract(v2);
//        bases.Vector2D v8 = v.subtract(1,2);
//        v7.subtractBy(1,2);
//        v7.subtractBy(v);
//        v.print();
//        bases.Vector2D v3 = v2.add(10,5);
//        v3.print();
//        bases.Vector2D v4 = v2.add(v);
//        v4.print();
//        bases.Vector2D v5 = v2.multiply(1.5f);
//        v5.print();
//        v2.length();

        Rect A = new Rect(1,1,3,3);
        Rect B = new Rect(2,2,4,4);
        if (Rect.overLap(A,B)) System.out.printf("ok");
        else System.out.printf("no");




    }
}
