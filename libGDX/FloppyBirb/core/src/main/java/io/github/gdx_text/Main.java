package io.github.gdx_text;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class Main extends ApplicationAdapter {
    private Screen currentScreen;

    @Override
    public void create() {
        setScreen(new PantallaPrincipal());
    }

    @Override
    public void render() {
        if (currentScreen != null) {
            currentScreen.render(Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void dispose() {
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        if (currentScreen != null) {
            currentScreen.resize(width, height);
        }
    }

    @Override
    public void pause() {
        if (currentScreen != null) {
            currentScreen.pause();
        }
    }

    @Override
    public void resume() {
        if (currentScreen != null) {
            currentScreen.resume();
        }
    }

    // Para cambiar la pantalla actual del juego
    public void setScreen(Screen screen) {
        if (this.currentScreen != null) {
            this.currentScreen.hide();
            this.currentScreen.dispose();
        }
        this.currentScreen = screen;
        if (this.currentScreen != null) {
            this.currentScreen.show();
            this.currentScreen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public Screen getScreen() {
        return currentScreen;
    }
}
