package com.github.rskupnik.gdxqnfsm.fsms.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.rskupnik.jqnfsm.implementation.FiniteStateMachine;
import com.github.rskupnik.jqnfsm.implementation.Message;

public class EngineFSM extends FiniteStateMachine {

    SpriteBatch batch = new SpriteBatch();
    Texture img;

    @Override
    protected void parseInput(Message message) {
        System.out.println("Engine received message: "+message.getId());
        switch (message.getId()) {
            case 0:
                setState(new RenderState(this));
                break;
            case 1:
                setState(new SetLogoState(this));
                break;
            case 2:
                dispose();
                break;
        }
    }

    void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (img != null)
            batch.draw(img, 0, 0);
        batch.end();
    }


    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
