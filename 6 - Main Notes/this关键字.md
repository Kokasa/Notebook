2024-12-30    16:58

status: #adult 
tags: [[Java]]


# this关键字

## 作用

指代当前对象的引用
用来区分局部变量和实例对象
可以在一个[[构造器(Constructor)]]中调用同一个类的其他构造器

## 用法

- 区分同名变量
```java
public class Person {
	String name;

	public Person(String name) {
		this.name = name // this指代的是成员变量
	}
}
```

- 在构造器中调用其他构造器
```java
public class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name) {
		this(name, 18) // 这里调用了上面的构造器
	}
}
```

## 为什么this不能在静态方法中使用

this指代的是当前对象, 而静态方法不属于任何对象, 不能在静态方法包括main方法中使用
# References

[[this关键字和super关键字的用法]]
[[this关键字和super关键字对比]]