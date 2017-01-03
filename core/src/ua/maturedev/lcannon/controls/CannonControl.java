package ua.maturedev.lcannon.controls;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import ua.maturedev.lcannon.model.Cannon;

public class CannonControl extends InputAdapter {

    private Cannon cannon;

    public CannonControl(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    public boolean keyDown(final int keycode) {
        if (keycode == Input.Keys.LEFT) {
            cannon.left();
            return true;
        } else if (keycode == Input.Keys.RIGHT) {
            cannon.right();
            return true;
        }
        return false;
    }
}
