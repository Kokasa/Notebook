在 MySQL 中，`TIME` 类型用于表示时间值，通常不包括日期部分，只存储小时、分钟和秒（`HH:MM:SS`）。在 Java 中，处理 `TIME` 类型的字段可以通过几种不同的方式存储和转换，具体方法取决于你的需求。

### 1. **使用 `java.time.LocalTime`（推荐方式）**

从 Java 8 开始，`java.time` 包提供了对日期和时间的更现代化的支持。`LocalTime` 类非常适合处理不包含日期的时间值，正好对应 MySQL 的 `TIME` 类型。

- **MySQL `TIME` 到 Java `LocalTime`**：当 MySQL 中的 `TIME` 字段被读取时，可以映射为 Java 的 `LocalTime` 类型。
- **Java `LocalTime` 到 MySQL `TIME`**：将 Java 的 `LocalTime` 类型存储到 MySQL 的 `TIME` 字段时，MySQL 会自动转换为正确的格式。

#### 示例

**Java 代码**：

```java
import java.time.LocalTime;
import java.sql.Time;

public class Schedule {
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
```

**数据库表设计**（MySQL）：

```sql
CREATE TABLE scheduleItem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_time TIME,
    end_time TIME
);
```

**存储数据**： 在 Java 中存储 `LocalTime` 时，通常使用 `PreparedStatement` 来自动处理转换。

```java
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;

public void insertSchedule(Connection connection, LocalTime startTime, LocalTime endTime) throws SQLException {
    String sql = "INSERT INTO scheduleItem (start_time, end_time) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setObject(1, startTime);  // Java 8及以上支持LocalTime
        stmt.setObject(2, endTime);
        stmt.executeUpdate();
    }
}
```

**读取数据**：

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public LocalTime readStartTime(ResultSet rs) throws SQLException {
    return rs.getObject("start_time", LocalTime.class);  // 获取LocalTime
}
```

### 2. **使用 `java.sql.Time`（旧方法）**

如果你的项目使用的是较老版本的 Java 或者没有引入 Java 8 的 `java.time` 包，可以使用 `java.sql.Time` 类。`java.sql.Time` 类表示时间（仅有小时、分钟和秒），并且可以与 MySQL 的 `TIME` 类型进行映射。

#### 示例

**Java 代码**：

```java
import java.sql.Time;

public class Schedule {
    private Time startTime;
    private Time endTime;

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
```

**数据库表设计**与前述相同。

**存储数据**：

```java
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;

public void insertSchedule(Connection connection, Time startTime, Time endTime) throws SQLException {
    String sql = "INSERT INTO scheduleItem (start_time, end_time) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setTime(1, startTime);  // 设置Time对象
        stmt.setTime(2, endTime);
        stmt.executeUpdate();
    }
}
```

**读取数据**：

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public Time readStartTime(ResultSet rs) throws SQLException {
    return rs.getTime("start_time");  // 获取Time对象
}
```

### 3. **其他注意事项**

- **MySQL `TIME` 类型的范围**：MySQL `TIME` 类型的范围是 `'-838:59:59'` 到 `'838:59:59'`，所以在 Java 中，你需要确保使用 `LocalTime` 或 `Time` 类型来正确处理这些范围。
    
- **时区问题**：如果你的应用涉及跨时区的操作，建议使用 `LocalTime`，因为它不涉及时区转换问题。`java.sql.Time` 则是与数据库的连接时区相关的。
    

### 总结

- **推荐使用 `LocalTime`**：因为它是 Java 8 及以后版本的标准，并且它是一个专门处理时间（无日期部分）的类。它与 MySQL `TIME` 类型非常匹配，代码清晰且更具可读性。
    
- **`java.sql.Time` 适用于老版本**：如果你使用的是早期的 Java 版本或还没有迁移到 Java 8，可以继续使用 `java.sql.Time`。
    

如果项目支持 Java 8 或更高版本，建议迁移到 `LocalTime` 类型，能带来更好的可维护性和清晰度。