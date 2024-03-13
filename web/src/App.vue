<template>
  <a-layout>
    <theHeader></theHeader>
      <router-view/>
    <theFooter></theFooter>
  </a-layout>
</template>


<script lang="ts">
import { defineComponent } from 'vue';
import theHeader from './components/the-header.vue';
import theFooter from './components/the-footer.vue';

export default defineComponent({
  name: 'app',
  components: {
    theHeader,
    theFooter
  },
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
