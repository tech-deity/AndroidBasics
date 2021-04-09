Some device configurations can change during runtime (such as screen orientation, keyboard availability, and when the user enables multi-window mode). When such a change occurs, Android restarts the running Activity ( onDestroy() is called, followed by onCreate()). 

The restart behavior is designed to help your application adapt to new configurations by automatically reloading your application with alternative resources that match the new device configuration.

it is important that your activity restores its previous state. You can use a combination of onSaveInstanceState(), ViewModel objects, and persistent storage to save and restore the UI state of your activity across configuration changes. For more information on how to save your Activity state, read Saving UI States.


**configuration changes (such as changing the screen orientation) while performing various tasks in your application. Your application should be able to restart at any time without loss of user data or state in order to handle events such as configuration changes or when the user receives an incoming phone call and then returns to your application much later after your application process may have been destroyed.**
