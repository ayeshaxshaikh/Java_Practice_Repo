# Array:
- An array is an indexed collection of fixed number of homogenous data elements.
- The main advantage of array is, we can represent multiple values by using single variable so that readability of the code will be improved.

# Limitations of Array:
- Arrays are fixed in size. once we create an array there is no chance of increasing or decreasing the size based on our requirement.
- Due to this to use arrays concept we must know the size in advance which may not possible always.\
- Array can hold only homogeneous data type elements.
e.g.
Student[] s = new Student[1000];
s[0] = new Student();
s[1] = new Customer();
    CE: incompatible types
        found: Customer
        required: Student

- We can solve this problem by using Object type arrays.
Object[] a = new Object[1000];
a[0] = new Student();
a[1] = new Customer();

- Arrays concept not implemented based on some standard data structure and hence ready-made method support is not available
- For every requirement we have to write the code explicitly which increases complexity of programming.

- To overcome above problems of arrays we should go for collection concept.

# Collections:
- Collections are growable in nature. based on our requirement we can increase or decrease the size.
- Collections can hold homogeneous and heterogeneous objects 
- Every collection class is implemented based on some standard data structure hence for every requirement ready-made data support is available
- Being a programmer we are responsible to use those methods, and we are not responsible to implement those.


# Array                                                                     Collection
------------------------------------------------------------------------------------------------------------------------------------
1. Arrays are fixed in size                                                 Collections are growable in nature. based on our requirement we can increase or decrease the size    
2. W.r.t memory, arrays are not recommended to use                          w.r.t memory, collections are recommended to use
3. w.r.t performance arrays are recommended to use                          w.r.t performance, collections are not recommended to use
4. Arrays can hold only homogeneous data type element                       Collections can hold both homogeneous and heterogeneous data type element
5. There is no underlying data structure for arrays and hence               Every collection class is implemented based on some standard data structure and hence for every requirement ready-made data support is available.
ready-made data support is not available. For every requirement
we have to write the code explicitly which increases 
complexity of programming.
6. Arrays can hold both primitive and objects                               Collections can hold only object type but not primitive


# Collection:
- If we want to represent a group of individual object as a single entity then we should go for collection.

# collection framework:
- It contains several classes and interfaces which can be used to represent a group of individual objects as a single entity.

# 9 key interfaces of collection framework:
1. Collection
2. List
3. Set
4. SortedSet
5. NavigableSet
6. Queue
7. Map
8. SortedMap
9. NavigableMap

# Collection (I):
- If we want to represent a group of individual objects as a single entity then we should go for collection.
- Collection interface defines the most common methods which are applicable for any collection object 
- In general collection interface is considered as root interface of collection framework
- There is no concrete class which implements collection interface directly

# Collection vs Collections:
- Collection is an interface. If we want to represent a group of individual objects as a single entity then we should go for Collection.
- Collections is a utility class present in java.util package to define several utility methods for collection objects (like sorting, searching, etc.)

# List (I):
- It is the child interface of Collection.
- If we want to represent a group of individual objects as a single entity where duplicates are allowed where insertion order must be preserved then we should go for List.

Collection (I) 1.2v  ----> List (I) 1.2v ----> 1. ArrayList 1.2v
                                               2. LinkedList 1.2v
                                               3. Vector 1.0v ---> Stack 1.0v

# Note: In 1.2v Vector and Stack classes are re-engineered to implement List interface                         

# Set (I):
- It is the child interface of Collection
- If we want to represent a group of individual objects as a single entity where duplicates are not allowed and insertion order is not required then we should go for Set interface.

Collection (I) 1.2v ----> Set (I) 1.2v -----> HashSet 1.2v ----> LinkedHashSet 1.4v

# SortedSet (I):
- It is the child interface of Set 
- If we want to represent a group of individual objects as a single entity where duplicates are not allowed and objects should be inserted according to some sorting order then we should go for SortedSet

# NavigableSet(I):
- It is the child interface of SortedSet
- It contains several methods for navigation purposes

Collection(I) 1.2v ----> Set (I) 1.2v ----> SortedSet(I) 1.2v ----> NavigableSet(I) 1.6v ----> TreeSet 1.2v

# List                                 Set:
- Duplicates are allowed               Duplicates are not allowed
- Insertion order preserved            Insertion order not preserved

# Queue (I):
- It is the child interface of Collection
- If we want to represent a group of individual objects prior to processing then we should go for Queue.
- Usually Queue follows first in first out order but based on our requirement we can implement our own priority order also
e.g.
- before sending a mail all mailIds we have to store in some data structure in which order we added mainIDs in the same order only mail should be delivered
- for this requirement Queue is the best choice

Collect(I) --->  Queue(I) 1.5v ----> 1. BlockingQueue ---->  1. PriorityBlockingQueue
                                     2. PriorityQueue        2. LinkedBlockingQueue

# Note: All the above interfaces (Collection, List, Set, SortedSet, NavigableSet, Queue) meant for representing a group of individual objects. If we want to represent a group of objects as key-value pair then we should go for map.

# map (I):
- map is not child interface of Collection
- If we want to represent a group of object as key-value pairs then we should go for map.
- Both key and value are objects only
- Duplicate keys are not allowed but values can be duplicate

Map (I) 1.2v ----> Hashmap 1.2 ----> LinkedHashmap 1.4v
                   WeakHashmap 1.2
                   IdentityHashmap 1.4v
Dictionary(AC) --> Hashtable  ---> Properties (1.0v)

# Sortedmap(I):
- It is the child interface of map 
- If we want to represent a group of key-value pairs according to some sorting order of keys then we should go for Sortedmap.
- In Sortedmap, the sorting should be based on key but not based on value.

# NavigableMap (I):
- It is the child interface of Sortedmap
- It defines several methods for navigation purposes

Map (I) 1.2v ---> Sortedmap(I) 1.2v ---> NavigableMap(I) 1.6v ---> Treemap 1.2v

# The following are legacy characters present in Collection framework:
- Enumeration (I)
- Dictionary (AC)
- Vector (C)
- Stack (C)
- Hashtable (C)
- Properties (C)
- ![img_1.png](img_1.png)

# Collection(I):
- If we want to represent a group of individual objects as a single entity we should go for collection
- Collection interface defines most common method which are applicable for any Collection object 

1. boolean add(Object o);
2. boolean addAll(Collection c);
3. boolean remove(Object o);
4. boolean removeAll(Collection c);
5. boolean retainAll(Collection c);
    - to remove all objects except those present in c
6. void clear();
7. boolean contains(Object o);
8. boolean containsAll(Collection c);
9. boolean isEmpty();
10. int size();
11. Object[] toArray();
12. Iterator iterator();

# Note: There is no concrete class which implements collection interface directly

# List(I):
- List is child interface of Collection 
- If we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order must be preserved then we should go for List.
- We can preserve insertion order via index, and we can differentiate duplicate objects by using index. Hence index will play very important role in List
- List interface defines the following specific methods:
1. void add(int index, Object o);
2. boolean addAll(int index, Collection c);
3. Object get(int index);
4. Object remove(int index);
5. Object set(int index, Object new)
   to replace the element present at specified index with provided Object and returns old object
6. int indexOf(Object o)
   returns index of first occurrence of 'o'
7. int lastIndexOf(Object o);
8. ListIterator listIterator();

Collection(I) ----> List(I) ----> ArrayList
                                  LinkedList
                                  Vector ----> Stack  

# ArrayList:
- The underlying data structure is resizable array or growable array
- Duplicates are allowed
- insertion order is preserved
- Heterogeneous objects are allowed (except TreeSet and Treemap)
- Null insertion is possible

# ArrayList Constructor:
1. ArrayList l = new ArrayList();
- creates an empty arraylist object with default initial capacity 10.
- once array list reaches its max capacity then a new array list object will be created with   
New Capacity = (Current capacity * 3/2) + 1

2. ArrayList l = new ArrayList(int initialCapacity);
- creates an empty array list object with specified initial capacity

3. ArrayList l = new ArrayList(Collection c);
- creates an equivalent array list object for the given collection.
e.g.
  import java.util.ArrayList;

class ArrayListDemo{
public static void main(String[] args){
ArrayList l =  new ArrayList();
l.add(1);
l.add("A");
l.add(null);
System.out.println(l);
}
}

- Usually we can use collections to hold and transfer objects from one location to another location (container). To provide support for this requirement every collection class by default implements serializable and cloneable interfaces
- ArrayList and Vector classes implements RandomAccess Interface so that any random element we can access with the same speed

# RandomAccess:
- RandomAccess interface present in java.util package, and it doesn't contain any methods. It is a marker interface where required ability will be provided automatically by the JVM
- ArrayList is the best choice if our frequent operation is retrieval operation because ArrayList implements RandomAccess interface
- ArrayList is the worst choice if our frequent operation is insertion or deletion in the middle.

# ArrayList vs Vector:
- Every method present in ArrayList is non-synchronized but every method present in Vector is synchronized
- At a time multiple threads are allowed to operate on ArrayList object and hence it is not thread safe but at a time only one thread is allowed to operate on Vector object and hence it is thread safe
- Relatively performance is high in ArrayList because threads are not required to wait to operate on ArrayList object. - Relatively performance is low in Vector because threads are required to wait to operate on Vector object. 
- Introduced in 1.2v and ArrayList is non legacy. Vector introduced in 1.0v and it is legacy. 

# How to get synchronized version of ArrayList object?
- By default, ArrayList is non-synchronized, but we can get synchronized version of ArrayList object by using synchronizedList() method of Collections class
public static List synchronizedList(List l);
e.g.
ArrayList al = new ArrayList();
List l = Collections.synchronizedList(al);

- Similarly, we can get synchronized version of set and map objects by using:
public static Set synchronizedSet(Set s);
public static Map synchronizedMap(Map m);

# LinkedList:
- The underlying data structure is double linkedList
- Insertion order is preserved 
- Duplicates objects are allowed
- Heterogeneous Object are allowed
- Null insertion is possible
- LinkedList implements serializable and cloneable interfaces but not RandomAccess
- LinkedList is the best choice if our frequent operation is insertion or deletion in the middle
- LinkedList is the worst choice if our frequent operation is retrieval operation

# LinkedList constructors:
1. LinkedList l = new LinkedList();
   - creates an empty LinkedList object
2. LinkedList l = new LinkedList(Collection c);
   - creates an equivalent LinkedList object for the given collection

# LinkedList class specific method:
- Usually we can LinkedList to develop stack and Queues
- To provide support for this requirement LinkedList class defines the following specific methods:
void addFirst(Object o);
void addLast(Object o);
Object getFirst();
Object getLast()
Object removeFirst()
Object removeLast()

# ArrayList vs LinkedList:
- ArrayList is the best choice if our frequent operation is retrieval operation.
- LinkedList is the best choice if our frequent operation is insertion or deletion in the middle
- ArrayList is the worst choice if our frequent operation is insertion or deletion in the middle because internally several shift operations are performed 
- LinkedList is the worst choice if our frequent operation is retrieval operation
- In ArrayList elements will be stored in consecutive memory locations and hence retrieval operation will become easy
- In LinkedList the elements won't be stored in consecutive memory locations and hence retrieval operation will become difficult

# Vector:
- The underlying data structure is resizable array or growable array
- Insertion order is preserved
- Duplicates are allowed
- heterogeneous objects are allowed 
- Null insertion is possible
- It implements serializable, cloneable and RandomAccess interfaces
- Every method present in the Vector is synchronized and hence Vector object is thread safe

# Vector Constructor:
1. Vector v = new Vector();
- creates an empty vector object with default initial capacity 10
- Once vector reaches its max capacity then a new Vector object will be created with 
- New Capacity = Current capacity * 2

2. Vector v = new Vector(int initialCapacity);
- creates an empty vector object with specified initial capacity

3. Vector v = new Vector(int initialCapacity, int incrementCapacity);

4. Vector v = new Vector(Collection c);
- creates an equivalent Vector object for given collection
- This constructor meant for interconversion between collection objects 

# Vector specific methods:
add(Object o) --> Collection
add(int index, Object o) --> List
addElement(Object o) --> Vector
remove(Object o) --> Collection
removeElement(Object o) --> Vector
remove(int index) --> List
removeElementAt(int index) --> Vector
clear() --> Collection
removeAllElements() --> Vector
Object get(int index) --> List
Object elementAt(int index) --> Vector
Object firstElement() --> Vector
Object lastElement() --> Vector
int size()
int capacity()
Enumeration elements()

# Stack:
- It is the child class of Vector
- It is a specially designed class for Last-in-first-out order
Stack s = new Stack();
methods:
Object push(Object o)
    - to insert an object into the stack
Object pop()
    - to remove and return top of the stack
Object peek()
    - to return top of the stack without removal
boolean empty()
    - returns true if the stack is empty
int search(Object o)
    - returns offset if the element is available otherwise returns -1

# The 3 cursors of Java:
- If we want to get Objects one by one from the collection then we should go for cursor
- there are 3 types of cursors available in java
1. Enumeration
2. Iterator
3. ListIterator

# Enumeration:
- we can use enumeration to get objects one by one from legacy collection object
- we can create enumeration object by using elements() method of Vector class
public Enumeration elements();
e.g.
Enumeration e = v.element();
-methods:
public boolean hasMoreElement();
public Object nextElement();

# Limitations of Enumeration:
- We can apply enumeration concept only for legacy classes and it is not a universal cursor
- By using enumeration we can get only read access and we can't perform remove operation
- To overcome above limitations we should go for Iterator

# Iterator:
- We can apply Iterator concept for any Collection object and hence it is universal cursor
- By using Iterator we can perform both read and remove operations
- We can create Iterator Object by using iterator() method of Collection interface
public Iterator iterator();
e.g.
Iterator itr = c.iterator();  c --> any collection object
- methods:
public boolean hasNext()
public Object next()
public void remove()

# Limitations of Iterator:
- By using Enumeration and Iterator we can always move only towards forward direction and we can't move towards backward direction
- These are single direction cursors but not bidirectional cursor
- By using Iterator we can perform only read and remove operation, and we can't perform replacement or addition of new Objects
- To overcome above limitations we should go for ListIterator

# ListIterator:
- By using ListIterator we can move either to the forward direction or to the backward direction 
- Hence, it is bidirectional cursor
  - By using ListIterator we can perform replacement or addition of new Objects in addition to read and remove operation
  public ListIterator listIterator();
  e.g.
  ListIterator ltr = l.ListIterator();  l --> any list object
- ListIterator(I) is the child interface of Iterator(I) and hence all method present in Iterator by default available to the ListIterator

# methods:
- ListIterator defines the following 9 methods:
public boolean hasNext()
public Object next()
public int nextIndex()

public boolean hasPrevious()
public Object previous()
public int previousIndex()

public void remove()
public void add(Object o)
public void set(Object o)

- The most powerful cursor is ListIterator but its limitation is it is applicable only for List objects


Property                         Enumeration                                        Iterator                      ListIterator
----------------------------------------------------------------------------------------------------------------------------------
Where we can apply               Only for legacy classes                            For any Collection object     Only for List objects
Is it legacy                     yes (1.0v)                                         No (1.2v)                     No (1.2v)
Movement                         Single direction (only forward direction)          Single direction (forward)    Bidirectional
Allowed Operations               Only read                                          Read / Remove                 Read / remove / replace / add
How we can get                   By using elements() of Vector class                iterator() of Collection(I)   listIterator() of List(I)
methods                          2 methods                                          3 methods                     9 methods
                                 hasMoreElements()                                  hasNext()
                                 nextElement()                                      next(), remove()

# Set:
Collect(I) 1.2v --> Set(I) 1.2v --> HashSet 1.2v --> LinkedHashSet 1.2v
                                    SortedSet 1.2v --> NavigableSet 1.6v --> TreeSet 1.2v

- Set is child interface of Collection
- If we want to represent a group of individual objects as a single entity where duplicates are not allowed and insertion order not preserved
- Set interface doesn't contain any new method and we have to use only Collection interface methods

# HashSet:
- The underlying data structure is Hashtable 
- Duplicate objects are not allowed
- Insertion order not preserved, and it is based on hashcode of objects
- Null insertion is possible (only once)
- Heterogeneous objects are allowed
- Implements serializable, cloneable but not RandomAccess interface
- HashSet is the best choice if our frequent operation is search operation

# Note: In HashSet duplicates are not allowed if we are trying to insert duplicates then we won't get any compile time or runtime errors and add() method simply returns false
e.g.
HashSet h = new HashSet();
System.out.println(h.add("A"));  // true
System.out.println(h.add("A"));  // false

# Constructors:
HashSet h = new HashSet();
- creates an empty HashSet object with default initial capacity 16 and default fill ratio 0.75

HashSet h = new HashSet(int initialCapacity);
- creates an empty HashSet object with specified initial capacity and default fill ratio 0.75

HashSet h = new HashSet(int initialCapacity, float fillRatio);

HashSet h = new HashSet(Collection c);
- creates an equivalent HashSet for given collection
- This constructor meant for interconversion between Collection objects

# Fill Ratio or Load Factor:
- After filling how much ratio, a new HashSet object will be created, this ratio is called fill ratio or load factor
- fill ratio 0.75 means, after filling 75% ratio a new HashSet object will be created

e.g.
import java.util.HashSet;

class HashSetDemo {
public static void main(String[] args) {
HashSet h = new HashSet();
h.add("A");
h.add("Z");
h.add("C");
h.add(null);
h.add(20);
System.out.println(h.add("D"));
System.out.println(h);
}
}
o/p:
true
[null, A, C, 20, D, Z]

# LinkedHashSet:
- It is the child class of HashSet
- It is exactly same as HashSet (including constructors and methods) except the following differences:

HashSet                                         LinkedHashSet
-----------------------------------------------------------------------------
The underlying data structure is Hashtable      The underlying data structure is the combination of LinkedList and Hashtable
Insertion order not preserved                   Insertion order preserved
Introduced in 1.2v                              Introduced in 1.4v

- In the above HashSet program If we replace HashSet with LinkedHashSet then output is [A, Z, C, null, 20, D] that is insertion order is preserved
# Note: In general we can use LinkedHashSet to develop cache based application where duplicates are not allowed and insertion order preserved.

# SortedSet:
- It is the child interface of Set
- If we want to represent a group of individual objects as a single entity according to some sorting order without duplicates then we should go for SortedSet.
- SortedSet interface defines the following specific methods:
Object first();
  - returns the first element of SortedSet
Object last();
  - returns the last element of SortedSet.
SortedSet headSet(Object o)
  - returns SortedSet whose elements are less than o.
SortedSet tailSet(Object o)
  - returns SortedSet whose elements are >= o
SortedSet subSet(Object obj1, Object obj2)
  - returns SortedSet whose elements are >= obj1 and < obj2
Comparator comparator();
  - returns Comparator object that describes underlying sorting technique. If we are using default natural sorting order then we will get null

# Note: The default natural sorting order for numbers ascending order and for String objects alphabetical order

# TreeSet:
- It is the child class of NavigableSet
- The underlying data structure is balanced tree
- Duplicate objects are not allowed
- Insertion order not preserved
- Heterogeneous Objects are not allowed otherwise we will get runtime exception ClassCastException
- Null insertion possible (only once)
- Implements serializable and cloneable but not RandomAccess
- All objects will be inserted based on some sorting order it may be default natural sorting order or customized sorting order.

# Constructors:
TreeSet t = new TreeSet();
    creates an empty TreeSet object where the elements will be inserted according to default natural sorting order

TreeSet t = new TreeSet(Comparator c);
    Creates an empty TreeSet object where the elements will be inserted according to customized sorting order specified by Comparator objects

TreeSet t = new TreeSet(Collection c);
TreeSet t = new TreeSet(SortedSet s);

e.g.
import java.util.TreeSet;

class TreeSetDemo {
public static void main(String[] args) {
TreeSet ts = new TreeSet();
ts.add("A");
ts.add("B");
ts.add("a");
ts.add("Z");
ts.add("C");
//        ts.add(new Integer(10));
//        ts.add(null);
System.out.println(ts);
}
}
[A, B, C, Z, a]

# null acceptance:
- For non-empty TreeSet If we are trying to insert null then we will get NullPointerException
- For empty TreeSet, as a first element null is allowed but after inserting that null if we are trying to insert any other, then we will get runtime exception saying NullPointerException

# Note: Until 1.6v null is allowed as first element to the empty TreeSet but from 1.7v onwards null is not allowed even as a first element.

e.g.
class TreeSetDemo {
public static void main(String[] args) {
TreeSet t = new TreeSet();
t.add(new StringBuffer("A"));
t.add(new StringBuffer("B"));
t.add(new StringBuffer("C"));
System.out.println(t);
}
}
[A, B, C]

# Comparable(I):
- It is present in java.lang package, and it contains only one method compareTo()
public int compareTo(Object obj);
- obje1.compareTo(obj2)
- returns -ve if obj1 has to come before obj2.
- returns +ve if obj1 has to come after obj2.
  - returns 0 if obj1 and obj2 are equal.
e.g.
    class CompareToDemo {
    public static void main(String[] args) {
    System.out.println("A".compareTo("D"));
    System.out.println("K".compareTo("A"));
    System.out.println("A".compareTo("A"));
    }
    }

-3
10
0   

- If we are depending on default natural sorting order then while adding objects into the TreeSet JVM will call compareTo() method
e.g.
TreeSet t = new TreeSet();
t.add("K"); 
t.add("Z"); // +ve "Z".compareTo("K");
t.add("A"); // -ve "A".compareTo("Z");
t.add("A"); // 0 "A".compareTo("A");
System.out.println(t); // [A, K, Z]

# Note: If default natural sorting order not available or if we are not satisfied with default natural sorting order then we can go for customized sorting by using Comparator.

# Comparable meant for Default natural sorting order whereas Comparator meant for customized sorting order  

# Comparator:
- Comparator present in java.util package, and it defines two methods compare() and equals()
public int compare(Object ob1, Object obj2);
- returns -ve if obj1 has to come before obj2.
- returns +ve if obj1 has to come after obj2.
    - returns 0 if obj1 and obj2 are equal.

public boolean equals(Object obj);

- Whenever we are implementing Comparator interface we must provide implementation only for compare() method, and we are not required to provide implementation for equals() method because it is already available to our class from Object class through inheritance

- Write a program to insert an integer object into the TreeSet where the Sorting order is descending order
e.g.
  class ComparatorDemo {
  public static void main(String[] args) {
  TreeSet t = new TreeSet(new MyComparator());
  t.add(10);
  t.add(20);
  t.add(30);
  t.add(0);
  t.add(5);
  System.out.println(t);
  }
  }
  class MyComparator implements Comparator {
  public int compare(Object o1, Object o2) {
  Integer i1 = (Integer)o1;
  Integer i2 = (Integer)o2;
  if (i1 < i2) {
  return 1;
  } else if (i1 > i2) {
  return -1;
  } else  {
  return 0;
  }
  }
  }
  [30, 20, 10, 5, 0]

- If we are not passing new MyComparator() as argument then internally JVM will call compareTo() method which is meant for default natural sorting order
- In this case the output is [0, 5, 10, 20, 30]

# Various possible implementation of compare():
class ComparatorDemo {
public static void main(String[] args) {
TreeSet t = new TreeSet(new MyComparator());
t.add(10);
t.add(20);
t.add(30);
t.add(0);
t.add(5);
System.out.println(t);
}
}
class MyComparator implements Comparator {
public int compare(Object o1, Object o2) {
Integer i1 = (Integer)o1;
Integer i2 = (Integer)o2;
return i1.compareTo(i2);  // Default natural sorting order [0, 5, 10, 20, 30]
return -i1.compareTo(i2); // Descending order [30, 20, 10,5, 0]
return i2.compareTo(i1);  // Descending order [30, 20, 10, 5, 0]
return -i2.compareTo(i1); // Ascending order [0, 5, 10, 20, 30]
return +1; // Insertion order [10, 20, 30, 0, 5]
return -1; // Reverse insertion order [5, 0, 30, 20, 10]
return 0;  // only first element will be inserted and remaining are considered as duplicates [10]
}
}