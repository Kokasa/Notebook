SSE（Server-Sent Events）是一种由服务器向客户端单向推送数据的技术，它基于 HTTP 协议，允许服务器主动向客户端发送实时更新。这种技术通常用于实时应用，如消息通知、实时数据流、股票行情更新等。

SSE 的主要特点包括：

1. **单向通信**：数据只从服务器流向客户端，而不是双向通信（例如 WebSocket）。
2. **基于 HTTP 协议**：SSE 使用的是标准的 HTTP 协议，客户端通过 `EventSource` 对象连接到服务器，接收服务器推送的数据。
3. **自动重连**：如果客户端和服务器之间的连接断开，SSE 会自动尝试重新连接，而无需额外的编码处理。
4. **支持文本格式数据**：数据通常是文本格式，通常采用 JSON 或纯文本形式。
5. **浏览器支持**：SSE 被大多数现代浏览器所支持（如 Chrome、Firefox、Safari 等）。

### SSE 的工作原理：

1. 客户端通过 `EventSource` 对象向服务器发起一个 HTTP 请求（如 `/events`）。
2. 服务器处理请求并保持连接，持续向客户端发送事件数据。
3. 客户端接收到数据后，可以通过 JavaScript 来处理这些数据，例如更新 UI。

### 示例：

#### 服务器端（Java 示例）：

```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.concurrent.*;

public class SSEServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.write("data: Hello, world!\n\n");
        out.flush();
        
        // 模拟实时数据推送
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            out.write("data: " + System.currentTimeMillis() + "\n\n");
            out.flush();
        }, 1, 1, TimeUnit.SECONDS);
    }
}
```

#### 客户端（HTML + JavaScript）：

```html
<!DOCTYPE html>
<html>
<head>
    <title>SSE Example</title>
</head>
<body>
    <h1>Server Sent Events</h1>
    <div id="output"></div>

    <script>
        const eventSource = new EventSource('/events');  // 连接服务器端事件源
        eventSource.onmessage = function(event) {
            const output = document.getElementById('output');
            output.innerHTML = "Received: " + event.data;  // 显示接收到的事件数据
        };
    </script>
</body>
</html>
```

### 使用场景：

- **实时通知**：例如聊天应用中的消息通知。
- **实时数据更新**：例如股票行情、体育赛事比分等。
- **监控**：例如服务器或系统状态的实时监控。

与 WebSocket 相比，SSE 更简单，适用于服务器到客户端的单向数据流，而 WebSocket 更适用于双向交互的数据流。