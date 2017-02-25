package com.github.rskupnik.gdxqnfsm.fsms.engine;

import com.badlogic.gdx.graphics.Texture;
import com.github.rskupnik.jqnfsm.implementation.FiniteStateMachine;
import com.github.rskupnik.jqnfsm.implementation.State;

public class SetLogoState extends State {

    public SetLogoState(FiniteStateMachine fsm) {
        super(fsm);
    }

    @Override
    public String getId() {
        return "SetLogoState";
    }

    @Override
    public void update() {
        ((EngineFSM) getFsm()).img = new Texture("badlogic.jpg");
        getFsm().setState(new RenderState(getFsm()));
    }
}
