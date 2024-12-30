Polymorphism is a fundamental concept in object-oriented programming (OOP) that allows a single entity, such as a method or object, to take on multiple forms. This enables code flexibility, reuse, and maintainability. There are two main types of polymorphism: **compile-time (static)** and **run-time (dynamic)**.

### Types of Polymorphism

1. **Compile-time Polymorphism (Static Polymorphism):**
    
    - Achieved using method overloading and operator overloading.
    - The method or operator to be invoked is determined at compile-time.
    - Example:
        
        ```java
        class Calculator {
            int add(int a, int b) {
                return a + b;
            }
        
            int add(int a, int b, int c) {
                return a + b + c;
            }
        }
        
        public class Main {
            public static void main(String[] args) {
                Calculator calc = new Calculator();
                System.out.println(calc.add(2, 3));        // Calls add(int, int)
                System.out.println(calc.add(1, 2, 3));    // Calls add(int, int, int)
            }
        }
        ```
        
2. **Run-time Polymorphism (Dynamic Polymorphism):**
    
    - Achieved using method overriding.
    - The method to be invoked is determined at runtime based on the object's actual type.
    - Example:
        
        ```java
        class Animal {
            void makeSound() {
                System.out.println("Animal makes a sound");
            }
        }
        
        class Dog extends Animal {
            @Override
            void makeSound() {
                System.out.println("Dog barks");
            }
        }
        
        public class Main {
            public static void main(String[] args) {
                Animal myAnimal = new Dog();
                myAnimal.makeSound(); // Output: Dog barks
            }
        }
        ```
        

### Key Characteristics

- **Overloading vs. Overriding:**
    - Overloading is used in static polymorphism.
    - Overriding is used in dynamic polymorphism.
- **Flexibility and Extensibility:**
    - Polymorphism allows classes to define specific behavior while sharing a common interface.
- **Implementation:**
    - Method Overriding enables child classes to provide specific implementations for methods defined in a parent class.
    - Interfaces and abstract classes are often used to achieve polymorphism.

By leveraging polymorphism, developers can write more general and reusable code, making the software easier to extend and maintain.