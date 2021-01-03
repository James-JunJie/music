<template>
  <div id="app">
   <the-header />
   <router-view class="music-content"/>
   <scroll-top/>
   <song-audio/>
  <play-bar/>
   <the-aside/>
   <the-footer/>
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue'
import ScrollTop from './components/ScrollTop';
import TheFooter from './components/TheFooter';
import SongAudio from './components/SongAudio.vue';
import playBar from './components/PlayBar.vue';
import TheAside from './components/TheAside.vue'

export default {
  name: 'App',
  components: {
      TheHeader,
      ScrollTop,
      TheFooter,
      SongAudio,
      playBar,
      TheAside
  }
}
</script>

<style  lang="scss" scoped>
@import './assets/css/app.scss';
</style>
