<template>
    <div>
        <v-text-field
            v-model="newTodo"
            solo
            :append-outer-icon="'add_circle'"
            clearable
            label="New Todo"
            type="text"
            @click:append-outer="addNewTodo"
            @click:clear="clearText"
            @keyup.enter="addNewTodo"
        ></v-text-field>
    </div>
</template>
<script>
import { mapActions } from 'vuex'
export default {
    data () {
        return {
            newTodo: ''
        }
    },
    methods: {
        ...mapActions([
            'addTodo',
            'setMessage'
        ]),
        addNewTodo: function() {
            if (this.newTodo.length > 0) {
                this.addTodo(this.newTodo)
                this.newTodo = ''
                this.setMessage('')
            } else {
                this.setMessage('入力してください')
            }
        },
        clearText () {
            this.newTodo = ''
        }
    }
}
</script>
