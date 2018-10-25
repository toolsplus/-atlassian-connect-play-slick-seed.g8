# $name$

$name$ Atlassian Connect app using Scala, Play and Slick.

## Quick start

1. Install ngrok

    To install a Atlassian Connect app on a Cloud instance it has to be served 
    over HTTPS. This can easily be done using [ngrok](ngrok). Make sure you have it
    installed and a tunnel started using
           
           ngrok http 9000
           
    ngrok will display the base URL for your app. Use it to configure the `AC_BASE_URL`
    parameter in the run configuration.
    
1. Configure the Play application

    You can configure your Play application via `conf/application.conf`.
    [Atlassian Connect Play](https://github.com/toolsplus/atlassian-connect-play) provides 
    the following configuration parameters:
    
        atlassian.connect {
          key = io.toolsplus.acplayscala
          name = "Atlassian Connect Play"
          baseUrl = "http://localhost:9000"
          allowReinstallMissingHost = false
        }
        
    `atlassian.connect.key` is your app's unique key
    `atlassian.connect.name` is your app's name that you can choose freely
    `atlassian.connect.baseUrl` is your ngrok HTTPS URL if you develop locally, 
    otherwise the HTTPS URL of where your app lives
    `atlassian.connect.allowReinstallMissingHost` when set to true will not allow
    to re-install a missing host, should always be false in production
    
1. Configure a database

    This project is configured to use H2 backend storage via 
    [Atlassian Connect Play Slick](atlassian-connect-play-slick). Follow the guide
    there on how to configure a different database system if you wish to use something
    else.
    
1. That's it. You're app is ready to go.

        sbt run
    
1. Finally, innstall the app in your Atlassian product using your ngrok URL
   
        https://<your-ngrok>.ngrok.io/atlassian-connect.json