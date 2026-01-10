# Introduction:
- An unexpected or unwanted event that disturbs normal flow of the program is called exception.
- It is highly recommanded to handle exceptions and the main objective of exception handling is graceful termination of the program.
- Exception handling does not mean repairing an exception. We have to provide alternative way to continue rest of the program normally, is a concept of exception handling.
e.g.
try 
{
    // Read data from remote file located at london
} 
catch (FileNotFoundException e)
{
    // use local file & continue rest of the program normally
}

# Runtime stack mechanism:
- For every thread, JVM will create a runtime stack.
- Each and every method call performed by that thread will be stored in the corresponding stack.
- Each entry in the stack is called stack frame or activation record.
- After completing every method call the corresponding entry from the stack will be removed.
- After completing all method calls, the stack will become empty and that empty stack will be destroyed by JVM just before terminating the thread.
e.g.
class Test
{
    public static void main(String[] args) 
    {
        doStuff();
    }
    public static void doStuff() 
    {
        doMoreStuff();
    }
    public static void doMoreStuff() 
    {
        System.out.println("Hello");
    }
}

# Default exception handling:
- Inside a method, if any exception occurs the method in which it is rised is responsible to create exception object by including the following information:
1. name of exception.
2. description of exception.
3. location at which exception occurs (stack trace)

- After creating exception object, method hand overs that object to the JVM.
- JVM will check whether the method contains any exception handling code or not. If the method doesn't contain exception handling code then JVM terminates that method abnormally and removes the corresponding entry from the stack.
- Then JVM identifies caller method and checks whether caller methods contains any handling code or not.
- If the caller method doesn't contain handling code then JVM terminates that caller method also abnormally and removes the corresponding entry from the stack. This process will be continued until main method and if the main method also doesn't contain handling code then JVM terminates main method also abnormally and removes corresponding entry from the stack.
- Then JVM hand overs responsibility of exception handling to default exception handler, which is the part of JVM.
- Default exception handler prints exception information in the following format and terminates program abnormally:
Exception in thread "main" Name of Exception: Description
stack trace

e.g.
class Test
{
    public static void main(String[] args) 
    {
        doStuff();
    }
    public static void doStuff() 
    {
        doMoreStuff();
    }
    public static void doMoreStuff() 
    {
        System.out.println(10/0);
    }
}
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Test.doMoreStuff(main.java:260)
        at Test.doStuff(main.java:256)
        at Test.main(main.java:252)


e.g.
class Test
{
    public static void main(String[] args) 
    {
        doStuff();
        System.out.println(10/0);
    }
    public static void doStuff() 
    {
        doMoreStuff();
        System.out.println("Hi");
    }
    public static void doMoreStuff() 
    {
        System.out.println("Hello");
    }
}        
Hello
Hi
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Test.main(main.java:269)


# Note: In a program, if at least one method terminates abnormally then the program termination is abnormal termination. If all methods terminated normally then only program termination is normal termination.

# Exception Hirarchy:
- Throwable class acts as root for java exception hirarchy.
- Throwable class defines two child classes Exception and Error.

1. Exception:
- Most of the times exceptions are caused by our program and these are recoverable. e.g. If our program requirement is to read data from remote file locating at london, at runtime if remote file is not avaible then we will get runtime exception saying FileNotFoundException.
- If FileNotFoundException occurs, we can provide local file and continue rest of the program normally.

2. Error:
- Most of the times, errors are not caused by our program and these are due to lack of system resources.
- Errors are non-recoverable.
for example if OutOfMemomyError occurs, being a program we cannot do anything and the program will be terminated abnormally.

![alt text](image.png)
![alt text](image-1.png)
 
# Checked vs Unchecked Exceptions: (V.imp)
- The exceptions which are checked by compiler for smooth execution of the program are called checked exception.
e.g. FileNotFoundException
- In our program if there is a chance of raising checked exception then we must handle that checked exception (either by try-catch or throws keyword) otherwise we will get compile time error.

- The exceptions whcih are not checked by compiler whether programmer handling or not such type of exceptions are called unchecked exception.
e.g.
ArithmeticException

# Note: Whether it is checked or unchecked, every exception occurs at runtime only. There is no chance of occuring exceptions at compile time.

# Note: RuntimeException and its child classes, Error and its child classes are unchecked. Except these remaining are checked.

# Fully checked vs Partially checked:
- A checked exception is said to be fully checked if and only if all its child classes also checked.
e.g.
IOException, InterruptedException

- A checked exception is said to be partially checked if and only if some of its child classes are unchecked.
e.g.
Exception, Throwable

# Note: The only possible partially checked exxceptions in java are Exception and Throwable.

# Customized Exception Handling by try-catch:
- It is highly recommanded to handle exceptions.
- The code which may raise exception is risky code and we have to define that code inside try block and corresponding handling code we have to define inside catch block.

try
{
    risky code
}
catch (Exception e)
{
    Handling code
}

e.g.

class Test
{
    public static void main(String[] args)
    {
        System.out.println("Hey");
        try
        {
            System.out.println(10/0);
        }
        catch (ArithmeticException e)
        {
            System.out.println(10/5);
        }
        System.out.println("Hello");
    }
}
o/p:
Hey
5
Hello

# Control flow in try-catch:
try
{
    statement 1;
    statement 2;
    statement 3;
}
catch (Exception e)
{
    statement 4;
}
    statement 5;

case 1:
- If there is no exception:
O/p: statement 1 statement 2 statement 3 statement 5 - Normal termination

case 2:
- If an exception raised at statement 2 and corresponding catch block matched:
O/p: statement 1 statement 4 statement 5 - Normal termination

case 3:
- If an exception raised at statement 2 and corresponding catch block not matched:
O/p: statement 1 - Abnormal termination

case 4:
- If an exception raised at statement 4 or statement 5 then it is always abnormal termination.

# Note: Within the try block, if anywhere exception raised then rest of the try block won't be executed even though we handled that exception hence within the try block we have to take only risky code and length of try block should as less as possible.

# Note: In addition to try block, there may be a chance of raising an exception inside catch and finally blocks.

# Note: If any statement which is not part of try block and raises an exception then it is always abnormal termination.