# real-time-comm
A real-time communication application using RabbitMQ and SpringBoot

## How to Run
### Intialization
You don't have to run the docker if you already have RabbitMQ setup.
```
$ git clone https://github.com/iamtanbirahmed/real-time-comm.git
$ cd real-time-comm
$ docker-compose up
```
### Running the Station
```
$ cd docking-station
$ mvn install
```
### Running the Ship
```
$ cd ship
$ mvn install
```
For both of these applications  I used commadline runner. So the build will not complete. It will wait for the input from the user.

### Launching Multiple Ship
You have change few values in the properties file for different ships. For example for a ship name `rocinante` the `application.yml` would be like the following:
```
ship: 
   name: rocinante  
   update-freq: 1000  
  
broker:  
  exchange:  
    direct:  
      ship:
        name: rocinante-direct-exchange  
        routing-key: __rocinante
      station:  
        name: tyco-direct-exchange 
        routing-key: __scheduled-update
    fanout:  
      name: tyco-fanout-exchange  
    queue:  
      name: rocinante
```
For example for a ship name `razorback` the `application.yml` would be like the following:
```
ship: 
   name: razorback  
   update-freq: 1000  
  
broker:  
  exchange:  
    direct:  
      ship:
        name: razorback-direct-exchange  
        routing-key: __razorback
      station:  
        name: tyco-direct-exchange 
        routing-key: __scheduled-update
    fanout:  
      name: tyco-fanout-exchange  
    queue:  
      name: razorback
```

 
