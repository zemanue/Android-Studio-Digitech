package io.github.gdx_text.input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input;

import io.github.gdx_text.actors.FloppyBirb;

public class FloppyBirbInputProcessor implements InputProcessor {
    private FloppyBirb floppyBirb;
    public boolean moveUp = false;
    public boolean moveDown = false;
    public boolean moveLeft = false;
    public boolean moveRight = false;

    public FloppyBirbInputProcessor(FloppyBirb floppyBirb) {
        this.floppyBirb = floppyBirb;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) {
            moveUp = true;
            return true;
        }
        if (keycode == Input.Keys.S) {
            moveDown = true;
            return true;
        }
        if (keycode == Input.Keys.A) {
            moveLeft = true;
            return true;
        }
        if (keycode == Input.Keys.D) {
            moveRight = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W) {
            moveUp = false;
            return true;
        }
        if (keycode == Input.Keys.S) {
            moveDown = false;
            return true;
        }
        if (keycode == Input.Keys.A) {
            moveLeft = false;
            return true;
        }
        if (keycode == Input.Keys.D) {
            moveRight = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
