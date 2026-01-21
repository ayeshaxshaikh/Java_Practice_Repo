# Thread Group:
- Based on functionality, we can group threads into a single unit which is nothing but thread group.
- Thread group contains a group of threads.
- In addition to thread, thread group can also contain sub thread groups.
- The main advantage of maintaining threads in the form of thread group is we can perform common operation very easily.
- Every thread in Java belongs to some group.
- Main thread belongs to main group.
- Every thread group in Java is a child group of system group either directly or indirectly hence system group acts as root for all threads groups in Java.
- System group contains several system level threads like finalizer, reference handler, signal dispatcher, attach listener.
class Test
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getThreadGroup().getName());  // main
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); // System
    }
}
- Thread Group is a java class present in java.lang package and it is direct child class of object.


# constructors:
ThreadGroup g = new ThreadGroup(String gname);
- creates a new thread group with the specified group name.
- the parent of this new group is the thread group of currently executing thread.
ThreadGroup g = new ThreadGroup("First Group");
ThreadGroup g = new ThreadGroup(ThreadGroup pg, String gname);
- creates a new thread group with the specified group name.
- The parent of this new thread group is specified parent group
e.g.
ThreadGroup g1 = new ThreadGroup(g, "Second Group");

e.g.
class Test
{
    public static void main(String[] args)
    {
        ThreadGroup g1 = new ThreadGroup("First Group");  
        System.out.println(g1.getParent().getName()); // main
        ThreadGroup g2 = new ThreadGroup(g1, "Second Group");
        System.out.println(g2.getParent().getName()); // First Group
    }
}

- System > main > First Group > Second Group

# Thread Group class method:
1. String getName()
2. int getMaxPriority():     
- the default max priority is 10

3. void setMaxPriority(int p):
e.g.
class ThreadGroupDemo
{
    public static void main(String[] args)
    {
        ThreadGroup g1 = new ThreadGroup("tg");
        Thread t1 = new Thread(g1, "Thread1");
        Thread t2 = new Thread(g1, "Thread2");
        g1.setMaxPriority(3);
        Thread t3 = new Thread(g1, "Thread3");
        System.out.println(t1.getPriority()); 
        System.out.println(t2.getPriority()); 
        System.out.println(t3.getPriority()); 
    }
}
o/p:
5
5
3

4. ThreadGroup getParent():
- it returns the parent group of current thread

5. void list():
- It prints information about thread group to the console

6. int activeCount():
- Returns number of active threads present in the thread group

7. int activeGroupCount():
- Returns numbers of active groups present in the current thread

8. int enumerate(Thread[] t):
- To copy all active threads of this thread group into provided thread array
- In this case sub thread group also will be considered. 

9. int enumerate(ThreadGroup[] g):
- To copy all active sub thread groups into thread group array.

10. boolean isDaemon():
- to check whether the thread group is daemon or not

11. void setDaemon(boolean b):
- to set daemon of thread group

13. void interrupt():
- to interrupt all waiting or sleeping threads present in the thread group

14. void destroy():
- to destroy thread groups and its sub thread groups

# write a program to display all active thread names belongs to system groups and its childs group:
e.g.

class ThreadGroupDemo
{
    public static void main(String[] args)
    {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);
        for (Thread t1 : t) {
            System.out.println(t1.getName() + "...." + t1.isDaemon());
        }
    }
}
o/p:
main....false
Reference Handler....true
Finalizer....true
Signal Dispatcher....true
Attach Listener....true
Notification Thread....true
Common-Cleaner....true

# java.util.concurrent:
- The problems with synchronized keyword:
1. we are not having any flexibility to try for a lock without waiting.
2. there is no way to specify maximum waiting time for a thread to get lock so that thread will wait until getting the lock which may creates performance problem which may cause deadlock.
3. If a thread releases lock then which waiting thread will get that lock we are having any control on this.
4. There is no API to list out all waiting threads for a lock.
5. synchronized keyword we have to use either at method level or within the method and it is not possible to use across multiple methods

- To overcome these problems SUN people introduced java.util.concurrent.locks package in 1.5v.
- It also provides several enhancements to the programmer to provide more control on concurrency.

# lock interface:
- lock object is similar to implicit lock aquired by a thread to execute synchonized method or synchronized block.
- lock implementation provides more extensive operation than traditional implicit locks.

# important methods of lock interface:
1. void lock():
- we can use this method to acquired a lock
- If lock is already available then immediately current thread will get the lock
- If the lock is not already available then it will wait until getting the lock
- It is exactly same behavior of traditional synchronized keyword.

2. boolean tryLock():
- To acquire the lock without waiting
- If the lock is available then the thread acquires that lock and returns true
- If the lock is not available then this method returns false and can continue its execution without waiting 
- In this case thread never be entered into waiting state
e.g.
if(l.tryLock())
{
    perform safe operation
}
else
{
    perform alternative operations
}

3. boolean tryLock(long time, TimeUnit unit):
- If the lock is available then the thread will get the lock and continue its execution
- If the lock is not available then the thread will wait until specified amount of time
- still if the lock is not available then thread can continue its execution

# TimeUnit:
- TimeUnit is an enum present in java.util.concurrent package 
enum TimeUnit
{
    NANOSECONDS,
    MICROSECONDS,
    MILLISECONDS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS
}
e.g.
if(l.tryLock(1000, TimeUnit.MILLISECONDS))
{

}

4. void lockInterruptibly():
- Acquires the lock if it is available and returns immediately
- If the lock is not available then it will wait 
- While waiting the thread is interrupted then thread won't get the lock

5. void unlock():
- to releases lock

# ReentrantLock():
- It is the implementation class of lock interface and it is the direct child class of object
- Reentrance means a thread can acquire same lock multiple times without any issue
- Internally reentrant lock increments threads personal count whenever we call lock() method and decrements count value whenever thread calls unlock method and lock will be released whenever count reaches zero


# constructors:
1. ReentrantLock l = new ReentrantLock();
- creates a instance of ReentrantLock 

2. ReentrantLock l = new ReentrantLock(boolean fairness);
- creates ReentrantLock with the given fairness policy:
If the fairness is true then longest waiting thread can acquire the lock if it is available. It follows first come first serve policy
If fairness is false then which waiting thread will get the chance we can't expect
The default value for fairness is false.

# Important methods ReentrantLock:
1. void lock()
2. boolean tryLock()
3. boolean tryLock(long l, TimeUnit t)
4. void lockInterruptibly()
5. void unlock()
6. int getHoldCount():
- returns the number of holds on this lock by current thread

7. boolean isHeldByCurrentThread():
- returns true if lock is hold by current thread

8. int getQueuedThreads():
- returns number of threads waiting for the lock

9. Collection getQueuedThreads():
- returns collection of threads which are waiting to get the lock

10. boolean hasQueuedThreads():
- return true if any thread waiting to get the lock

11. boolean isLocked():
- returns true if the lock acquired by some thread

12. boolean isFair():
- returns true if the fairness policy is set to be true value

13. Thread getOwner():
- returns the thread which acquires the lock

# thread pools (Executor Framework):
- creating a new thread for every job may create performance and memory problems.
- To overcome this we should go for thread pool
- Thread pool is a pool of already created threads ready to do our job.
- Java 1.5v introduces thread pool framework to implement thread pools.
- Thread pool framework also known as Executor Framework
- we can create a thread pool as follows:
ExecutorService service = Executors.newFixedThreadPool(3);
- we can submit a runnable job by using submit() method
service.submit(job);
- we can shutdown executor service by using shutdown()
service.shutdown();

e.g.
import java.util.concurrent.*;

class PrintJob implements Runnable {
    String name;
    PrintJob(String name)
    {
        this.name = name;
    }
    public void run()
    {
        System.out.println(name + "...job started by thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            
        }
        System.out.println(name + "...job completed by thread: " + Thread.currentThread().getName());
    }
}

class ExecutorDemo
{
    public static void main(String[] args) {
        PrintJob[] jobs = {
            new PrintJob("Sadia"),
            new PrintJob("Shoyee"),
            new PrintJob("Junaid"),
            new PrintJob("Mona"),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (PrintJob job: jobs)
        {
            service.submit(job);
        }
        service.shutdown();   
    }
}
- In the above exapmle 3 threads are responsible to execute 6 jobs so that a single thread can be reused for multiple jobs.

# Note: while designing web server and application servers we can use thread pool concept.

# callable and future:
- In the case of runnable job thread won't return anything after completing the job 
- If a thread is required to return some result after execution then we should go for callable.
- callable interface contain only one method call()
public Object call() throws Exception
- if we submit a callable object to executor then after completing the job thread returns object as a type Future
i.e. Future object can be used to retieve the result from callable job

# differences between Runnable and Callable:
- if a thread is not required to return anything after completing the job then we should go for Runnable.
- if a thread is required to return something after completing the job then we should go for Callable.
- Runnable interface contains only one method run().
- Callable interface contains only one method call().
- Runnable job not required to return anything hence return type of run() method is void.
- Callable job required to return something hence return type of call() method is Object.
- Within the run() method if there is any chance of rising checked exception we should handle using try-catch because we can't use throws keyword for run() method.
- Within the call() method if there is any chance of rising checked exception we are not required to handle by using try-catch because call() method already throws Exception.
- Runnable interface present in java.lang package 
- Callable interface present in java.util.concurrent package
- Runnable concept introduced in 1.0v
- Callable concept introduced in 1.5v

# thread local:
- Thread Local class provides thread local variable.
- Thread local class maintains values for thread bases.
- Each thread local object maintains a separate value like userId, transactionId, etc. for each thread that accesses that object.
- Thread can access its local value and can manipulate its value and even can remove its value.
- In every part of the code which is executed by the thread we can access its local variable.
- consider a servlet which invokes some business methods 
- we have a requirement to generate a unique transaction id for each and every request and we have to pass this transaction ids to the business methods for this requirement we can use this thread local to maintain a separate transaction id for every request that means for every thread

# Note: Thread local class intoduced in 1.2v enhanced in 1.5v. Thread local can be associated with thread scope. Total code which is executed by thread has access to the corresponding thread local variables 