package bases.physics;

import bases.Vector2D;

public class BoxCollieder {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollieder(float width, float height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left() {
        return position.x - width / 2;
    }

    public float right() {
        return position.x + width / 2;
    }

    public float top() {
        return position.y - height / 2;
    }

    public float bottom() {
        return position.y + height / 2;
    }

    public boolean collideWith(BoxCollieder other) {
        return (this.right() >= other.left() &&
                this.left() <= other.right() &&
                this.bottom() >= other.top() &&
                this.top() <= other.bottom());
    }

}
