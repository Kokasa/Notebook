`BufferedReader` 和 `BufferedWriter` 是 Java I/O 流中用于提高字符流读写效率的缓冲流。它们分别用于读取和写入字符数据，通过内部缓冲区减少实际的 I/O 操作次数，从而提高性能。

**BufferedReader 的作用**

`BufferedReader` 用于从字符输入流中高效地读取文本。它内部维护一个缓冲区，当调用 `read()` 方法时，`BufferedReader` 会尝试从缓冲区中读取数据。如果缓冲区为空，它会一次性从底层输入流中读取较大的数据块填充缓冲区，然后再从缓冲区中返回所需的数据。这样就减少了对底层输入流的频繁访问，提高了读取效率。

主要作用：

- **减少 I/O 操作次数：** 通过缓冲机制，减少了对底层字符输入流的实际读取次数，提高了读取速度。
- **支持按行读取：** 提供了 `readLine()` 方法，可以方便地按行读取文本数据。

常用方法：

- `BufferedReader(Reader in)`：构造方法，创建一个使用默认大小输入缓冲区的缓冲字符输入流。
- `BufferedReader(Reader in, int sz)`：构造方法，创建一个使用指定大小输入缓冲区的缓冲字符输入流。
- `int read()`：读取单个字符。
- `int read(char[] cbuf, int off, int len)`：将字符读入数组的某一部分。
- `String readLine()`：读取一行文本。
- `void close()`：关闭流并释放相关资源。

示例：

Java

```
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**BufferedWriter 的作用**

`BufferedWriter` 用于高效地向字符输出流中写入文本。它也维护一个内部缓冲区，当调用 `write()` 方法时，`BufferedWriter` 会将数据写入缓冲区。只有当缓冲区满或者调用 `flush()` 方法时，才会将缓冲区的数据一次性写入底层输出流。这样同样减少了对底层输出流的频繁访问，提高了写入效率。

主要作用：

- **减少 I/O 操作次数：** 通过缓冲机制，减少了对底层字符输出流的实际写入次数，提高了写入速度。
- **提高写入效率：** 尤其在写入大量数据时，性能提升非常明显。

常用方法：

- `BufferedWriter(Writer out)`：构造方法，创建一个使用默认大小输出缓冲区的缓冲字符输出流。
- `BufferedWriter(Writer out, int sz)`：构造方法，创建一个使用指定大小输出缓冲区的缓冲字符输出流。
- `void write(int c)`：写入单个字符。
- `void write(char[] cbuf, int off, int len)`：写入字符数组的某一部分。
- `void write(String s, int off, int len)`：写入字符串的某一部分。
- `void newLine()`：写入一个行分隔符。
- `void flush()`：刷新缓冲区，将缓冲区的数据立即写入底层输出流。
- `void close()`：关闭流并释放相关资源。

示例：

Java

```
import java.io.*;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, World!");
            writer.newLine(); // 写入换行符
            writer.write("This is a test.");
            writer.flush(); // 确保所有数据都写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**BufferedReader 和 BufferedWriter 的比较**

| 特性   | BufferedReader                    | BufferedWriter                               |
| ---- | --------------------------------- | -------------------------------------------- |
| 功能   | 从字符输入流中读取文本                       | 向字符输出流中写入文本                                  |
| 内部机制 | 内部维护一个输入缓冲区，减少读取次数                | 内部维护一个输出缓冲区，减少写入次数                           |
| 常用方法 | `read()`, `readLine()`, `close()` | `write()`, `newLine()`, `flush()`, `close()` |
| 适用场景 | 需要高效读取文本数据，尤其需要按行读取的场景            | 需要高效写入文本数据，尤其写入大量数据的场景                       |

**总结**

`BufferedReader` 和 `BufferedWriter` 是提高字符流 I/O 效率的重要工具。它们通过内部缓冲区减少实际的 I/O 操作次数，从而显著提升性能。在处理文本文件的读写操作时，建议优先使用它们。尤其要注意在 `BufferedWriter` 使用完毕后调用 `flush()` 方法，以确保缓冲区中的数据被完全写入底层输出流。另外，使用 try-with-resources 语句 (try (Resource res = ...) { ... }) 可以确保流在使用完毕后自动关闭，避免资源泄漏。