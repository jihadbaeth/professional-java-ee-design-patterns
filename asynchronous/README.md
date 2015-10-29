# asynchronous

## Run the app

``` sh
$ mvn clean package && java -jar ./target/asynchronous-swarm.jar
```

## Access the app

### Asynchronous log

``` sh
$ curl localhost:8080/api/test-logging
```

The Above `curl` request receives the response in about 1 second, and server.log(standard output) displays the following log.

``` sh
2015-10-29 23:30:40,945 INFO  [stdout] (default task-1) call async
2015-10-29 23:30:40,948 INFO  [stdout] (default task-1) call sync
2015-10-29 23:30:40,948 INFO  [MyGlobalLogger] (default task-1) Entering sync log
2015-10-29 23:30:41,950 INFO  [MyGlobalLogger] (default task-1) Log Sync
2015-10-29 23:30:41,951 INFO  [stdout] (default task-1) finished
2015-10-29 23:30:41,951 INFO  [MyGlobalLogger] (EJB default - 1) Entering async log (1)
2015-10-29 23:30:51,953 INFO  [MyGlobalLogger] (EJB default - 1) Log Async (2)
```

(1), (2) are asynchronous logs on an EJB thread.
