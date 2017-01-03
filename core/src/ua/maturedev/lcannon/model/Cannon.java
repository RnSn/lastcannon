package ua.maturedev.lcannon.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Cannon {

    private final Texture txt;
    private float x;
    private float y;
    private boolean leftMotion;
    private boolean rightMotion;

    public Cannon(Texture txt) {
        this.txt = txt;
        this.x = (Gdx.graphics.getWidth() / 2) - txt.getWidth();
        this.y = .0f;
    }

    public Texture texture() {
        return txt;
    }

    private void updateX() {
        if (leftMotion) {
            x -= 30 * Gdx.graphics.getDeltaTime();
        } else if (rightMotion) {
            x += 30 * Gdx.graphics.getDeltaTime();
        }
    }

    public void right() {
        rightMotion = true;
        leftMotion = false;
    }

    public void left() {
        rightMotion = false;
        leftMotion = true;
    }

    public void stopHorizontal() {
        rightMotion = leftMotion = false;
    }

    public float x() {
        updateX();
        return x;
    }

    public float y() {
        return y;
    }
}
