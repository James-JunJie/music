 #幻听音乐网站

* 采用springboot+vue的前后端分离项目
* 管理员上传音乐，用户可以评论、点赞。
* 系统开发平台：JDK1.8+Maven3.6.1
* 开发语言：JavaEE+vue2.X 
* 后台框架：Springboot2.X 
* 前端：Vue2.9.6 
* 数据库和工具：MySql5.7 Navicat
* 开发工具： Intellij Idea VSCode 
* 浏览器：Chrome
* 存储方式：FastDfs

# 更改后端端口

* music-manager\src\api\http.js中  axios.defaults.baseURL 改为后端地址
* music-manager\src\store\index.js  HOST改为后端地址
* music-client\src\api\http.js 中  axios.defaults.baseURL 改为后端地址
* music-client\src\store\configuure.js  HOST改为后端地址

# 项目演示

前台：http://118.31.121.237:8080/

后台：http://118.31.121.237:8083/



# 项目展示

​    **前台主要实现歌曲播放，收藏，评论，用户登录注册，已查看已收藏歌曲，主要实现界面如图所示：**

​                               

 图2-1-1 前台展示主界面

![image-20210103144431435](\image\image-20210103144431435.png)

图2-1-2 歌单界面

 ![image-20210103144417755](image\image-20210103144417755.png)



图2-1-3 歌手界面

 

 ![image-20210103144440416](image\image-20210103144440416.png)

图2-1-4 登录界面

 ![image-20210103144447657](image\image-20210103144447657.png)

图2-1-5 注册界面

 ![image-20210103144451665](\image\image-20210103144451665.png)

图2-1-1 我的音乐界面

 ![image-20210103144454699]( image\image-20210103144454699.png)

图2-1-1 歌单详情界面

 ![image-20210103144458547]( image\image-20210103144458547.png)

  图2-1-1 歌单列表界面

 

 ![image-20210103144501210]( image\image-20210103144501210.png)![image-202101 

 图2-1-1 列表界面

![image-20210103144517662]( image\image-20210103144517662.png)

后台管理实现主要是对音乐，歌手，进行相关设置与维护操作。具体的实现界面如图2-1、图2-2所示。

###### 2.2.1.1系统首页



图2-1 后台管理主界面

 ![image-20210103144532614](image\image-20210103144532614.png)

图2-2 用户管理

![image-20210103144535518]( image\image-20210103144535518.png)理界面



图2-3 歌手管理界面

 ![image-20210103144539157]( image\image-20210103144539157.png)

图2-4 歌单管理界面

 <img src=" image\image-20210103144545289.png" alt="image-20210103144545289"  />

图2-5 歌曲信息管理界面

 ![image-20210103144548713]( \image\image-20210103144548713.png)

图2-6歌单歌曲信息管理界面

# 前端介绍 

> api/index.js ： 与后端交互接口
>
> assets： 静态资源文件....



