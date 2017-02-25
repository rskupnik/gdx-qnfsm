package com.github.rskupnik.gdxqnfsm;

import com.badlogic.gdx.Game;
import com.github.rskupnik.gdxqnfsm.fsms.FSMID;
import com.github.rskupnik.gdxqnfsm.fsms.engine.EngineFSM;
import com.github.rskupnik.gdxqnfsm.fsms.logic.LogicFSM;
import com.github.rskupnik.gdxqnfsm.fsms.messages.Dispose;
import com.github.rskupnik.gdxqnfsm.fsms.messages.DrawBadlogicLogo;
import com.github.rskupnik.gdxqnfsm.fsms.messages.Render;
import com.github.rskupnik.jqnfsm.implementation.*;

public class Test extends Game {

    private Coordinator coordinator;

    @Override
    public void create() {
        coordinator = new Coordinator();    // Create a new Coordinator to interact with the jqnfsm
        LTEAPI.setCoordinator(coordinator); // Inform the LTEAPI about the Coordinator

        /**
         * Create a node on the main thread that will run the EngineFSM implementation
         * identifier as ENGINE. This FSM will execute all the rendering code, which is
         * why we have to run it on the main thread which has the OpenGL context.
         */
        coordinator.createNodeOnMainThread(FSMID.ENGINE, new EngineFSM());

        /**
         * The LogicFSM identifier as LOGIC can have a separate Thread to run it.
         */
        coordinator.createNode(FSMID.LOGIC, new LogicFSM());

        // Send a DrawBadlogicLogo Message to our LogicFSM
        coordinator.sendMessage(new DrawBadlogicLogo(), FSMID.LOGIC);
    }

    @Override
    public void render() {
        // Send a Render Message directly to our EngineFSM to make it run the render loop
        coordinator.sendMessage(new Render(), FSMID.ENGINE);

        // Because EngineFSM is ran on the main thread, we need to "tick" it manually
        coordinator.tickMainThreadNode();
    }

    @Override
    public void dispose() {
        coordinator.sendMessage(new Dispose(), FSMID.ENGINE);
        coordinator.tickMainThreadNode();
    }
}
