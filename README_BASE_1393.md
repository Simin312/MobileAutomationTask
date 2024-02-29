# MobileAutomationTask
Test Automation: Practical and Questionnaire Assignment

# Question
Question 1: Mobile Automation task
Todoist App
At the stage of developing these tests, please think over the overall architecture that it will be huge scalable test 
environment growing with additional tests.

Useful Links:
  Official website :https://en.todoist.com/
  APK : https://todoist.en.uptodown.com/android
  
Please follow these instructions when designing and delivering your solution:
Create test user manually. Use Android emulator for tests.

It is very important, that you have smart designed checks on each step, not only in the end of the whole flow.
For Automation Framework you can use appium or similar framework. 
Please do not use for test creation postman and other similar clients. 
When creating an automation test, you should only use the custom REST client, that you create from scratch.
DO NOT use the official ones.

Please write the automation test in one file. 
  1. Test “Create Project”
  2. Create test project via API.
  3. Login into mobile application.
  4. Verify on mobile that project is created
  5. Test “Create Task via mobile phone”
  6. Create test task via mobile application in test project.
  7. API: Verify that task created correctly.
  8. Test “Reopen Task”
  9. Open mobile application
  10. Open test project
  11. Created test task
  12. Complete test task.
  13. Reopen test task via API.
  14. Mobile: Verify that test task appears in your test project.

# What is Appium?
1. Appium is an open source tool to automate mobile applications.
2. Appium can automate Native, web and hybrid mobile applications.
3. Appium also support Android, iOS and Windows desktop platforms.
4. Appium suppports multiple programming languages.
     1. Java
     2. Python
     3. C#
     4. JavaScript
     5. Ruby
     6. PHP
     7. Robot Framework

# How Appium works?
1. Appium works in a client - server architecture.
2. Appium is a 'HTTP Server' written using - Node.js platform.
![image](https://github.com/Simin312/MobileAutomationTask/assets/48896656/70c2ab66-1748-4460-813b-6d6650883db9)
3. Desired Capabilities - Desired capabilities are a set of keys and values sent to the Appium server to tell the server what kind od automation session we are interested in starting up.

# Prerequisite to use Appium (Windos)
Pre-requisites  (https://www.youtube.com/watch?v=x_5bc72GQco&list=PLUDwpEzHYYLsx_2JFNBMITjHqTnuszhb_&index=2&ab_channel=SDET-QA)
1. Install Java
2. Eclipse
3. Mave plugin for Eclipse
4. TestNG plugin for Eclipse
5. Selenium Standalone Server
Android Tools
1. Android Studio
2. Appium Server/Appium Desktop
3. Appium Client Library

# How to run the Appium with emulator
1. Open android studio run the emulator *Please select a andriod device with Play Store icon, otherwise you are not able to Sign in using Google. 
![alt text](image.png)
2. Open appium server and run it
3. Open cmd and cd to "C:\Users\"YourUserName"\AppData\Local\Android\Sdk\platform-tools" then type adb.exe devices -> it will show you the list of devices attached emulator-5554 device










# How to install Appium on Windows
1. Check if node.js and npm are installed on your system.
     1. open command prompt type "node --version"
     2. open command prompt type "npm --version"
2. Go to "https://nodejs.org/en/download" download the Windows installer and install it.
3. Run the installer & install node.js and npm.
4. Check if node.js & npm are installed.
   1. open command prompt type "node --version"
   2. open command prompt type "npm --version"
5. Install Appium with node.js
   1. open command prompt type "npm install -g appium"
6. Check if Appium is installed.
   1. appium --version
7. Start Appium
   1. open command prompt type "appium"

# How to install Appium Doctor
1. Appium-doctor is a tool to verify appium installation
2. open command prompt type "npm install appium-doctor -g"
3. type "npm appium-doctor -h" to see all the available usage.
![image](https://github.com/Simin312/MobileAutomationTask/assets/48896656/600fd407-4674-48ca-8d37-f8d81b806661)





# How to connect Real Andriod Mobile Device on Windows
1. Prerequisites
  1. Java installed on system
  2. JAVA_HOME is set in environment variable
       command to check: java -version
  3. An andriod mobile device
  4. Connecting cable
  5. 200MB to 1GB free space


2.Steps 
  1. Download SDK tools from(https://developer.android.com/studio).
   ![image](https://github.com/Simin312/MobileAutomationTask/assets/48896656/f2ba0ce3-34ed-4539-b624-2d7169e15456)
   Scroll down until Command line tool only.
  2. Unzip folder & Extract platform tools.
     1. Go to the ...sdkfolder\bin open terminal
     2. 
