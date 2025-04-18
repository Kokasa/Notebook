函数是一段代码，通过名字来进行调用。它能将一些数据（参数）传递进去进行处理，然后返回一些数据（返回值），也可以没有返回值。

所有传递给函数的数据都是显式传递的。

方法也是一段代码，也通过名字来进行调用，但它跟一个对象相关联。方法和函数大致上是相同的，但有两个主要的不同之处：

1. **方法中的数据是隐式传递的；**
    
2. **方法可以操作类内部的数据**
    
    (请记住,对象是类的实例化,类定义了一个数据类型，而对象是该数据类型的一个实例化）
    

以上只是简略的解释，忽略了作用域之类的问题。

“方法在C++中是被称为成员函数”。 在 C++ 中的“**方法**”和“**函数**”的区别，就是“**成员函数**”和“**函数**”的区别。此外，诸如Java一类的编程语言只有“方法”。所以这时候就是“静态方法”和“方法”直接的区别。

你应当补上方法可以操作已在类中声明的私有实例（成员）数据。其他代码都可以访问公共实例数据。

- 方法和对象相关；
    
- 函数和对象无关。
    

Java中只有方法，C中只有函数，而C++里取决于是否在类中。

文章来源: https://weishuai.gitbooks.io/hello/content/methodfunction.html