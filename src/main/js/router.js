import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoListContent from './components/TodoListContent.vue'
import Landing from './components/Landing.vue'
import SignUp from './components/SignUp.vue'
import SignIn from './components/SignIn.vue'

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [
        { path: '/',        component: Landing },
        { path: '/todos',   component: TodoListContent },
        { path: '/signup',  component: SignUp },
        { path: '/signin',  component: SignIn },
    ]
})

export default router