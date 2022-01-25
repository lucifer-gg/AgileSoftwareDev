<template>
  <div v-title data-title="博客">
    <el-container>

      <el-main class="me-articles">

      </el-main>

      <el-aside>

      </el-aside>

    </el-container>
  </div>
</template>

<script>

  export default {
    name: 'Index',
    data() {
      return {
      }
    },
    methods: {

    },
    components: {
    }
  }
</script>

<style scoped>
  .el-container{
    width: 960px;
  }

  .el-aside{
    margin-left: 20px;
    width: 260px;
  }

  .el-main{
    padding: 0px;
    line-height: 16px;
  }

  
</style>
