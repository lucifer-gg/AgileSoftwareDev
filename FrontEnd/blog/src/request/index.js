import axios from 'axios'
import {Message} from 'element-ui'
import store from '../store'
  /* eslint-disable */
const service = axios.create({
  // 暂定
  baseURL: "http://172.19.240.253:8888/",
  timeout: 5000
})

// 设置request拦截器
service.interceptors.request.use(config => {
  if(store.state.token){
    config.headers['Oauth-Token'] = localStorage.token
  }
  return config
},error => {
  Promise.reject(error)
})

// 设置response拦截器
service.interceptors.response.use(response => {
  // Session 超时
  if(response.headers['session_time_out'] == 'timeout'){
    store.dispatch('fedLogOut')
  }

  const res = response.data;
  if(res.code !== 200){

    // Session超时
    if(res.code === 90001){
      return Promise.reject('error');
    }

    // 用户未登录
    if(res.code === 90002){
      Message({
        type: 'warning',
        showClose: true,
        message: '您还未登录哦，请重新登录'
      })
      return Promise.reject('error');
    }

    // 权限认证失败
    if(res.code === 70001){
      Message({
        type: 'warning',
        showClose: true,
        message: '您没有权限访问哦'
      })
      return Promise.reject('error');
    }

    return Promise.reject(res.msg);
  }else{
    return response.data;
  }
},error => {
  Message({
    type: 'warning',
    showClose: true,
    message: '连接超时'
  })
  return Promise.reject('error')
})

export default service