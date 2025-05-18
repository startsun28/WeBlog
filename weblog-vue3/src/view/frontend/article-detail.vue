<template>
  <Header/>
  <!-- 主内容区域 -->
  <main class="container max-w-screen-xl mx-auto p-4 px-6">
    <!-- grid 表格布局，分为 4 列 -->
    <div class="grid grid-cols-4 gap-7">
      <!-- 左边栏，占用 3 列 -->
      <div class="col-span-4 md:grid-cols-3">

      </div>
      <!-- 右边侧边栏，占用一列 -->
      <div class="col-span-4 md:grid-cols-1">
        <!-- 博主信息 -->
        <UserInfoCard />
        <!-- 分类 -->
        <CategoryListCard />
        <!-- 标签 -->
        <TagListCard />
      </div>
    </div>

  </main>
</template>

<script setup>
import Header from '@/layouts/frontend/components/Header.vue';
import UserInfoCard from '@/layouts/frontend/components/UserInfoCard.vue';
import CategoryListCard from '@/layouts/frontend/components/CategoryListCard.vue';
import TagListCard from '@/layouts/frontend/components/TagListCard.vue';
import { useRoute} from 'vue-router';

const route = useRoute()

console.log(route.params.articleId)
</script>