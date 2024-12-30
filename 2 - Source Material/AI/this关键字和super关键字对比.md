我来创建一个简单的示例来说明 `this` 和 `super` 关键字的区别和使用场景。

```java:Animal.java
public class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;  // this关键字指向当前类的实例
    }
    
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}
```

```java:Dog.java
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name);  // super调用父类的构造方法
        this.breed = breed;  // this指向当前Dog类的实例
    }
    
    @Override
    public void makeSound() {
        super.makeSound();  // super调用父类的方法
        System.out.println("汪汪汪！");  // 添加子类特有的行为
    }
    
    public void showInfo() {
        // this用于访问当前类的属性
        System.out.println("我是一只" + this.breed + "品种的狗，名字叫" + this.name);
    }
}
```

```java:Main.java
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑", "拉布拉多");
        dog.showInfo();
        dog.makeSound();
    }
}
```

让我解释一下这些关键字的主要区别：

1. **this 关键字**：
   - 指向当前类的实例
   - 用于访问当前类的属性和方法
   - 用于区分局部变量和实例变量
   - 常用于构造方法中给实例变量赋值

2. **super 关键字**：
   - 指向父类的实例
   - 用于调用父类的构造方法
   - 用于访问父类的方法和属性
   - 常用于方法重写时调用父类的实现

运行上面的代码，输出结果将是：
```
我是一只拉布拉多品种的狗，名字叫小黑
动物发出声音
汪汪汪！
```

主要使用场景：
- 使用 `this` 当：
  - 需要在构造方法中给实例变量赋值
  - 需要明确指出使用的是类的成员而不是局部变量
  - 需要返回当前对象的引用

- 使用 `super` 当：
  - 需要调用父类的构造方法
  - 需要在重写的方法中调用父类的实现
  - 需要访问父类的属性或方法
