<template>
  <div id="app"> 
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style>
  :root {
    --juejin-brand-1-normal: #1e80ff;
    --juejin-brand-2-hover: #1171ee;
    --juejin-brand-3-click: #0060dd;
    --juejin-brand-4-disable: #abcdff;
    --juejin-brand-5-light: #eaf2ff;
    --juejin-font-1: #252933;
    --juejin-font-2: #515767;
    --juejin-font-3: #8a919f;
    --juejin-font-4: #c2c8d1;
  }
  * {
    margin: 0;
    padding: 0;
  }
</style>

