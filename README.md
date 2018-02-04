# AFSM
AFSM - Simple 'Finite State Machine in Java', built for Android.

### Example:
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

Usage

* **Option 1:** AAR
  * Get [.aar release](https://github.com/duke79/AFSM/releases).
* **Option 2:** [JITPACK](https://jitpack.io/#duke79/AFSM/0.0.2) *(recommended)*
  
  Step 1. Add the JitPack repository to your build file
  	Add it in your root build.gradle at the end of repositories:
    ```
      allprojects {
      		repositories {
      			...
      			maven { url 'https://jitpack.io' }
      		}
      	}
    ```
  Step 2. Add the dependency
    ```
    dependencies {
	        compile 'com.github.duke79:AFSM:-SNAPSHOT'
	}
    ```
