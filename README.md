# AFSM
AFSM - Simple 'Finite State Machine in Java', built for Android.

Example:
```java
FSM.addStates(new String[]{
                "Root","SecondState"
        });

new Transition("Root","","SecondState")
        .setAction(new Action() {
            @Override
            public void run(Bundle data) {
                // Do something while going from Root to SecondState
                // Control comes here only if isGo returns true.
            }
        }); // Condition is optional (unless there are more than one transitions from a single state)
        .setCondition(new Condition() {
            @Override
            public boolean isGo(Bundle data) {
                // Put a condition to make this transition 'unique' from "Root"
                boolean condition = ...
                return condition;
            }
        });
        
// Call transit to invoke a transition
// Which transitition happpens, depends upon the "current state" of FSM and "condition check" for the transition.
Bundle data = new Bundle();
data.putString("key1","data1");
FSM.transit(data);
````
