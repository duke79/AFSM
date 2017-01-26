# AFSM
AFSM - Simple 'Finite State Machine in Java', built for Android.

Example:
```java
FSM.addStates(new String[]{
                "Root","LoginPrompt","SearchResults"
        });

new Transition("Root","","LoginPrompt")
        .setAction(new Action() {
            @Override
            public void run(Bundle data) {
                setupLoginFragment();
                setupVideoListFragment();
            }
        });

new Transition("LoginPrompt","","SearchResults")
        .setAction(new Action() {
            @Override
            public void run(Bundle data) {
                String query = "";
                if(data!=null)
                    query = data.getString("query");
                StartSearch(query);
            }
        });

new Transition("SearchResults","","LoginPrompt")
        .setAction(new Action() {
            @Override
            public void run(Bundle data) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();

                if (mLoginFragment != null)
                    transaction.remove(mSearchResultsFragment);
                transaction.add(R.id.LoginFragmentContainer, mLoginFragment);
                transaction.add(R.id.VideoListFragmentContainer, mVideoListFragment);
                transaction.commit();
            }
        })
        .setCondition(new Condition() {
            @Override
            public boolean isGo(Bundle data) {
                if(data!=null) {
                    if(data.getBoolean("backPressed"))
                        return true;
                }
                return false;
            }
        });

        FSM.transit(null);
````
