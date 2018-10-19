import Vue from 'vue'
import Vuex from 'vuex'
import router from './router'
Vue.use(Vuex)

import * as TodoAPI from './lib/http/TodoAPI'
import * as UserAPI from './lib/http/UserAPI'
import { HttpConstants } from './lib/http/Constants'

const store = new Vuex.Store({
    state: {
        todos: [],
        message: "",
        username: undefined,
        signin: false
    },
    getters: {
        todos: state => {
            return state.todos
        },
        message: state =>  {
            return state.message
        },
        username: state => {
            return state.username
        },
        signin: state => {
            return state.login
        }
    },
    mutations: {
        setUsername(state, payload) {
            state.username = payload.username
            state.signin = true
        },
        setTodos(state, payload) {
            state.todos = payload.todos
        },
        addTodo(state, payload) {
            state.todos.push(payload.todo)
        },
        deleteTodo(state, payload) {
            state.todos = state.todos.filter(todo => todo.id !== payload.id)
        },
        setMessage(state, payload) {
            state.message = payload.message
        },
        changeStatus(state, payload) {
            const arrayNum = state.todos.findIndex((todo) => todo.id === payload.id)
            state.todos[arrayNum].done = !state.todos[arrayNum].done
        },
        updateName(state, payload) {
            const arrayNum = state.todos.findIndex((todo) => todo.id === payload.id)
            state.todos[arrayNum].name = payload.name
        }
    },
    actions: {
       signIn({ commit }, { username, password }) {
            sessionStorage.removeItem(HttpConstants.STORAGE_AUTHORIZATION_KEY)
            UserAPI.signin({ username, password }).then(res => {
                let authorization = res.headers['authorization']
                if (authorization && authorization.startsWith("Bearer ")) {
                    sessionStorage.setItem(HttpConstants.STORAGE_AUTHORIZATION_KEY, authorization)
                    commit('setMessage', { message: "ログインしました！" })
                    router.push({ path: 'todos'})
                } else {
                    commit('setMessage', { message: "存在しないユーザー名かパスワードが間違っています" })
                }
            }).catch(err => {
                commit('setMessage', { message: "存在しないユーザー名かパスワードが間違っています" })
            })
        },
        signUp({ commit }, { username, password, password_confirm }) {
            sessionStorage.removeItem(HttpConstants.STORAGE_AUTHORIZATION_KEY)
            if (password === password_confirm) {
                UserAPI.signup({ username, password }).then(res => {
                    if (res.status == 201) {
                        commit('setMessage', { message: "ユーザーは作成されました" })
                    } else {
                        commit('setMessage', { message: "ユーザーは作成できませんでした" })
                    }
                }).catch(err => {
                    console.log(err)
                    commit('setMessage', { message: "ユーザーは作成できませんでした" })
                })
            } else {
                commit('setMessage', { message: "パスワードと確認用パスワードが一致していません" })
            }
        },
        signOut({ commit }) {
            sessionStorage.removeItem(HttpConstants.STORAGE_AUTHORIZATION_KEY)
            router.push({ path: '/'})
            commit('setMessage', { message: "サインアウトしました" })

        },
        me({ commit }) {
            UserAPI.me().then(me => {
                commit('setUsername', { username: me.username })
            })
        },
        async setTodos({ commit }) {
            const todos = await TodoAPI.findAll()
            commit('setTodos', { todos })
        },
        async addTodo({ commit }, name) {
            const todo = await TodoAPI.create({ name, done: false})
            commit('addTodo', { todo })
        },
        async deleteTodo({ commit }, id) {
            await TodoAPI.remove(id)
            commit('deleteTodo', { id })
        },
        async changeStatus({ commit, state }, id) {
            const done = !state.todos.find(todo => todo.id === id).done
            const todo = await TodoAPI.patch(id, { done })
            commit('changeStatus', { id: todo.id } )
        },
        async updateName({ commit }, { id, name }) {
            const todo = await TodoAPI.patch(id, { name })
            commit('updateName', { id, name: todo.name })
        },
        setMessage({ commit }, message) {
            commit('setMessage', { message }) 
        }
    }
  })

export default store