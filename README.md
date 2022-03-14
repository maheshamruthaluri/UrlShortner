# Cli application to shorten a given url
## UrlShortner ##
Given a lengthy URL shortens it

### Assumptions ###
The url will not contain a scheme **https://** or a **http://**

## Technologies ##
Springboot
Redis to serve cache memory

### Steps to install ###
### Running redis server ###

brew install redis

### Start redis ###

redis-server

In a new terminal tab start the redis cli
redis-cli

The application is built on springboot and defaults to 8080

#### APIS to run ####
Method **POST**

**localhost:8080/shortUrl/www.apple.com/**

Gives you
```json
{
    "url": "www.apple.com",
    "key": "0d027b91",
    "created": "2022-03-11T15:26:42.828823"
}
```

#### Using the key to find the url ####

Method **GET**

**localhost:8080/shortUrl/0d027b91**

RESPONSE

www.apple.com
 