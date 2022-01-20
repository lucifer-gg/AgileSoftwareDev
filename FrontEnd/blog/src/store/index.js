import Vuex from 'vuex'
import Vue from 'vue'
import {login, getUserInfo, logout, register} from '@/api/login'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id: '',
    account: '',
    name: '',
    avatar: '',
    token: localStorage.token,
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
    },
    SET_ACCOUNT: (state, account) => {
      state.account = account
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ID: (state, id) => {
      state.id = id
    }
  },
  actions: {

    // 登录
    login({commit}, user){
      return new Promise((resolve, reject) => {
        login(user.account, user.password).then(data => {
          if(data.success){
            commit('SET_TOKEN', data.data)
            localStorage.token = data.data
            resolve()
          }else{
            reject(data.msg)
          }
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    getUserInfo({commit, state}) {
      // let that = this
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(data => {
          if (data.success) {
            commit('SET_ACCOUNT', data.data.account)
            commit('SET_NAME', data.data.nickname)
            commit('SET_AVATAR', data.data.avatar)
            commit('SET_ID', data.data.id)
            resolve(data)
          } else {
            commit('SET_ACCOUNT', '')
            commit('SET_NAME', '')
            commit('SET_AVATAR', '')
            commit('SET_ID', '')
            localStorage.removeItem('token')
            resolve(data)
          }
        }).catch(error => {
          commit('SET_ACCOUNT', '')
          commit('SET_NAME', '')
          commit('SET_AVATAR', '')
          commit('SET_ID', '')
          localStorage.removeItem('token')
          reject(error)
        })
      })
    },

    // 退出
    logout({commit, state}) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(data => {
          if(data.success){
            commit('SET_TOKEN', '')
            commit('SET_ACCOUNT', '')
            commit('SET_NAME', '')
            commit('SET_AVATAR', '')
            commit('SET_ID', '')
            localStorage.removeItem('token')
            resolve()
          }
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    fedLogOut({commit}) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        commit('SET_ACCOUNT', '')
        commit('SET_NAME', '')
        commit('SET_AVATAR', '')
        commit('SET_ID', '')
        localStorage.removeItem('token')
        resolve()
      })
    },

    // 注册
    register({commit}, user) {
      return new Promise((resolve, reject) => {
        register(user.account, user.nickname, user.password).then((data) => {
          if(data.success){
            commit('SET_TOKEN', data.data)
            localStorage.token = data.data
            resolve()
          }else{
            reject(data.msg)
          }
        }).catch((error) => {
          reject(error)
        })
      })
    }
  }
})
