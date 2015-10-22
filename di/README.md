# di

## Run the app

``` sh
$ mvn clean package && java -jar ./target/di-swarm.jar
```

## Access the app

``` sh
$ curl -X POST -H "Content-Type: application/json" -d '{"fullName":"foo"}' localhost:8080 -v
...
< HTTP/1.1 201 Created
< Location: http://localhost:8080/foo
...
```

And server.log(standard output) displays the following log.

``` sh
INFO  [stdout] (default task-1) com.devchronicles.di.UserDataRepositoryMongo#save executed.
```
