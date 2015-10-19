# singleton

## Run the app

``` sh
$ mvn clean package && java -jar ./target/singleton-swarm.jar
```

## Access the app

``` sh
$ curl localhost:8080/1 -I
HTTP/1.1 404 Not Found
...
```

``` sh
$ curl -X PUT -H "Content-Type: application/json" -d '{"id":1, "name":"foo"}' localhost:8080 -v
...
< HTTP/1.1 201 Created
< Location: http://localhost:8080/1
...
```

``` sh
$ curl localhost:8080/1
foo
```