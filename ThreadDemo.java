// class MyThread extends Thread
// {
//     public void run()
//     {
//         for (int i = 0; i < 10; i++)
//         {
//             System.out.println("Child Thread");  // executed by child Thread
//         }
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread(); // Thread instantiation
//         t.start(); // starting of the thread
//         for (int i = 0; i < 10; i++)
//         {
//             System.out.println("Main Thread");  // executed by main Thread
//         }
//     }
// }

// class MyThread extends Thread
// {
//     public void run()
//     {
//         System.out.println("no-arg run");  
//     }

//     public void run(int i)
//     {
//         System.out.println("int-arg run");  
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread(); // Thread instantiation
//         t.start(); // starting of the thread
//     }
// }

// class MyThread extends Thread
// {

// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread(); // Thread instantiation
//         t.start(); // starting of the thread
//     }
// }

// class MyThread extends Thread
// {
//     public void start()
//     {
//         System.out.println("start method");
//     }

//     public void run()
//     {
//         System.out.println("run method");
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread(); 
//         t.start(); 
//         System.out.println("main thread");
//     }
// }

// class MyThread extends Thread
// {
//     public void start()
//     {
//         super.start();
//         System.out.println("start method");
//     }

//     public void run()
//     {
//         System.out.println("run method");
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread(); 
//         t.start(); 
//         System.out.println("main thread");
//     }
// }

// class MyRunnable implements Runnable
// {
//     public void run()
//     {
//         for (int i = 0; i < 5; i++){
//             System.out.println("child thread");
//         }
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyRunnable r = new MyRunnable(); 
//         Thread t = new Thread(r);
//         t.start();
//         for (int i = 0; i < 5; i++){
//             System.out.println("main thread");
//         }
//     }
// }

// class MyThread extends Thread
// {

// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         System.out.println(Thread.currentThread().getName());
//         MyThread t = new MyThread();
//         System.out.println(t.getName());
//         Thread.currentThread().setName("Junaid Asif");
//         System.out.println(Thread.currentThread().getName());
//         System.out.println(10/0);
//     }
// }

// class MyThread extends Thread
// {
//     public void run()
//     {
//         System.out.println("run method executed by Thread : " + Thread.currentThread().getName());
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread();
//         t.start();
//         System.out.println("run method executed by Thread : " + Thread.currentThread().getName());
//     }
// }

// class MyThread extends Thread
// {

// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         System.out.println(Thread.currentThread().getPriority());
//         Thread.currentThread().setPriority(7);
//         MyThread t = new MyThread();
//         System.out.println(t.getPriority());
//     }
// }

// class MyThread extends Thread
// {
//     public void run()
//     {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("child thread");
//         }
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread();
//         t.setPriority(9);
//         t.start();
//         for (int i = 0; i < 5; i++) {
//             System.out.println("main thread");
//         }
//     }
// }

// class MyThread extends Thread
// {
//     public void run()
//     {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("child thread");
//             Thread.yield();
//         }
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args)
//     {
//         MyThread t = new MyThread();
//         t.start();
//         for (int i = 0; i < 5; i++) {
//             System.out.println("main thread");
//         }
//     }
// }

// class MyThread extends Thread
// {
//     public void run()
//     {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("child thread");
//             try {
//                 Thread.sleep(2000);
//             } catch (InterruptedException e) {
//             }
//         }
//     }
// }
// class ThreadDemo
// {
//     public static void main(String[] args) throws InterruptedException
//     {
//         MyThread t = new MyThread();
//         t.start();
//         t.join();
//         for (int i = 0; i < 5; i++) {
//             System.out.println("main thread");
//         }
//     }
// }



// class MyThread extends Thread {
//     static Thread mt;

//     public void run() {
//         try {
//             mt.join();
//         } catch (InterruptedException e) {
//         }
//         for (int i = 0; i < 5; i++) {
//             System.out.println("child thread");
//         }
//     }
// }

// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         MyThread.mt = Thread.currentThread();
//         MyThread t = new MyThread();
//         t.start();
//         for (int i = 0; i < 5; i++) {
//             System.out.println("main thread");
//             Thread.sleep(1000);
//         }
//     }
// }





// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         Thread.currentThread().join();
//     }
// }



// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Slide-" + i);
//             Thread.sleep(5000);
//         }
//     }
// }            



// class MyThread extends Thread {
//     public void run() {
//         try {
//             for (int i = 0; i < 5; i++) {
//                 System.out.println("child thread");
//                 Thread.sleep(2000);
//             }
//         } catch (InterruptedException e) {
//             System.out.println("I got interrupted");
//         }
//     }
// }

// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         MyThread t = new MyThread();
//         t.start();
//         t.interrupt();
//         System.out.println("end of main thread");
//     }
// }



// class MyThread extends Thread {
//     public void run() {
//         for (int i = 0; i < 20; i++) {
//                 System.out.println("child thread");
//         }
//         System.out.println("I am entering into sleeping state");
//         try {
//             Thread.sleep(10000);
//         } catch (InterruptedException e) {
//             System.out.println("I got interrupted");
//         }
//     }
// }

// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         MyThread t = new MyThread();
//         t.start();
//         t.interrupt();
//         System.out.println("end of main thread");
//     }
// }



// class Display
// {
//     public synchronized void greet(String name)
//     {
//         for (int i = 0; i < 5; i++) {
//             System.out.print("Hey: ");   
//             try
//             {
//                 Thread.sleep(2000);
//             }
//             catch (InterruptedException e)
//             {
//                 System.out.println(e);
//             }
//             System.out.println(name);
//         }
//     }
// }
// class MyThread extends Thread {
//     Display d;
//     String name;
//     MyThread(Display d, String name)
//     {
//         this.d = d;
//         this.name = name;
//     }
//     public void run() {
//         d.greet(name);
//     }
// }
// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         Display d = new Display();
//         MyThread t1 = new MyThread(d, "Dhoni");
//         MyThread t2 = new MyThread(d, "Kohli");
//         t1.start();
//         t2.start();
//     }
// }




// class Display
// {
//     public void greet(String name)
//     {
//         synchronized(this)
//         {
//             for (int i = 0; i < 5; i++) {
//             System.out.print("Hey: ");   
//             try
//             {
//                 Thread.sleep(2000);
//             }
//             catch (InterruptedException e)
//             {
//                 System.out.println(e);
//             }
//             System.out.println(name);
//         }
//         }
//     }
// }
// class MyThread extends Thread {
//     Display d;
//     String name;
//     MyThread(Display d, String name)
//     {
//         this.d = d;
//         this.name = name;
//     }
//     public void run() {
//         d.greet(name);
//     }
// }
// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         Display d = new Display();
//         MyThread t1 = new MyThread(d, "Dhoni");
//         MyThread t2 = new MyThread(d, "Kohli");
//         t1.start();
//         t2.start();
//     }
// }




// class Display
// {
//     public void greet(String name)
//     {
//         synchronized(Display.class)
//         {
//             for (int i = 0; i < 5; i++) {
//             System.out.print("Hey: ");   
//             try
//             {
//                 Thread.sleep(2000);
//             }
//             catch (InterruptedException e)
//             {
//                 System.out.println(e);
//             }
//             System.out.println(name);
//         }
//         }
//     }
// }
// class MyThread extends Thread {
//     Display d;
//     String name;
//     MyThread(Display d, String name)
//     {
//         this.d = d;
//         this.name = name;
//     }
//     public void run() {
//         d.greet(name);
//     }
// }
// class ThreadDemo {
//     public static void main(String[] args) throws InterruptedException {
//         Display d1 = new Display();
//         Display d2 = new Display();
//         MyThread t1 = new MyThread(d1, "Dhoni");
//         MyThread t2 = new MyThread(d2, "Kohli");
//         t1.start();
//         t2.start();
//     }
// }




// class ThreadA
// {
//     public static void main(String[] aStrings) throws InterruptedException
//     {
//         ThreadB b = new ThreadB();
//         b.start();
//         synchronized(b)
//         {
//             System.out.println("main method trying to call wait() method");
//             b.wait();
//             System.out.println("main thread got notification");
//             System.out.println(b.total);
//         }
//     }
// }
// class ThreadB extends Thread
// {
//     int total = 0;
//     public void run()
//     {
//         synchronized(this)
//         {
//             System.out.println("child thread starts calculation");
//             for (int i = 1; i <= 100; i++) {
//                 total = total + i;
//             }
//             System.out.println("child thread giving notification");
//             this.notify();
//         }
//     }
// }



// class A
// {
//     public synchronized void d1(B b)
//     {
//         System.out.println("Thread 1 starts execution od d1() method");
//         try {
//             Thread.sleep(6000);
//         } catch (InterruptedException e) {
            
//         }
//         System.out.println("Thread 1 trying to call B's last()");    
//         b.last();
//     }
//     public synchronized void last()
//     {
//         System.out.println("Inside A, this is last() method");
//     }
// }
// class B
// {
//     public synchronized void d2(A a)
//     {
//         System.out.println("Thread 2 starts execution od d2() method");
//             try {
//                 Thread.sleep(6000);
//             } catch (InterruptedException e) {
//             }
//         System.out.println("Thread 2 trying to call A's last()");    
//         a.last();
//     }
//     public synchronized void last()
//         {
//             System.out.println("Inside B, this is last() method");
//         }
// }
// class DeadLock extends Thread
// {
//     A a = new A();    
//     B b = new B();    
//     public void m1()
//     {
//         this.start();
//         a.d1(b);
//     }
//     public void run()
//     {
//         b.d2(a);
//     }
//     public static void main(String[] args) {
//         DeadLock d = new DeadLock();
//         d.m1();
//     }
// }




// class MyThread extends Thread
// {

// }
// class DaemonDemo
// {
//     public static void main(String[] args) {
//         System.out.println(Thread.currentThread().isDaemon()); // false
//         // Thread.currentThread().setDaemon(true); // Exception in thread "main" java.lang.IllegalThreadStateException
//         MyThread t = new MyThread();
//         System.out.println(t.isDaemon()); // false
//         t.setDaemon(true);
//         System.out.println(t.isDaemon()); // true
//     }
// }





// class MyThread extends Thread
// {
//     public void run()
//     {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Child Thread");
//             try {
//                 Thread.sleep(2000);
//             } catch (InterruptedException e) {
                
//             }
//         }
//     }
// }
// class DaemonDemo
// {
//     public static void main(String[] args) {
//         MyThread t = new MyThread();
//         t.setDaemon(true);
//         t.start();
//         System.out.println("End of the main thread");
//     }
// }



// class Test
// {
//     public static void main(String[] args)
//     {
//         ThreadGroup g1 = new ThreadGroup("First Group");
//         System.out.println(g1.getParent().getName()); 
//         ThreadGroup g2 = new ThreadGroup(g1, "Second Group");
//         System.out.println(g2.getParent().getName()); 
//     }
// }



// class ThreadGroupDemo
// {
//     public static void main(String[] args)
//     {
//         ThreadGroup g1 = new ThreadGroup("tg");
//         Thread t1 = new Thread(g1, "Thread1");
//         Thread t2 = new Thread(g1, "Thread2");
//         g1.setMaxPriority(3);
//         Thread t3 = new Thread(g1, "Thread3");
//         System.out.println(t1.getPriority()); 
//         System.out.println(t2.getPriority()); 
//         System.out.println(t3.getPriority()); 
//     }
// }


// class MyThread extends Thread
// {
//     MyThread(ThreadGroup g, String name)
//     {
//         super(g, name);
//     }
//     public void run()
//     {
//         System.out.println("Child Thread");
//         try {
//             Thread.sleep(5000);
//         } catch (Exception e) {
//         }
//     }
// }

// class ThreadGroupDemo
// {
//     public static void main(String[] args) throws Exception
//     {
//         ThreadGroup pg = new ThreadGroup("ParentGroup");
//         ThreadGroup cg = new ThreadGroup("ChildGroup");
//         MyThread t1 = new MyThread(pg, "ChildThread1");
//         MyThread t2 = new MyThread(pg, "ChildThread2");
//         t1.start();
//         t2.start();
//         System.out.println(pg.activeCount()); 
//         System.out.println(pg.activeGroupCount()); 
//         pg.list();
//         Thread.sleep(10000);
//         System.out.println(pg.activeCount()); 
//         System.out.println(pg.activeGroupCount());
//         pg.list();
//     }
// }



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