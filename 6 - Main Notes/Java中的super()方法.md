2024-12-29    00:44

status: #adult 
tags: [[Java]], [[OOP]]

Java 中的 `super()` 方法是继承中一个至关重要的组成部分。它在子类内部用于调用其父类（超类）的构造函数。以下是它如何工作以及为何重要的详细说明：

**`super()` 的目的**

- **构造函数链：** 当你创建一个子类的对象时，所有父类的构造函数也会按照从最顶层父类到子类的顺序依次被调用，形成一个链。`super()` 对于这个过程至关重要。
- **初始化继承的成员：** 父类构造函数负责初始化子类继承的成员（变量）。`super()` 确保这种初始化正确发生。

**如何使用 `super()`**

1. **在子类构造函数内部：** 你需要在子类的构造函数内部使用 `super()`。
2. **第一条语句：** 调用 `super()` 必须是子类构造函数中的第一条语句。这确保了在任何子类特定的初始化之前，父类就已经被初始化。
3. **调用特定的父类构造函数：**
    - `super();` 调用父类的无参数（默认）构造函数。
    - `super(参数);` 调用与你提供的参数匹配的父类的带参数构造函数。

**示例**

Java

```
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal 构造函数被调用");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name); // 调用 Animal 构造函数
        this.breed = breed;
        System.out.println("Dog 构造函数被调用");
    }

    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "金毛巡回犬");
        System.out.println("名字: " + myDog.name);
        System.out.println("品种: " + myDog.breed);
    }
}
```

**输出：**

```
Animal 构造函数被调用
Dog 构造函数被调用
名字: Buddy
品种: 金毛巡回犬
```

**解释：**

- `Dog` 类继承自 `Animal` 类。
- 在 `Dog` 构造函数中，`super(name)` 用于调用 `Animal` 构造函数，初始化 `name` 字段。
- 这确保了当创建一个 `Dog` 对象时，它也拥有 `Animal` 的属性。

**重点**

- 如果你没有在子类构造函数中显式调用 `super()`，Java 会自动插入一个对父类无参数构造函数的调用。但是，如果父类没有无参数构造函数，你必须使用 `super(参数)` 显式调用一个带参数的构造函数。
- `super()` 只能在构造函数内部使用。

正确使用 `super()` 对于 Java 中正确的继承和对象初始化至关重要。它确保子类的对象是在其父类的基础上正确构建的。

总结来说，`super()` 关键字在 Java 中有以下几种用法：

1. **调用父类的构造方法：** `super()` 或 `super(参数列表)`，必须是子类构造方法的第一条语句。
2. **访问父类的成员变量：** `super.变量名`，即使子类有同名的成员变量，也可以通过 `super` 访问父类的。
3. **调用父类的方法：** `super.方法名(参数列表)`，可以调用父类中被子类重写的方法。

希望以上解释能够帮助你理解 `super()` 方法在 Java 中的使用。