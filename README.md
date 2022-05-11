# AutomationUISeleniumGridDocker
Repository to automate UI tests with multi browser support using Selenium Grid and Docker

## Requisites:
- Selenium hub image:
you can download it by command line:  
> docker pull selenium/hub  

Source: https://hub.docker.com/r/selenium/hub  
you will get something like this:
![alt text](https://i.ibb.co/dK8whBd/Cursor-and-Docker-With-Selenium-zsh-122-32.png)
![alt text](https://i.ibb.co/cxCtt7P/Images-Docker-Desktop.png)

- Selenium node-chrome-debug image:
> docker pull selenium/node-chrome-debug  

https://hub.docker.com/r/selenium/node-chrome-debug

- Selenium node-firefox-debug image:
> docker pull selenium/node-firefox-debug

https://hub.docker.com/r/selenium/node-firefox-debug

## Start Selenium Hub:
>docker run -d -p 4444:4444 --name selenium-hub selenium/hub

if you open your browser and type:  
http://localhost:4444/grid/console  (It can be redirected to: http://localhost:4444/ui)
you will see something like this:  
![alt text](https://i.ibb.co/RjTZbPp/Selenium-Grid.png)

## Start Selenium Nodes:

- Chrome:
>docker run -d --link selenium-hub:hub selenium/node-chrome

Command to run chrome node from Docker:  
>docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug  

//If you face an error like this:  
WARNING: The requested image's platform (linux/amd64) does not match the detected host platform (linux/arm64/v8)  
Try this command instead:
> docker run -d --platform linux/amd64 --link selenium-hub:hub selenium/node-chrome-debug

- Firefox:
>docker run -d --link selenium-hub:hub selenium/node-firefox

Command to run firefox node from Docker: 
>docker run -d -P --link selenium-hub:hub selenium/node-firefox-debug  

At the end you will see something like this:  
![alt text](https://i.ibb.co/mHWdvsQ/Window-and-Selenium-Grid.png)

# How to run the tests:
> mvn clean test -Dsurefire.suiteXmlFiles=Testng.xml  

if you face some failure, try this one:
> mvn clean test -DsuiteXmlFile=Testng.xml 

if it still not working, try this:
>mvn clean package -DskipTests=true -Dsuite=‘Testng.xml’  

and to run the test/s:
> mvn clean package -Dsuite=‘Testng.xml’ -DPort=9001  

> mvn clean package -Dsuite=‘Testng.xml’ -Dbrowser='chrome'  

//Remember that -DPort=9001 is any parameter if needed, like -Dbrowser=‘chrome’
