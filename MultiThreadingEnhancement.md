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
ThreadGroup g1 = new ThreadGroup(String gname);