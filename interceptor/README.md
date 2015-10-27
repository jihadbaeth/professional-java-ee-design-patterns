# interceptor

## Run the app

``` sh
$ mvn clean package && java -jar ./target/interceptor-swarm.jar
```

## Access the app

``` sh
$ curl localhost:8080/start-service
```

server.log(standard output) displays the following log. `[SecurityLog]` category log is interceptors log.

```sh
2015-10-28 02:49:28,876 INFO  [stdout] (default task-1) ####: 1939586130
2015-10-28 02:49:28,877 INFO  [SecurityLog] (default task-1) startService is accessed!
2015-10-28 02:49:28,878 INFO  [SecurityLog] (default task-1) user: null
2015-10-28 02:49:28,878 INFO  [SecurityLog] (default task-1) user: user1
2015-10-28 02:49:28,878 INFO  [AppLog] (default task-1) done...
```
