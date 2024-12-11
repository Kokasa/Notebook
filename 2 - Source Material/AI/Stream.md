
`Stream` 是 Java 8 引入的一个类，位于 `java.util.stream` 包中，用于表示一个序列化的元素，可以通过流式操作（如 `map`、`filter`、`reduce` 等）进行处理。

- **基本操作**：`Stream` 提供了许多操作，如 `map`、`filter`、`reduce`、`collect` 等。
- **流的两种类型**：顺序流（处理数据按顺序执行）和并行流（可以并行处理数据）。

例如，流 `Stream<String>` 可以通过 `map` 操作来转换每个元素。