<template>
  <Header></Header>
  <main class="container max-w-screen-xl mx-auto p-4 px-6">
    <div class="grid grid-cols-4 gap-7">
      <div class="col-span-4 md:col-span-3 mb-3">
        <CategoryListCard />
      </div>
      <!-- 右边侧边栏，占用一列 -->
      <aside class="col-span-4 md:col-span-1">
        <!-- 博主信息 -->
        <UserInfoCard />
        <!-- 分类     -->
        <CategoryListCard/>
        <!-- 标签 -->
        <TagListCard />
      </aside>
    </div>
  </main>
  <Footer />
</template>

<script setup>
import Header from '@/layouts/frontend/components/Header.vue'
import Footer from '@/layouts/frontend/components/Footer.vue'
import UserInfoCard from '@/layouts/frontend/components/UserInfoCard.vue'
import TagListCard from '@/layouts/frontend/components/TagListCard.vue'
import CategoryListCard from '@/layouts/frontend/components/CategoryListCard.vue'
</script>

