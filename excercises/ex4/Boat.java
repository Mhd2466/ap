package ap.excercises.ex4;

public class Boat {
    private double x;
    private double y;
    private double direction; //   0 = east

    public Boat() {
        x = 0;
        y = 0;
        direction = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDirection() {
        return direction;
    }

    public void turn(double degrees) {
        direction += degrees;
        direction = direction % 360; // keep it in 0, 360 :)
        if (direction < 0) {
            direction += 360;
        }
    }

    public void move(double distance) {
        double radians = Math.toRadians(direction);
        x += distance * Math.cos(radians);// i dont know if this is what it wants or not but wrote in this form
        y += distance * Math.sin(radians);
    }
}

