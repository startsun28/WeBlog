import Index from '@/view/frontend/index.vue'
import Login from '@/view/admin/login.vue'
import AdminIndex from '@/view/admin/index.vue'
import Admin from "@/layouts/admin/admin.vue";
import { createRouter, createWebHashHistory } from 'vue-router'
import AdminArticleList from '@/view/admin/article-list.vue'
import AdminCategoryList from '@/view/admin/category-list.vue'
import AdminTagList from '@/view/admin/tag-list.vue'
import AdminBlogSettings from '@/view/admin/blog-settings.vue'
import ArchiveList from '@/view/frontend/archive-list.vue'
import CategoryList from '@/view/frontend/category-list.vue'
import CategoryArticleList from '@/view/frontend/category-article-list.vue'
import TagList from '@/view/frontend/tag-list.vue'
import TagArticleList from '@/view/frontend/tag-article-list.vue'
import ArticleDetail from '@/view/frontend/article-detail.vue'
import NotFound from '@/view/frontend/404.vue'

// 统一在这里声明所有路由
const routes = [
    {
        path: '/', // 路由地址
        component: Index, // 对应组件
        meta: { // meta 信息
            title: 'Weblog 首页' // 页面标题
        }
    },
    {
        path: '/login', // 登录页
        component: Login,
        meta: {
            title: 'Weblog 登录页'
        }
    },
    {
        path: '/archive/list',
        component: ArchiveList,
        meta:{
            title: 'Weblog 归档页'
        }
    },
    {
        path: '/category/list',
        component: CategoryList,
        meta:{
            title: 'Weblog 分类页'
        }
    },
    {
        path: '/category/article/list', // 分类文章页
        component: CategoryArticleList,
        meta: { // meta 信息
            title: 'Weblog 分类文章页'
        }
    },
    {
        path: '/tag/list', // 标签列表页
        component: TagList,
        meta: { // meta 信息
            title: 'Weblog 标签列表页'
        }
    },
    {
        path: '/tag/article/list', // 标签文章页
        component: TagArticleList,
        meta: { // meta 信息
            title: 'Weblog 标签文章页'
        }
    },
    {
        path: '/article/:articleId', // 文章详情页
        component: ArticleDetail,
        meta: { // meta 信息
            title: 'Weblog 详情页'
        }
    },
    {
        path: '/:pathMatch(.*)*',
        name: 'NotFound',
        component: NotFound,
        meta: {
            title: '404 页'
        }
    },
    {
        path: "/admin", // 后台首页
        component: Admin,
        // 使用到 admin.vue 布局的，都需要放置在其子路由下面
        children: [
            {
                path: "/admin/index",
                component: AdminIndex,
                meta: {
                    title: '仪表盘'
                }
            },
            {
                path: "/admin/article/list",
                component: AdminArticleList,
                meta: {
                    title: '文章管理'
                }
            },
            {
                path: "/admin/category/list",
                component: AdminCategoryList,
                meta: {
                    title: '分类管理'
                }
            },
            {
                path: "/admin/tag/list",
                component: AdminTagList,
                meta: {
                    title: '标签管理'
                }
            },
            {
                path: "/admin/blog/settings",
                component: AdminBlogSettings,
                meta: {
                    title: '博客设置'
                }
            },
        ]

    }
]

// 创建路由
const router = createRouter({
    // 指定路由的历史管理方式，hash 模式指的是 URL 的路径是通过 hash 符号（#）进行标识
    history: createWebHashHistory(),
    // routes: routes 的缩写
    routes,
    // 每次切换路由后，页面滚动到顶部
    scrollBehavior() {
        return { top: 0 }
    }
})


// ES6 模块导出语句，它用于将 router 对象导出，以便其他文件可以导入和使用这个对象
export default router