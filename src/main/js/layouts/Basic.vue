<template>
  <div>
  <v-navigation-drawer app></v-navigation-drawer>
  <v-toolbar app color="primary" dark>
    <v-toolbar-title><router-link to="/" class="title">Vue Todo</router-link></v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn flat to="/signup">
        Sign Up
      </v-btn>
      <v-btn flat to="/signin">
        Sign In
      </v-btn>
    </v-toolbar-items>
  </v-toolbar>
  <v-content>
            <slot></slot>
  </v-content>
  </div>
</template>
<style lang="scss" scoped>
    .title {
        text-decoration: none;
        color: white;
    }
</style>