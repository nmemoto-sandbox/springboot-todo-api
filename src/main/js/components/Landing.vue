<template>
<basic>
  <v-jumbotron color="primary" dark height="500px">
    <v-container fill-height>
      <v-layout align-center>
        <v-flex text-xs-center>
          <h3 class="display-3">Vue Todo</h3>
          <router-link to="/signup">
            <v-btn
                class="mx-0"
                flat
                large
                outline 
            >
                Sign Up
            </v-btn>
          </router-link>
          <router-link to="/signin">
            <v-btn
                class="mx-0"
                flat
                large
                outline 
            >
                Sign In
            </v-btn>
          </router-link>
        </v-flex>
      </v-layout>
    </v-container>
  </v-jumbotron>
</basic>
</template>
<script>
import Basic from '../layouts/Basic.vue'
export default {
    components: {
        Basic
    },
}
</script>

