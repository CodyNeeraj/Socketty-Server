
<p align=center>
<img src ="https://user-images.githubusercontent.com/60183278/121336438-21a96300-c939-11eb-85dd-4d009e02f956.png" align="center" width="500">
<br><br>
<a target="_blank" href="https://adoptopenjdk.net/" title="Java version"><img src="https://img.shields.io/badge/Java-%3E%3D1.8-red"></a>
<a target="_blank" href="LICENSE" title="License: MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"></a>
<a target="_blank" title ="Version"> <img src="https://img.shields.io/badge/Version-1.4-g"></a><br>
</p>

> ###  *Socketty, a CCS (Centralised-Chat-Server) Application built using Java :computer: :satellite:*
*Socketty* is a program mainly built to function as a Central Administrative Server utility to connect with using (*[ClientEX](https://github.com/CodyNeeraj/Socketty-ClientEX)*), and to communicate with each other ClientEX Hosts on the bare Internet/Networking architecture !!!

***This software is a bare server application and a Client application is required to connect to it so, For more info regarding the client software refer this url [ClientEX](https://github.com/CodyNeeraj/Socketty-ClientEX)***
## Navigation :
 - [How to's](#how-tos)
 - [Working](#understanding-code-logic-implementation)
 - [Main Features](#main-features)
 - [Permissions](#usage-permissions)
 - [Project Requirements](#development-requirements)
 - [Dependancy](#supported-platforms-and-dependancies)
 - [License Info](#license)
 - [Downloads](#downloads)
 - [Feedback](#feedback)

 
## User Interface 
**1. Main Screen (Running Mode)**<br><br>
![serverRunningNew](https://user-images.githubusercontent.com/60183278/122185997-35117c80-ceab-11eb-9db2-c9e363c20665.png) <br><br>
**2. Main Screen (Stopped Mode)**<br><br>
![server_mainScreen](https://user-images.githubusercontent.com/60183278/122185987-32af2280-ceab-11eb-9467-f41579575710.png)

> *Other working is in the program itself ;) !!*


## How to's

## Understanding Code Logic Implementation
 > *It harnesses the power of socket programming in Java and TCP IP networking paradigm to make an efficient connection with a client, we can share any type of media or text using it and for any types of data it uses the underlying principle of sending an object in socket programming by first applying principle of serialization on that particular object and then we are using the object output stream as byte stream in which the serialized object can easily be casted into a full fledged previously declared object so that the client or the server machine can easily distinguish the data being sent to it by this particular stream of data written inside this packed object !!!
So this is all about how the data is being sent on the object output stream by socket programming now we should discuss about how , many different clients are able to connect to the server in real-time and access data on everywhere at the same instant this is done by using the multithreading. By using this, the working for client and the server keeps a record of all the objects of each and every client being connected to it and then not mixing matching each and every type of message been to everyone the first feature of this program is we can connect up to a number of clients depending upon the size of the machine for the specification used in the machine, since the JVM supports only limited amount of memory so that we can say that we can easily connect up to 20 devices on  Central server or a machine and rest is being used by a client software to spawn a thread on that particular server on which the program is running on to :smile:*
## Main Features
 - Able to connect many Clients Asynchronously.
 - Easily share Images, Audio, text and other media files over it.
 - Automatic Hide/Show console written using JAVA properties.
 - A Local personal chat server for anonymous discussions.
 - Highly optimised for long term usage.
 - No need to install additional dependencies.
 - Direct deployment Workflow.
 - Rest will made public soon :blush:
## Development Requirements
- Must Ensure to have a JDK installed in your Operating System Version *(>=1.8) any Vendor* 
- Familiarity with Apache ANT build tool (can get replaced with Maven or Gradle in the future builds).
- NetBeans IDE Latest Version will also work, but I've developed this program on version 8.2 using JDK 1.8.
- For Ease of deployment , usage of Jlink and JPackage and Other Packaging Bundle Softwares.
- Nerdy Programmer Skills :computer: :mag_right:
- A lot of Coffee :coffee:
## Usage Permissions
This software is licensed under MIT License any Commercial use can't be done without asking the developer and liability to use all these sources must be in hand of developer only, you may need to ask me for using this in your project by giving credit to the native developer :stuck_out_tongue_winking_eye:!<br>Probably as per **MIT's license** everyone is free to use the software but in case of development of any software using FOSS principle the MIT gave her license to the follow developers all around the world which is an extension of Apache 2.0
 
## Supported Platforms and Dependancies
  - Windows, Mac and Linux for both x32 and x64 bit.
  - Internet Required if you want to connect outside your Network.
  - Specified port must be unfiltered for the above application too.
  - [Java](https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot "JDK download")  (Minimum version 16 must be installed, **only for development**)
   
  ### Compile/Build our own directly from source !
  *ABOVE TUTORIAL IS FOR WINDOWS ONLY !*
  1. Clone this Repo to local
  ```bash
  git clone https://github.com/CodyNeeraj/Socketty-Server.git
  ```
  2. If [ANT](https://ant.apache.org/) Installed somewhere in your system, then got the root of repo and do
  ```bash
  ant -buildfile build.xml
  ```
3.  If above ANT not installed, you then required to have atleast Java 16 installed in your system and then do the following

  -- **(For checking JDK is in path of Env. ?)**
  ```bash
  java -version
  ```
*  Fetching list of all the java files inside all sub-directories and copying them inside a file named details.txt
```bash
dir /s /b *.java > details.txt
```
* Compiling all the files captured in the above details.txt.
```bash
mkdir output && 
javac -cp libs/* -d output @details.txt
```
* Making A jar file out of it now, take all the packages of *.classes and take the fonts and icons folder then zip all the files now with a name of *codyneeraj_Server.jar* and then run
```bash
 cd output && 
 jar cvfe codyneeraj_Server.jar main.ServerMain .
```
```bash
 move codyneeraj_Server.jar ..\
```
* Now we have a JAR containing all the resources but no classpaths so to run the jar executable do
```bash
cd .. && 
java -cp "codyneeraj_Server.jar;libs\*" main.ServerMain
```
Native Packing Tutorial COMING SOON !!
## License
Original Developer- [Neeraj](https://github.com/CodyNeeraj)
> **Project's License  > [MIT's License](https://opensource.org/licenses/MIT)** MIT ©
 
**DOWNLOADING** :
Anyone is free to download the executables without any consent of developer and can use them for your OS without any hesitation.
 
**DEVELOPMENT** :
This software is licensed under MIT License any Commercial use can't be done without asking the developer and liability to use all these sources must be in hand of developer only, you may need to ask me for using this in your project by giving credit to the native developer :stuck_out_tongue_winking_eye:
## Downloads
Pointing to github downloads section

 ## Feedback
 - Your feedback is important to me so please give a feedback.
