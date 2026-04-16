package ressources;

import java.awt.image.BufferedImage;

public class Car {

    public int x;
    public int y;
    public double geschwindigkeit;
    public int lap;
    public double rotCar;

    public BufferedImage carI;

    public double MAX_SPEED = 10;
    public double MIN_SPEED = -5;
    public double ACCELERATION = 0.5;
    public double FRICTION = 0.999999;

    public Car(int x, int y, BufferedImage carI) {
        this.x = x;
        this.y = y;
        this.carI = carI;
        this.rotCar = 0;
        this.geschwindigkeit = 0;
        this.lap = 0;
    }

    public void Steigung(String richtung) {

        if (richtung.equals("Oben")) {
            geschwindigkeit += ACCELERATION;
        }

        if (richtung.equals("Unten")) {
            geschwindigkeit -= ACCELERATION;
        }

        // limit speed
        if (geschwindigkeit > MAX_SPEED) {
            geschwindigkeit = MAX_SPEED;
        }

        if (geschwindigkeit < MIN_SPEED) {
            geschwindigkeit = MIN_SPEED;
        }
    }

    public void movement(double rot) {
        // reduce speed slightly when turning sharply
        if (Math.abs(rot - rotCar) > 0.2) {
            geschwindigkeit *= 0.98;
        }

        // movement
        x += (int) (Math.cos(rot) * geschwindigkeit);
        y += (int) (Math.sin(rot) * geschwindigkeit);

        // friction
        geschwindigkeit *= FRICTION;

        // debug output
        System.out.println("x: " + x + " y: " + y);
        System.out.println("Geschwindigkeit: " + geschwindigkeit);
        System.out.println("Rotation: " + rot);

        rotCar = rot;
    }
}