<template>
    <div>
        <v-navigation-drawer
            v-model="drawer"
            fixed
            app
        >
            <v-list dense subheader>
                <v-subheader>Hello, 
                    <div style="padding-left: 10px;font-weight: bold;">
                     {{ username }}
                    </div>
                </v-subheader>
                <v-list-tile to="/todos" class="item">
                    <v-list-tile-action>
                        <v-icon>home</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>Home</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
                <v-list-tile @click="clickSignInButton" class="item">
                    <v-list-tile-action>
                        <v-icon>arrow_back</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>Sign Out</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar color="primary" dark fixed app>
            <v-toolbar-side-icon @click.stop="changeDrawer"></v-toolbar-side-icon>
            <v-toolbar-title>
                <router-link to="/todos" class="title">Vue Todo</router-link>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items class="hidden-sm-and-down">
                <v-btn flat @click="clickSignInButton">Sign Out</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <slot></slot>
        <v-footer color="primary" app>
            <span class="white--text">&copy; 2018</span>
        </v-footer>
    </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
export default {
    data () {
        return {
            drawer: false
        }
    },
    computed: mapGetters(['username']),
    methods: {
        ...mapActions([
            'signOut',
            'me'
        ]),
        clickSignInButton() {
            this.signOut()
        },
        changeDrawer: function() {
            this.drawer = !this.drawer
        }
    },
    created () {
        this.me()
    }

}
</script>
<style lang="scss" scoped>
    .title {
        text-decoration: none;
        color: white;
    }
    .item {
        text-decoration: none;
        color: black;
    }
</style>

