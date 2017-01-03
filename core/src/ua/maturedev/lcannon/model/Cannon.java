package ua.maturedev.lcannon.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Cannon {

    private final Texture txt;
    private float x;
    private float y;

    public Cannon(Texture txt) {
        this.txt = txt;
        this.x = (Gdx.graphics.getWidth() / 2) - txt.getWidth();
        this.y = .0f;
    }

    public Texture texture() {
        return txt;
    }

    public void right() {
        x += 5;
    }

    public void left() {
        x -= 5;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }
}
