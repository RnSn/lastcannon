package ua.maturedev.lcannon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedList;
import java.util.List;
import ua.maturedev.lcannon.controls.CannonControl;
import ua.maturedev.lcannon.model.Cannon;

public class LastCannonGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private List<Texture> enemies;
    private int xOffset;
    private Cannon cannon;
    private Texture bomb;


    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 720);

        cannon = new Cannon(new Texture("gun_01.png"));

        Gdx.input.setInputProcessor(new CannonControl(cannon));

        batch = new SpriteBatch();
        bomb = new Texture("bomb_01.png");
        enemies = new LinkedList<>();
        enemies.add(new Texture("enemies/landing_party_01.png"));
        enemies.add(new Texture("enemies/landing_party_02.png"));
        enemies.add(new Texture("enemies/plane-bomber.png"));
        enemies.add(new Texture("enemies/plane-destroyer.png"));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        int windowHeight = Gdx.graphics.getHeight();
        int windowWidth = Gdx.graphics.getWidth();
        enemies.forEach(t -> {
            batch.draw(t, xOffset, windowHeight - t.getHeight());
            xOffset += t.getWidth() + 10;
        });

        batch.draw(cannon.texture(), cannon.x(), cannon.y());
        batch.draw(bomb, (windowWidth / 2) - cannon.texture().getWidth(),
            cannon.texture().getHeight() + 10);

        xOffset = 0;
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        enemies.forEach(Texture::dispose);
    }
}
