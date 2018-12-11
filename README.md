# hibernate-cascade
hibernate级联保存、级联删除、级联更新

使用方法：
1. 将项目clone下来
2. 导入项目，并将项目名改为自己的项目名
3. 更改jdbc.properties（数据库地址），包括数据库名、用户名、密码
4. 新建数据库（注意数据库名称对应）
5. 配置tomcat
6. 启动tomcat（hibernate自动创建数据库表）

数据库介绍
1. 包含停车场表和道口表，一个停车场下有多个道口，如D区东门停车场下有前门入口、后门入口两个道口
2. 包含道口状态表，指明当前道口的状态
3. 包含过车记录表，记录过车信息，包含阶段信息列表（更具体的请看代码Model层，里面有详细的介绍）

功能点：
1.删除ParkModel，所有Model全部删除
2.删除CrossingModel，同时删除CrossingStateModel，RecordModel，SectionModel
3.删除CrossingStateModel，只删除CrossingStateModel
4.删除RecordModel，同时删除SectionModel

5.保存CrossingModel，同时保存ParkModel
6.保存RecordModel，同时保存SectionModel
7.保存CrossingStateModel，同时保存CrossingModel

8.更新ParkModel时，可以更新
9.更新CrossingModel时，ParkModel同时更新
9.更新RecordModel时，SectionModel同时更新

问题点（与功能点对应）：
1. ParkModel是CrossingModel外键关联的主键表
2. CrossingModel是CrossingStateModel外键关联的主键表
3. CrossingStateModel删除时会级联删除CrossingModel，而CrossingModel是CrossingStateModel外键关联的主键表
4. RecordModel删除时会级联删除CrossingModel，而CrossingModel是CrossingStateModel外键关联的主键表

解决办法（与问题点对应）：
1. 将mysql的外键约束设为级联删除
2. 将mysql的外键约束设为级联删除
3. 将Model层对应的cascade = CascadeType.ALL删除
4. 将Model层对应的cascade = CascadeType.ALL删除

测试：
1. 测试级联保存 http://localhost:8080/hibernate-cascade/test1
2. 测试级联删除 http://localhost:8080/hibernate-cascade/test2
3. 测试级联更新 http://localhost:8080/hibernate-cascade/test3

有问题欢迎随时交流，联系邮箱：1501873102@qq.com
