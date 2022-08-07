<template>
  <div id="app"> 
    <Header />
    <Index />
   
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
