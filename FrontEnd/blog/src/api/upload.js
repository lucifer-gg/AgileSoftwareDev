import request from '@/request'

export function upload(data){
  return request({
    headers: {'Content-Type': 'multipart/form-data'},
    url: '/upload',
    method: 'post',
    data: data
  })
}