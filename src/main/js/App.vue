<template>
    <v-app id="inspire">
        <router-view />
        <message></message>
    </v-app>
</template>
<script>
import Message from './components/Message.vue'
export default {
    components: {
        Message
    }
}
</script>

