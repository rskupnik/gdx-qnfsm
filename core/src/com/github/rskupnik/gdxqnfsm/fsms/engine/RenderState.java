package com.github.rskupnik.gdxqnfsm.fsms.engine;

import com.github.rskupnik.jqnfsm.implementation.FiniteStateMachine;
import com.github.rskupnik.jqnfsm.implementation.State;

public class RenderState extends State {

    public RenderState(FiniteStateMachine fsm) {
        super(fsm);
    }

    @Override
    public String getId() {
        return "RenderState";
    }

    @Override
    public void update() {
        ((EngineFSM) getFsm()).render();
    }
}
