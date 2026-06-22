# 部署到 Render（免费）

## 前提条件

1. 一个 [GitHub](https://github.com) 账号
2. 一个 [Render](https://render.com) 账号（用 GitHub 登录即可）

## 部署步骤

### 第一步：将代码推送到 GitHub

```bash
git add .
git commit -m "feat: 支持 H2 内存数据库，适配 Render 免费部署"
git push origin main
```

### 第二步：在 Render 上部署

1. 打开 https://render.com，用 GitHub 账号登录
2. 点击 **New **+** → **Web Service**
3. 连接你的 GitHub 仓库（选择包含本项目的仓库）
4. 填写以下配置：

| 配置项 | 值 |
|--------|------|
| **Name** | blog-system（自定义） |
| **Region** | Oregon（推荐，离亚洲较快） |
| **Branch** | main |
| **Root Directory** | （留空） |
| **Runtime** | Docker |
| **Build Strategy** | Dockerfile |
| **Instance Type** | Free |

5. 点击 **Create Web Service**

> Render 会自动读取项目根目录的 `Dockerfile` 进行构建部署。
> Dockerfile 中已配置 `ENV DB_PROFILE=h2`，自动使用 H2 内存数据库，**不需要任何数据库服务**。

### 第三步：获取访问链接

部署完成后，Render 会给你一个类似这样的地址：
```
https://blog-system-xxxx.onrender.com
```

分享给任何人，他们都可以访问你的博客！

## 默认账号

| 用户名 | 密码 | 角色 |
|--------|------|------|
| admin | 123456 | 管理员 |
| user1 | 123456 | 普通用户 |

（所有用户的默认密码都是 123456）

## 注意事项

- **免费实例休眠**：15 分钟无人访问后会自动休眠，下次访问需要等待 30-60 秒唤醒
- **数据不持久**：H2 内存数据库，重启后数据会清空。如果需要持久化，可以用 H2 文件模式或改用 Render 的 PostgreSQL
- **Dockerfile 已配置**：自动使用 H2 模式，无需额外配置环境变量

## 备选：不用 Docker，直接用 JAR

如果你不想用 Docker 部署，也可以：

1. 本地执行 `mvnw package -DskipTests` 生成 `target/blog-system-1.0.0.jar`
2. 在 Render 创建 Web Service 时：
   - **Build Command**: `mvnw package -DskipTests`
   - **Start Command**: `DB_PROFILE=h2 java -jar target/blog-system-1.0.0.jar`
   - **Instance Type**: Free
