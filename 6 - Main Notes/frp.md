
status: #adult 

tags: [[Network]], [[Sharpen Yourself]], 


`frp`（Fast Reverse Proxy）是一个高性能的反向代理应用，专门用于实现[[内网穿透]]。它的原理基于反向代理和 NAT 穿透技术，使得位于内网的设备能够通过公网访问。`frp` 主要通过搭建一个代理服务器和客户端之间的通信桥梁来实现[[内网穿透]]，其基本的工作原理和流程可以分为以下几个步骤：

### 1. **frp 架构概览**

`frp` 主要由两部分组成：

- **frps（Server）**：服务器端，通常部署在公网（如 VPS、云服务器等）上。它负责接收来自客户端的连接请求，并将请求转发到相应的内网服务。
- **frpc（Client）**：客户端，部署在内网机器上，负责将内网服务与公网的 `frps` 进行连接。

这两个组件通过 TCP 或 UDP 协议通信，`frpc` 通过向 `frps` 服务器发起连接请求，建立起一个隧道，允许外部访问内网服务。

### 2. **工作原理**

#### 2.1 **初始化连接**

- **客户端启动（frpc）**：
    
    - 内网机器上的 `frpc` 启动时，会连接到公网的 `frps` 服务器。连接时，`frpc` 会将自身需要暴露的服务信息（如服务的端口、协议类型、身份认证信息等）发送到 `frps` 服务器。
    - `frpc` 和 `frps` 之间的连接是持久化的，`frpc` 启动后就会保持与 `frps` 的连接，直到 `frpc` 被停止。
- **服务注册**：
    
    - `frpc` 在启动时，注册本地的服务信息到 `frps`。这意味着内网中的服务（如 Web 服务、数据库等）通过 `frpc` 以指定的端口对外提供服务。
    - 比如，`frpc` 可以将内网中运行的一个 Web 服务暴露到 `frps` 的指定端口。此时外部的用户访问 `frps` 的该端口就可以间接访问到内网的 Web 服务。

#### 2.2 **建立隧道**

- **隧道创建**：
    - 当 `frpc` 向 `frps` 注册一个服务时，`frps` 会在其服务器端打开一个端口，并将该端口与内网服务的端口建立关联。通过这种方式，`frps` 充当了内网和公网之间的桥梁。
    - 例如，内网服务监听在 `localhost:8080`，`frps` 监听公网的某个端口（如 `frps:7000`）。这样，当外部用户访问公网 IP 的 `7000` 端口时，`frps` 会将流量转发到内网的 `8080` 端口上。

#### 2.3 **数据传输**

- **流量转发**：
    - 外部用户访问 `frps` 的公网端口时，`frps` 会根据映射规则将流量转发到内网的 `frpc` 客户端。`frpc` 再将流量转发到实际的内网服务。
    - 这种数据流转发是通过 TCP、UDP 或 HTTP 隧道实现的，外部请求和内网服务之间的通信就如同在同一个局域网内一样流畅。

#### 2.4 **客户端返回数据**

- 内网服务处理完请求后，返回的数据会通过 `frpc` 发送到 `frps`，然后 `frps` 将数据返回给外部的请求方。
- 这种流量交换是双向的，`frpc` 通过隧道将内网响应数据转发回外部，确保完整的数据流通。

### 3. **[[内网穿透]]流程图**

简要流程如下：

```
[外部用户] <---> [公网服务器 frps] <---> [内网客户端 frpc] <---> [内网服务]
```

1. 外部用户请求访问公网服务器 `frps` 的端口。
2. `frps` 根据映射规则将流量转发到客户端 `frpc`。
3. `frpc` 将流量传递给内网服务进行处理。
4. 内网服务响应请求，`frpc` 将数据传回 `frps`。
5. `frps` 将数据返回给外部用户。

### 4. **frp 的常见配置**

#### 4.1 **`frps` 配置文件**

`frps` 配置文件通常位于 `/etc/frp/frps.ini` 或 `frps.ini`，其中可以指定服务的监听端口、认证信息等。例如：

```ini
[common]
bind_port = 7000        # frps 监听的端口
vhost_http_port = 80    # HTTP 服务暴露的端口
vhost_https_port = 443  # HTTPS 服务暴露的端口
```

#### 4.2 **`frpc` 配置文件**

`frpc` 配置文件位于 `/etc/frp/frpc.ini` 或 `frpc.ini`，可以指定客户端暴露的内网服务端口及 `frps` 服务器地址。例如：

```ini
[common]
server_addr = 1.2.3.4    # frps 服务器公网 IP
server_port = 7000       # frps 监听的端口

[web]
type = tcp
local_ip = 127.0.0.1     # 本地内网服务地址
local_port = 8080        # 本地内网服务端口
remote_port = 6000       # frps 服务器暴露的端口
```

#### 4.3 **客户端和服务器认证**

为了确保安全性，`frp` 支持通过 **token** 或 **用户名和密码** 进行认证。可以在 `frps.ini` 和 `frpc.ini` 中配置认证信息：

```ini
[common]
authentication_method = token
token = my_secret_token
```

### 5. **frp 的优点**

- **高性能**：`frp` 基于高效的 Go 语言实现，提供了快速的代理能力，尤其适用于高并发的场景。
- **易于配置**：通过简单的配置文件即可实现[[内网穿透]]，支持灵活的端口映射和多种协议。
- **跨平台支持**：`frp` 支持 Windows、Linux、macOS 等操作系统，适用于各种环境。
- **支持多种协议**：除了 TCP 和 UDP，`frp` 还支持 HTTP、HTTPS、SSH、RDP 等协议，提供了广泛的应用场景。
- **安全性**：通过认证、加密等机制，保障数据传输的安全。

### 6. **总结**

`frp` 是一个非常高效且灵活的[[内网穿透]]工具，它通过反向代理和隧道技术使得内网设备可以轻松地被外部设备访问。其工作原理基于客户端和服务器端的持久连接，通过端口映射和流量转发实现[[内网穿透]]，适用于多种应用场景，如远程办公、远程监控等。