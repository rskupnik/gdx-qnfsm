package com.github.rskupnik.gdxqnfsm.fsms.logic;

import com.github.rskupnik.gdxqnfsm.LTEAPI;
import com.github.rskupnik.jqnfsm.implementation.FiniteStateMachine;
import com.github.rskupnik.jqnfsm.implementation.Message;

public class LogicFSM extends FiniteStateMachine {

    @Override
    protected void parseInput(Message message) {
        switch (message.getId()) {
            case 1:
                LTEAPI.displayBadlogicLogo();
                break;
        }
    }
}
