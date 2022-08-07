<template>
  <div id="app"> 
    <Header />
    <router-view></router-view>
  </div>
</template>

<script>
  import Header from './components/Header.vue'
  import Index from './pages/Index.vue'

  export default {
    name: 'App',
    components: {
      Header,
      Index
    }
  }
</script>

<style>

</style>
