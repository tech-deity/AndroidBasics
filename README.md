<h1> AndroidBasics </h1>
<h3>Definition of Android</h3>
Android operating system is multi user linux system in which each app is a different user
<ul>
  <li> Android system assigns each app a unique Linux user ID (the ID is used only by the system and is unknown to the app). The system sets permissions for all the files in an app so that only the user ID assigned to that app can access them.</li>
  <li>Each process has its own virtual machine so an app code runs in isolation from other apps</li>
  <li>Every app run on its own linux process, Android system starts the process when any of the app's components need to be executed, and then shuts down the process when it's no longer needed or when the system must recover memory for other apps.</li>
</ul>

<h4> Android system implements the principle of least privilege </h4>
Each app, by default, has access only to the components that it requires to do its work and no more.

<li> An app can request permission to access device data such as the device's location, camera, and Bluetooth connection. The user has to explicitly grant these permissions</li>

<li> It's possible to arrange for two apps to share the same Linux user ID, in which case they are able to access each other's files. To conserve system resources, apps with the same user ID can also arrange to run in the same Linux process and share the same VM. The apps must also be signed with the same certificate. </li>

<h3> There are four different types of app components: </h3>

<li>Activities </li>
<li> Services </li>
<li> Broadcast receivers </li>
<li> Content providers </li>

<h2> Activities </h2>
An activity is the entry point for interacting with the user. It represents a single screen with a user interface. 
For example, an email app might have one activity that shows a list of new emails, another activity to compose an email, and another activity for reading emails. Although the activities work together to form a cohesive user experience in the email app, each one is independent of the others. As such, a different app can start any one of these activities if the email app allows it. For example, a camera app can start the activity in the email app that composes new mail to allow the user to share a picture.

<h2> Services </h2>
A service is a general-purpose entry point for keeping an app running in the background for all kinds of reasons. It is a component that runs in the background to perform long-running operations or to perform work for remote processes. A service might play music in the background while the user is in a different app, or it might fetch data over the network without blocking user interaction with an activity. 

<h2> Broadcast Receivers </h2>
A broadcast receiver is a component that enables the system to deliver events to the app outside of a regular user flow, allowing the app to respond to system-wide broadcast announcements.  for example, an app can schedule an alarm to post a notification to tell the user about an upcoming event... and by delivering that alarm to a BroadcastReceiver of the app, there is no need for the app to remain running until the alarm goes off. Many broadcasts originate from the system???for example, a broadcast announcing that the screen has turned off, the battery is low, or a picture was captured. Apps can also initiate broadcasts???for example, to let other apps know that some data has been downloaded to the device and is available for them to use. Although broadcast receivers don't display a user interface, they may create a status bar notification to alert the user when a broadcast event occurs.

<h2> Content Provider </h2>

A content provider manages a shared set of app data that you can store in the file system, in a SQLite database, on the web, or on any other persistent storage location that your app can access. Through the content provider, other apps can query or modify the data if the content provider allows it. For example, the Android system provides a content provider that manages the user's contact information. As such, any app with the proper permissions can query the content provider, such as ContactsContract.Data, to read and write information about a particular person. 

<h3>Three of the four component types???activities, services, and broadcast receivers???are activated by an asynchronous message called an intent  , The content resolver handles all direct transactions with the content provider so that the component that's performing transactions with the provider doesn't need to and instead calls methods on the ContentResolver object. This leaves a layer of abstraction between the content provider and the component requesting information (for security). </h3>

There are separate methods for activating each type of component:

You can start an activity or give it something new to do by passing an Intent to **startActivity** or **startActivityForResult()** (when you want the activity to return a result).

With Android 5.0 (API level 21) and later, you can use the **JobScheduler** class to schedule actions. For earlier Android versions, you can start a service (or give new instructions to an ongoing service) by passing an Intent to startService(). You can bind to the service by passing an Intent to bindService().

You can initiate a broadcast by passing an Intent to methods such as **sendBroadcast()** ,  **sendOrderedBroadcast()**, or **sendStickyBroadcast()**.

You can perform a query to a content provider by calling **query()** on a **ContentResolver** .



 <h2> The manifest does a number of things in addition to declaring the app's components, such as the following:  </h2>

Identifies any user permissions the app requires, such as Internet access or read-access to the user's contacts.

Declares the minimum API Level required by the app, based on which APIs the app uses.

Declares hardware and software features used or required by the app, such as a camera, bluetooth services, or a multitouch screen.

Declares API libraries the app needs to be linked against (other than the Android framework APIs), such as the Google Maps library.

<h2> what is R Class In Android ? </h2>

Android R.java is an auto-generated file by aapt (Android Asset Packaging Tool) that contains resource IDs for all the resources of res/ directory.
If you create any component in the activity_main.xml file, id for the corresponding component is automatically created in this file. This id can be used in the activity source file to perform any action on the component.


<h2> what is dex </h2>

One of the most remarkable features of the Dalvik Virtual Machine (the workhorse under the Android system) is that it does not use Java bytecode. Instead, a homegrown format called DEX was introduced and not even the bytecode instructions are the same as Java bytecode instructions.

Compiled Android application code file.
Android programs are compiled into .dex (Dalvik Executable) files, which are in turn zipped into a single .apk file on the device. .dex files can be created by automatically translating compiled applications written in the Java programming language.

<h3> DeX file formate </h3>
1. File Header
 2. String Table
 3. Class List
 4. Field Table
 5. Method Table
 6. Class Definition Table
 7. Field List
 8. Method List
 9. Code Header
10. Local Variable List

dex files are similar to java class files, but they were run under the Dalkvik Virtual Machine (DVM) on older Android versions, and compiled at install time on the device to native code with ART on newer Android versions.



