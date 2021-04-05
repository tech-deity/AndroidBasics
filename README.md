<h1> AndroidBasics </h1>
<h3>Definition of Android</h3>
Android operating system is multi user linux system in which each app is a different user
<ul>
  <li> Android system assigns each app a unique Linux user ID (the ID is used only by the system and is unknown to the app). The system sets permissions for all the files in an app so that only the user ID assigned to that app can access them.</li>
  <li>Each process has its own virtual machine so an app code runs in isolation from other apps</li>
  <li>Every app run on its own linux process, Android system starts the process when any of the app's components need to be executed, and then shuts down the process when it's no longer needed or when the system must recover memory for other apps.</li>
</ul>

<h4> Android system implements the principle of least privilege </h4>
