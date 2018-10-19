<template>
    <main-content>
        <v-content>
            <v-container fluid fill-height>
                <v-layout
                    row
                >
                    <v-flex xs12 sm6 offset-sm3>
                        <add-todo></add-todo>
                        <todo-list></todo-list>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>
    </main-content>
</template>
<script>
import { mapActions } from 'vuex'
import MainContent from '../layouts/MainContent.vue'
import TodoList from './TodoList.vue'
import AddTodo from './AddTodo.vue'
export default {
    components: {
        MainContent,
        TodoList,
        AddTodo
    },
    created () {
        this.setTodos()
    },
    methods: {
        ...mapActions([
            'setTodos'
        ])
    }
}
</script>
