// import java.util.concurrent.*;

// class PrintJob implements Runnable {
//     String name;
//     PrintJob(String name)
//     {
//         this.name = name;
//     }
//     public void run()
//     {
//         System.out.println(name + "...job started by thread: " + Thread.currentThread().getName());
//         try {
//             Thread.sleep(5000);
//         } catch (InterruptedException e) {
            
//         }
//         System.out.println(name + "...job completed by thread: " + Thread.currentThread().getName());
//     }
// }

// class ExecutorDemo
// {
//     public static void main(String[] args) {
//         PrintJob[] jobs = {
//             new PrintJob("Sadia"),
//             new PrintJob("Shoyee"),
//             new PrintJob("Junaid"),
//             new PrintJob("Mona"),
//         };
//         ExecutorService service = Executors.newFixedThreadPool(3);
//         for (PrintJob job: jobs)
//         {
//             service.submit(job);
//         }
//         service.shutdown();   
//     }
// }






import java.util.concurrent.*;

class MyCallable implements Callable 
{
    int num;
    MyCallable(int num)
    {
        this.num = num;
    }
    public Object call() throws Exception
    {
        System.out.println(Thread.currentThread().getName() + "is responsible to find sum of first " + num + " numbers");
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }   
        return sum;
    }
}

class CallableFutureDemo
{
    public static void main(String[] args) throws Exception
    {
        MyCallable[] jobs = {
            new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50),
            new MyCallable(60),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyCallable job: jobs)
        {
            Future f = service.submit(job);
            System.out.println(f.get());
        }
        service.shutdown();   
    }
}
