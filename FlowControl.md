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
