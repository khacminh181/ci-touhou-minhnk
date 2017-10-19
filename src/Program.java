import java.util.ArrayList;
import java.util.Vector;

public class Program {
    public static void main(String[] args) {
//        GameWindow gameWindow = new GameWindow();
//        gameWindow.gameLoop();


//        Vector2D<Integer> numbers = new Vector2D<>(); // Vector2D<GameObject>
//        numbers.add(1);
//        numbers.add(12);
//        numbers.add(-156);
//        for (Integer number : numbers) {
//            System.out.println(number);
//            numbers.add(2);
//        }

        Vector2D v = new Vector2D(1,5);
        Vector2D v2 = new Vector2D(1,1);
        v.print();
        v.set(10,-1);
        v.print();
        v.addUp(1,2);
        v.print();
        v.addUp(v2);
        Vector2D v7 = v.subtract(v2);
        Vector2D v8 = v.subtract(1,2);
        v7.subtractBy(1,2);
        v7.subtractBy(v);
        v.print();
        Vector2D v3 = v2.add(10,5);
        v3.print();
        Vector2D v4 = v2.add(v);
        v4.print();
        Vector2D v5 = v2.multiply(1.5f);
        v5.print();
        v2.length();
    }
}
