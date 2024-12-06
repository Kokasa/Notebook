### **流的映射（`map`）**

`map` 是 `Stream` 接口的一个中间操作，它用于将流中的每个元素应用一个函数，转换为另外一种类型的元素，并返回一个新的流。

#### **方法签名**

java

Copy code

`<R> Stream<R> map(Function<? super T, ? extends R> mapper)`

- **`T`**：流中元素的类型。
- **`R`**：映射后的元素类型。
- **`mapper`**：应用于流中每个元素的转换函数。

#### **功能**

`map` 操作会将流中的每个元素映射到另一个元素，它的作用是对流的元素进行转换。它是一个“惰性操作”，意味着它不会立即执行，而是直到有终结操作（如 `collect`、`forEach` 等）时才会被执行。

#### **举个例子**

java

Copy code

`Stream<String> stringStream = Stream.of("101", "102", "103"); Stream<Long> longStream = stringStream.map(Long::valueOf);`

上面的代码使用 `map` 将 `Stream<String>` 转换为 `Stream<Long>`，每个字符串都被转换成了 `Long` 类型。

#### **常见用途**

- **类型转换**：如将 `String` 转换为 `Integer` 或 `Long`。
- **属性映射**：可以用来提取对象的某个属性。

例如，如果有一个 `Person` 类，你可以通过 `map` 获取所有人的名字：

java

Copy code

`List<Person> people = ...; List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());`