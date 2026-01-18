# Multi-tasking:
- Executing several tasks simultaneously is a concept of multi-taskig.
- There are two types of multi-tasking i.e. Process based and Thread based multi-tasking.

1. Process Based muktitasking:
- Executing several taks simultaneously where each task is a separate independent prgram (process) is called process based multi-tasking.
- Process based multi-tasking is best suitable at OS level.

2. Thread based multi-tasking:
- Executing several taks simultaneously where each task is a separate independent part of same prgram (process) is called thread based multi-tasking. ANd each independent part is called thread.
- Process based multi-tasking is best suitable at programmatic level.

- Whether it is process based or thread based, the main objective of multi-tasking is to reduce the response time of system and to improve performance.
- The main important application area of multi-threading are:
1. To develop multi media graphics.
2. To develop animation.
3. To develop video games
4. To develop web servers and application servers

- When compared with old languages, developing multi-threaaded application in java is very easy becuase java provides inbuilt support for multi-threading with rich API (Thread, Runnable, ThreadGroup,...).

# Defining a Thread:
- we can define a thread in the following two ways:
1. By extending Thread class:
e.g.
class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Child Thread");  // executed by child Thread
        }
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread(); // Thread instantiation
        t.start(); // starting of the thread
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Main Thread");  // executed by main Thread
        }
    }
}
o/p:
It will change JVM to JVM

# case-1 (Thread Scheduler):
- It is a part of JVM
- It is responsible to schedule threads i.e. if multiple threads are waiting to get a chance of execution then in which order threads will be executed is decided by thread scheduler.
- we can't expect exact algorithm followed by thread scheduler 
- It is varied from JVM to JVM, hence we can't expect thread execution order and exact output
- Hence whenever situation comes to multithreading there is no garuntee for exact output but we can provide several possible outputs

# case-2: Difference between t.start() and t.run(): (v.imp)
- In the case of t.start() , a new thread will be created which is responsible for the execution of run() method 
- But in the t.run(), a new thread won't be created and run() method will be executed just like a normal method call by main thread 
- Hence in the above program if we replace t.start() with t.run() then the output is 
Child Thread (10 times )
Main Thread (10 times)
- This total output produced by only main thread.

# case-3 (importance of thread class start method):
- Thread class start method is responsible to register the thread with thread scheduler and all other mandatory activities
- Hence without execution thread class start method there is no chance of starting a new thread in java.
- Due to this thread class start method is considered as heart of multi threading.
e.g.
start()
{
    1. Register this thread with Thread Scheduler
    2. Perform all other mandatory activities
    3. invoke run() 
}

# case-4 (overloading of run()):
- Overloading of run() method is always possible but Thread class start method can invoke no argument run() method 
- The other overloaded method , we have to call explicitly like a normal method call.
e.g.
class MyThread extends Thread
{
    public void run()
    {
        System.out.println("no-arg run");  
    }

    public void run(int i)
    {
        System.out.println("int-arg run");  
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread(); // Thread instantiation
        t.start(); // starting of the thread
    }
} // no-arg run

# case-5 (If we are not overriding run()):
- If we are not overriding run() method then thread class run() method will be executed which has empty implementation
- Hence we won't get any output
e.g.
class MyThread extends Thread
{
    
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread(); // Thread instantiation
        t.start(); // starting of the thread
    }
} // no output

# Note: It is highly recommanded to override run() method otherwise don't go for multi threading concept
 
# case-6 (overriding of start()):
- If we override start() method then our start() method will be executed just like a normal method call and new thread won't be created
e.g.
class MyThread extends Thread
{
    public void start()
    {
        System.out.println("start method");
    }

    public void run()
    {
        System.out.println("run method");
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread(); 
        t.start(); 
        System.out.println("main thread");
    }
} 
o/p:
start method
main thread

# Note: It is not recommanded to override start() method otherwise don't go for multi threading concept.

# case-7: (with super())
e.g.
class MyThread extends Thread
{
    public void start()
    {
        super.start();
        System.out.println("start method");
    }

    public void run()
    {
        System.out.println("run method");
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread(); 
        t.start(); 
        System.out.println("main thread");
    }
}
possible o/p:
start method
run method
main thread

start method
main thread
run method

run method
start method
main thread

# case-8 (thread lifecycle):
- New/Born (MyThread t = new MyThread()) --------> Ready/Runnable ------> Running -------> Dead

# case-9:
- After starting a thread if we are trying to restart the same thread the we will get runtime exception saying IllegalThreadException
Thread t = new Thread();
t.start();
...
t.start();
// RE: IllegalThreadException

2. By implementing Runnable interface
- We can define a thread by implementing Runnable interface.
- MyThread --> Thread --> Runnable Interface
- MyRunnable --> Runnable Interface
- Runnable interface present in java.lang package and it contains only run method i.e.public void run()
e.g.
class MyRunnable implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 5; i++){
            System.out.println("child thread");
        }
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyRunnable r = new MyRunnable(); 
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 5; i++){
            System.out.println("main thread");
        }
    }
}
o/p: varied 
- We will get mixed output and we can't tell exact out

# case study:
MyRunnable r = new MyRunnable();
Thread t1 = new Thread();
Thread t2 = new Thread(r);

# case-1 (t1.start()):
- A new thread will be created and which is responsible for the execution of thread class run(), which has empty implementation.

# case-1 (t1.run()):
- No new thread will be created and thread class run() method will be executed just like normal method call.

# case-3 (t2.start()):
- A new Thread will be created and which is responsible for the execution of MyRunnable class of run().

# case-4 (t2.run()):
- A new thread won't be created and MyRunnable run() method will be executed just like a normal method call

# case-5 (r.start()):
- We will get compile time error saying CE: MyRunnable class does not have start capability
CE: cannot find symbol
symbol: method start()
location: class MyRunnable

# case-6 (r.run()):
- No new thread will be created and MyRunnable run() method will be executed just like a normal method call.

# Note: Among two ways of defining thread, implements Runnable approach is recommanded. In the first approach our class always exxtends Thread class, there is no chance of extending any other class. Hence we are missing inheritance benefits. But in the second approach while implementing Runnable interface we can extend any other class. So we won't miss any inheritance benefit. Because of this reason implementing Runnable interface approach is recommanded.


# Thread class constructors:
Thread t = new Thread();
Thread t = new Thread(Runnable r);
Thread t = new Thread(String s);
Thread t = new Thread(Runnable r, String s);
Thread t = new Thread(ThreadGroup g, String s);
Thread t = new Thread(ThreadGroup g, Runnable r);
Thread t = new Thread(ThreadGroup g, Runnable r, String s);
Thread t = new Thread(ThreadGroup g, Runnable r, String name, long stacksize);

# Getting and setting name of a thread:
- Every thread in Java has some name. It may be default name generated by JVM or customized name provided by programmer.
- We can get and set name of a thread by using the following two methods of thread class:
public final String getName()
public final void setName(String name)

e.g.
class MyThread extends Thread
{

}
class ThreadDemo
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName());
        MyThread t = new MyThread();
        System.out.println(t.getName());
        Thread.currentThread().setName("Junaid Asif");
        System.out.println(Thread.currentThread().getName());
        System.out.println(10/0);
    }
}
o/p:
main
Thread-0
Junaid Asif
Exception in thread "Junaid Asif" java.lang.ArithmeticException: / by zero
        at ThreadDemo.main(ThreadDemo.java:157)

# Note: We can get current executing thread object by using Thread.currentThread().

e.g.

class MyThread extends Thread
{
    public void run()
    {
        System.out.println("run method executed by Thread : " + Thread.currentThread().getName());
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();
        System.out.println("run method executed by Thread : " + Thread.currentThread().getName());
    }
}
o/p:
run method executed by Thread : Thread-0
run method executed by Thread : main

# Thread Priorities:
- Every thread in java has some priority. It may be default priority generated by JVM or customized priority provided by programmer.
- The valid range of Thread priority is 1 to 10 where 1 is min priority and 10 is max priority.
- Thread class defines the following constants to represent some startdard priority
Thread.MIN_PRIORITY ---> 1
Thread.NORM_PRIORITY ---> 5
Thread.MAX_PRIORITY ---> 10

- Thread Scheduler will use priority while allocating processor.
- The Thread which is having highest priority will get chance first.
- If two Threads having same priority then we can't expect exact execution order. It depends on Thread scheduler.

- Thread class defines the following methods to get and set priority of Thread:
public final int getPriority()
public final void settPriority(int p)
- Allowed values range from 1 to 10. Otherwise we will get runtime exception saying IllegalArgumentException

# default priority:
- The default priority only for main thread is 5 and for all remaining thread default priority will be inherited from parent to child i.e. whatever priority parent thread has the same priority will be there for child thread.

e.g.
class MyThread extends Thread
{
 
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        MyThread t = new MyThread();
        System.out.println(t.getPriority());
    }
}
o/p:
5
7

e.g.
class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
        }
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.setPriority(9);
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}
- output must be
child thread (5 times) 
main thread (5 times)

# Note: Some platforms won't provide better support for Thread priorities.

# We can prevent a thread execution by using the following methods:
1. yield()
2. join()
3. sleep()

# yield():
- yield() method causes to pause current executing thread to give chance to waiting threads of same priority.
- If there is no waiting threads or waiting threads have low priority then same thread can continue its execution.

# If multiple threads are waiting with same priority then which waiting thread will get chance ?
We can't expect. It depends on thread scheduler.

# The thread which is yielded, when it will get the chance once again?
It depends on thread scheduler and we can't expect exactly.

- public static native void yield();

e.g.
class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
            Thread.yield();
        }
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}
- In the above program, If we comment Thread.yield(); then both Threads will be executed simultaneously and we can't expect which thread will complete first.
- If we are not commenting Thread.yield(); then child thread always call yield() method because of that main thread will get chance more number of times and the chance of completing main thread first is high.
- Some platforms won't provide proper support for yield method.

# join():
- If a thread wants to wait until completing some other thread then we should go for join() method.
- If a thread t1 wants to wait until completing t2 then t1 has to call t2.join().
- If t1 executes t2.join() then immediately t1 will be entered into waiting state until t2 completes.
- Once t2 completes then t1 continue its execution.

public final void join() throws InterruptedException
public final void join(long ms) throws InterruptedException
public final void join(long ms, int ns) throws InterruptedException

# Note: Every join() method throws InterruptedException which is checked exception hence we must handle this exception either by using try-catch or using throws keyword otherwise we will get compile time error.


# case-1:
waiting of main thread until completing child thread

e.g.
class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
class ThreadDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        MyThread t = new MyThread();
        t.start();
        t.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}
o/p:
child thread
child thread
child thread
child thread
child thread
main thread
main thread
main thread
main thread
main thread

- If we comment t.join(); then both main and child classes will be executed simultaneously and we can't expect exact output.
- If we are not commenting t.join(); then main thread calls join() method on child thread object hence main thread will wait until completing child thread.

# case-2:
waiting of child thread until completing main thread
e.g.

class MyThread extends Thread {
    static Thread mt;

    public void run() {
        try {
            mt.join();
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
        }
    }
}

class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread.mt = Thread.currentThread();
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
            Thread.sleep(1000);
        }
    }
}
o/p:
main thread
main thread
main thread
main thread
main thread
child thread
child thread
child thread
child thread
child thread

- In the above example, child thread calls join() method on main thread object hence child thread has to wait until completing main thread.

# case-3:
if main thread calls join() on child thread object and child thread calls join() on main thread object then both threads will wait forever and the program will stucked. This is something like dead lock.

# case-4:
If the thread calls join() method on the same thread itself then the program will be stuck. Thread has to wait infinite time. 
e.g.
class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}


# sleep():
- If a thread don't want to perform any operation for a particular amount of time then we should go for sleep() method.
public static native void sleep(long ms) throws InterruptedException
public static void sleep(long ms, int ns) throws InterruptedException

# Note: Every sleep() method throws InterruptedException, which is checked exception hence whenever we are using sleep() method we must handle InterruptedException either by try-catch or by throws keyword. Otherwise we will get compile time error.

e.g.
class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Slide-" + i);
            Thread.sleep(5000);
        }
    }
}     
o/p:
Slide-0
Slide-1
Slide-2
Slide-3
Slide-4

# How a Thread can interrupt another Thread?
- A Thread can interrupt a sleeping thread or waiting thread by using interrupt method of thread class
public void interrupt()
e.g.
class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("child thread");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}
class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.interrupt();
        System.out.println("end of main thread");
    }
}
o/p:
end of main thread
child thread
I got interrupted

# Note: Whenever we are calling interrupt() method, if the target thread not in sleeping state or waiting state then there is no impart of interrupt call immediately. interrupt will be waited until target thread entered into sleeping or waiting state. If the target thread entered into sleeping or waiting state then immediately interrupt call will interrupt the target thread. If the target thread never entered into sleeping or waiting state then there is no impact of interrupt call. This is the only case where interrupt call will be wasted.

e.g.
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
                System.out.println("child thread");
        }
        System.out.println("I am entering into sleeping state");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}

class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.interrupt();
        System.out.println("end of main thread");
    }
}
o/p:
end of main thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
child thread
I am entering into sleeping state
I got interrupted

- In the above example, interrupt call waited until child thread completed for loop 20 times.

# synchronization:
- synchronized is a modifier applicable only for methods and blocks but not for classes and variables.
- If multiple threads are trying to operate on same java object then there may be a chance of data inconsistency problem.
- To overcome this problem we should go for synchronized keyword.
- If a method or block declared as synchronized then at a time only one thread is allowed to execute that method or block on the given object so that data inconsistency problem will be resolved.
- The main advantage of synchronized keyword is we can resolve data inconsistency problem but the main disadvantage is it increases waiting time of threads and creates performance problem.

- Internally synchronization concept is implemented using lock.
- Every object in java has a unique lock.
- Whenever we are using synchronized keyword then only lock concept come into the picture.
- If a thread wants to execute synchronized method on the given object.
- first it has to get lock of that object
- Once thread got the lock, it is allowed to execute any snychronized method on that object.
- Once method execution completes, automatically thread releases lock.
- Aquiring and releasing lock internally takes care by JVM and programmer not responsible for this activity.
- While a thread executing synchronized method on the given object, the remaining threads are not allowed to execute any synchronized method simultaneouly on the same object but remaining threads allowed to execute non-synchronized method simultaneously.
- Lock concept is implemented based on object but not based on method.
e.g.
class Display
{
    public synchronized void greet(String name)
    {
        for (int i = 0; i < 5; i++) {
            System.out.print("Hey: ");   
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
            System.out.println(name);
        }
    }
}
class MyThread extends Thread {
    Display d;
    String name;
    MyThread(Display d, String name)
    {
        this.d = d;
        this.name = name;
    }
    public void run() {
        d.greet(name);
    }
}
class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Dhoni");
        MyThread t2 = new MyThread(d, "Kohli");
        t1.start();
        t2.start();
    }
}
- If we are not declared greet() method as synchronized then both threads will be executed simultaneously and hence we will get irregular output.
- If we declared greet() method as synchronized then at a time only one thread is allowed to execute greet() on the given Display object hence we will get regular output.

# case study:
class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Display d1 = new Display();
        Display d2 = new Display();
        MyThread t1 = new MyThread(d1, "Dhoni");
        MyThread t2 = new MyThread(d2, "Kohli");
        t1.start();
        t2.start();
    }
}

- Even though greet() method is synchronized, we will get irregular output becuase threads are operting on different java objects.

# Conclusion: 
- If multiple threads are operating on same java object then synchronization is required.
- If multiple threads are operating on multiple java object then synchronization is not required.

# class level lock:
- Every class in java has a unique lock which is also known as class level lock.
- If a thread wants to execute a static synchonized method then thread required class level lock
- once thread got class level lock then it is allowed to execute any static synchronized method of that class.
- once method execution completes, automatically thread releases lock.
- While a thread executing static synchronized method, the remaining threads are not allowed to execute any static synchronized method of that class simultaneously but remaining threads are allowed to execute following methods simultaneously:
1. normal static methods
2. synchronized instance methods
3. normal instance methods

e.g.
class X
{
    static synchronized m1() 
    static synchronized m2()
    static m3()
    synchronized m4()
    m5()
}

# synchronized block:
- If very few lines of code required synchronization then it is not recommanded to  declared entire method as synchronized.
- We have to enclose those few lines of code by using synchronized block.
- The main advantage synchronized block over synchronized method is, it reduces waiting time of threads and improves performance of the system.
- We can declare synchronized block as follows:
1. to get Lock of current Object:
synchronized(this)
{
If a thread got Lock of current object then only it is allowed to execute this area
}

2. to get Lock of particular Objet 'b':
synchronized(b)
{
    If a thread got lock of particular object 'b' then only it is allowed to execute this Area
}

3. to get class level lock:
synchronized(Display.class)
{
    If a thread got class level lock of 'Display' class, then only it is allowed to execute this area
}

- Lock concept applicable for only object and class but not for primitives hence we can't pass primitive argument type to synchronized block otherwise we will get compile time error.

# FAQs:
1. What is synchronized keyword and where we can apply?
2. Explain advantage of synchronized keyword?
3. Explain disadvantage of synchronized keyword?
4. What is Race Condition?
5. What is Object Lock and when it is required?
6. What is class level lock and when it is required?
7. What is the difference between class level lock and object level lock?

# Inter Thread Communication:
- Two threads can communicate with eachother by using wait(), notify() and notifyAll().
- The Thread which is expecting updation is responsible to call wait() method then immediately the thread will entered into waiting state.
- The thread which is responsible to perform updation, after performing updation it is responsible to call notify() method then waiting thread will get notification and continue with execution with those updated items.
- wait(), notify() and notifyAll() methods present in Object class but not in thread class because thread can call these methods on any java object.
- To call wait(), notify(), notifyAll() methods on any object, thread should be owner of that object that is the thread should has lock of that object. The thread should be inside synchronized area. 
- Hence we can call wait(), notify() and notifyAll() methods only from synchronized area. Otherwise we will get runtime exception.

- If a thread class wait() method on any object, it immediately releases the lock of that particular object and entered into waiting state
- If a thread calls notify() method on any object it releases lock of that object but may not immediately.
- Except wait(), notify() and notifyALl(), there is no other method where thread releases lock.

public final void wait() throws InterruptedException
public final native void wait(long ms) throws InterruptedException
public final void wait(long ms, int ns) throws InterruptedException

public final native void notify() 
public final native void notifyAll() 

# Note: Every wait() method throws InterruptedException which is checked exception hence whnever we are using wait() method we must handle this InterruptedException either by try-catch or by throws keyword Otherwise we will get compile time error.

e.g.
class ThreadA
{
    public static void main(String[] aStrings) throws InterruptedException
    {
        ThreadB b = new ThreadB();
        b.start();
        synchronized(b)
        {
            System.out.println("main method trying to call wait() method");
            b.wait();
            System.out.println("main thread got notification");
            System.out.println(b.total);
        }
    }
}
class ThreadB extends Thread
{
    int total = 0;
    public void run()
    {
        synchronized(this)
        {
            System.out.println("child thread starts calculation");
            for (int i = 1; i <= 100; i++) {
                total = total + i;
            }
            System.out.println("child thread giving notification");
            this.notify();
        }
    }
}
o/p:
main method trying to call wait() method
child thread starts calculation
child thread giving notification
main thread got notification
5050

# producer-consumer problem:
- producer thread is responsible to produce items with q and consumer thread is responsible to consume items from the q.
- If q is empty, then consumer method will call wait() method and entered into waiting state.
- After producing items to the q, producer thread is responsible to call notify() method then waiting consumer will get that notification and continue its exxecution with updated items.
e.g.
class ProducerThread
{
    produce()
    {
        synchronized(q)
        {
            produce items to the Queue
            q.notify();
        }
    }
}
class ConsumerThread
{
    comsume()
    {
        synchronized(q)
        {
            if (q is empty)
            {
                q.wait();
            } 
            else
            {
                consume items
            }
        }
    }
}

# difference between notify() and notifyAll():
- We can use notify() method to give the notification for only one waiting thread.
- If multiple threads are waiting then only one thread will be notify and the remaining threads have to wait for further notifications.
- which thread will be notified we can't expect. It depends on JVM.
- We can use notifyAll() to give the notification for all waiting threads of a particular object.
- Even though multiple threads notified but execution will be performed one by one because threads required lock and only one lock is available.


# DeadLock:
- If two threads are waiting for each other forever such type of infinite waiting is called DeadLock.
- synchronized keyword is only reason for deadlock situation hence while using synchronized keyword we have to take special care.
- There are no resolution technique for deadlock but several prevention techniques are available.
e.g.
class A
{
    public synchronized void d1(B b)
    {
        System.out.println("Thread 1 starts execution od d1() method");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            
        }
        System.out.println("Thread 1 trying to call B's last()");    
        b.last();
    }
    public synchronized void last()
    {
        System.out.println("Inside A, this is last() method");
    }
}
class B
{
    public synchronized void d2(A a)
    {
        System.out.println("Thread 2 starts execution od d2() method");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
        System.out.println("Thread 2 trying to call A's last()");    
        a.last();
    }
    public synchronized void last()
        {
            System.out.println("Inside B, this is last() method");
        }
}
class DeadLock extends Thread
{
    A a = new A();    
    B b = new B();    
    public void m1()
    {
        this.start();
        a.d1(b);
    }
    public void run()
    {
        b.d2(a);
    }
    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        d.m1();
    }
}

- In the above program, if we remove at least one synchronized keyword, then the program won't entered into deadlock.
- Hence synchronized keyword is the only reason for deadlock situation.

# deadlock vs starvation:
- Long waiting of a thread where waiting never ends is called deadlock 
- Whereas long waiting of a thread where waiting ends at certain point is called starvation. for example low priority thread has to wait until completing all high priority threads. It may be long waiting but ends at certain point.

# Daemon Thread:
- The threads which are executing in the background are called Daemon Threads.
e.g.
Garbage Collector, Signal Dispatcher, Attach Listener

- The main objective of Daemon Thread is to provide support for non-daemon threads (main thread).
- If a main thread runs with low memory then JVM run garbage collector to destroy useless object so that number of bytes of free memory will be improved. 
- With this free memory, main thread can continue its execution.
- Usually daemon threads having low priority but based on our requirement daemon thread can run with high priority also.
- we can check daemon nature of a thread by using isDaemon() of a thread class.
public boolen isDaemon()
- We can change Daemon nature of a thread by using setDaemon() method
public void setDaemon(boolean b)
- But changing daemon nature is possible before starting of a thread only.
- After starting a thread if we are trying to change daemon nature we will get runtime exception saying IllegalThreadStateException

# Default nature of a thread:
- By default main thread is always non daemon and for all remaining threads daemon nature will be inheritated from parent to child.
- If the parent thread is daemon then automatically child thread is also daemon.
- If the parent thread is non-daemon then automatically child thread is also non-daemon.

# Note: It is impossible to change daemon nature of main thread because it is already started by JVM at begining.

e.g.

class MyThread extends Thread
{

}
class DaemonDemo
{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isDaemon()); // false
        // Thread.currentThread().setDaemon(true); // Exception in thread "main" java.lang.IllegalThreadStateException
        MyThread t = new MyThread();
        System.out.println(t.isDaemon()); // false
        t.setDaemon(true);
        System.out.println(t.isDaemon()); // true
    }
}
- Whenever last non-daemon thread terminates automatically all daemon threads will be terminated irrespective of their position.

e.g.

class MyThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                
            }
        }
    }
}
class DaemonDemo
{
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.setDaemon(true);
        t.start();
        System.out.println("End of the main thread");
    }
}
- If we comment t.setDaemon(true); both main and child threads are non-daemon and hence both threads will be executed until their completion.
- If we are not commenting   t.setDaemon(true); then main thread is non-daemon and child thread is daemon hence whenever main threads terminates automatically child thread will be terminated.
- In this case output is:
End of the main thread
child Thread
or
End of the main thread
or 
Child Thread
End of the main thread

# Green Thread:
- Java multi threading concept is implementated by using the following two models:
1. Green Thread Model:
The Thread which is managed completely by JVM without taking underlying OS support is called Green Thread.
Very few operating systems like SUN solaries provide support for green thread mmodel.
Anyway it is deprecated and not recomanded to use.


1. Native OS Model:
The thread which is managed by JVM with the help of underlying OS is called native OS model
All windows based Operating System provide support for native OS model.

# How to stop a Thread:
- We can stop a thread execution using stop() method of thread class.
public void stop()
- If we call stop() method then immediately the thread will entered into dead state.
- Anyway stop() method is deprecated and not recomanded to use

# How to suspend and resume of a Thread:
- We can suspend a thread by using suspend() of thread class then immediately the thread will be entered into suspended state.
- We can resume a suspended thread by using resume() method of thread class then suspended can continue its execution.
public boid suspend()
public boid resume()
- Anyway these methods are deprecated and not recomanded to use