public class Rect {
    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public Rect(int x1, int y1, int x2 ,int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static boolean overLap(Rect A, Rect B) {
        return (A.x1 < B.x2 && A.x2 > B.x1 && A.y1 < B.y2 && A.y2 > B.y1);
    }
}
