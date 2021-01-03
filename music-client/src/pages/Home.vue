<template>

  <div class="home">
    <swiper/>
    <div class="section" v-for="(item,index) in songsList" :key="index">
      <div class="section-title">{{item.name}}</div>
      <content-list :contentList="item.list"></content-list>
    </div>

  </div>
</template>

<script>
  //引入轮播图
  import Swiper from "../components/Swiper";
  //引入列表
  import contentList from '../components/ContentList.vue';

  import {
    getAllSinger,
    getAllSongList
  } from "../api/index.js";

  export default {
    name: 'home',
    components: {
      Swiper,
      contentList
    },
    data() {
      return {
        songsList: [{
            name: "歌单",
            list: []
          },
          {
            name: "歌手",
            list: []
          }
        ]
      }
    },
    created() {
    this.getSongList();
    this.getSinger();
    },
    methods: {
      //获取前十条歌单
      getSongList() {
        getAllSongList().then((res) => {
          //slice   取值 0 到 10的jsons数据
          this.songsList[0].list = res.slice(0, 10);

        }).catch((err) => {
          console.log(err);
        })
      },
      getSinger() {
        getAllSinger().then((res) => {
          //slice   取值 0 到 10的jsons数据
          this.songsList[1].list = res.slice(0, 10);
        }).catch((err) => {
          console.log(err);
        })

      }
    },
  }
</script>

<style lang="scss" scoped>
  @import '../assets/css/home.scss';
</style>
