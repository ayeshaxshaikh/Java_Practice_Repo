# Data Hiding:
- Outside person can't access our internal data directly or our internal data should not go directly.
This OOP feature is nothing but data hiding.
- After validation or identification, outside person can access our internal data.
- e.g: After providing proper username and password, we can able to access our gmail inbox information.
- By declaring data member (variable) as private, we can achieve data hiding.

e.g.
public class Account
{
    private double balance;

    public double getBalance()
    {
        // validation
        return balance;
    }
}

- The main advantage of data hiding is security.

# NOTE: It is highly recommanded to declare data member (variable) as private.

# Abstraction:
- Hiding internal implementation and just highlight the set of services what we are offering, is a concept of abstraction.
- e.g.: ATM GUI Screen
- The main advantages of abstractions are:
1. We can achieve security because we are not highlighting our internal implementation.
2. Without affecting outside person, we can able to perform any type of changes in our internal system and hence enhancement will becomes easy.
3. It improves maintainablity of the application.
4. It improves easiness of our system.

- By using interfaces and abstract classes, we can implement abstraction.

# Encapsulation:
- The process of binding data and corresponding methods into a single unit is nothing but encapsulation.
e.g.
class student 
{
    data members
         +
    methods(behaviour)     
}

- If any component follows data hiding and abstraction, such type of component is said to be encapsulated component.
Encapsulation = data hiding + abstraction

e.g.
public class Account
{
    private double balance;

    public double getBalance()
    {
        // validation
        return balance;
    }

    public void setBalance(double balance)
    {
        // validation
        this.balance = balance;
    }
}

- The main advantages of encapsulation are:
1. We can achieve security.
2. Enhancement will becomes easy.
3. It improves maintainablity of the application.

- The main disadvantage of encapsulation is, it increases length of the code and slows down execution.


# Tightly Encapsulation:
- A class is said to be tightly encapsulated if and only if each and every variable declared as private whether class contains corresponding getter and setter method or not and whether these methods are declared as public or not. These things we are not required to check.

public class Account
{
   private double balance;

    public double getBalance()
    {
        return balance;
    }
}

# NOTE: If the parent class is not tightly encapsulated then no child class is tightly encapsulated.