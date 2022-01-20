<template>
  <div id="home">
    <el-container>    
      <base-header :activeIndex="activeIndex"></base-header>	
      <router-view class="me-container"/>
    </el-container>
  </div>
</template>

<script>
import BaseHeader from '@/views/BaseHeader'

export default{
  name:'Home',
  data(){
    return{
      activeIndex:'/'
    }
  },
  components:{
    'base-header':BaseHeader
  },
  beforeRouteEnter (to, from, next){
    next(vm => {
      vm.activeIndex = to.path
    })
  },
  beforeRouteUpdate (to, from, next) {
    this.activeIndex = to.path
    next()
	}
}
</script>
