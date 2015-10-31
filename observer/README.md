# observer

## Run the app

``` sh
$ mvn clean package && java -jar ./target/observer-swarm.jar
```

## Access the app

### Basic example

``` sh
$ curl localhost:8080
```

the console displays

``` sh
2015-10-31 17:35:59,991 INFO  [com.devchronicles.observer.TraceObserver] (default task-1) Service message: Message{value='Starting service produced message'}
2015-10-31 17:35:59,994 INFO  [com.devchronicles.observer.TraceObserver] (default task-1) with parametres: Message{value='-d -p'}
```

### Successful Tx examples

``` sh
$ curl localhost:8080/third-child
```

the console displays

``` sh
2015-10-31 17:36:59,366 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-2) In progress message: ChildrenMessage{value='Successful event'}
2015-10-31 17:36:59,370 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-2) After completion message: ChildrenMessage{value='Successful event'}
2015-10-31 17:36:59,371 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-2) After success message: ChildrenMessage{value='Successful event'}
```

### Rollback Tx examples

``` sh
$ curl localhost:8080/sixth-child
```

``` sh
2015-10-31 17:38:48,003 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-3) In progress message: ChildrenMessage{value='Rollback event occurred.'}
2015-10-31 17:38:48,005 INFO  [com.devchronicles.observer.Children] (default task-3) Exception caught: java.lang.ArrayIndexOutOfBoundsException: 5
2015-10-31 17:38:48,009 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-3) After completion message: ChildrenMessage{value='Rollback event occurred.'}
2015-10-31 17:38:48,011 INFO  [com.devchronicles.observer.TransactionEventObserver] (default task-3) After failure message: ChildrenMessage{value='Rollback event occurred.'}
```