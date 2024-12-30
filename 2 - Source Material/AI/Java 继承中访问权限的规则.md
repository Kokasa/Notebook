这道题考察的是 Java 继承中访问权限的规则。答案是 **B. 父类中 private 修饰的属性和方法在子类中不被继承**。这个说法是错误的。更准确的说法是：**父类中 private 修饰的属性和方法在子类中会被继承，但是子类无法直接访问。**

下面我来详细剖析这道题，并总结相关的知识点：

**Java 访问权限修饰符**

Java 中有四种访问权限修饰符，它们决定了类、属性和方法的可见性和可访问性：

- **public：** 公共访问权限。对所有类可见，无论是否在同一个包中。
- **protected：** 受保护访问权限。对同一个包中的类和所有子类可见。
- **default (缺省/包访问权限)：** 如果没有指定任何修饰符，则默认为 default 访问权限。对同一个包中的类可见。
- **private：** 私有访问权限。只对当前类可见。

**继承规则**

子类继承父类的所有成员（属性和方法），但并非所有成员都能直接访问。访问权限决定了子类能否直接访问父类的成员。具体规则如下：

- **public：** 子类可以继承并直接访问父类的 public 成员。
- **protected：** 子类可以继承并直接访问父类的 protected 成员。
- **default：**
    - 如果子类和父类在同一个包中，子类可以继承并直接访问父类的 default 成员。
    - 如果子类和父类不在同一个包中，子类可以继承父类的 default 成员，但无法直接访问。
- **private：** 子类可以继承父类的 private 成员，但无法直接访问。这意味着虽然子类拥有了这些成员，但无法通过 `子类对象.成员名` 的方式来使用它们。但是，可以通过父类提供的 public 或 protected 的 getter 和 setter 方法来间接访问 private 成员。

**对选项的分析**

- **A. 父类中 default 权限的属性和方法在子类中被继承，若父类和子类在同一个包中，则也可以直接访问：** 正确。这是 default 访问权限的定义。
- **B. 父类中 private 修饰的属性和方法在子类中不被继承：** 错误。private 成员会被继承，只是子类无法直接访问。
- **C. 父类中 protected 修饰的属性和方法在子类中被继承且可直接访问：** 正确。这是 protected 访问权限的定义。
- **D. 父类中 public 修饰的属性和方法在子类中被继承且可直接访问：** 正确。这是 public 访问权限的定义。

**为什么 private 成员会被继承？**

虽然子类不能直接访问父类的 private 成员，但它们仍然是子类对象的一部分。这是因为对象的内存布局中包含了其所有父类的成员。考虑以下代码：

Java

```
class Parent {
    private int privateVar = 10;
    public int publicVar = 20;
    public int getPrivateVar() {
        return privateVar;
    }
}

class Child extends Parent {
    public int childVar = 30;
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.publicVar); // 可以直接访问
        // System.out.println(child.privateVar); // 编译错误，无法直接访问
        System.out.println(child.getPrivateVar()); // 通过父类方法间接访问
        System.out.println(child.childVar);
        System.out.println(child instanceof Parent);
    }
}
```

在这个例子中，`Child` 类继承了 `Parent` 类的 `privateVar`，虽然 `Child` 类不能直接访问它，但是 `Child` 类的对象在内存中仍然包含 `privateVar` 的空间。`Child` 类可以通过继承自 `Parent` 类的 `getPrivateVar()` 方法来间接访问 `privateVar`。

**总结**

理解 Java 继承中的访问权限至关重要。记住以下几点：

- 子类继承父类的所有成员。
- 访问权限决定了子类能否_直接_访问父类的成员。
- private 成员会被继承，但子类无法直接访问，可以通过父类提供的公共方法间接访问。
- 使用合适的访问权限修饰符可以有效地控制代码的可见性和封装性。

通过以上分析，相信你对 Java 继承中访问权限的规则有了更清晰的理解。