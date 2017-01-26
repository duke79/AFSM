package com.baliyaan.android.FSM;

import android.os.Bundle;

public class Transition {

    private String mName;
    private State mTargetState;
    private Action mAction;
    private Condition mCondition;

    public Transition(String nameTransition,String statename){
        mName = nameTransition;
        State state = FSM.getState(statename);
        mTargetState = state;
    }

    public Transition(String startStateName, String nameTransition,String targetStateName){
        mName = nameTransition;

        State targetState = FSM.getState(targetStateName);
        mTargetState = targetState;

        FSM.getState(startStateName).addTransition(this);
    }

    protected State tryTransition(final Bundle data) {
        if(mCondition==null || mCondition.isGo(data))
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mAction.run(data);
                }
            }).start();
            return mTargetState;
        }
        return null;
    }

    public Transition setAction(Action action){
        mAction = action;
        return this;
    }

    public Transition setCondition(Condition condition){
        mCondition = condition;
        return this;
    }

    public Transition setTargetState(State state){
        mTargetState = state;
        return this;
    }
}
