package com.baliyaan.android.FSM;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pulkit Singh on 1/26/2017.
 */

public class FSM {
    //private static State mRootState;
    private static State mCurrentState;
    private static HashMap<String,State> states = new HashMap<>();

    /*
    * The first state added to FSM is considered the root(starting) state.
     */
    public static FSM addStates(String[] states){
        for(int i=0;i<states.length;i++)
        {
            addState(states[i]);
        }
        return null;
    }

    /*
    * The first state added to FSM is considered the root(starting) state.
     */
    public static FSM addState(String stateName)
    {
        State state = new State(stateName);
        states.put(stateName,state);

        if(mCurrentState==null && states.size()==1)  // First state to be considered the root state.
            mCurrentState = state;

        return null;
    }

    public static State getState(String name){
        return states.get(name);
    }

    /*
    public static FSM addRootState(String name){
        if(name.equals(""))
            name="Root";
        State state = new State(name);
        setCurrentState(state);
        return null;
    }*/

    public static State getCurrentState(){
        return mCurrentState;
    }

    public static FSM setCurrentState (State state){
        mCurrentState = state;
        return null; // for chaining
    }

    /*
    * In that case of ambiguous transitions, only one of them will be considered.
     */
    public static FSM transit(Bundle data){
        if(mCurrentState==null)return null;
        State state = mCurrentState.transit(data);
        if(state!=null)
            mCurrentState = state;
        return null;
    }

    public static ArrayList<State> getAllStates(){
        return (ArrayList<State>) states.values();
    }

    public static ArrayList<String> getAllStatesNames(){
        return (ArrayList<String>) states.keySet();
    }
}
