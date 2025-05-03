<template>
  <div class="app">
    <h1>User List</h1>
    <ul v-if="users.length">
      <li v-for="(user, index) in users" :key="index">
        {{ user[0] }} - {{ user[1] }}
      </li>
    </ul>
    <p v-else>Loading...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const users = ref([])

onMounted(async () => {
  const res = await fetch('/api/users')
  users.value = await res.json()
})
</script>

<style>
.app {
  font-family: sans-serif;
  padding: 2rem;
}
</style>