-- H2 内存数据库种子数据
-- 表名使用反引号以兼容 H2 保留字 (user, comment)

-- 默认分类
INSERT INTO `category` (`name`, `description`, `sort`) VALUES
('技术', '技术相关文章', 1),
('生活', '生活感悟', 2),
('随笔', '随笔记录', 3);

-- 管理员账户（密码：123456，BCrypt加密后）
INSERT INTO `user` (`username`, `password`, `email`, `nickname`, `status`) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'admin@blog.com', '管理员', 1);

-- 10个普通用户
INSERT INTO `user` (`username`, `password`, `email`, `nickname`, `avatar`, `status`) VALUES
('user1', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user1@qq.com', '张三', 'https://picsum.photos/200/200?random=1', 1),
('user2', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user2@qq.com', '李四', 'https://picsum.photos/200/200?random=2', 1),
('user3', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user3@qq.com', '王五', 'https://picsum.photos/200/200?random=3', 1),
('user4', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user4@163.com', '赵六', 'https://picsum.photos/200/200?random=4', 1),
('user5', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user5@163.com', '小明', 'https://picsum.photos/200/200?random=5', 1),
('user6', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user6@foxmail.com', '小红', 'https://picsum.photos/200/200?random=6', 1),
('user7', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user7@foxmail.com', '小李', 'https://picsum.photos/200/200?random=7', 1),
('user8', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user8@blog.com', '小张', 'https://picsum.photos/200/200?random=8', 1),
('user9', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user9@blog.com', '小陈', 'https://picsum.photos/200/200?random=9', 1),
('user10', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'user10@test.com', '小林', 'https://picsum.photos/200/200?random=10', 1);

-- 18篇文章
INSERT INTO `article` (`user_id`, `category_id`, `title`, `summary`, `content`, `view_count`, `like_count`, `comment_count`, `status`) VALUES
-- 技术类
(1, 1, 'SpringBoot实现文件上传下载', 'SpringBoot文件上传功能实现教程', 'SpringBoot文件上传非常简单，只需要引入spring-boot-starter-web依赖，然后配置MultipartFile即可实现单文件和多文件上传，同时可以限制文件大小和类型，非常方便。', 225, 36, 12, 1),
(2, 1, 'MyBatis-Plus快速开发', 'MyBatis-Plus简化CRUD操作教程', 'MyBatis-Plus是一个MyBatis的增强工具，只做增强不做修改，内置通用Mapper、通用Service，仅仅通过少量配置即可实现单表CRUD操作，极大提高开发效率。', 186, 29, 8, 1),
(3, 1, 'Vue3+ElementPlus后台管理', 'Vue3+ElementPlus搭建后台管理系统', '使用Vue3+Vite+ElementPlus可以快速开发现代化后台管理系统，组合式API更灵活，打包体积更小，页面渲染速度更快，适配PC端各种分辨率。', 320, 45, 15, 1),
(4, 1, 'MySQL索引优化实战', 'MySQL索引优化提高查询速度', '合理建立索引可以极大提升查询效率，最左前缀原则、避免索引失效、分页查询优化、慢查询分析都是开发中必须掌握的技能。', 198, 33, 10, 1),
(5, 1, 'Redis缓存实战', 'Redis缓存减轻数据库压力', 'Redis高性能缓存中间件，支持多种数据结构，可用于缓存、限流、分布式锁、消息队列等场景，有效减轻数据库查询压力。', 267, 41, 13, 1),
(6, 1, 'SpringSecurity权限控制', 'SpringSecurity实现登录认证授权', 'SpringSecurity功能强大，支持多种登录方式，细粒度权限控制，与SpringBoot无缝整合，是企业级权限管理首选框架。', 175, 27, 7, 1),
-- 生活类
(7, 2, '周末爬山日记', '周末爬山放松心情', '周末约上好友一起爬山，呼吸新鲜空气，远离城市喧嚣，放松身心，感受大自然的美好，缓解一周工作的疲惫。', 142, 23, 5, 1),
(8, 2, '早餐的重要性', '每天吃早餐保持健康', '一日之计在于晨，营养均衡的早餐可以提供一天所需能量，提高工作学习效率，保持身体健康。', 118, 19, 4, 1),
(1, 2, '城市夜景随拍', '城市夜晚灯光美景', '夜晚的城市灯火辉煌，车水马龙，高楼大厦灯光璀璨，用手机记录下这美丽的瞬间。', 153, 25, 6, 1),
(2, 2, '阅读的乐趣', '读书丰富内心世界', '每天坚持阅读半小时，不断学习新知识，拓宽视野，丰富内心世界，提升个人修养。', 136, 21, 5, 1),
(3, 2, '健身打卡坚持', '坚持健身保持好状态', '每周坚持三次健身，增强体质，塑造体型，保持良好精神状态，提高生活质量。', 129, 20, 4, 1),
(4, 2, '猫咪日常', '可爱猫咪陪伴生活', '家里的小猫咪非常可爱，每天陪伴左右，治愈所有不开心，带来很多欢乐。', 164, 28, 7, 1),
-- 随笔类
(5, 3, '人生感悟随笔', '对生活的一些思考', '生活就像一面镜子，你对它笑，它就对你笑；你对它哭，它就对你哭，保持乐观心态很重要。', 98, 15, 3, 1),
(6, 3, '学习心得总结', '近期学习收获总结', '最近学习了很多新技术，收获满满，不断进步才能不被淘汰，坚持终身学习。', 87, 13, 2, 1),
(7, 3, '工作日常记录', '记录工作中的点滴', '认真对待每一项工作，不断积累经验，提升能力，努力成为更优秀的自己。', 105, 17, 4, 1),
(8, 3, '心情随笔', '记录当下心情', '有时候安静下来，写写心情，梳理思绪，会让自己更平静、更清醒。', 76, 11, 2, 1),
(9, 3, '成长记录', '记录自己的成长历程', '每一步成长都值得记录，遇到困难不放弃，坚持下去就能看到希望。', 112, 18, 3, 1),
(10, 3, '未来期许', '对未来的期待和规划', '未来可期，努力奋斗，朝着目标不断前进，相信自己会越来越好。', 92, 14, 3, 1);

-- 30条评论
INSERT INTO `comment` (`article_id`, `user_id`, `parent_id`, `content`, `status`) VALUES
(1, 2, 0, '写得非常详细，学到了！', 1),
(1, 3, 0, '感谢分享，很实用', 1),
(1, 4, 1, '请问文件大小怎么配置？', 1),
(2, 5, 0, 'MP确实很香，开发效率超高', 1),
(2, 6, 0, '一直用MP，简化很多代码', 1),
(3, 7, 0, 'Vue3+ElementPlus太好用了', 1),
(3, 8, 0, '请问有源码吗？', 1),
(3, 9, 3, '同求源码学习一下', 1),
(4, 10, 0, '索引优化很关键', 1),
(4, 1, 0, '学习了，感谢分享', 1),
(5, 2, 0, 'Redis缓存实战很强', 1),
(5, 3, 0, '已收藏，慢慢学习', 1),
(6, 4, 0, 'Security权限控制很详细', 1),
(6, 5, 0, '学到了，感谢大佬', 1),
(7, 6, 0, '爬山确实很放松', 1),
(7, 7, 0, '请问去哪里爬的山？', 1),
(8, 8, 0, '早餐真的很重要', 1),
(8, 9, 0, '每天坚持吃早餐', 1),
(9, 10, 0, '夜景拍得真好看', 1),
(9, 1, 0, '城市夜景太美了', 1),
(10, 2, 0, '阅读使人进步', 1),
(10, 3, 0, '坚持阅读打卡', 1),
(11, 4, 0, '健身坚持最难了', 1),
(11, 5, 0, '一起健身打卡', 1),
(12, 6, 0, '猫咪太可爱了吧', 1),
(12, 7, 0, '治愈系小猫咪', 1),
(13, 8, 0, '写得很有道理', 1),
(14, 9, 0, '学习使人快乐', 1),
(15, 10, 0, '认真工作的每一天', 1),
(16, 1, 0, '未来一起加油', 1);
