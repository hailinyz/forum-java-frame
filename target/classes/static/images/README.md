# 登录注册页面图片使用说明

## 目录结构

请在 `src/main/resources/static/images/` 目录下放置以下图片：

1. **login-bg.jpg** - 登录页面右侧背景图
2. **register-bg.jpg** - 注册页面右侧背景图

## 图片建议

### 尺寸要求
- 推荐尺寸：1920x1080 像素或更大
- 最小尺寸：1200x800 像素
- 格式：JPG 或 PNG

### 内容建议

**登录页面背景图（login-bg.jpg）：**
- 建议使用与博客、写作、阅读相关的图片
- 可以是书房、图书馆、笔记本、咖啡杯等温馨场景
- 色调建议：温暖、专业、舒适

**注册页面背景图（register-bg.jpg）：**
- 建议使用与创意、灵感、成长相关的图片
- 可以是自然风光、城市景观、抽象艺术等
- 色调建议：明亮、活力、积极向上

## 自定义方式

### 方法1：替换图片文件
将您的图片重命名为 `login-bg.jpg` 和 `register-bg.jpg`，然后放到 `src/main/resources/static/images/` 目录下。

### 方法2：修改CSS样式
如果需要使用不同的图片路径，可以修改模板文件中的CSS：

在 `login.html` 和 `register.html` 中找到以下CSS代码：

```css
.login-image-side::before {
    background-image: url('/images/login-bg.jpg');
    /* 修改为您自己的图片路径 */
}
```

### 方法3：修改右侧文字内容
在HTML中修改 `.image-content` 的内容：

```html
<div class="image-content">
    <h3>欢迎来到海林博客</h3>
    <p>分享知识，记录生活<br>在这里发现更多精彩内容</p>
</div>
```

### 方法4：修改背景渐变色
修改CSS中的渐变色：

```css
.login-image-side {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    /* 修改为您喜欢的颜色 */
}
```

## 当前效果

如果没有放置自定义图片，页面将显示：
- 紫色渐变色背景（#667eea 到 #764ba2）
- 白色文字内容
- 响应式布局，移动端自动切换为上下布局

## 响应式设计

- **桌面端（>768px）**：左右分栏布局
- **移动端（≤768px）**：上下布局，图片区域在上方

## 技术说明

- 使用 Flexbox 实现左右分栏
- 图片通过 CSS `background-image` 设置
- 使用 `::before` 伪元素添加图片叠加效果
- `opacity: 0.3` 使图片半透明，不影响文字可读性
- `background-size: cover` 确保图片完全覆盖区域
