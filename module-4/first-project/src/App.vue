<template>
  <div id='app'>
    <product-review> </product-review>
  </div>
</template>

<script>
import productReview from './components/productReview.vue';

export default {
  name: 'App',
  components: {
    productReview
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
