# asynchronous

## Run the app

``` sh
$ mvn clean package && java -jar ./target/dao-swarm.jar
```

## Access the app

``` sh
$ curl localhost:8080 | jq .
...
[
  {
    "runtimeId": 0,
    "price": 100,
    "description": "description1",
    "title": "title1",
    "id": 1
  },
  {
    "runtimeId": 0,
    "price": 200,
    "description": "description2",
    "title": "title2",
    "id": 2
  },
  {
    "runtimeId": 0,
    "price": 300,
    "description": "description3",
    "title": "title3",
    "id": 3
  }
]
```