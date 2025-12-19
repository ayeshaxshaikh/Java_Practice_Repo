# Flow-Control describes the order in which the statements will be executed at runtime:
1. selection statements:
if-else
switch

2. Iterative statements:
while()
do-while()
for()
for-each loop

3. Transfer Statements:
break
continue
return
try-catch-finally
assert

# if-else:
The argument to the if statement should be boolean type, by mistake if we are trying to provide any other type then we will get compile time error.
e.g.
int x = 0;
if (x) {
    Sopln("Hello");
} else {
    Sopln("Hi");
} // CE

int x = 10;
if (x = 20) {
    Sopln("Hello");
} else {
    Sopln("Hi");
} // CE

int x = 10;
if (x == 20) {
    Sopln("Hello");
} else {
    Sopln("Hi");
} // Hi

boolean b = true;
if (b = false) {
    Sopln("Hello");
} else {
    Sopln("Hi");
} // Hi

boolean b = false;
if (b == false) {
    Sopln("Hello");
} else {
    Sopln("Hi");
} // Hello

else part and curly braces are optional, without the curly braces only one statement is allowed under if which should not be declarative statement.

NOTE: Every else is mapped to the nearest if statement.\

# switch statement:
If several options are available then it is not recommanded to use if-else statements. It reduces readability. To handle this requirement we should go for switch statement.
The allowed argument types for the switch statements are:
byte, short, char, int until 1.4v.
But from 1.5v onwards corresponding wrapper classes and enum type also allowed.
From 1.7v, String type also allowed.

Every case label should be compile time constant i.e. constant expression
e.g.
int x = 10;
int y = 20;
switch(x) {
    case 10:
        Sopln(10);
        break;
    case y:
        Sopln(20);
        break;    
} // CE

But if we declare y as final then we won't get any compile time error.

Duplicate case labels are not allowed otherwise we will get compile time error.
e.g.
int x = 10;
switch (x) {
    case 97:
        Sopln(97);
        break;
    case 98:
        Sopln(98);
        break;
    case 99:
        Sopln(99);
        break;
    case 'a':
        Sopln('a');
        break;
} // CE: Duplicate case label

# Fall-through inside a switch:
Within the switch, if any case is matched from that case onwards all statements will be executed until break or end of the switch, this is called fall-through inside a switch.
The main advantage is we can define common action for multiple cases (code reusability).

e.g.
switch(x) {
    case 1:
    case 2:
    case 3:
        Sopln("Q-4");
        break;
    case 4:
    case 5:
    case 6:
        Sopln("Q-1");  
        break;  
}

e.g.
switch (x) {
    case 0:
        Sopln(0);
    case 1:
        Sopln(1);
        break;
    case 2:
        Sopln(2);
    case 'a':
        Sopln('a');
        break;
} 
if x = 0 // 0, 1
x = 1 // 1
x = 2 // 2, 97 
x = 3 // 97


# Iterative Statements:
# While loop:
If we don't know number of iteration in advance then we should go for while loop.
e.g.
while (rs.next()) {
}
while (e.hasMoreElement()) {
}
while (its.hasNext()) {
}

The argument should be boolean type, if we are trying to provide any other type then we will get compile time error.
e.g.
while(1) {
    Sopln("Hello");
} // CE

e.g.
while (true) {
    Sopln("Hello");
}
Sopln("Hi");
// CE: Unreachable Statement

e.g.
while (false) {
    Sopln("Hello");
}
Sopln("Hi");
// CE: Unreachable Statement

e.g.
int a = 10, b = 20;
while (a < b) {
    Sopln("Hello");
}
Sopln("Hi");
// Hello, Hello, Hello, .....

e.g.
int a = 10, b = 20;
while (a > b) {
    Sopln("Hello");
}
Sopln("Hi");
// Hi

e.g.
final int a = 10, b = 20;
while (a < b) {
    Sopln("Hello");
}
Sopln("Hi");
// CE

e.g.
final int a = 10, b = 20;
while (a > b) {
    Sopln("Hello");
}
Sopln("Hi");
// CE

# NOTE: Every final variable will be replaced by the value at compile time only.
e.g.
final int a = 10;
int b = 20;
Sopln(a); 
Sopln(b);
After Compilation:
Sopln(10);
Sopln(b);

# NOTE: If every argument is a final variable (compile time constant) then that operation should be performed at compile time only.
final int a = 10, b = 20;
Sopln(a + b); after compilation Sopln(30)

# do-while:
If we want to execute loop body at least once then we should go for do-while loop.

# For loop:
For loop is the most commonly used loop in Java. If we know number of iterations in advance then for-loop is the best choice.

Initialization:
This part will be executed only once in loop lifecycle. Here we can declare and initialize local variables of for-loop.
We can declare any numbers of variables but should be of the same type.
int i = 0, j = 0; ✅ 
int i = 0, String s = "love"; ❌ 
int i = 0, int j = 0; ❌ 

Conditional Check:
Here we can take any valid java expression but should be of the type boolean.
This part is optional and if we are not taking anything then compiler will always place true.

Increment or Decrement Section:
we can take Any valid java statement including Sop are.

# For-Each loop (Enhanced for-loop):
Introduced in 1.5v.
It is specially designed loop to iterate elements of arrays and collections.
e.g.
int[] x = {10, 20, 30};
for (int x1: x) {
    Sopln(x1);
}

e.g.
int[][] x = {{1, 2, 3}, {4, 5}};
for (int i = 0; i < x.length; i++) {
    for (int j = 0; j < x[i].length; j++) {
        Sopln(x[i][j]);
    }
}

for (int[] x1: x) {
    for (int x2: x1) {
        Sopln(x2);
    }
}

for-each loop is the best choice to retrive elements of arrays and collection but its limitation is it is applicable only for arrays and collection and it is not a general purpose loop.

Iterable Interface:
The target element in for-each loop should be iterable object.
An object is said to be iterable if and only if corresponding class implements java.lang.Iterable(I).
Iterable(I) intruduced in 1.5v. and it contains only one method.
public Iterator iterator()
All array related classes and collection implemented classes already implement iterable interface.

# break statement:
We can use break statement in the following places:
1. Inside Switch: To stop fall through.
2. Inside Loops: To break loop execution based on some condition.
3. Inside labeled blocks: To break block execution based on some condition.

# continue statement:
We can use continue statement inside loop to skip current iteration and continue for the next iteration.

We can use labeled break and continue to break or continue a particular loop in nested loops.
e.g.
l1:
for {
    l2: {
        for {
            for {
                break l1;
                break l2;
                break;
            }
        }
    }
}