<template>
  <!-- 分类 -->
  <div class="w-full mt-4 p-5 mb-3 bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
    <!-- 分类标题 -->
    <h2 class="flex items-center text-lg mb-2 font-bold text-gray-900 uppercase dark:bg-gray-800 dark:border-gray-600 dark:text-white">
      <svg t="1747476559436" class="icon w-4 h-4 mr-2 dark:border-gray-600 dark:text-white" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13152" width="200" height="200"><path d="M482.133333 341.333333l-42.666666-106.666666h-341.333334v554.666666h42.666667V277.333333h256l42.666667 106.666667h469.333333v469.333333h-810.666667v42.666667h853.333334V341.333333z" fill="" p-id="13153"></path><path d="M247.466667 106.666667v128h42.666666V149.333333h469.333334v149.333334h42.666666V106.666667zM631.466667 448h170.666666v42.666667h-170.666666z" fill="#ED3F80" p-id="13154"></path></svg>
      分类
    </h2>
    <!-- 分类列表 -->
    <div class="text-sm font-medium text-gray-600 bg-white rounded-lg dark:bg-gray-800 dark:border-gray-600 dark:text-white">
      <a @click="goCategoryArticleListPage(category.id, category.name)" v-for="(category, index) in categories" :key="index"
         class="flex items-center w-full px-4 py-2 rounded-lg border-gray-200 cursor-pointer hover:bg-gray-100
         hover:text-sky-600 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500
         dark:focus:text-white"
      >
        <svg class="w-3.5 h-3.5 mr-1.5 dark:text-white dark:border-white-600" aria-hidden="true"
             xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 21 18">
          <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M2.539 17h12.476l4-9H5m-2.461 9a1 1 0 0 1-.914-1.406L5 8m-2.461 9H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H16a1 1 0 0 1 1 1v2H5" />
        </svg>
        {{ category.name }}
      </a>
    </div>

  </div>
</template>

<script setup>

import {ref} from 'vue'
import { useRouter } from 'vue-router'
import {getCategoryList} from '@/api/frontend/category'
// 引入路由
const router = useRouter()

// 跳转分类文章列表页
const goCategoryArticleListPage = (id, name) => {
  // 跳转时通过 query 携带参数（分类 ID、分类名称）
  router.push({path: '/category/article/list', query: {id, name}})
}

//所有分类
const categories = ref([])
getCategoryList().then((res) => {
  if(res.success) {
    categories.value = res.data
  }
})
</script>
