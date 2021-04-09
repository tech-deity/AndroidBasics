Some device configurations can change during runtime (such as screen orientation, keyboard availability, and when the user enables multi-window mode). When such a change occurs, Android restarts the running Activity ( onDestroy() is called, followed by onCreate()). 

The restart behavior is designed to help your application adapt to new configurations by automatically reloading your application with alternative resources that match the new device configuration.

it is important that your activity restores its previous state. You can use a combination of onSaveInstanceState(), ViewModel objects, and persistent storage to save and restore the UI state of your activity across configuration changes. For more information on how to save your Activity state, read Saving UI States.


**configuration changes (such as changing the screen orientation) while performing various tasks in your application. Your application should be able to restart at any time without loss of user data or state in order to handle events such as configuration changes or when the user receives an incoming phone call and then returns to your application much later after your application process may have been destroyed.**

<h3> Retaining an object during a configuration change </h3>

alleviate the burden of reinitializing part of your activity by using a ViewModel object.
ViewModels are preserved across configuration changes so they are the perfect place to keep your UI data without having to query them again.

<h3>Handling the configuration change yourself </h3>

TO  Declare that your activity handles a configuration change edit he appropriate <Activity> element in your menifest file to include android : configChanges attribute with a value that represents the configuration you want to handle values are listed in the documentation for the android:configChange attribute the most commonly used values are orientations , screenSize screenLayout and keyboardHidden  
 
 
 example 
  
  <activity android:name=".MyActivity"
          android:configChanges="orientation|screenSize|screenLayout|keyboardHidden"
          android:label="@string/app_name">
          
          
Now, when one of these configurations change, MyActivity does not restart. Instead, the MyActivity receives a call to onConfigurationChanged(). This method is passed a Configuration object that specifies the new device configuration
override fun onConfigurationChanged(newConfig: Configuration) {
    super.onConfigurationChanged(newConfig)

    // Checks the orientation of the screen
    if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
        Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
    } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
        Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
    }
}
 
