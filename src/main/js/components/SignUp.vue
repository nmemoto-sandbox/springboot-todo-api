<template>
    <basic>
        <v-container fluid fill-height>
            <v-layout align-center justify-center>
                <v-flex xs12 sm8 md4>
                    <v-card>
                        <v-toolbar card>
                            <v-toolbar-title>
                                SignUp page
                            </v-toolbar-title>
                        </v-toolbar>
                        <v-card-text>
                            <v-form>
                                <v-text-field prepend-icon="person" name="login" label="username" type="text" v-model="username"></v-text-field>
                                <v-text-field id="password" prepend-icon="lock" name="password" label="Password" type="password" v-model="password"></v-text-field>
                                <v-text-field id="password_confirm" prepend-icon="lock" name="password" label="Password Confirmation" type="password" v-model="password_confirm"></v-text-field>
                            </v-form>
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn @click="clickSignInButton" color="primary">SignUp</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
    </basic>
</template>
<script>
import Basic from '../layouts/Basic.vue'
import { mapActions } from 'vuex'
export default {
    components: {
        Basic
    },
    data () {
        return {
            username: '',
            password: '',
            password_confirm: ''
        }
    },
    methods: {
        ...mapActions([
            'signUp'
        ]),
        clickSignInButton() {
            this.signUp({ username: this.username, password: this.password, password_confirm: this.password_confirm })
        }
    }
}
</script>

