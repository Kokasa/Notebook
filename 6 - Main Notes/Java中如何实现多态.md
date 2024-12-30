2024-12-30    15:28

status: #adult 
tags: [[Java]], [[OOP]],


# Java中如何实现多态

## 什么是[[多态(Polymorphism)]]
一种核心思想
允许某个对象能表现出多种形态

## 实现多态的两种方法

### [[方法重载(Method Overloading)]]
相同的方法名, 可以有不同的参数或者返回值

在调用相同的方法名时, 根据不同的参数推断出具体调用的方法
调用相同的方法名能起到不同的结果, 表现出多态

**在编译时实现**
### [[方法重写(Method Overriding)]]

也被称为方法覆盖

发生在子类提供父类方法的具体实现时
子类方法有着和父类方法一样的方法名, 参数列表和返回值

**JVM会在运行时决定调用实际的对象类型, 而不是被引用的类型**

```java
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

## [[向上转型(Upcasting)]]与[[多态(Polymorphism)]]
	即为什么使用 Animal dog = new Dog();

当我们想要调用子类的共同成员时, 也就是定义在父类中的成员
通过这种父类型的引用能够在不关心具体子类中成员的情况下调用子类中被重写的方法

```java
class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public void bark() {
        System.out.println("Bark! Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.bark();       // Works fine
        myDog.makeSound();  // Works fine

        Animal myAnimal = new Dog();
        myAnimal.makeSound(); // Calls Dog's makeSound() (Polymorphism)
        // myAnimal.bark();  // Compile-time error: Animal doesn't have a bark() method
    }
}
```



# References

[[在java中多态是如何实现的]]