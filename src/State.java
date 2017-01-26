package com.baliyaan.android.FSM;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Pulkit Singh on 1/26/2017.
 */

public class State {
    String mName;
    ArrayList<Transition> mTransitions = new ArrayList<>();

    public State(String name){
        mName = name;
    }

    public String getName(){
        return mName;
    }

    public State setName(String name){
        mName = name;
        return this;
    }

    /*
    * In that case of ambiguous transitions, only one of them will be considered.
     */
    protected State transit(Bundle data) {
        State nextState = this;
        int nbrTransitions = mTransitions.size();
        for(int i=0;i<nbrTransitions;i++)
        {
            nextState = mTransitions.get(i).tryTransition(data);
            if(nextState!=null)
                break;
        }
        return nextState;
    }

    /*
    * Warning: Do not add ambiguous transitions.
    *          In that case, only one of them will be considered.
     */
    public State addTransition(Transition transition){
        if(transition!=null)
            mTransitions.add(transition);
        return this;
    }

    public State removeTransition(Transition transition)
    {
        if(null!=null)
            mTransitions.remove(transition);
        return this;
    }
}
