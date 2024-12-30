Polymorphism, meaning "many forms," is a core concept in object-oriented programming that allows objects to take on multiple forms. In Java, polymorphism is primarily implemented through two mechanisms:

**1. Method Overloading (Compile-Time Polymorphism)**

- **How it works:** Method overloading occurs when multiple methods within the same class have the same name but different parameter lists (different number, types, or order of parameters). The compiler determines which method to call based on the arguments provided in the method call.
- **Example:**

Java

```
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));       // Calls the int add() method
        System.out.println(calc.add(2.5, 3.5));   // Calls the double add() method
    }
}
```

- **Key features:**
    - Resolved at compile time.
    - Increases code readability and reusability.

**2. Method Overriding (Runtime Polymorphism)**

- **How it works:** Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. The method in the subclass has the same name, return type, and parameter list as the method in the superclass. At runtime, the JVM determines which method to call based on the actual object type, not the reference type.
- **Example:**

Java

```
class Animal {
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override // Good practice to use @Override annotation
    void makeSound() {
        System.out.println("Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog(); // Upcasting

        animal.makeSound(); // Calls Animal's makeSound()
        dog.makeSound();    // Calls Dog's makeSound() - Runtime polymorphism
    }
}
```

- **Key features:**
    - Achieved through inheritance and method overriding.
    - Resolved at runtime (dynamic method dispatch).
    - Enables dynamic behavior and flexibility.

**Key Concepts Related to Polymorphism in Java**

- **Upcasting:** Treating an object of a subclass as an object of its superclass. This is implicit in Java. (e.g., `Animal dog = new Dog();`)
- **Dynamic Method Dispatch:** The mechanism by which the JVM determines the appropriate method to call at runtime based on the object's actual type.
- **`@Override` Annotation:** Although not mandatory, it's a good practice to use the `@Override` annotation when overriding a method. It helps the compiler detect errors if you accidentally misspell the method name or change the parameter list.

Polymorphism is a powerful tool in Java that enhances code reusability, flexibility, and maintainability. It allows you to write more generic code that can work with objects of different classes in a unified way.