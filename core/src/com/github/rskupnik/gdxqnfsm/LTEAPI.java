package com.github.rskupnik.gdxqnfsm;

import com.github.rskupnik.gdxqnfsm.fsms.FSMID;
import com.github.rskupnik.gdxqnfsm.fsms.messages.DrawBadlogicLogo;
import com.github.rskupnik.jqnfsm.implementation.Coordinator;
import com.github.rskupnik.jqnfsm.implementation.FiniteStateMachine;

/**
 * Logic-to-Engine API.
 * Provides methods to allow the logicFSM to communicate with the engineFSM in a structured way.
 */
public class LTEAPI {

    private static FiniteStateMachine engineFSM, logicFSM;
    private static Coordinator coordinator;

    public static void setEngineFSM(FiniteStateMachine val) {
        engineFSM = val;
    }

    public static void setLogicFSM(FiniteStateMachine val) {
        logicFSM = val;
    }

    public static void setCoordinator(Coordinator val) {
        coordinator = val;
    }

    /* This is where our API methods start. In this example, only one is provided. */

    /**
     * Makes the game display a Badlogic Logo by sending a DrawBadlogicLogo Message to the EngineFSM
     */
    public static void displayBadlogicLogo() {
        coordinator.sendMessage(new DrawBadlogicLogo(), FSMID.ENGINE);
    }
}
