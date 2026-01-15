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