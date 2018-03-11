**项目说明** 
- ljkFrame-base-boot是一个Spring boot快速开发脚手架，是另一个开源项目ljkFrame的Spring boot基础框架版本。
技术使用shiro、Redis、MyBatis、quartz、jwt、swagger2、Vue2.x等，
完善的权限管理（菜单权限、按钮权限、数据权限）、用户管理、角色管理、API接口、日志管理、定时任务管理、云存储等模块。
感兴趣可以Watch、Start持续关注项目最新状态


**项目地址** 
**ljkFrame-base-boot地址**
-  码云仓库：https://gitee.com/leejinki/ljkFrame-base-boot.git

 **演示环境** 

 **软件环境** 
- JDK1.8
- MySQL5.7.17
- Maven3.5.2
- Tomcat8.5.27
- redis 3.2.100

 **本地部署**
- 创建数据库ljkframe，数据库编码为UTF-8,导入sql/db/ljkframe_boot.sql脚本
- 修改application-dev.yml文件，更改MySQL账号和密码
- redis服务,可以使用单机redis也可以配置哨兵集群模式
- 启动项目，访问路径：http://localhost:8081/frame-admin  帐户/密码:ljk/a


 
 
