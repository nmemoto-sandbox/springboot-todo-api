<template>

<div>
    <v-snackbar
      :value="message.length > 0"
      :bottom="true"
      :right="true"
      :timeout="0"
    >
      {{ message }}
      <v-btn
        color="pink"
        flat
        @click="setMessage('')"
      >
        Close
      </v-btn>
    </v-snackbar>
</div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
export default {
    computed: mapGetters(['message']),
    methods: {
        ...mapActions([
            'setMessage'
        ])
    }
}
</script>
