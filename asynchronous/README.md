# asynchronous

## Run the app

``` sh
$ mvn clean package && java -jar ./target/asynchronous-swarm.jar
```

## Access the app

### Asynchronous EJB

``` sh
$ time curl localhost:8080/api/test-logging
curl localhost:8080/api/test-logging  0.00s user 0.01s system 0% cpu 1.120 total
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

### AsyncServlet

``` sh
$ time curl localhost:8080/async
Results: Data{value='Thread'}
curl localhost:8080/async  0.00s user 0.00s system 0% cpu 5.048 total
```

server.log

``` sh
2015-10-30 13:03:05,946 INFO  [stdout] (default task-1) Read data...
2015-10-30 13:03:10,946 INFO  [stdout] (Thread-50) Using Thread
```

### ManagedThreadFactory

``` sh
$ time curl localhost:8080/managed-thread-factory
Results: Data{value='ManagedThreadFactory'}
curl localhost:8080/managed-thread-factory  0.00s user 0.00s system 0% cpu 5.012 total
```

server.log

``` sh
2015-10-30 13:03:30,419 INFO  [stdout] (default task-3) Read data...
2015-10-30 13:03:35,419 INFO  [stdout] (EE-ManagedThreadFactory-default-Thread-1) Using ManagedThreadFactory
```

### ManagedExecutorService

``` sh
$ time curl localhost:8080/managed-executor-service
Results: Data{value='ManagedExecutorService'}
curl localhost:8080/managed-executor-service  0.00s user 0.00s system 0% cpu 5.011 total
```

server.log

``` sh
2015-10-30 13:04:06,314 INFO  [stdout] (default task-5) Read data...
2015-10-30 13:04:11,315 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-1) Using ManagedExecutorService
```