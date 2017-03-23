# JavaThreadSamples

Learn Thread concepts from Cave Of Programming #youtube

How Synchronization works under the hood?
 Lock object with key(Key is also called monitor)
 
 When the Thread accesses the Synch method. The thread A request for the lock object, if the lock object has the key then it is handed over to the thread. 
 
 If Thread B tries to access the same synch method. The Thread B will request for the lock object, this time the lock object doesn't have the key as it was already handed over to Thread A. So Thread B has to wait.
 
 Once Thread A finished running the synch method it hands over the key to lock Object. So that it can be allocated to Thread B.
