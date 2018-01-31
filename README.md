# CookieCutter

The initial idea of this CookieCutter is to provide a base arquitecture in order to be able to implement
a brand new project using Room and LiveData.

# How the project is structured

- app
- MVVM

As you can see, we offer MVVM to build our application.
This base arquitecture is implemented as a library module and should be included in the application gradle.

MVVM contains:
 - BaseView
 - BaseViewModel
 - BaseActivity
 
 ![alt text](https://github.com/restriglio/CookieCutter/blob/master/ACC.png)

# Room Persistence Library
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

Apps that handle non-trivial amounts of structured data can benefit greatly from persisting that data locally.
The most common use case is to cache relevant pieces of data. That way, when the device cannot access the network,
the user can still browse that content while they are offline. Any user-initiated content changes are then synced to 
the server after the device is back online.

The core framework provides built-in support for working with raw SQL content. Although these APIs are powerful,
they are fairly low-level and require a great deal of time and effort to use:

- There is no compile-time verification of raw SQL queries. As your data graph changes, you need to update the affected SQL
queries manually. This process can be time consuming and error prone.

- You need to use lots of boilerplate code to convert between SQL queries and Java data objects.

Room takes care of these concerns for you while providing an abstraction layer over SQLite.

# LiveData

LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it 
respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures
LiveData only updates app component observers that are in an active lifecycle state.

LiveData considers an observer, which is represented by the Observer class, to be in an active state if its lifecycle is in the STARTED or RESUMED state. LiveData only notifies active observers about updates. Inactive observers registered to watch LiveData objects aren't notified about changes.

You can register an observer paired with an object that implements the LifecycleOwner interface.
This relationship allows the observer to be removed when the state of the corresponding Lifecycle object changes 
to DESTROYED. This is especially useful for activities and fragments because they can safely observe LiveData objects
and not worry about leaks—activities and fragments are instantly unsubscribed when their lifecycles are destroyed.
