<template>
  <div id="home">
    <el-container>    
      <blog-header :activeIndex="activeIndex"></blog-header>	
      <router-view class="me-container"/>
      <blog-footer v-show="footerShow"></blog-footer>
    </el-container>
  </div>
</template>

<script>
import BlogHeader from '@/views/BlogHeader'
import BlogFooter from '@/views/BlogFooter'
export default{
  name:'Home',
  data(){
    return{
      activeIndex:'/',
      footerShow:true
    }
  },
  components:{
    'blog-header':BlogHeader,
    'blog-footer':BlogFooter
  },
  beforeRouteEnter (to, from, next){
    next(vm => {
      vm.activeIndex = to.path
    })
  },
  beforeRouteUpdate (to, from, next) {
    if(to.path == '/'){
      this.footerShow = true
    }else{
      this.footerShow = false
    }
    this.activeIndex = to.path
    next()
	}
}
</script>

<style>

.me-container{
  margin: 100px auto 140px;
}
</style>
