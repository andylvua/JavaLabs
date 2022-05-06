[![Java CI with Maven](https://github.com/andylvua/JavaLabs/actions/workflows/maven.yml/badge.svg)](https://github.com/andylvua/JavaLabs/actions/workflows/maven.yml)
# Laboratory work 2
## Task description
1. Implement the hierarchy of classes for the task of laboratory №2 (section Winter School)
2. When writing a program, you have to use the arrangements for the design of the java code convention.
3. Classes need to be properly divided into packages.
4. Work with the console or console menu should be minimal.
5. Important: only the class hierarchy needs to be implemented, the code for searching for items in lists or collections is not included in the 2nd work
6. You should also create objects of the classes you have implemented in a separate Main class, which will contain the main method
7. It is necessary to add the surname in the table to the task 2 next to the chosen variant (it is necessary to choose independently)
8. If there are no more free options left in the document - you should contact the teacher in order to get a variant

# Laboratory work 3
## Task description
1. Create a class - ```Manager```, which will contain program logic (example for option 1):
> Implement a search for products that can be bought for a girl in the fall and implement the ability to sort the found products:
> - by the price
> - by the size
> <!-- end -->
> <br/>
> The implementation of sorting should provide the ability to sort both in descending and ascending order.



2. Use the built-in sorting methods available in Java
3. Sorting should be implemented in a separate method
4. The code should not contain static methods / attributes. Only one static method is allowed - void
5. Code must use _enum_ type (if necessary)

# Laboratory work 4
## Task description
Convert a project with work 2-3 code so its assembly can be performed with Maven.

At the same time it's necessary to merge the previous works in master branch

**Important**: The project build should be performed from the console with the ```mvn clean package``` command

You can generate pom.xml using the following maven command (run from the console):
``` java
mvn archetype:generate 
-DgroupId=ua.lviv.iot 
-DartifactId=work 
-Dversion=1.0-SNAPSHOT 
-DarchetypeArtifactId=maven-archetype-quickstart 
-DarchetypeVersion=1.0 
-DinteractiveMode=false
```

# Questions
* This keyword
* Super keyword
* Final keyword
* Initialization blocks
* Enum - why are they used? How do they differ from final static fields?
* Interface vs Abstract class
* Inheritance in Java: extends, implements keywords
* Make a class abstract
* Make a method abstract in Java
* Create an interface in Java
* How to make a constant variable
* Constructors vs initialization blocks
* What is immutability in Java?
* Explain what is package in Java
* What happens if main() is not declared as static?
* Explain the difference between JDK, JRE, and JVM?
* Can a constructor return a value?
* Explain Method Overloading in Java. Provide an example based on your code
* Can we overload a static method?
* Why is the delete function faster in the linked list than in an array?
* What is pom.xml?
* Explain pom.xml sections
* How to add a new dependency in pom.xml?
* How Maven dispatches dependencies?

# Laboratory work 5
## Task description
In laboratory work №5 you have to write unit tests for the code of laboratory work №4
and reach a test coverage level of 80%.

Obviously, the perfect coverage is 100% (ie each line of code is covered by tests). </br>
It is also obvious that writing tests takes a considerable amount of time, which is always lacking. <br>
The way to avoid this problem is the **TDD** approach.

For this laboratory compromise value will be coverage of 80%

# Laboratory work 6
## Task description
This work is devoted to work with files and write operations, and is also based on
laboratory works 3, 5-6. For the implemented hierarchy of classes in the 3rd laboratory work you should implement
a writing to a CSV file function that uses a list of objects present in the manager. Please note, that the code should be
done only after 3, 5-6 laboratory works.

Let the ```CrocodileManager``` class be implemented in laboratory work 3,
which contains a list of objects derived from the ```Crocodile``` class. For each class,
derived from ```Crocodile``` and in the class ```Crocodile``` you have to implement two methods:

``` java
pubic String getHeaders() { ... }
```
> Returns a string of the attributes present in this class, separated by commas
``` java
pubic String toCSV() { ... }
```
> Returns the value of attributes (field values) of this object, separated by commas

The implementation of the ```toCSV``` method in the child classes should also call this method from the parent class.
Fields declared in the parent class must be converted to a comma-separated string,
in the parent class, for example:

``` java
class Crocodile {
private String origin;
    pubic String getHeaders() { 
         return “origin”;
    }
}

class Alligator extends Crocodile  {
private int maxSpeed;
    pubic String getHeaders() { 
         return super.getHeaders() + “,” + “maxSpeed”;
    }
}
```

You must implement a separate class ```Writer```
(for example - CrocodileWriter), which will contain the method
```public void writeToFile (List<Crocodile> crocodiles)```.
Call of this method should be implemented from the tests.

The code must meet the **code convention** rules.

Also, in the **pom.xml** you should add ```checkstyle``` and ``` spotbugs``` plugins in order to check your code.

You should also fix **any** errors that spotbugs will find and **reduce** the number of errors that checkstyle points out.

To check the quality of the code, run the ```mvn clean site``` command

# Laboratory work 7
## Task description
1. Write the code for the task from the table
2. The code must comply with the java code convention.
3. The code should be tested
4. Any operations on the text should be done via objects (the use of static methods is prohibited)
5. The code should receive the necessary parameters and return the expected results