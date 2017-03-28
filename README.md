# JavaThreadSamples

Learn Thread concepts from Cave Of Programming #youtube

How Synchronization works under the hood?
 Lock object with key(Key is also called monitor)
 
 When the Thread accesses the Synch method. The thread A request for the lock object, if the lock object has the key then it is handed over to the thread. 
 
 If Thread B tries to access the same synch method. The Thread B will request for the lock object, this time the lock object doesn't have the key as it was already handed over to Thread A. So Thread B has to wait.
 
 Once Thread A finished running the synch method it hands over the key to lock Object. So that it can be allocated to Thread B.
 
 
 # Concurrency - Executor Pattern
 
 Pool of thread is an - Executor interface.(Several Implementation available in JDK)
 
 public interface Executor{
  void execute(Runnable task);
 }
 
 ExecutorService is an extension of Executor
 
  public interface ExecutorService{
  //11 more methods
 }
 
 To Create an instance of Executor we have *factory class Executors* - provieds 20 methods
 
 Lets create a Thread pool with only one thread
 
 ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // Thread in this pool will be available as long as this pool is available.
 
