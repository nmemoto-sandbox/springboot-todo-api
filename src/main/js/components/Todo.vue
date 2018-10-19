<template>
    <v-list-tile>
        <v-list-tile-action>
            <v-checkbox :input-value="todo.done" :value="todo.done" @change="changeStatus(todo.id)"></v-checkbox>
        </v-list-tile-action>

        <template v-if="this.editable">
            <v-text-field @keyup.enter="updateTodoName" @blur="updateTodoName" v-model="name" v-focus></v-text-field>
        </template>
        <template v-else>
            <v-list-tile-content @click="changeEditable">
                <v-list-tile-title :class="{done: todo.done}">{{ todo.name }}</v-list-tile-title>
            </v-list-tile-content>
            <v-list-tile-action>
              <v-btn icon ripple @click="deleteTodoById(todo.id)">
                <v-icon color="gray lighten-1">delete</v-icon>
              </v-btn>
            </v-list-tile-action>
        </template>
    </v-list-tile>
</template>
<script>
import { mapActions } from 'vuex'
export default {
    props: ['todo'],
    data () {
        return {
            editable: false,
            name: this.todo.name
        }
    },
    methods: {
        ...mapActions([
            'changeStatus',
            'updateName',
            'setMessage',
            'deleteTodo'
        ]),
        changeEditable() {
            this.editable = true
        },
        updateTodoName() {
            if (this.name.length > 0) {
                this.editable = false
                this.setMessage('')
                this.updateName({ id: this.todo.id, name: this.name })
            } else {
                this.setMessage('入力してください')
            }
        },
        deleteTodoById(id) {
            this.deleteTodo(id)
        }
    },
    directives: {
        focus: {
            inserted: function (el) {
                el.getElementsByTagName('input')[0].focus()
            }
        }
    }
}
</script>
<style lang="scss" scoped>
    .done {
        color: gray;
        text-decoration: line-through;
    }
</style>
