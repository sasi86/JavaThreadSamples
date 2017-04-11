# JavaThreadSamples

Learn Thread concepts from Cave Of Programming #youtube

How Synchronization works under the hood?
 Lock object with key(Key is also called monitor)
 
 When the Thread accesses the Synch method. The thread A request for the lock object, if the lock object has the key then it is handed over to the thread. 
 
 If Thread B tries to access the same synch method. The Thread B will request for the lock object, this time the lock object doesn't have the key as it was already handed over to Thread A. So Thread B has to wait.
 
 Once Thread A finished running the synch method it hands over the key to lock Object. So that it can be allocated to Thread B.
 
 
 # Concurrency - Executor Pattern
 
 Pool of thread is an - Executor interface.(Several Implementation available in JDK)
 ```java
 public interface Executor{
  void execute(Runnable task);
 }
 ```
 
 ExecutorService is an extension of Executor
```java
  public interface ExecutorService<T>{
  <T>  Future <T> submit(Callable<T> task);
  //11 more methods
  
 }
 ```
 To Create an instance of Executor we have *factory class Executors* - provieds 20 methods
 
 Lets create a Thread pool with only one thread
 
 Exampel 1:
   ```java
 ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // Thread in this pool will be available as long as this pool is available.
``` 
 
 Exampel 2:
 ```java
 ExecutorService multipleThreadExecutor = Executors.newFixedThreadPoolExecutor(8);
``` 
 # Waiting Queue Of ExecutorService
```java 
 ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
 
 Runnable task1  = () - > {System.out.println("Thread A")};
 
 Runnable task2  = () - > {System.out.println("Thread B")};
 
 singleThreadExecutor.execute(task1);
 
 singleThreadExecutor.execute(task2);
``` 
 When we run the above code. Task2 has to wait for Task1 to complete. The single thread executor has a waiting queue to handle that.
 
 
 This waiting queue is specified:
 
-A task is added to the waiting queue when no thread is available

-The tasks are executed in the order of their submission.

More questions:

Can we know if a task is done or not? - No…

Can we cancel the execution of a task? - Yes, if the task has not started yet
 
 # From Runnable to Callable
 
 DrawBack
 ========
 ```java
Runnable task= () -> someReallyLongProcess();
Executor executor= ...;
executor.execute(task);
```
A task does not return anything

 • No object can be returned

 • No exception can be raised

There is no way we can know if a task is done or not

What is Needed?
==============

We need a new model for our tasks:

With a method that returns a value And that can throw an Exception.

We also need a new object that acts as a bridge between threads.
```java
@FuntionlaInterface
public interfce Callable V{

 v call() throws Exception;

}
```
The Executor interface does not handle callables.The ExecutorService interface has a submit() method

# How does Future Object work?

# Behavior of Future.get()


```java
// In the main thread 
Callable<List<Patient>> task= () -> buildPatientReport(); 
Future<List<Patient>> future = executor.submit(task); 
List<Patient> result = future.get();
```

The Future object is returned by the submit()  call in the main thread 

The get() method of the Future object can be called to return the produced String 

The get() call is blocking until the returned String is available

If an exception has been thrown, then this exception is also thrown by the get() call, wrapped in an ExecutionException

One can pass a timeout to the get() call, to avoid indefinitely blocking calls 


