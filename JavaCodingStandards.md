# Whenever we are writing java code it is highly recommended to follow coding standards.

# Coding standards for classes:
Usually class names are Nouns.
Should starts with upper case character and if it contains multiple words, every inner word should start with upper case character.
e.g. String, StringBuffer, Account, Dog, etc.

# Coding standards for Interfaces:
Usually interfaces names are adjectives.
should starts with upper case character and if it contains multiple words, every inner word should start with upper case character.
e.g. Runnable, Serializable, Comparable, etc.

# Coding standards for methods:
Usually methods names are either verbs or verb-noun combination.
should starts with lower case character and if it contains multiple words, every inner word should start with upper case character. (camelCase convention)
e.g. print(), eat(), add(), getWord(), setName(), etc.

# Coding standards for variables:
Usually variables names are nouns.
should starts with lower case character and if it contains multiple words, every inner word should start with upper case character. (camelCase Convention)
e.g. name, mobileNumber, salary, etc.

# Coding standards for constants:
Usually constants names are nouns.
should contain only upper case character and if it contains multiple words, every inner word should separate with underscore(_) character.
e.g. MAX_VALUE, MAX_PRIORITY, NORM_PRIORITY, MIN_PRIORITY, PI, etc.
# NOTE: Usually we can declare constants with public static and final modifiers. 

# JavaBean Coding standards:
JavaBean is a simple java class with private properties and public getter and setter methods.
e.g.
public class StudentBean {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class name ends with "Bean" is not official convention from SUN.

# Syntax for setter method:
1. It should be public method
2. The return type should be void.
3. Method name should be prefixed with set.
4. It should take some argument. 

# Syntax for getter method:
1. It should be public method.
2. The return type should not be void.
3. Method name should be prefixed with get.
4. It should not take any argument. 

# For boolean properties, getter method name can be prefixed with either get or is but recommended to use is.
private boolean empty;
public boolean getEmpty() {
    return empty;
}
public boolean isEmpty() {
    return empty;
}

# Coding standards for Listeners:
Case 1: To register a listener - 
Method name should be prefixed with add.
e.g. public void addMyActionListener(MyActionListener, l)

case 2: To unregister a listener - 
Method name should be prefixed with remove.
e.g. public void removeMyActionListener(MyActionListener, l)