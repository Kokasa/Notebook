2024-12-30    17:08

status: #adult 
tags: [[Java]]


# super关键字

## 作用
代指父类对象

和this关键字类似, **super关键字代指的是父类对象的引用**

## 用法

- 访问父类成员: 当子类和父类有同名成员时可以通过super访问父类成员
```java
class Animal {
	String name;
}
```

```java
class Dog extends Animal {
	String name;

	public Dog(String name, String dogName) {
		super.name = name; // super代指父类, 这里访问的是父类中的name成员
		this.name = dogName; // this代指当前类, 这里访问当前类的name成员
	}
```

- 在构造器中调用父类构造器
```java
class Animal {
	public Animal(String name) {
	}
}
```

```java
class Dog extends Animal {
	public Dog(String name, String bread) {
		super(name); // 这里调用了父类的构造方法
	}
}
```

## 为什么不能在静态方法中使用super

和[[this关键字]]类似, super代指的是父类对象, 但静态方法不属于对象


# References


[[this关键字和super关键字的用法]]
[[this关键字和super关键字对比]]
[[java中创建类为什么需要实现接口或者继承父类]]