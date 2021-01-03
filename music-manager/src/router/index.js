import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    //不带#
    mode:'hash',
    
  routes: [
    {
     //路由跳转路径
          path: '/',
          //name:..路由名称
          //路由跳转组件
          //用require这种方式引入的时候，会将你的component分别打包成不同的js，加载的时候也是按需加载，只用访问这个路由网址时才会加载这个js。
      component: resolve => require(['../pages/Login.vue'], resolve)
    },

    {
      path: '/Home',
      component: resolve => require(['../components/Home.vue'], resolve),
      children:[
        {

          path: '/Info',
          component: resolve => require(['../pages/InfoPage.vue'], resolve)
        },
        {
          //用户页面
          path: '/Consumer',
          component: resolve => require(['../pages/ConsumerPage.vue'], resolve)
        },
        {
          //歌手管理页面
          path: '/Singer',
          component: resolve => require(['../pages/SingerPage.vue'], resolve)
        },
        {
          //歌单管理页面
          path: '/SongList',
          component: resolve => require(['../pages/SongListPage.vue'], resolve)
        },
        {
          //歌曲管理页面(由歌手页面跳转)
          path: '/Song',
          component: resolve => require(['../pages/SongPage.vue'], resolve)
        },
        //歌曲管理页面(由歌单页面跳转的)
        {
          path: '/ListSong',
          component: resolve => require(['../pages/ListSongPage.vue'], resolve)
        }
      ]
    },
    {
      //路由跳转路径
      path: '*',
      //路由跳转组件
      component: resolve => require(['../pages/NotFound.vue'], resolve)
    }
  ]
})
