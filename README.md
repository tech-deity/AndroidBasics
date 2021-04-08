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





