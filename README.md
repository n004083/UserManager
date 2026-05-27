# 用户综合管理系统（UserManager）
软件工程课程设计 - 任务1 & 任务2 项目源码

---

## 📌 项目简介
本项目为基于 **Java Web + MySQL** 的用户综合管理系统，实现了用户信息的**增、删、改、查**全功能操作，并提供了统一的可视化导航主界面，满足课程设计的功能要求。

系统采用 MVC 设计思想，将数据访问、业务逻辑与视图展示分离，结构清晰，易于维护与扩展。

---

## 🛠️ 开发环境与技术栈
| 技术/工具 | 说明 |
| :--- | :--- |
| 开发语言 | Java 8 |
| 前端技术 | JSP + HTML + CSS |
| 后端技术 | Servlet + JavaBean |
| 数据库 | MySQL 8.0 |
| 数据库连接 | JDBC |
| 服务器 | Apache Tomcat 9.0 |
| 开发工具 | Eclipse / IntelliJ IDEA |
| 版本控制 | Git + GitHub |

---

## ✨ 系统功能
本系统包含以下核心功能模块：

1.  **主界面导航**
    - 作为系统统一入口，提供功能按钮，一键跳转到各操作页面。
2.  **显示全部用户**
    - 查询并展示数据库中所有用户的信息列表。
3.  **按ID查询用户**
    - 根据用户ID，查询并展示单条用户的详细信息。
4.  **添加新用户**
    - 提交表单，将新用户信息插入数据库。
5.  **修改用户信息**
    - 根据用户ID查询并更新用户信息。
6.  **删除用户**
    - 根据用户ID删除指定用户信息。

---

## 📂 项目结构
UserManager/
├── src/main/java/
│ ├── dbutil/
│ │ └── Dbconn.java # 数据库连接与关闭工具类
│ ├── entity/
│ │ └── User.java # 用户实体类
│ └── model/
│ └── Model.java # 业务逻辑处理类（增删改查）
└── src/main/webapp/
├── index.jsp # 系统主界面（导航页）
├── allShow.jsp # 显示全部用户页面
├── search.jsp # 按 ID 查询用户页面
├── insert.jsp # 添加用户表单页面
├── insertShow.jsp # 添加用户结果页
├── update.jsp # 修改用户表单页面
├── updateShow.jsp # 修改用户结果页
├── dele.jsp # 删除用户处理页
├── deleShow.jsp # 删除用户结果页
└── WEB-INF/
└── lib/
└── mysql-connector-j-8.4.0.jar # MySQL 驱动

---

## 🗄️ 数据库设计
### 用户表 `user` 结构
| 字段名 | 数据类型 | 约束 | 说明 |
| :--- | :--- | :--- | :--- |
| `Id` | `INT(11)` | `NOT NULL AUTO_INCREMENT PRIMARY KEY` | 用户ID，主键，自增 |
| `name` | `VARCHAR(255)` | `DEFAULT NULL` | 用户名 |
| `password` | `VARCHAR(255)` | `DEFAULT NULL` | 用户密码 |

### 建表与初始化数据 SQL
```sql
CREATE DATABASE IF NOT EXISTS userdb;
USE userdb;

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入测试数据
INSERT INTO `user` (`Id`, `name`, `password`) VALUES
(1, '李国华', 'admin'),
(2, '王老五', 'wlw'),
(3, '张淑芳', 'zsf');
🚀 部署与运行说明
1. 环境准备
安装 JDK 8 并配置环境变量
安装 MySQL 8.0，创建数据库 userdb 并执行上述 SQL 脚本
安装 Apache Tomcat 9.0 服务器
安装 Eclipse/IDEA 并配置 Tomcat 服务器
2. 项目导入与配置
将项目导入 Eclipse/IDEA。
确保 mysql-connector-j-8.4.0.jar 已添加到项目构建路径。
修改 dbutil/Dbconn.java 中的数据库连接信息：
private static String url = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8mb4";
private static String user = "root";          // 你的MySQL用户名
private static String password = "你的数据库密码"; // 你的MySQL密码
3. 启动与访问
将项目部署到 Tomcat 服务器并启动。
打开浏览器，访问：
http://localhost:8080/UserManager/
即可进入系统主界面，进行各项操作。
