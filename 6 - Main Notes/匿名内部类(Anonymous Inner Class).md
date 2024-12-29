2024-12-29    12:22

status: #adult 
tags: [[Java]]


# 匿名内部类(Anonymous Inner Class)

## 匿名内部类的产生

当我们想创建一个类, 但这个类并不会被再次使用

匿名内部类作为传统类的补充被大家使用, 具体使用方式取决于上下文

为了保持代码的整洁和物尽其用, 使用匿名内部类来进行一次性实现, 用完就丢, 方便快捷

示例, 为一个按钮添加点击事件监听器: 
### 传统类示例
```java
import javax.swing.*;
import java.awt.event.*;

class MyButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
}

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Click me");
        button.addActionListener(new MyButtonListener()); // 创建监听器对象
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
```

### 匿名内部类示例
```java
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() { // 匿名内部类
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
```

## 使用匿名内部类的关键因素

- **一次性使用：** 如果一个类的实例只在一个地方使用，并且没有其他地方需要引用它，那么使用匿名内部类可以避免创建一个单独的类文件，使代码更加集中和简洁。
    
- **实现简单：** 当需要实现的接口或继承的类的方法非常简单，只有几行代码时，使用匿名内部类可以快速完成实现，无需编写完整的类定义。
    
- **事件处理（GUI编程）：** 在图形用户界面（GUI）编程中，经常需要处理各种事件，例如按钮点击、鼠标移动等。这些事件的处理通常只需要一段简单的代码，使用匿名内部类可以很方便地定义事件监听器。
    
- **回调函数：** 在异步编程中，需要将一个函数作为参数传递给另一个函数，并在某个事件发生后执行。这时，可以使用匿名内部类来创建回调函数。

## 匿名内部类也是类!

创建匿名内部类必须实现接口或者继承一个父类

因为匿名内部类本质上仍然只是一个类, 但是没有显显式类名
所以它必须遵守Java中面向对象的准则: 

- 所有类都直接或间接继承Object类
- 一个类可以实现多个接口或者继承一个父类

但是匿名内部类没有名字, 不能通过  [[class关键字]] 来显式声明它继承或者实现什么

为此开发者们定义了新的语法: 

```java
new 接口名/父类名() { // 类体 };
```

通过这个语句做了两件事: 
1. 创建一个匿名的类
2. new创建该匿名类的实例

## 总结

匿名内部类只是为了简化开发而生的 类的补充
需要遵循Java中类的定义

推荐使用[[Lambda 表达式]]代替书写匿名内部类


# References

[[为什么使用匿名内部类]]

[[为什么匿名内部类必须实现接口或继承父类]]
