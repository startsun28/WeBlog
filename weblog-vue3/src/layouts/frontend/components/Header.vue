<template>
  <header class="sticky top-0 z-10">
    <nav class="bg-white border-gray-200 border-b dark:bg-gray-900">
      <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
        <!-- 博客 LOGO 、博客名称 -->
        <a href="/" class="flex items-center">
          <img :src="blogSettingsStore.blogSettings.logo" class="h-8 mr-3 rounded-full" alt="Flowbite Logo" />
          <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
            {{blogSettingsStore.blogSettings.name}}</span>
        </a>

        <div class="flex items-center md:order-2">
          <button type="button" data-collapse-toggle="navbar-search" aria-controls="navbar-search"
                  aria-expanded="false"
                  class="md:hidden text-gray-500 dark:text-gray-400 hover:bg-gray-100 dark:hover:bg-gray-700 focus:outline-none focus:ring-4 focus:ring-gray-200 dark:focus:ring-gray-700 rounded-lg text-sm p-2.5 mr-1">
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                 viewBox="0 0 20 20">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
            </svg>
            <span class="sr-only">Search</span>
          </button>
          <!-- 搜索框 -->
          <button type="button" @click="clickSearchBtn"
                  class="mr-2 hidden outline-none md:flex items-center text-sm leading-6 text-slate-400 rounded-md ring-1 ring-slate-900/10 shadow-sm py-1.5 pl-2 pr-3 hover:ring-slate-300 dark:bg-slate-800 dark:highlight-white/5 dark:hover:bg-slate-700">
            <svg class="w-3.5 h-3.5 mr-2 text-gray-500 dark:text-gray-400" aria-hidden="true"
                 xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
            </svg>
            <span class="mr-3">搜索文章 ...</span>
            <span class="px-2 py-[1px] flex-none text-xs border text-gray-400 rounded">Ctrl K</span>
          </button>
          <!-- 登录 -->
          <div class="text-gray-900 ml-1 mr-1 hover:text-blue-700" v-if="!isLogined"
               @click="$router.push('/login')">登录</div>
          <!-- 已经登录，展示用户头像 -->
          <button id="dropdownDefaultButton" data-dropdown-toggle="dropdown" v-else
                  class="text-white ml-2 mr-2 md:mr-0 focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                  type="button">
            <!-- 用户登录头像 -->
            <img class="w-8 h-8 rounded-full" :src="blogSettingsStore.blogSettings.avatar" alt="user photo">
          </button>

          <!-- Dropdown menu -->
          <div id="dropdown"
               class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow dark:bg-gray-700">
            <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefaultButton">
              <li>
                <a @click="router.push('/admin/index')"
                   class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">
                  <svg class="inline w-3 h-3 mb-[2px] mr-1 text-gray-700 dark:text-white"
                       aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                       viewBox="0 0 20 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M10 14v4m-4 1h8M1 10h18M2 1h16a1 1 0 0 1 1 1v11a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1Z" />
                  </svg>
                  进入后台
                </a>
              </li>
              <li>
                <a data-modal-target="popup-modal" data-modal-toggle="popup-modal"
                   class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">
                  <svg class="inline w-3 h-3 mb-[2px] mr-1 text-gray-700 dark:text-white"
                       aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                       viewBox="0 0 16 16">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M4 8h11m0 0-4-4m4 4-4 4m-5 3H3a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h3" />
                  </svg>
                  退出登录
                </a>
              </li>
            </ul>
          </div>

          <button data-collapse-toggle="navbar-search" type="button"
                  class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                  aria-controls="navbar-search" aria-expanded="false">
            <span class="sr-only">Open main menu</span>
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                 viewBox="0 0 17 14">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M1 1h15M1 7h15M1 13h15" />
            </svg>
          </button>
        </div>
        <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-search">
          <!-- 移动端搜索框 -->
          <button type="button" @click="clickSearchBtn"
                  class="relative mt-3 flex w-full md:hidden items-center text-sm leading-6 text-slate-400 rounded-md
                         ring-1 ring-slate-900/10 shadow-sm py-1.5 pl-2 pr-3 hover:ring-slate-300 dark:bg-slate-800
                         dark:highlight-white/5 dark:hover:bg-slate-700 dark:hover:ring-slate-700">
            <svg class="w-3.5 h-3.5 mr-2 text-gray-500 dark:text-gray-400" aria-hidden="true"
                 xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
            </svg>
            <span class="mr-3 grow text-left">搜索文章 ...</span>
            <span class="px-2 py-[1px] flex-none text-xs border text-gray-400 rounded dark:border-gray-600">Ctrl
                            K</span>
          </button>

          <ul class="flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
            <li>
              <a @click="router.push('/')"
                 :class="[currPath == '/' ? 'text-blue-700' : 'text-gray-900']"
                 class="block py-2 pl-3 pr-4  rounded md:bg-transparent md:p-0 md:dark:text-blue-500"
                 aria-current="page"
              >
                首页
              </a>
            </li>
            <li>
              <a @click="router.push('/category/list')"
                 :class="[currPath == '/category/list' ? 'text-blue-700' : 'text-gray-900']"
                 class="block py-2 pl-3 pr-4 rounded hover:bg-gray-100 md:hover:bg-transparent
                 md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700
                 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700"
              >
                分类
              </a>
            </li>
            <li>
              <a @click="router.push('/tag/list')"
                 :class="[currPath == '/tag/list' ? 'text-blue-700' : 'text-gray-900']"
                 class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700
                 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white
                 md:dark:hover:bg-transparent dark:border-gray-700"
              >
                标签
              </a>
            </li>
            <li>
              <a @click="router.push('/archive/list')"
                 :class="[currPath == '/archive/list' ? 'text-blue-700' : 'text-gray-900']"
                 class="block py-2 pl-3 pr-4 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700
                 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white
                 md:dark:hover:bg-transparent dark:border-gray-700"
              >
                归档
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <!-- 退出登录 -->
  <div id="popup-modal" tabindex="-1"
       class="fixed top-0 left-0 right-0 z-50 hidden p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] max-h-full">
    <div class="relative w-full max-w-md max-h-full">
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <button type="button"
                class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                data-modal-hide="popup-modal">
          <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
               viewBox="0 0 14 14">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
          </svg>
          <span class="sr-only">Close modal</span>
        </button>
        <div class="p-6 text-center">
          <svg class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200" aria-hidden="true"
               xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
          </svg>
          <h3 class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">是否确定退出登录?
          </h3>
          <button @click="logout" data-modal-hide="popup-modal" type="button"
                  class="text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm inline-flex items-center px-5 py-2.5 text-center mr-2">
            确定
          </button>
          <button data-modal-hide="popup-modal" type="button"
                  class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">
            取消</button>
        </div>
      </div>
    </div>
  </div>

  <!-- 站内搜索 -->
  <div id="search-modal" tabindex="-1" aria-hidden="true"
       class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center
              w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
    <div class="relative p-4 w-full max-w-2xl max-h-full">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow-sm dark:bg-gray-700">
        <!-- Modal header -->
        <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600 border-gray-200">
          <!-- 搜索框 -->
          <form class="w-full mr-2">
            <label for="search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
            <div class="relative">
              <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                <div v-if="searchLoading" role="status">
                  <svg aria-hidden="true" class="w-4 h-4 text-gray-200 animate-spin dark:text-gray-600 fill-blue-600" viewBox="0 0 100 101" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z" fill="currentColor"/><path d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z" fill="currentFill"/></svg>
                  <span class="sr-only">Loading...</span>
                </div>

                <svg v-else class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                     xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                        stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                </svg>
              </div>
              <input type="search" id="search" ref="searchInputRef" v-model="searchWord"
                     class="block w-full p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="请输入关键词搜索..." required>
            </div>
          </form>
          <button type="button" @click="searchModal.hide()"
                  class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white">
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                 viewBox="0 0 14 14">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
            </svg>
            <span class="sr-only">Close modal</span>
          </button>

        </div>
        <!-- Modal body -->
        <div class="p-4 md:p-5 space-y-4">
          <!-- Modal body -->
          <div v-if="searchArticles && searchArticles.length > 0">
            <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
              共搜索到 {{ total }} 篇相关文章
            </p>
            <ol class="mt-3 divide-y divider-gray-200 dark:divide-gray-700">
              <li v-for="(article, index) in searchArticles" :key="index">
                <a @click="jumpToArticleDetailPage(article.id)" class="items-center cursor-pointer block p-3 sm:flex hover:bg-gray-100 hover:rounded-lg dark:hover:bg-gray-700">
                  <img class="w-24 h-full mb-3 mr-3 rounded-lg sm:mb-0"
                       :src="article.cover">
                  <div class="text-gray-600 dark:text-gray-400">
                    <h2 class="text-base font-normal text-gray-900" v-html="article.title"></h2>
                    <span
                        class="inline-flex items-center text-xs font-normal text-gray-500 dark:text-gray-400">
                                        <svg class="inline w-2.5 h-2.5 mr-2 text-gray-400 dark:text-white"
                                             aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                             viewBox="0 0 20 20">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                                  stroke-width="2"
                                                  d="M5 1v3m5-3v3m5-3v3M1 7h18M5 11h10M2 3h16a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1Z">
                                            </path>
                                        </svg> {{ article.createDate }}</span>
                  </div>
                </a>
              </li>
            </ol>
            <!-- 分页 -->
            <div class="flex mt-7">
              <a v-if="current > 1" @click="prePage"
                 class="flex items-center justify-center px-3 h-8 me-3 text-xs font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 5H1m0 0 4 4M1 5l4-4"/>
                </svg>
              </a>

              <a v-if="current < pages" @click="nextPage" class="flex ml-auto items-center justify-center px-3 h-8 text-xs font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                </svg>
              </a>
            </div>
          </div>
          <!-- 未搜索到结果提示 -->
          <div v-else class="flex items-center justify-center flex-col mb-10">
            <svg class="w-50 h-50" height="200" node-id="1" sillyvg="true" template-height="1024" template-width="1024" version="1.1"
                 viewBox="0 0 1024 1024" width="1024" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs node-id="60"></defs><path d="M -0.00 24.86 L 1024.00 24.86 L 1024.00 1048.86 L -0.00 1048.86 Z" fill="#ffffff" fill-rule="nonzero" node-id="62" stroke="none" target-height="1024" target-width="1024" target-x="-0.000002861023" target-y="24.860868"/><path d="M 857.40 809.30 L 857.10 812.20 L 856.40 815.00 L 855.20 817.90 L 853.50 820.90 L 851.20 823.90 L 848.20 827.00 L 844.60 830.10 L 840.30 833.30 L 829.20 839.90 L 822.20 843.30 L 813.70 846.90 L 804.20 850.50 L 793.40 854.10 L 781.20 857.70 L 765.20 861.80 L 747.40 865.80 L 727.60 869.70 L 707.70 873.00 L 686.30 876.00 L 663.20 878.80 L 640.10 881.10 L 615.80 883.10 L 590.30 884.60 L 564.70 885.80 L 538.20 886.40 L 510.80 886.70 L 483.40 886.40 L 456.90 885.80 L 431.30 884.60 L 405.70 883.10 L 381.40 881.10 L 358.40 878.80 L 335.30 876.00 L 313.90 873.00 L 294.00 869.70 L 274.20 865.80 L 256.30 861.80 L 240.30 857.70 L 228.20 854.10 L 217.40 850.50 L 207.80 846.90 L 199.40 843.30 L 192.40 839.90 L 181.30 833.30 L 173.40 827.00 L 170.40 823.90 L 168.10 820.90 L 166.30 817.90 L 165.20 815.00 L 164.50 812.20 L 164.20 809.30 L 164.50 806.40 L 165.20 803.50 L 166.30 800.60 L 168.10 797.70 L 170.40 794.60 L 173.40 791.50 L 176.90 788.40 L 186.40 782.00 L 199.40 775.20 L 207.80 771.60 L 217.40 768.00 L 228.20 764.40 L 240.30 760.80 L 256.30 756.70 L 274.20 752.70 L 294.00 748.90 L 313.90 745.50 L 335.30 742.50 L 358.40 739.70 L 381.40 737.40 L 405.70 735.50 L 431.30 733.90 L 456.90 732.80 L 483.40 732.10 L 510.80 731.90 L 538.20 732.10 L 564.70 732.80 L 590.30 733.90 L 615.80 735.50 L 640.10 737.40 L 663.20 739.70 L 686.30 742.50 L 707.70 745.50 L 727.60 748.90 L 747.40 752.70 L 765.20 756.70 L 781.20 760.80 L 793.40 764.40 L 804.20 768.00 L 813.70 771.60 L 822.20 775.20 L 829.20 778.60 L 840.30 785.20 L 844.60 788.40 L 848.20 791.50 L 851.20 794.60 L 853.50 797.70 L 855.20 800.60 L 856.40 803.50 L 857.10 806.40 L 857.40 809.30 Z" fill="#dddddd" fill-rule="nonzero" node-id="64" stroke="none" target-height="154.79999" target-width="693.2" target-x="164.2" target-y="731.9"/><path d="M 449.40 433.10 L 572.60 433.10 L 581.90 433.30 L 591.10 434.10 L 600.20 435.30 L 609.20 436.90 L 618.10 439.10 L 626.80 441.70 L 635.40 444.70 L 643.80 448.20 L 652.00 452.10 L 660.10 456.50 L 667.90 461.20 L 675.40 466.40 L 682.70 472.00 L 689.70 478.00 L 696.50 484.40 L 702.90 491.10 L 708.90 498.20 L 714.40 505.40 L 719.60 513.00 L 724.40 520.80 L 728.70 528.80 L 732.60 537.00 L 736.10 545.40 L 739.10 554.00 L 741.80 562.80 L 743.90 571.60 L 745.60 580.60 L 746.80 589.70 L 747.50 598.90 L 747.80 631.80 L 747.50 635.80 L 746.70 639.50 L 745.50 643.00 L 743.80 646.40 L 741.70 649.40 L 739.30 652.20 L 736.50 654.70 L 733.50 656.70 L 730.10 658.40 L 726.60 659.60 L 722.80 660.40 L 718.90 660.70 L 303.10 660.70 L 299.20 660.40 L 295.40 659.60 L 291.90 658.40 L 288.50 656.70 L 285.50 654.70 L 282.70 652.20 L 280.30 649.40 L 278.20 646.40 L 276.50 643.00 L 275.30 639.50 L 274.50 635.80 L 274.30 631.80 L 274.50 598.90 L 275.20 589.70 L 276.40 580.60 L 278.10 571.60 L 280.20 562.80 L 282.90 554.00 L 285.90 545.40 L 289.40 537.00 L 293.30 528.80 L 297.60 520.80 L 302.40 513.00 L 307.60 505.40 L 313.10 498.20 L 319.10 491.10 L 325.50 484.40 L 332.30 478.00 L 339.30 472.00 L 346.60 466.40 L 354.10 461.20 L 361.90 456.50 L 370.00 452.10 L 378.20 448.20 L 386.60 444.70 L 395.20 441.70 L 403.90 439.10 L 412.80 436.90 L 421.80 435.30 L 430.90 434.10 L 440.10 433.30 L 449.40 433.10 Z" fill="#ffdccd" fill-rule="nonzero" node-id="66" stroke="none" target-height="227.6" target-width="473.5" target-x="274.3" target-y="433.1"/><path d="M 718.90 662.50 L 303.10 662.50 L 298.90 662.20 L 294.90 661.40 L 291.20 660.10 L 287.60 658.30 L 284.40 656.10 L 281.40 653.50 L 278.80 650.60 L 276.60 647.30 L 274.80 643.70 L 273.50 640.00 L 272.70 636.00 L 272.40 631.80 L 272.40 608.20 L 272.70 598.40 L 273.50 588.80 L 274.80 579.40 L 276.60 570.20 L 278.80 561.20 L 281.60 552.30 L 284.70 543.60 L 288.30 535.20 L 292.30 527.00 L 296.70 519.00 L 301.60 511.20 L 306.70 503.80 L 312.30 496.60 L 318.20 489.80 L 324.40 483.20 L 331.00 476.90 L 337.80 471.10 L 345.00 465.50 L 352.40 460.40 L 360.20 455.50 L 368.20 451.10 L 376.40 447.10 L 384.80 443.50 L 393.50 440.40 L 402.40 437.60 L 411.40 435.40 L 420.60 433.60 L 430.00 432.30 L 439.60 431.50 L 449.40 431.20 L 572.60 431.20 L 582.40 431.50 L 592.00 432.30 L 601.40 433.60 L 610.60 435.40 L 619.60 437.60 L 628.60 440.40 L 637.20 443.50 L 645.70 447.10 L 653.90 451.10 L 661.80 455.50 L 669.60 460.40 L 677.10 465.50 L 684.20 471.10 L 691.10 476.90 L 697.60 483.20 L 703.90 489.80 L 709.80 496.60 L 715.30 503.80 L 720.50 511.20 L 725.30 519.00 L 729.70 527.00 L 733.70 535.20 L 737.30 543.60 L 740.50 552.30 L 743.20 561.20 L 745.40 570.20 L 747.20 579.40 L 748.50 588.80 L 749.30 598.40 L 749.60 608.20 L 749.60 631.80 L 749.30 636.00 L 748.50 640.00 L 747.20 643.80 L 745.40 647.30 L 743.20 650.60 L 740.60 653.50 L 737.60 656.10 L 734.40 658.30 L 730.80 660.10 L 727.10 661.40 L 723.10 662.20 L 718.90 662.50 Z M 449.40 434.90 L 439.80 435.20 L 430.40 436.00 L 421.20 437.30 L 412.20 439.00 L 403.40 441.20 L 394.60 443.90 L 386.10 447.00 L 377.90 450.50 L 369.80 454.40 L 362.00 458.70 L 354.40 463.40 L 347.10 468.50 L 340.10 473.90 L 333.40 479.70 L 327.00 485.80 L 320.90 492.20 L 315.10 499.00 L 309.70 506.00 L 304.60 513.30 L 299.90 520.90 L 295.60 528.70 L 291.60 536.70 L 288.10 544.90 L 285.10 553.40 L 282.40 562.20 L 280.20 571.00 L 278.40 580.00 L 277.20 589.20 L 276.40 598.60 L 276.10 608.20 L 276.10 631.80 L 276.30 635.50 L 277.00 639.00 L 278.20 642.30 L 279.80 645.50 L 281.70 648.30 L 284.00 650.90 L 286.60 653.20 L 289.50 655.10 L 292.60 656.70 L 295.90 657.90 L 299.40 658.60 L 303.10 658.90 L 718.90 658.90 L 722.60 658.60 L 726.10 657.90 L 729.40 656.70 L 732.50 655.10 L 735.40 653.20 L 738.00 650.90 L 740.30 648.30 L 742.20 645.50 L 743.80 642.30 L 745.00 639.00 L 745.70 635.50 L 745.90 631.80 L 745.90 608.20 L 745.60 598.60 L 744.80 589.20 L 743.60 580.00 L 741.80 571.00 L 739.60 562.20 L 736.90 553.40 L 733.90 544.90 L 730.40 536.70 L 726.40 528.70 L 722.10 520.90 L 717.40 513.30 L 712.30 506.00 L 706.90 499.00 L 701.10 492.20 L 695.00 485.80 L 688.60 479.70 L 681.90 473.90 L 674.90 468.50 L 667.60 463.40 L 660.00 458.70 L 652.20 454.40 L 644.10 450.50 L 635.90 447.00 L 627.40 443.90 L 618.60 441.20 L 609.80 439.00 L 600.80 437.30 L 591.60 436.00 L 582.20 435.20 L 572.60 434.90 Z" fill="#141619" fill-rule="nonzero" node-id="68" stroke="none" target-height="231.29999" target-width="477.19998" target-x="272.4" target-y="431.2"/><path d="M 142.70 393.30 L 137.60 392.80 L 134.90 393.00 L 132.40 393.60 L 130.00 394.50 L 127.80 395.90 L 125.90 397.50 L 124.20 399.40 L 122.80 401.60 L 121.80 404.00 L 121.20 406.70 L 121.10 409.40 L 121.30 412.00 L 122.00 414.40 L 123.10 416.80 L 126.20 420.80 L 128.20 422.40 L 130.40 423.70 L 135.00 425.00 L 80.20 417.30 L 77.50 417.20 L 74.90 417.50 L 72.50 418.30 L 70.20 419.40 L 68.30 420.90 L 66.50 422.80 L 65.10 424.90 L 64.10 427.30 L 63.50 430.30 L 59.00 429.90 L 56.50 430.20 L 54.10 431.00 L 51.90 432.20 L 49.90 433.70 L 48.20 435.50 L 46.80 437.70 L 45.80 440.00 L 45.20 442.60 L 45.00 445.30 L 45.40 447.80 L 46.10 450.20 L 47.30 452.50 L 48.70 454.50 L 50.60 456.20 L 52.70 457.60 L 55.00 458.70 L 57.60 459.30 L 68.20 460.80 L 68.00 463.60 L 68.40 466.10 L 69.10 468.60 L 70.30 470.80 L 71.80 472.80 L 73.60 474.60 L 75.80 476.00 L 78.10 477.00 L 80.80 477.60 L 113.60 482.20 L 113.10 485.60 L 113.40 488.30 L 114.00 490.80 L 115.10 493.10 L 116.60 495.20 L 118.40 496.90 L 120.50 498.40 L 122.70 499.50 L 125.20 500.20 L 127.90 500.40 L 181.00 500.40 L 208.40 484.20 L 258.70 453.20 L 246.70 443.40 L 232.90 433.40 L 214.90 421.90 L 204.70 416.10 L 193.40 410.40 L 185.60 406.80 L 169.00 400.40 L 160.50 397.60 L 151.70 395.30 L 142.70 393.30 Z" fill="#ffffff" fill-rule="nonzero" node-id="70" stroke="none" target-height="107.600006" target-width="213.70001" target-x="45" target-y="392.8"/><path d="M 264.20 455.60 L 251.00 444.80 L 236.10 433.90 L 217.00 421.60 L 206.30 415.40 L 194.50 409.30 L 178.20 402.10 L 169.60 398.80 L 160.80 395.90 L 152.00 393.50 L 143.00 391.60 L 137.60 391.00 L 134.60 391.20 L 131.80 391.90 L 129.20 392.90 L 126.80 394.40 L 124.70 396.20 L 122.80 398.40 L 121.40 400.80 L 120.30 403.40 L 119.60 406.30 L 119.40 409.30 L 119.60 412.10 L 120.30 414.90 L 121.50 417.50 L 123.00 419.80 L 124.80 421.90 L 127.00 423.70 L 129.50 425.20 L 132.30 426.30 L 163.30 432.40 L 164.30 428.90 L 133.50 422.90 L 131.30 422.10 L 127.50 419.50 L 125.90 417.80 L 123.80 413.90 L 122.90 409.40 L 123.10 407.00 L 123.60 404.60 L 125.70 400.50 L 127.20 398.80 L 130.80 396.10 L 135.20 394.80 L 140.00 394.70 L 151.90 397.20 L 161.30 399.80 L 170.60 403.00 L 179.70 406.60 L 196.90 414.60 L 213.00 423.40 L 230.60 434.60 L 247.40 446.60 L 263.60 459.90 L 264.70 457.60 L 264.70 456.50 L 264.20 455.60 Z" fill="#141619" fill-rule="nonzero" node-id="72" stroke="none" target-height="68.899994" target-width="145.30002" target-x="119.4" target-y="391"/><path d="M 133.80 422.90 L 80.50 415.40 L 77.60 415.30 L 74.80 415.60 L 72.20 416.40 L 69.70 417.60 L 67.50 419.20 L 65.60 421.10 L 64.00 423.40 L 62.80 425.90 L 62.00 428.70 L 65.60 429.50 L 66.90 425.60 L 69.30 422.50 L 72.40 420.20 L 74.20 419.50 L 78.20 418.90 L 132.90 426.40 L 133.80 422.90 Z" fill="#141619" fill-rule="nonzero" node-id="74" stroke="none" target-height="14.200012" target-width="71.8" target-x="62" target-y="415.3"/><path d="M 62.00 428.20 L 59.00 428.10 L 56.20 428.50 L 53.50 429.40 L 51.00 430.80 L 48.80 432.40 L 46.90 434.50 L 45.30 436.90 L 44.20 439.50 L 43.50 442.40 L 43.40 445.40 L 43.70 448.30 L 44.60 451.00 L 45.80 453.50 L 47.50 455.70 L 49.50 457.70 L 51.90 459.20 L 54.50 460.40 L 57.40 461.20 L 66.90 462.50 L 67.20 458.90 L 57.90 457.60 L 55.70 457.00 L 52.10 455.00 L 50.50 453.60 L 48.20 450.10 L 47.10 446.10 L 47.10 443.90 L 48.10 439.70 L 50.30 436.10 L 53.50 433.50 L 57.50 432.00 L 61.50 431.90 L 163.50 446.20 L 164.20 442.70 Z" fill="#141619" fill-rule="nonzero" node-id="76" stroke="none" target-height="34.399994" target-width="120.799995" target-x="43.4" target-y="428.1"/><path d="M 85.10 446.50 L 82.10 446.40 L 79.30 446.80 L 76.60 447.70 L 74.10 449.00 L 71.90 450.70 L 70.00 452.80 L 68.40 455.20 L 67.30 457.80 L 66.60 460.70 L 66.50 463.70 L 66.80 466.50 L 67.70 469.20 L 68.90 471.80 L 70.60 474.00 L 72.60 475.90 L 74.90 477.50 L 77.50 478.70 L 80.50 479.50 L 112.80 484.00 L 113.50 480.40 L 81.00 475.80 L 76.90 474.40 L 73.60 471.90 L 71.30 468.40 L 70.50 466.40 L 70.10 462.10 L 70.40 459.90 L 71.10 457.90 L 73.40 454.40 L 76.60 451.70 L 80.50 450.20 L 84.60 450.10 L 165.00 461.50 L 165.70 457.90 Z" fill="#141619" fill-rule="nonzero" node-id="78" stroke="none" target-height="37.600006" target-width="99.2" target-x="66.5" target-y="446.4"/><path d="M 188.30 496.40 L 186.00 497.60 L 183.60 498.40 L 181.00 498.70 L 127.90 498.70 L 125.60 498.30 L 121.70 496.60 L 120.00 495.30 L 117.40 492.00 L 116.00 487.90 L 115.80 485.70 L 116.50 481.30 L 118.60 477.60 L 121.70 474.80 L 123.60 473.70 L 127.90 472.70 L 170.80 472.70 L 170.80 469.10 L 127.90 469.10 L 124.90 469.30 L 122.10 470.00 L 119.40 471.10 L 117.00 472.80 L 114.90 474.80 L 113.10 477.30 L 111.90 480.00 L 111.10 482.80 L 110.90 485.70 L 111.10 488.60 L 111.90 491.40 L 113.10 494.10 L 114.90 496.60 L 117.00 498.60 L 119.40 500.20 L 122.10 501.40 L 124.90 502.10 L 181.00 502.30 L 183.40 502.10 L 188.00 500.70 L 191.90 498.10 L 193.60 496.40 Z" fill="#141619" fill-rule="nonzero" node-id="80" stroke="none" target-height="33.19998" target-width="82.700005" target-x="110.9" target-y="469.1"/><path d="M 384.90 605.70 L 296.90 661.20 L 191.30 527.20 L 279.30 471.70 L 384.90 605.70 Z" fill="#ffdccd" fill-rule="nonzero" node-id="82" stroke="none" target-height="189.5" target-width="193.59999" target-x="191.3" target-y="471.7"/><path d="M 296.90 663.10 L 295.50 662.40 L 189.50 527.70 L 189.50 526.90 L 190.30 525.70 L 279.00 469.90 L 280.20 470.10 L 280.80 470.60 L 386.70 605.30 L 386.70 606.00 L 385.90 607.30 L 297.90 662.80 L 296.90 663.10 Z M 194.00 527.70 L 297.30 658.80 L 382.20 605.30 L 278.90 474.10 Z" fill="#141619" fill-rule="nonzero" node-id="84" stroke="none" target-height="193.19998" target-width="197.20001" target-x="189.5" target-y="469.9"/><g node-id="176"><path d="M 176.20 504.30 L 265.00 448.30 L 266.40 447.60 L 269.40 447.50 L 272.10 448.90 L 273.10 450.10 L 282.50 465.40 L 282.60 468.50 L 281.20 471.10 L 280.00 472.10 L 191.30 528.20 L 189.80 528.80 L 186.80 528.90 L 184.10 527.50 L 174.40 512.40 L 173.70 511.00 L 173.60 508.00 L 174.10 506.50 L 176.20 504.30 Z" fill="#ffffff" fill-rule="nonzero" group-id="1" node-id="88" stroke="none" target-height="81.400024" target-width="109" target-x="173.6" target-y="447.5"/></g><path d="M 188.10 530.90 L 184.90 530.30 L 182.50 528.50 L 172.80 513.40 L 171.90 511.50 L 171.60 509.60 L 171.80 507.60 L 172.50 505.80 L 173.60 504.10 L 175.20 502.80 L 264.00 446.80 L 265.90 445.90 L 267.80 445.60 L 269.80 445.80 L 271.60 446.50 L 273.30 447.60 L 274.60 449.20 L 283.40 463.10 L 284.20 465.00 L 284.60 467.00 L 284.40 468.90 L 283.70 470.80 L 282.60 472.40 L 281.00 473.70 L 192.20 529.70 L 190.20 530.60 L 188.10 530.90 Z M 268.10 449.30 L 266.00 449.90 L 177.20 505.90 L 176.00 507.00 L 175.40 508.40 L 175.40 509.90 L 175.90 511.50 L 184.70 525.40 L 185.80 526.50 L 187.20 527.10 L 188.80 527.20 L 190.30 526.60 L 279.10 470.60 L 280.20 469.50 L 280.80 468.10 L 280.90 466.50 L 280.30 465.00 L 271.60 451.10 L 270.10 449.70 L 268.10 449.30 Z" fill="#141619" fill-rule="nonzero" node-id="91" stroke="none" target-height="85.30002" target-width="113" target-x="171.6" target-y="445.6"/><path d="M 878.90 393.30 L 884.00 392.80 L 886.70 393.00 L 889.20 393.60 L 891.60 394.60 L 893.80 395.90 L 895.70 397.50 L 897.40 399.50 L 898.70 401.70 L 899.70 404.10 L 900.30 406.70 L 900.50 409.40 L 900.20 412.00 L 899.50 414.50 L 898.50 416.80 L 895.40 420.80 L 893.40 422.40 L 891.10 423.70 L 886.60 425.00 L 941.50 417.30 L 944.40 417.10 L 947.20 417.60 L 949.90 418.60 L 952.40 420.10 L 954.60 422.10 L 956.30 424.40 L 957.50 427.00 L 958.20 430.30 L 962.60 429.90 L 965.10 430.20 L 967.50 431.00 L 969.80 432.10 L 971.80 433.60 L 973.50 435.50 L 974.90 437.60 L 976.00 440.00 L 976.60 442.60 L 976.70 445.30 L 976.40 447.90 L 975.60 450.30 L 974.50 452.60 L 973.00 454.50 L 971.10 456.30 L 969.00 457.70 L 966.60 458.70 L 964.00 459.40 L 953.50 460.80 L 953.60 463.80 L 953.10 466.70 L 952.10 469.40 L 950.60 471.90 L 948.60 474.00 L 946.30 475.70 L 943.70 477.00 L 940.90 477.60 L 908.10 482.30 L 908.50 485.70 L 908.20 488.40 L 907.60 490.90 L 906.50 493.10 L 905.00 495.20 L 903.20 497.00 L 901.20 498.50 L 898.90 499.60 L 896.40 500.20 L 893.70 500.50 L 840.60 500.50 L 813.10 484.30 L 762.90 453.30 L 774.90 443.50 L 788.70 433.40 L 806.70 421.90 L 816.90 416.10 L 828.30 410.40 L 836.00 406.80 L 852.60 400.40 L 861.10 397.60 L 869.90 395.30 L 878.90 393.30 Z" fill="#ffffff" fill-rule="nonzero" node-id="93" stroke="none" target-height="107.70001" target-width="213.79999" target-x="762.9" target-y="392.8"/><path d="M 757.40 455.60 L 770.60 444.80 L 785.50 433.90 L 804.60 421.60 L 815.30 415.40 L 827.10 409.30 L 843.40 402.10 L 852.00 398.80 L 860.70 395.90 L 869.60 393.50 L 878.60 391.60 L 884.00 391.00 L 887.00 391.20 L 889.80 391.90 L 892.40 392.90 L 894.80 394.40 L 896.90 396.20 L 898.80 398.40 L 900.20 400.80 L 901.30 403.40 L 902.00 406.30 L 902.20 409.30 L 902.00 412.10 L 901.30 414.90 L 900.10 417.50 L 898.60 419.80 L 896.80 421.90 L 894.60 423.70 L 892.10 425.20 L 889.30 426.30 L 858.30 432.30 L 857.30 428.90 L 888.10 422.90 L 890.30 422.00 L 894.10 419.50 L 895.60 417.80 L 897.80 413.90 L 898.70 409.40 L 898.50 407.00 L 898.00 404.60 L 895.90 400.50 L 894.50 398.80 L 890.80 396.20 L 886.50 394.80 L 881.70 394.70 L 869.80 397.20 L 860.40 399.80 L 851.10 403.00 L 842.00 406.60 L 824.80 414.50 L 808.70 423.40 L 791.00 434.50 L 774.30 446.60 L 758.10 459.90 L 756.90 457.50 L 756.90 456.50 L 757.40 455.60 Z" fill="#141619" fill-rule="nonzero" node-id="95" stroke="none" target-height="68.899994" target-width="145.29999" target-x="756.9" target-y="391"/><path d="M 887.80 422.90 L 941.10 415.40 L 944.00 415.20 L 946.80 415.60 L 949.40 416.40 L 951.90 417.60 L 954.10 419.10 L 956.10 421.10 L 957.60 423.40 L 958.80 425.90 L 959.60 428.70 L 956.10 429.50 L 954.80 425.60 L 952.40 422.50 L 949.20 420.20 L 947.40 419.50 L 943.40 418.90 L 888.70 426.40 L 887.80 422.90 Z" fill="#141619" fill-rule="nonzero" node-id="97" stroke="none" target-height="14.299988" target-width="71.79999" target-x="887.8" target-y="415.2"/><path d="M 959.60 428.20 L 962.60 428.00 L 965.50 428.30 L 968.30 429.20 L 970.90 430.40 L 973.20 432.20 L 975.30 434.30 L 976.90 436.80 L 978.10 439.50 L 978.70 442.30 L 978.90 445.20 L 978.50 448.10 L 977.60 451.00 L 976.20 453.60 L 974.50 455.90 L 972.30 457.90 L 969.90 459.40 L 967.20 460.50 L 964.20 461.20 L 954.70 462.50 L 954.40 458.90 L 963.70 457.60 L 967.90 456.20 L 971.20 453.70 L 973.60 450.20 L 974.30 448.20 L 974.70 443.90 L 974.40 441.60 L 972.70 437.70 L 970.00 434.60 L 968.20 433.40 L 964.20 432.00 L 960.20 431.90 L 858.20 446.20 L 857.40 442.60 Z" fill="#141619" fill-rule="nonzero" node-id="99" stroke="none" target-height="34.5" target-width="121.5" target-x="857.4" target-y="428"/><path d="M 936.50 446.50 L 939.50 446.30 L 942.40 446.60 L 945.20 447.40 L 947.80 448.70 L 950.10 450.40 L 952.20 452.60 L 953.80 455.10 L 954.90 457.80 L 955.60 460.60 L 955.70 463.50 L 955.40 466.40 L 954.50 469.30 L 953.10 471.90 L 951.30 474.20 L 949.20 476.20 L 946.70 477.70 L 944.10 478.80 L 908.80 484.00 L 908.10 480.40 L 940.60 475.80 L 942.80 475.30 L 946.50 473.30 L 948.10 471.90 L 950.40 468.40 L 951.50 464.30 L 951.60 462.10 L 951.20 459.90 L 949.60 456.00 L 948.30 454.30 L 945.00 451.70 L 941.10 450.20 L 937.00 450.10 L 856.60 461.40 L 855.90 457.80 Z" fill="#141619" fill-rule="nonzero" node-id="101" stroke="none" target-height="37.700012" target-width="99.79999" target-x="855.9" target-y="446.3"/><path d="M 833.30 496.40 L 835.60 497.60 L 838.00 498.40 L 840.60 498.70 L 893.70 498.70 L 895.90 498.30 L 899.90 496.60 L 903.00 493.80 L 904.20 492.00 L 905.60 487.90 L 905.80 485.70 L 905.10 481.30 L 903.00 477.60 L 899.90 474.80 L 898.00 473.70 L 893.70 472.70 L 850.80 472.70 L 850.80 469.10 L 893.70 469.10 L 896.70 469.40 L 899.40 470.20 L 901.90 471.50 L 904.20 473.10 L 906.10 475.10 L 907.70 477.40 L 908.90 480.00 L 909.60 482.70 L 909.90 485.70 L 909.60 488.70 L 908.90 491.40 L 907.70 494.00 L 906.10 496.30 L 904.20 498.20 L 901.90 499.90 L 899.40 501.20 L 896.70 502.00 L 893.70 502.30 L 838.20 502.10 L 835.90 501.60 L 831.60 499.60 L 828.00 496.40 Z" fill="#141619" fill-rule="nonzero" node-id="103" stroke="none" target-height="33.19998" target-width="81.900024" target-x="828" target-y="469.1"/><path d="M 636.70 605.70 L 724.70 661.20 L 830.30 527.20 L 742.30 471.70 L 636.70 605.70 Z" fill="#ffdccd" fill-rule="nonzero" node-id="105" stroke="none" target-height="189.5" target-width="193.59998" target-x="636.7" target-y="471.7"/><path d="M 724.70 663.10 L 723.70 662.80 L 635.70 607.30 L 634.90 606.00 L 634.90 605.30 L 740.80 470.60 L 741.90 469.90 L 743.20 470.20 L 831.20 525.70 L 831.80 526.20 L 832.00 527.70 L 726.10 662.40 L 724.70 663.10 Z M 639.40 605.30 L 724.30 658.80 L 827.60 527.70 L 742.70 474.10 Z" fill="#141619" fill-rule="nonzero" node-id="107" stroke="none" target-height="193.19998" target-width="197.09998" target-x="634.9" target-y="469.9"/><g node-id="177"><path d="M 830.40 528.20 L 741.70 472.10 L 740.50 471.10 L 739.10 468.50 L 739.20 465.40 L 748.60 450.10 L 750.80 448.10 L 752.30 447.50 L 753.80 447.40 L 756.70 448.30 L 845.50 504.30 L 846.70 505.30 L 848.10 508.00 L 848.00 511.00 L 838.50 526.30 L 837.50 527.50 L 834.90 528.90 L 833.30 529.10 L 830.40 528.20 Z" fill="#ffffff" fill-rule="nonzero" group-id="2" node-id="111" stroke="none" target-height="81.69998" target-width="109" target-x="739.1" target-y="447.4"/></g><path d="M 833.50 530.90 L 831.30 530.60 L 829.40 529.70 L 740.60 473.70 L 739.00 472.40 L 737.90 470.80 L 737.20 468.90 L 737.00 466.90 L 737.30 465.00 L 738.20 463.10 L 747.00 449.20 L 748.30 447.60 L 750.00 446.50 L 751.80 445.80 L 753.80 445.60 L 755.70 445.90 L 757.60 446.80 L 846.40 502.80 L 848.00 504.10 L 849.10 505.80 L 849.80 507.60 L 850.00 509.60 L 849.70 511.50 L 848.80 513.40 L 839.10 528.50 L 836.60 530.30 L 833.50 530.90 Z M 742.60 470.60 L 831.30 526.60 L 832.80 527.20 L 834.40 527.10 L 835.80 526.50 L 836.90 525.40 L 845.70 511.50 L 846.30 509.90 L 846.20 508.40 L 845.60 507.00 L 844.40 505.90 L 755.70 449.90 L 754.20 449.30 L 752.60 449.30 L 751.20 450.00 L 750.10 451.10 L 741.30 465.00 L 740.70 466.50 L 740.80 468.10 L 741.40 469.50 L 742.60 470.60 Z" fill="#141619" fill-rule="nonzero" node-id="114" stroke="none" target-height="85.30002" target-width="113" target-x="737" target-y="445.6"/><path d="M 573.00 433.10 L 535.40 433.10 L 531.40 430.90 L 529.70 429.50 L 527.00 426.10 L 525.20 422.00 L 524.60 417.50 L 497.40 417.50 L 496.80 422.00 L 496.00 424.10 L 493.80 427.90 L 490.60 430.90 L 486.60 433.10 L 441.00 433.30 L 432.20 434.00 L 423.50 435.10 L 414.80 436.60 L 406.20 438.60 L 421.20 449.30 L 434.30 459.10 L 445.60 468.10 L 456.60 477.50 L 465.90 486.00 L 473.70 493.70 L 481.20 501.60 L 492.40 515.00 L 497.10 521.50 L 503.60 531.90 L 507.20 539.00 L 509.30 544.20 L 510.70 548.90 L 511.60 554.20 L 512.80 547.70 L 514.60 542.20 L 517.00 536.20 L 520.80 528.30 L 527.60 517.00 L 532.40 510.20 L 537.40 503.70 L 543.60 496.50 L 551.00 488.70 L 558.70 481.20 L 567.70 473.20 L 578.20 464.50 L 589.10 456.30 L 601.60 447.60 L 615.80 438.40 L 607.40 436.50 L 598.90 435.00 L 590.30 433.90 L 581.70 433.30 L 573.00 433.10 Z" fill="#ffffff" fill-rule="nonzero" node-id="116" stroke="none" target-height="136.70001" target-width="209.59998" target-x="406.2" target-y="417.5"/><path d="M 511.60 556.10 L 510.80 555.90 L 509.90 554.90 L 509.10 550.00 L 506.70 542.50 L 504.30 537.20 L 501.30 531.50 L 497.00 524.40 L 492.50 518.10 L 482.00 505.30 L 473.40 496.00 L 464.00 486.80 L 454.20 478.00 L 434.10 461.30 L 424.10 453.70 L 405.10 440.10 L 404.50 439.30 L 404.40 438.30 L 404.80 437.40 L 405.70 436.80 L 414.40 434.80 L 423.20 433.30 L 432.00 432.10 L 440.90 431.50 L 449.80 431.20 L 486.30 431.20 L 488.90 429.80 L 491.10 428.00 L 493.00 425.80 L 494.40 423.30 L 495.20 420.50 L 495.70 416.80 L 496.70 415.80 L 525.30 415.80 L 526.30 416.80 L 526.80 420.50 L 527.60 423.30 L 529.00 425.80 L 530.90 428.00 L 533.10 429.80 L 535.80 431.20 L 573.00 431.20 L 581.80 431.50 L 590.50 432.10 L 599.10 433.20 L 607.70 434.70 L 616.20 436.60 L 617.10 437.20 L 617.60 438.10 L 617.40 439.20 L 616.80 440.00 L 598.60 451.80 L 589.20 458.50 L 579.40 466.00 L 569.80 473.80 L 554.10 488.10 L 542.50 500.50 L 537.10 507.00 L 532.10 513.60 L 527.50 520.40 L 523.00 528.00 L 519.80 534.40 L 517.20 540.40 L 514.30 549.30 L 513.20 555.10 L 512.20 555.90 L 511.60 556.10 Z M 410.60 439.40 L 425.70 450.30 L 438.70 460.20 L 449.90 469.30 L 460.80 478.80 L 470.00 487.30 L 477.60 495.00 L 485.00 503.00 L 491.00 510.10 L 500.40 522.90 L 506.50 533.10 L 509.80 540.10 L 511.70 545.20 L 513.30 540.30 L 516.00 533.90 L 519.40 527.10 L 524.30 518.80 L 529.20 511.50 L 535.90 502.80 L 546.70 490.60 L 560.60 477.00 L 578.20 462.30 L 587.90 455.00 L 598.80 447.30 L 611.20 439.10 L 601.70 437.30 L 592.20 436.00 L 582.60 435.20 L 573.00 434.90 L 535.40 434.90 L 531.60 433.20 L 528.90 431.20 L 526.60 428.80 L 524.80 425.90 L 523.60 422.80 L 522.90 419.40 L 499.10 419.40 L 498.40 422.80 L 497.20 425.90 L 495.40 428.80 L 493.10 431.20 L 490.40 433.20 L 487.20 434.80 L 439.90 435.20 L 430.00 436.00 L 420.30 437.40 L 410.50 439.40 Z" fill="#141619" fill-rule="nonzero" node-id="118" stroke="none" target-height="140.29999" target-width="213.19998" target-x="404.4" target-y="415.8"/><path d="M 511.00 552.20 L 449.50 433.10 L 455.50 437.10 L 460.60 439.90 L 466.40 442.70 L 479.20 447.40 L 491.80 450.50 L 498.40 451.50 L 505.70 452.20 L 513.70 452.40 L 521.00 452.20 L 527.80 451.60 L 533.90 450.60 L 545.50 447.60 L 557.10 442.80 L 562.40 440.00 L 567.00 437.20 L 572.50 433.10 Z" fill="#ffdccc" fill-rule="nonzero" node-id="120" stroke="none" target-height="119.100006" target-width="123" target-x="449.5" target-y="433.1"/><path d="M 511.00 554.00 L 510.00 553.70 L 509.40 553.00 L 447.80 433.90 L 447.60 433.30 L 447.90 432.10 L 448.80 431.40 L 450.00 431.30 L 456.80 435.70 L 467.60 441.10 L 480.10 445.80 L 492.40 448.70 L 498.90 449.70 L 506.00 450.30 L 513.70 450.60 L 520.80 450.40 L 527.30 449.80 L 533.30 448.80 L 544.60 445.90 L 556.00 441.30 L 561.20 438.60 L 565.80 435.80 L 571.90 431.40 L 573.10 431.30 L 574.10 432.10 L 574.40 433.30 L 574.20 433.90 L 512.60 553.10 L 511.90 553.80 L 511.00 554.00 Z M 454.40 438.60 L 511.00 548.20 L 567.30 439.20 L 561.30 442.70 L 555.20 445.80 L 548.80 448.40 L 542.30 450.50 L 535.60 452.20 L 528.90 453.30 L 522.00 454.00 L 512.80 454.20 L 499.20 453.50 L 493.10 452.60 L 481.50 450.10 L 469.40 446.00 L 463.50 443.50 L 454.40 438.60 Z" fill="#141619" fill-rule="nonzero" node-id="122" stroke="none" target-height="122.70001" target-width="126.80002" target-x="447.6" target-y="431.3"/><path d="M 400.30 472.10 L 418.20 472.10 L 425.90 472.40 L 433.40 473.30 L 440.60 474.80 L 447.60 476.80 L 454.40 479.40 L 461.00 482.50 L 467.20 486.00 L 473.10 490.00 L 478.70 494.50 L 484.00 499.30 L 488.80 504.50 L 493.30 510.20 L 497.30 516.10 L 500.80 522.30 L 503.90 528.80 L 506.50 535.70 L 508.50 542.70 L 510.00 549.90 L 510.90 557.40 L 511.20 565.10 L 511.20 693.90 L 511.00 695.40 L 510.40 696.70 L 508.40 698.80 L 505.60 699.60 L 313.00 699.60 L 310.20 698.80 L 308.10 696.70 L 307.40 693.90 L 307.40 565.00 L 307.70 557.30 L 308.60 549.80 L 310.10 542.60 L 312.10 535.60 L 314.70 528.80 L 317.70 522.20 L 321.30 516.00 L 325.30 510.10 L 329.80 504.50 L 334.60 499.20 L 339.80 494.40 L 345.40 489.90 L 351.40 485.90 L 357.60 482.40 L 364.10 479.30 L 371.00 476.70 L 378.00 474.70 L 385.20 473.20 L 392.60 472.30 L 400.40 472.00 Z" fill="#ffffff" fill-rule="nonzero" node-id="124" stroke="none" target-height="227.59998" target-width="203.80002" target-x="307.4" target-y="472"/><path d="M 505.50 701.40 L 313.00 701.40 L 311.00 701.10 L 309.20 700.40 L 307.70 699.20 L 306.50 697.70 L 305.80 695.90 L 305.50 693.90 L 305.50 565.00 L 305.90 557.10 L 306.80 549.50 L 308.30 542.20 L 310.40 535.10 L 313.00 528.10 L 316.10 521.40 L 319.70 515.10 L 323.80 509.00 L 328.40 503.30 L 333.30 498.00 L 338.60 493.10 L 344.40 488.50 L 350.40 484.40 L 356.70 480.80 L 363.40 477.70 L 370.40 475.10 L 377.50 473.00 L 384.80 471.50 L 392.40 470.60 L 400.30 470.20 L 418.20 470.20 L 426.10 470.60 L 433.70 471.50 L 441.00 473.00 L 448.10 475.10 L 455.10 477.70 L 461.80 480.80 L 468.10 484.40 L 474.20 488.50 L 479.90 493.10 L 485.20 498.00 L 490.10 503.30 L 494.70 509.00 L 498.80 515.10 L 502.40 521.40 L 505.50 528.10 L 508.10 535.10 L 510.20 542.20 L 511.70 549.50 L 512.70 557.10 L 513.00 565.00 L 513.00 693.90 L 512.40 696.80 L 510.80 699.20 L 508.40 700.80 L 505.50 701.40 Z M 400.30 473.90 L 392.80 474.20 L 385.50 475.10 L 378.40 476.60 L 371.50 478.60 L 364.80 481.10 L 358.50 484.10 L 352.40 487.60 L 346.50 491.50 L 341.00 495.90 L 335.90 500.60 L 331.20 505.70 L 326.80 511.20 L 322.90 517.00 L 319.40 523.10 L 316.40 529.50 L 313.90 536.20 L 311.90 543.10 L 310.40 550.10 L 309.50 557.40 L 309.20 565.00 L 309.20 693.90 L 309.50 695.40 L 310.30 696.60 L 311.50 697.40 L 313.00 697.70 L 505.50 697.70 L 507.00 697.40 L 508.20 696.60 L 509.00 695.40 L 509.30 693.90 L 509.30 565.00 L 509.00 557.40 L 508.10 550.10 L 506.70 543.10 L 504.70 536.20 L 502.10 529.50 L 499.10 523.10 L 495.60 517.00 L 491.70 511.20 L 487.30 505.70 L 482.60 500.60 L 477.50 495.90 L 472.00 491.50 L 466.20 487.60 L 460.10 484.10 L 453.70 481.10 L 447.00 478.50 L 440.10 476.50 L 433.10 475.10 L 425.80 474.20 L 418.20 473.90 Z" fill="#141619" fill-rule="nonzero" node-id="126" stroke="none" target-height="231.20001" target-width="207.5" target-x="305.5" target-y="470.2"/><path d="M 603.80 472.10 L 621.70 472.10 L 629.40 472.40 L 636.80 473.30 L 644.10 474.80 L 651.10 476.80 L 657.90 479.40 L 664.40 482.50 L 670.70 486.00 L 676.60 490.00 L 682.20 494.50 L 687.40 499.30 L 692.30 504.50 L 696.70 510.20 L 700.70 516.10 L 704.30 522.30 L 707.30 528.80 L 709.90 535.70 L 712.00 542.70 L 713.40 549.90 L 714.30 557.40 L 714.70 565.10 L 714.70 693.90 L 713.90 696.70 L 711.90 698.80 L 709.00 699.60 L 516.50 699.60 L 513.70 698.80 L 511.60 696.70 L 510.90 693.90 L 510.90 565.00 L 511.20 557.30 L 512.10 549.80 L 513.60 542.60 L 515.60 535.60 L 518.20 528.80 L 521.20 522.20 L 524.80 516.00 L 528.80 510.10 L 533.30 504.50 L 538.10 499.20 L 543.30 494.40 L 548.90 489.90 L 554.90 485.90 L 561.10 482.40 L 567.60 479.30 L 574.50 476.70 L 581.50 474.70 L 588.70 473.20 L 596.10 472.30 L 603.90 472.00 Z" fill="#ffffff" fill-rule="nonzero" node-id="128" stroke="none" target-height="227.59998" target-width="203.80002" target-x="510.9" target-y="472"/><path d="M 709.00 701.40 L 516.50 701.40 L 515.00 701.20 L 512.30 700.10 L 511.20 699.20 L 509.60 696.80 L 509.00 693.90 L 509.00 565.00 L 509.30 557.10 L 510.30 549.50 L 511.80 542.20 L 513.90 535.10 L 516.50 528.10 L 519.60 521.40 L 523.20 515.10 L 527.30 509.00 L 531.90 503.30 L 536.80 498.00 L 542.10 493.10 L 547.80 488.50 L 553.90 484.40 L 560.20 480.80 L 566.90 477.70 L 573.80 475.10 L 581.00 473.00 L 588.30 471.50 L 595.90 470.60 L 603.80 470.20 L 621.70 470.20 L 629.50 470.50 L 637.10 471.50 L 644.50 473.00 L 651.60 475.10 L 658.60 477.70 L 665.20 480.80 L 671.60 484.40 L 677.60 488.50 L 683.30 493.10 L 688.70 498.00 L 693.60 503.30 L 698.10 509.00 L 702.20 515.10 L 705.80 521.40 L 709.00 528.10 L 711.60 535.00 L 713.70 542.20 L 715.20 549.50 L 716.10 557.10 L 716.50 565.00 L 716.50 693.90 L 716.20 695.90 L 715.40 697.70 L 714.30 699.20 L 712.80 700.30 L 711.00 701.10 L 709.00 701.40 Z M 603.80 473.90 L 596.20 474.20 L 588.90 475.10 L 581.90 476.60 L 575.00 478.60 L 568.30 481.10 L 561.90 484.10 L 555.80 487.60 L 550.00 491.50 L 544.50 495.90 L 539.40 500.60 L 534.70 505.70 L 530.30 511.20 L 526.40 517.00 L 522.90 523.10 L 519.90 529.50 L 517.40 536.20 L 515.40 543.10 L 513.90 550.10 L 513.00 557.40 L 512.70 565.00 L 512.70 693.90 L 513.00 695.40 L 513.80 696.60 L 515.00 697.40 L 516.50 697.70 L 709.00 697.70 L 710.50 697.40 L 711.70 696.60 L 712.50 695.40 L 712.80 693.90 L 712.80 565.00 L 712.50 557.40 L 711.60 550.10 L 710.20 543.10 L 708.20 536.20 L 705.60 529.50 L 702.60 523.10 L 699.10 517.00 L 695.20 511.20 L 690.80 505.70 L 686.10 500.60 L 681.00 495.90 L 675.50 491.50 L 669.70 487.50 L 663.60 484.10 L 657.20 481.10 L 650.50 478.50 L 643.60 476.50 L 636.60 475.10 L 629.30 474.20 L 621.70 473.90 Z" fill="#141619" fill-rule="nonzero" node-id="130" stroke="none" target-height="231.20001" target-width="207.5" target-x="509" target-y="470.2"/><path d="M 456.90 348.00 L 456.60 351.60 L 455.70 354.90 L 454.20 358.00 L 452.20 360.70 L 449.90 363.10 L 447.10 365.10 L 444.00 366.50 L 440.70 367.40 L 437.10 367.80 L 433.50 367.40 L 430.20 366.50 L 427.10 365.10 L 424.30 363.10 L 421.90 360.70 L 420.00 358.00 L 418.50 354.90 L 417.60 351.60 L 417.30 348.00 L 417.60 344.40 L 418.50 341.00 L 420.00 338.00 L 421.90 335.20 L 424.30 332.80 L 427.10 330.90 L 430.20 329.40 L 433.50 328.50 L 437.10 328.20 L 440.70 328.50 L 444.00 329.40 L 447.10 330.90 L 449.90 332.80 L 452.20 335.20 L 454.20 338.00 L 455.70 341.00 L 456.60 344.40 L 456.90 348.00 Z" fill="#ffffff" fill-rule="nonzero" node-id="132" stroke="none" target-height="39.599976" target-width="39.600006" target-x="417.3" target-y="328.2"/><path d="M 437.10 369.60 L 434.20 369.40 L 428.70 367.90 L 423.90 365.20 L 421.80 363.30 L 418.40 358.90 L 417.10 356.20 L 415.60 350.70 L 415.40 347.90 L 416.20 342.40 L 418.30 337.20 L 419.90 334.90 L 421.80 332.70 L 426.30 329.20 L 428.90 328.00 L 434.20 326.50 L 439.90 326.50 L 442.60 327.10 L 445.40 328.00 L 450.30 330.90 L 454.30 334.80 L 457.10 339.70 L 458.50 345.10 L 458.70 348.00 L 458.50 351.00 L 457.00 356.40 L 455.70 358.90 L 453.60 361.90 L 451.00 364.50 L 448.00 366.70 L 445.50 367.90 L 440.10 369.40 L 437.10 369.60 Z M 437.10 330.00 L 433.80 330.30 L 430.80 331.10 L 428.00 332.40 L 425.50 334.20 L 423.30 336.40 L 421.50 338.90 L 420.20 341.70 L 419.40 344.70 L 419.10 348.00 L 419.40 351.30 L 420.20 354.30 L 421.50 357.10 L 423.30 359.60 L 425.50 361.70 L 428.00 363.50 L 430.80 364.90 L 433.80 365.70 L 437.10 366.00 L 440.40 365.70 L 443.40 364.90 L 446.20 363.50 L 448.70 361.70 L 450.80 359.60 L 452.60 357.10 L 454.00 354.30 L 454.80 351.30 L 455.10 348.00 L 454.80 344.70 L 454.00 341.70 L 452.60 338.90 L 450.80 336.40 L 448.70 334.20 L 446.20 332.50 L 443.40 331.10 L 440.40 330.30 L 437.10 330.00 Z" fill="#141619" fill-rule="nonzero" node-id="134" stroke="none" target-height="43.100006" target-width="43.30002" target-x="415.4" target-y="326.5"/><path d="M 604.70 348.00 L 604.40 351.60 L 603.50 354.90 L 602.00 358.00 L 600.10 360.70 L 597.70 363.10 L 594.90 365.10 L 591.80 366.50 L 588.50 367.40 L 584.90 367.80 L 581.30 367.40 L 578.00 366.50 L 574.90 365.10 L 572.10 363.10 L 569.80 360.70 L 567.80 358.00 L 566.30 354.90 L 565.40 351.60 L 565.10 348.00 L 565.40 344.40 L 566.30 341.00 L 567.80 338.00 L 569.80 335.20 L 572.10 332.80 L 574.90 330.90 L 578.00 329.40 L 581.30 328.50 L 584.90 328.20 L 588.50 328.50 L 591.80 329.40 L 594.90 330.90 L 597.70 332.80 L 600.10 335.20 L 602.00 338.00 L 603.50 341.00 L 604.40 344.40 L 604.70 348.00 Z" fill="#ffffff" fill-rule="nonzero" node-id="136" stroke="none" target-height="39.599976" target-width="39.600037" target-x="565.1" target-y="328.2"/><path d="M 584.90 369.60 L 582.00 369.40 L 576.60 367.90 L 574.10 366.70 L 569.70 363.30 L 566.20 358.90 L 564.90 356.20 L 563.50 350.70 L 563.30 347.90 L 564.00 342.40 L 566.10 337.20 L 567.70 334.90 L 569.60 332.70 L 574.20 329.20 L 576.70 328.00 L 582.10 326.50 L 587.70 326.50 L 590.50 327.10 L 593.20 328.00 L 598.20 330.90 L 602.10 334.80 L 604.90 339.70 L 606.40 345.10 L 606.60 348.00 L 606.30 351.00 L 604.80 356.40 L 603.60 358.90 L 601.40 361.90 L 598.90 364.50 L 595.80 366.70 L 593.30 367.90 L 587.90 369.40 L 584.90 369.60 Z M 584.90 330.00 L 581.60 330.30 L 578.60 331.10 L 575.80 332.40 L 573.30 334.20 L 571.20 336.40 L 569.40 338.90 L 568.00 341.70 L 567.20 344.70 L 566.90 348.00 L 567.20 351.30 L 568.00 354.30 L 569.40 357.10 L 571.20 359.60 L 573.30 361.70 L 575.80 363.50 L 578.60 364.90 L 581.60 365.70 L 584.90 366.00 L 588.20 365.70 L 591.20 364.90 L 594.00 363.50 L 596.50 361.70 L 598.70 359.60 L 600.50 357.10 L 601.80 354.30 L 602.60 351.30 L 602.90 348.00 L 602.60 344.70 L 601.80 341.70 L 600.50 338.90 L 598.70 336.40 L 596.50 334.20 L 594.00 332.50 L 591.20 331.10 L 588.20 330.30 L 584.90 330.00 Z" fill="#141619" fill-rule="nonzero" node-id="138" stroke="none" target-height="43.100006" target-width="43.299988" target-x="563.3" target-y="326.5"/><path d="M 461.80 270.20 L 560.20 270.20 L 564.20 270.50 L 568.00 271.30 L 571.60 272.50 L 575.00 274.20 L 578.10 276.30 L 580.90 278.80 L 583.40 281.60 L 585.40 284.70 L 587.20 288.10 L 588.40 291.70 L 589.20 295.50 L 589.50 299.50 L 589.50 341.10 L 589.10 348.00 L 588.20 354.80 L 586.80 361.50 L 584.70 368.00 L 582.10 374.20 L 579.00 380.30 L 575.30 386.00 L 571.20 391.50 L 566.50 396.60 L 561.40 401.30 L 555.90 405.40 L 550.20 409.10 L 544.10 412.20 L 537.90 414.80 L 531.40 416.90 L 524.70 418.40 L 517.90 419.30 L 511.00 419.60 L 504.50 419.30 L 498.20 418.50 L 492.10 417.30 L 486.20 415.60 L 480.40 413.40 L 474.90 410.80 L 469.70 407.80 L 464.70 404.40 L 459.90 400.70 L 455.50 396.60 L 451.50 392.20 L 447.70 387.40 L 444.30 382.40 L 441.30 377.20 L 438.70 371.70 L 436.60 365.90 L 434.80 360.00 L 433.60 353.90 L 432.80 347.60 L 432.60 341.10 L 432.60 299.50 L 432.80 295.50 L 433.60 291.70 L 434.90 288.10 L 436.60 284.70 L 438.70 281.60 L 441.10 278.80 L 443.90 276.30 L 447.00 274.20 L 450.40 272.50 L 454.00 271.30 L 457.80 270.50 L 461.80 270.20 Z" fill="#ffffff" fill-rule="nonzero" node-id="140" stroke="none" target-height="149.4" target-width="156.9" target-x="432.6" target-y="270.2"/><path d="M 511.00 421.40 L 504.30 421.10 L 497.90 420.30 L 491.70 419.00 L 485.60 417.30 L 479.70 415.00 L 474.10 412.40 L 468.70 409.30 L 463.60 405.90 L 458.80 402.00 L 454.30 397.90 L 450.10 393.40 L 446.20 388.50 L 442.80 383.40 L 439.70 378.00 L 437.10 372.40 L 434.80 366.50 L 433.10 360.40 L 431.80 354.20 L 431.00 347.80 L 430.70 341.10 L 430.70 299.50 L 431.00 295.20 L 431.80 291.20 L 433.20 287.40 L 435.00 283.80 L 437.20 280.50 L 439.80 277.50 L 442.80 274.90 L 446.10 272.60 L 449.70 270.80 L 453.50 269.50 L 457.60 268.70 L 461.80 268.40 L 560.20 268.40 L 564.40 268.70 L 568.50 269.50 L 572.30 270.80 L 575.90 272.60 L 579.20 274.90 L 582.20 277.50 L 584.80 280.50 L 587.00 283.80 L 588.80 287.40 L 590.10 291.20 L 591.00 295.20 L 591.30 299.50 L 591.30 341.10 L 591.00 347.80 L 590.20 354.20 L 588.90 360.40 L 587.20 366.50 L 584.90 372.40 L 582.30 378.00 L 579.20 383.40 L 575.80 388.50 L 571.90 393.40 L 567.70 397.90 L 563.20 402.00 L 558.40 405.90 L 553.30 409.30 L 547.90 412.40 L 542.30 415.00 L 536.40 417.30 L 530.30 419.00 L 524.10 420.30 L 517.70 421.10 L 511.00 421.40 Z M 461.80 272.00 L 458.10 272.30 L 454.50 273.00 L 451.10 274.20 L 448.00 275.80 L 445.10 277.70 L 442.40 280.00 L 440.10 282.70 L 438.20 285.60 L 436.60 288.80 L 435.40 292.10 L 434.70 295.70 L 434.40 299.40 L 434.40 341.10 L 434.70 347.40 L 435.40 353.60 L 436.60 359.50 L 438.30 365.30 L 440.40 370.90 L 443.00 376.30 L 445.90 381.40 L 449.20 386.30 L 452.80 391.00 L 456.80 395.30 L 461.10 399.20 L 465.80 402.90 L 470.60 406.20 L 475.80 409.10 L 481.10 411.60 L 486.80 413.80 L 492.60 415.50 L 498.50 416.70 L 504.60 417.40 L 511.00 417.70 L 517.40 417.40 L 523.50 416.70 L 529.40 415.50 L 535.20 413.80 L 540.90 411.60 L 546.20 409.10 L 551.40 406.20 L 556.20 402.90 L 560.90 399.20 L 565.20 395.30 L 569.20 391.00 L 572.80 386.30 L 576.10 381.40 L 579.00 376.30 L 581.60 370.90 L 583.70 365.30 L 585.40 359.50 L 586.60 353.60 L 587.30 347.40 L 587.60 341.10 L 587.60 299.50 L 587.40 295.80 L 586.70 292.30 L 585.50 289.00 L 584.00 285.80 L 582.00 282.80 L 579.60 280.10 L 576.80 277.70 L 573.90 275.70 L 570.70 274.10 L 567.30 272.90 L 563.80 272.20 L 560.20 272.00 Z" fill="#141619" fill-rule="nonzero" node-id="142" stroke="none" target-height="153" target-width="160.59998" target-x="430.7" target-y="268.4"/><path d="M 517.10 381.80 L 516.90 383.40 L 516.30 384.80 L 515.30 386.10 L 514.10 387.00 L 512.70 387.60 L 511.00 387.90 L 509.40 387.60 L 508.00 387.10 L 506.70 386.10 L 505.70 384.80 L 505.10 383.40 L 504.90 381.80 L 505.10 380.20 L 505.70 378.70 L 506.70 377.40 L 508.00 376.50 L 509.40 375.90 L 511.00 375.70 L 512.70 375.90 L 514.10 376.50 L 515.30 377.40 L 516.30 378.70 L 516.90 380.10 L 517.10 381.80 Z" fill="#141619" fill-rule="nonzero" node-id="144" stroke="none" target-height="12.199982" target-width="12.199982" target-x="504.9" target-y="375.7"/><path d="M 490.50 375.10 L 490.20 376.30 L 489.10 377.50 L 485.30 379.50 L 479.70 380.80 L 473.00 381.30 L 466.20 380.80 L 460.60 379.50 L 456.80 377.50 L 455.70 376.30 L 455.40 375.10 L 455.70 374.00 L 456.80 372.80 L 460.60 370.80 L 466.20 369.50 L 473.00 369.00 L 479.70 369.50 L 485.30 370.80 L 489.10 372.80 L 490.20 374.00 L 490.50 375.10 Z" fill="#f4c5b7" fill-rule="nonzero" node-id="146" stroke="none" target-height="12.299988" target-width="35.100006" target-x="455.4" target-y="369"/><path d="M 566.60 375.10 L 566.30 376.30 L 565.20 377.50 L 561.40 379.50 L 555.80 380.80 L 549.10 381.30 L 542.30 380.80 L 536.70 379.50 L 534.40 378.50 L 532.90 377.50 L 531.80 376.30 L 531.50 375.10 L 531.80 374.00 L 532.90 372.80 L 536.70 370.80 L 542.30 369.50 L 549.10 369.00 L 555.80 369.50 L 561.40 370.80 L 565.20 372.80 L 566.30 374.00 L 566.60 375.10 Z" fill="#f4c5b7" fill-rule="nonzero" node-id="148" stroke="none" target-height="12.299988" target-width="35.099976" target-x="531.5" target-y="369"/><path d="M 508.60 336.80 L 508.20 341.60 L 507.30 346.10 L 505.80 350.40 L 503.80 354.50 L 501.30 358.10 L 498.30 361.50 L 495.00 364.50 L 491.30 366.90 L 487.20 369.00 L 483.00 370.50 L 478.40 371.40 L 473.70 371.70 L 468.90 371.40 L 464.30 370.50 L 460.10 369.00 L 456.00 366.90 L 452.30 364.50 L 449.00 361.50 L 446.00 358.10 L 443.50 354.50 L 441.50 350.40 L 440.00 346.10 L 439.10 341.60 L 438.70 336.80 L 439.10 332.00 L 440.00 327.50 L 441.50 323.20 L 443.50 319.10 L 446.00 315.50 L 449.00 312.10 L 452.30 309.10 L 456.00 306.70 L 460.10 304.60 L 464.30 303.10 L 468.90 302.20 L 473.70 301.90 L 478.40 302.20 L 483.00 303.10 L 487.20 304.60 L 491.30 306.70 L 495.00 309.10 L 498.30 312.10 L 501.30 315.50 L 503.80 319.10 L 505.80 323.20 L 507.30 327.50 L 508.20 332.00 L 508.60 336.80 Z" fill="#ffffff" fill-rule="nonzero" node-id="150" stroke="none" target-height="69.80002" target-width="69.899994" target-x="438.7" target-y="301.9"/><path d="M 473.70 373.60 L 466.20 372.80 L 459.30 370.70 L 455.10 368.50 L 451.20 365.90 L 447.70 362.80 L 444.50 359.30 L 441.90 355.40 L 439.80 351.10 L 437.60 344.30 L 436.90 336.80 L 437.60 329.30 L 439.80 322.50 L 441.90 318.20 L 444.50 314.30 L 447.70 310.80 L 451.20 307.70 L 455.10 305.10 L 459.30 302.90 L 466.20 300.80 L 469.80 300.20 L 473.70 300.00 L 477.50 300.20 L 484.60 301.70 L 488.00 302.90 L 492.20 305.10 L 496.10 307.70 L 499.60 310.80 L 502.80 314.30 L 505.40 318.20 L 507.50 322.50 L 509.70 329.30 L 510.40 336.80 L 509.60 344.30 L 507.50 351.10 L 505.40 355.40 L 502.70 359.20 L 499.60 362.80 L 496.10 365.90 L 492.20 368.50 L 488.00 370.70 L 481.10 372.80 L 473.70 373.60 Z M 473.70 303.70 L 469.20 304.00 L 465.00 304.80 L 460.90 306.20 L 457.10 308.10 L 453.50 310.50 L 450.30 313.30 L 447.40 316.50 L 445.00 320.10 L 443.10 324.10 L 441.60 328.30 L 440.80 332.60 L 440.50 336.90 L 440.80 341.20 L 441.60 345.30 L 443.00 349.40 L 444.90 353.30 L 447.30 356.80 L 450.20 360.20 L 453.60 363.10 L 457.20 365.50 L 461.00 367.40 L 465.10 368.80 L 469.30 369.60 L 473.60 369.90 L 477.80 369.60 L 482.10 368.80 L 486.30 367.40 L 490.30 365.40 L 493.90 363.00 L 497.10 360.20 L 499.90 356.90 L 502.30 353.40 L 504.20 349.50 L 505.60 345.50 L 506.40 341.20 L 506.80 336.80 L 506.40 332.30 L 505.60 328.00 L 504.10 323.90 L 502.20 320.10 L 499.80 316.60 L 497.00 313.40 L 493.90 310.60 L 490.40 308.20 L 486.50 306.30 L 482.50 304.90 L 478.20 304.00 L 473.70 303.70 Z" fill="#141619" fill-rule="nonzero" node-id="152" stroke="none" target-height="73.600006" target-width="73.5" target-x="436.9" target-y="300"/><path d="M 583.30 336.80 L 582.90 341.60 L 582.00 346.10 L 580.50 350.40 L 578.50 354.50 L 576.00 358.10 L 573.00 361.50 L 569.70 364.50 L 566.00 366.90 L 561.90 369.00 L 557.70 370.50 L 553.10 371.40 L 548.40 371.70 L 543.60 371.40 L 539.00 370.50 L 534.80 369.00 L 530.70 366.90 L 527.00 364.50 L 523.70 361.50 L 520.70 358.10 L 518.20 354.50 L 516.20 350.40 L 514.70 346.10 L 513.80 341.60 L 513.40 336.80 L 513.80 332.00 L 514.70 327.50 L 516.20 323.20 L 518.20 319.10 L 520.70 315.50 L 523.70 312.10 L 527.00 309.10 L 530.70 306.70 L 534.80 304.60 L 539.00 303.10 L 543.60 302.20 L 548.40 301.90 L 553.10 302.20 L 557.70 303.10 L 561.90 304.60 L 566.00 306.70 L 569.70 309.10 L 573.00 312.10 L 576.00 315.50 L 578.50 319.10 L 580.50 323.20 L 582.00 327.50 L 582.90 332.00 L 583.30 336.80 Z" fill="#ffffff" fill-rule="nonzero" node-id="154" stroke="none" target-height="69.80002" target-width="69.89996" target-x="513.4" target-y="301.9"/><path d="M 548.40 373.60 L 540.90 372.80 L 534.00 370.70 L 529.80 368.50 L 525.90 365.90 L 522.40 362.80 L 519.20 359.30 L 516.60 355.40 L 514.50 351.10 L 512.30 344.30 L 511.60 336.80 L 512.30 329.30 L 514.50 322.50 L 516.60 318.20 L 519.20 314.30 L 522.40 310.80 L 525.90 307.70 L 529.80 305.10 L 534.00 302.90 L 540.90 300.80 L 544.50 300.20 L 548.40 300.00 L 552.20 300.20 L 559.30 301.70 L 562.70 302.90 L 566.90 305.10 L 570.80 307.70 L 574.30 310.80 L 577.50 314.30 L 580.10 318.20 L 582.20 322.50 L 584.40 329.30 L 585.10 336.80 L 584.30 344.30 L 582.20 351.10 L 580.10 355.40 L 577.40 359.20 L 574.30 362.80 L 570.80 365.90 L 566.90 368.50 L 562.70 370.70 L 555.80 372.80 L 548.40 373.60 Z M 548.40 303.70 L 543.90 304.00 L 539.70 304.80 L 535.60 306.20 L 531.80 308.10 L 528.20 310.50 L 525.00 313.30 L 522.10 316.50 L 519.70 320.10 L 517.80 324.10 L 516.30 328.30 L 515.50 332.60 L 515.20 336.90 L 515.50 341.20 L 516.30 345.30 L 517.70 349.40 L 519.60 353.30 L 522.00 356.80 L 524.90 360.20 L 528.30 363.10 L 531.90 365.50 L 535.70 367.40 L 539.80 368.80 L 544.00 369.60 L 548.30 369.90 L 552.50 369.60 L 556.80 368.80 L 561.00 367.40 L 565.00 365.40 L 568.60 363.00 L 571.80 360.20 L 574.60 356.90 L 577.00 353.40 L 578.90 349.50 L 580.30 345.50 L 581.10 341.20 L 581.50 336.80 L 581.10 332.30 L 580.30 328.00 L 578.80 323.90 L 576.90 320.10 L 574.50 316.60 L 571.70 313.40 L 568.60 310.60 L 565.10 308.20 L 561.20 306.30 L 557.20 304.90 L 552.90 304.00 L 548.40 303.70 Z" fill="#141619" fill-rule="nonzero" node-id="156" stroke="none" target-height="73.600006" target-width="73.49997" target-x="511.6" target-y="300"/><path d="M 448.40 303.80 L 452.00 306.80 L 454.80 308.60 L 457.90 310.30 L 461.50 311.80 L 466.80 312.90 L 469.60 312.90 L 472.30 312.50 L 475.20 311.50 L 478.10 309.90 L 480.80 307.80 L 483.50 304.90 L 486.40 300.90 L 488.80 296.60 L 491.20 291.00 L 493.60 284.00 L 494.90 288.30 L 496.40 292.00 L 498.20 295.20 L 500.10 297.90 L 502.40 300.50 L 507.50 304.40 L 510.30 305.90 L 514.20 307.30 L 518.20 308.30 L 522.40 308.80 L 526.60 308.80 L 534.90 307.80 L 542.70 305.40 L 549.50 301.90 L 554.60 297.90 L 556.60 295.50 L 557.90 293.30 L 558.60 291.10 L 560.50 294.40 L 562.80 297.50 L 565.70 300.50 L 568.90 303.20 L 572.30 305.50 L 576.00 307.50 L 579.90 309.00 L 583.90 310.00 L 587.90 310.60 L 590.90 310.60 L 596.70 309.60 L 599.50 308.50 L 602.40 306.90 L 605.10 304.90 L 607.60 302.50 L 609.80 299.70 L 611.60 296.80 L 613.00 293.70 L 614.00 290.40 L 614.40 287.10 L 614.30 283.80 L 613.00 278.90 L 610.10 274.20 L 608.10 272.20 L 605.70 270.30 L 602.70 268.40 L 599.00 266.70 L 598.00 259.20 L 596.00 252.00 L 594.40 248.60 L 592.40 245.40 L 590.10 242.40 L 587.30 239.80 L 584.00 237.30 L 580.30 235.40 L 576.10 233.80 L 571.00 232.60 L 565.80 231.90 L 559.80 231.70 L 552.70 232.10 L 550.00 228.10 L 547.10 224.70 L 544.00 221.70 L 540.70 219.10 L 537.20 216.90 L 533.60 215.20 L 529.80 213.90 L 526.00 213.00 L 522.10 212.50 L 518.20 212.50 L 514.20 212.80 L 510.30 213.60 L 506.40 214.80 L 502.60 216.40 L 498.90 218.50 L 495.20 221.00 L 491.80 223.80 L 488.60 227.00 L 485.50 230.70 L 482.60 234.90 L 474.30 233.70 L 467.20 234.10 L 462.70 235.00 L 458.50 236.40 L 454.60 238.20 L 451.00 240.40 L 444.40 245.70 L 440.00 250.10 L 428.50 263.40 L 424.50 265.10 L 421.00 267.10 L 418.00 269.50 L 415.40 272.30 L 413.10 275.30 L 411.30 278.60 L 409.80 282.00 L 408.70 285.40 L 407.50 292.40 L 407.80 298.80 L 409.30 304.70 L 410.50 307.00 L 412.30 309.40 L 414.40 311.50 L 417.10 313.50 L 419.90 315.10 L 426.20 317.30 L 429.50 317.90 L 432.70 317.90 L 435.90 317.60 L 438.90 316.70 L 441.60 315.30 L 444.00 313.40 L 445.50 311.60 L 446.70 309.50 L 447.70 306.90 L 448.40 303.80 Z" fill="#3a3e52" fill-rule="nonzero" node-id="158" stroke="none" target-height="105.399994" target-width="206.90002" target-x="407.5" target-y="212.5"/><path d="M 431.70 319.80 L 425.80 319.10 L 422.80 318.30 L 417.30 315.80 L 412.50 312.30 L 409.00 308.00 L 407.80 305.70 L 406.20 300.30 L 405.70 295.90 L 405.80 291.20 L 406.60 286.40 L 408.00 281.70 L 409.30 278.30 L 413.10 272.20 L 418.10 267.10 L 421.00 265.00 L 427.50 261.80 L 437.80 249.70 L 441.70 245.70 L 446.00 241.90 L 452.40 237.50 L 459.50 234.10 L 463.40 233.00 L 467.70 232.20 L 472.00 231.90 L 476.70 232.10 L 481.80 232.90 L 485.10 228.40 L 488.70 224.40 L 492.50 220.90 L 496.60 217.80 L 500.90 215.30 L 505.40 213.30 L 510.10 211.80 L 514.90 210.90 L 519.70 210.60 L 524.50 210.90 L 528.80 211.70 L 533.00 213.00 L 537.00 214.70 L 540.90 217.00 L 544.50 219.60 L 547.80 222.70 L 550.90 226.20 L 553.80 230.20 L 560.70 229.90 L 566.90 230.20 L 572.30 230.90 L 577.20 232.20 L 581.50 233.90 L 585.40 236.00 L 588.80 238.60 L 591.50 241.30 L 594.00 244.30 L 596.00 247.70 L 597.80 251.40 L 599.10 255.60 L 600.20 260.30 L 600.80 265.40 L 604.40 267.30 L 607.50 269.30 L 610.00 271.50 L 612.20 273.90 L 613.90 276.50 L 615.20 279.40 L 616.00 282.40 L 616.30 285.60 L 616.20 288.90 L 615.50 292.10 L 614.40 295.40 L 612.90 298.50 L 611.00 301.30 L 608.80 304.00 L 606.20 306.50 L 603.40 308.50 L 600.30 310.20 L 596.60 311.50 L 592.90 312.30 L 589.00 312.40 L 585.10 312.10 L 581.20 311.20 L 577.40 309.90 L 570.20 306.20 L 563.90 301.20 L 561.20 298.30 L 559.00 295.30 L 557.20 297.80 L 554.70 300.30 L 551.60 302.70 L 544.30 306.70 L 540.10 308.30 L 535.70 309.50 L 531.10 310.30 L 526.50 310.70 L 521.70 310.60 L 517.30 310.00 L 513.30 309.00 L 509.60 307.50 L 506.10 305.70 L 503.00 303.40 L 500.20 300.70 L 497.70 297.60 L 495.50 294.00 L 493.60 290.00 L 491.30 295.60 L 489.00 300.30 L 486.50 304.10 L 484.00 307.30 L 481.40 309.80 L 478.70 311.70 L 475.90 313.20 L 473.00 314.20 L 468.10 314.80 L 462.30 314.00 L 456.20 311.50 L 449.60 307.20 L 448.50 310.20 L 446.80 312.90 L 444.70 315.20 L 442.20 317.10 L 439.40 318.50 L 436.30 319.30 L 431.70 319.80 Z M 472.50 235.60 L 468.00 235.80 L 463.80 236.60 L 460.00 237.80 L 456.40 239.50 L 449.70 243.60 L 445.20 247.40 L 441.10 251.50 L 429.90 264.60 L 423.20 268.00 L 418.20 272.00 L 416.00 274.40 L 412.60 279.90 L 410.20 287.20 L 409.50 291.40 L 409.30 295.60 L 409.70 299.40 L 411.10 304.10 L 413.70 308.30 L 415.70 310.30 L 418.10 312.10 L 423.60 314.70 L 429.70 316.10 L 432.60 316.10 L 435.50 315.80 L 437.70 315.20 L 441.50 313.20 L 444.10 310.30 L 446.00 306.30 L 446.60 303.50 L 447.00 302.60 L 447.90 302.10 L 448.90 302.00 L 449.70 302.50 L 454.40 306.30 L 456.70 307.70 L 462.30 310.20 L 465.50 310.90 L 469.80 311.10 L 472.10 310.70 L 474.80 309.70 L 477.40 308.20 L 479.90 306.20 L 482.40 303.40 L 484.90 299.90 L 487.30 295.60 L 489.60 290.10 L 492.10 282.90 L 493.60 282.20 L 495.10 283.00 L 496.50 287.50 L 499.40 293.80 L 501.00 296.20 L 503.70 299.20 L 506.40 301.60 L 509.30 303.40 L 512.30 304.80 L 518.30 306.50 L 522.70 307.00 L 526.40 307.10 L 531.20 306.60 L 536.20 305.50 L 541.20 304.00 L 545.80 302.00 L 551.10 298.60 L 555.00 294.80 L 556.20 292.80 L 557.00 290.20 L 558.40 289.30 L 560.00 289.80 L 562.50 294.00 L 565.00 297.30 L 567.90 300.20 L 571.10 302.70 L 574.60 304.80 L 578.10 306.40 L 581.90 307.60 L 585.50 308.40 L 589.10 308.70 L 592.60 308.60 L 595.90 307.90 L 598.80 306.90 L 603.80 303.70 L 606.10 301.60 L 609.70 296.70 L 612.00 291.30 L 612.70 285.70 L 612.40 283.00 L 611.50 279.90 L 610.60 277.90 L 607.20 273.80 L 605.00 272.00 L 597.60 267.80 L 595.80 257.30 L 594.60 253.30 L 593.00 249.80 L 591.10 246.60 L 588.90 243.80 L 586.40 241.40 L 583.20 239.00 L 579.70 237.10 L 575.60 235.50 L 571.00 234.40 L 565.70 233.70 L 552.00 233.80 L 545.80 225.90 L 542.70 223.00 L 539.30 220.40 L 535.80 218.30 L 532.10 216.60 L 528.20 215.30 L 524.20 214.60 L 520.00 214.30 L 515.20 214.60 L 510.70 215.50 L 506.30 216.90 L 502.10 218.80 L 498.10 221.30 L 494.20 224.30 L 490.60 227.70 L 487.30 231.50 L 484.30 235.90 L 483.40 236.70 L 472.50 235.60 Z" fill="#141619" fill-rule="nonzero" node-id="160" stroke="none" target-height="109.19998" target-width="210.59998" target-x="405.7" target-y="210.6"/><path d="M 549.60 333.50 L 549.40 335.10 L 547.80 337.80 L 546.60 338.80 L 545.20 339.40 L 543.50 339.60 L 541.90 339.40 L 540.40 338.80 L 538.20 336.60 L 537.60 335.10 L 537.40 333.50 L 537.60 331.80 L 538.20 330.40 L 540.40 328.20 L 541.90 327.60 L 543.50 327.40 L 545.20 327.60 L 546.60 328.20 L 547.80 329.20 L 548.80 330.40 L 549.40 331.80 L 549.60 333.50 Z" fill="#141619" fill-rule="nonzero" node-id="162" stroke="none" target-height="12.200012" target-width="12.199951" target-x="537.4" target-y="327.4"/><path d="M 488.10 333.50 L 487.90 335.10 L 487.30 336.50 L 486.30 337.80 L 485.00 338.80 L 483.60 339.40 L 482.00 339.60 L 480.40 339.40 L 479.00 338.80 L 477.70 337.80 L 476.70 336.50 L 476.10 335.10 L 475.90 333.50 L 476.10 331.90 L 477.70 329.20 L 479.00 328.20 L 480.40 327.60 L 482.00 327.40 L 483.60 327.60 L 485.00 328.20 L 486.30 329.20 L 487.30 330.50 L 487.90 331.90 L 488.10 333.50 Z" fill="#141619" fill-rule="nonzero" node-id="164" stroke="none" target-height="12.200012" target-width="12.200012" target-x="475.9" target-y="327.4"/><path d="M 787.70 632.50 L 787.70 812.30 L 233.90 812.30 L 233.90 632.50 L 420.50 632.50 L 423.20 639.70 L 426.40 646.60 L 430.10 653.00 L 434.20 659.20 L 438.90 665.00 L 443.90 670.30 L 449.30 675.30 L 455.00 679.80 L 461.20 683.90 L 467.50 687.50 L 474.20 690.50 L 481.20 693.10 L 488.30 695.20 L 495.60 696.60 L 503.10 697.50 L 510.80 697.90 L 518.50 697.50 L 526.00 696.60 L 533.30 695.20 L 540.40 693.10 L 547.40 690.50 L 554.10 687.50 L 560.40 683.90 L 566.50 679.80 L 572.30 675.30 L 577.70 670.30 L 582.70 665.00 L 587.40 659.20 L 591.50 653.00 L 595.20 646.60 L 598.40 639.70 L 601.10 632.50 Z" fill="#5779eb" fill-rule="nonzero" node-id="166" stroke="none" target-height="179.79999" target-width="553.80005" target-x="233.9" target-y="632.5"/><path d="M 787.70 819.70 L 233.90 819.70 L 231.10 819.10 L 228.70 817.50 L 227.80 816.40 L 226.70 813.80 L 226.60 812.30 L 226.60 632.50 L 226.70 631.00 L 227.80 628.40 L 229.80 626.40 L 232.50 625.30 L 422.00 625.30 L 424.80 626.50 L 426.80 628.70 L 429.90 636.80 L 432.90 643.20 L 436.30 649.10 L 440.10 654.80 L 444.40 660.20 L 449.00 665.10 L 454.00 669.70 L 459.30 673.90 L 465.00 677.60 L 470.90 680.90 L 477.00 683.80 L 483.40 686.20 L 490.00 688.00 L 496.80 689.40 L 503.70 690.20 L 510.80 690.50 L 517.90 690.20 L 524.80 689.40 L 531.60 688.00 L 538.10 686.20 L 544.60 683.80 L 550.70 680.90 L 556.60 677.60 L 562.30 673.90 L 567.60 669.70 L 572.60 665.10 L 577.20 660.20 L 581.50 654.80 L 585.30 649.10 L 588.70 643.20 L 591.70 636.80 L 594.80 628.70 L 596.80 626.50 L 599.60 625.30 L 787.70 625.20 L 789.70 625.40 L 791.40 626.20 L 792.90 627.30 L 794.00 628.80 L 794.70 630.50 L 795.00 632.50 L 795.00 812.30 L 794.70 814.30 L 794.00 816.00 L 792.90 817.50 L 791.40 818.70 L 789.70 819.40 L 787.70 819.70 Z M 241.20 805.00 L 780.40 805.00 L 780.40 639.80 L 606.30 639.80 L 603.10 647.10 L 599.50 654.00 L 595.40 660.50 L 590.80 666.60 L 585.80 672.50 L 580.50 677.80 L 574.80 682.80 L 568.70 687.30 L 562.20 691.30 L 555.60 694.90 L 548.60 697.90 L 541.40 700.50 L 534.00 702.50 L 526.50 704.00 L 518.70 704.90 L 510.80 705.20 L 502.90 704.90 L 495.10 704.00 L 487.60 702.50 L 480.20 700.50 L 473.00 697.90 L 466.00 694.90 L 459.40 691.30 L 452.90 687.30 L 446.80 682.80 L 441.10 677.80 L 435.80 672.50 L 430.70 666.60 L 426.20 660.50 L 422.10 654.00 L 418.50 647.10 L 415.30 639.80 L 241.20 639.80 Z" fill="#3e6fcd" fill-rule="nonzero" node-id="168" stroke="none" target-height="194.5" target-width="568.4" target-x="226.6" target-y="625.2"/><path d="M 453.70 751.40 L 452.30 751.20 L 451.20 750.50 L 450.50 749.40 L 450.10 748.10 L 450.20 746.70 L 450.80 745.60 L 451.70 744.70 L 453.00 744.20 L 477.00 739.60 L 456.10 723.30 L 455.30 721.60 L 455.50 719.60 L 456.70 718.10 L 458.50 717.40 L 460.40 717.70 L 461.30 718.20 L 487.90 738.80 L 489.20 740.50 L 489.30 742.50 L 488.20 744.30 L 486.40 745.30 L 453.70 751.40 Z" fill="#efefef" fill-rule="nonzero" node-id="170" stroke="none" target-height="34" target-width="39.19998" target-x="450.1" target-y="717.4"/><path d="M 570.20 751.40 L 537.50 745.30 L 535.60 744.30 L 534.60 742.50 L 534.70 740.40 L 535.90 738.80 L 562.60 718.20 L 563.90 717.60 L 565.30 717.50 L 566.60 717.90 L 567.70 718.90 L 568.40 720.20 L 568.50 721.60 L 568.00 722.90 L 567.10 724.00 L 546.80 739.60 L 570.80 744.20 L 572.10 744.70 L 573.10 745.60 L 573.60 746.70 L 573.80 748.10 L 573.40 749.40 L 572.60 750.50 L 571.50 751.20 L 570.20 751.40 Z" fill="#efefef" fill-rule="nonzero" node-id="172" stroke="none" target-height="33.900024" target-width="39.200012" target-x="534.6" target-y="717.5"/><path d="M 535.50 782.10 L 534.50 782.00 L 532.80 781.00 L 529.10 775.50 L 525.00 771.90 L 520.20 769.30 L 517.50 768.50 L 512.00 767.80 L 506.40 768.40 L 501.30 770.30 L 496.80 773.40 L 494.80 775.30 L 491.00 780.70 L 490.30 781.40 L 488.50 781.90 L 487.50 781.90 L 485.80 780.90 L 484.80 779.30 L 484.80 777.40 L 485.20 776.40 L 487.10 773.30 L 489.40 770.40 L 492.00 767.90 L 494.90 765.70 L 497.90 763.90 L 501.30 762.40 L 504.70 761.30 L 508.30 760.70 L 512.00 760.50 L 515.80 760.70 L 519.30 761.40 L 522.80 762.50 L 526.10 764.00 L 529.10 765.90 L 532.00 768.10 L 534.60 770.70 L 536.80 773.50 L 538.70 776.70 L 539.10 778.10 L 539.00 779.50 L 538.30 780.80 L 537.20 781.70 L 535.50 782.10 Z" fill="#efefef" fill-rule="nonzero" node-id="174" stroke="none" target-height="21.599976" target-width="54.299988" target-x="484.8" target-y="760.5"/></svg>
            <p class="text-gray-600 text-sm">未查询到结果, 换个姿势搜索吧~</p>
          </div>
        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-4 md:p-5 border-t border-gray-200 rounded-b dark:border-gray-600">
          <span class="px-2 py-[1px] flex-none border rounded">Esc</span>
          <span class="text-gray-400 ml-2">关闭</span>

          <!-- 底层技术介绍 -->
          <span class="ml-auto">基于 <a href="https://lucene.apache.org/" target="_blank" class="underline">Apache Lucene</a> 全文检索引擎开发</span>
        </div>
      </div>
    </div>
  </div>

</template>

<script setup>

import { initCollapses, initDropdowns, initModals, Modal } from 'flowbite'
import { useBlogSettingsStore } from '@/stores/blogsettings'
import { useUserStore } from '@/stores/user'
import { useRouter, useRoute } from 'vue-router'
import { showMessage } from '@/composables/util'
import { onMounted, ref, onBeforeUnmount, watch } from 'vue'
import { getArticleSearchPageList } from '@/api/frontend/search'

const router = useRouter()
const route = useRoute()

// 当前路由地址
const currPath = ref(route.path)

// 引入博客设置信息 store
const blogSettingsStore = useBlogSettingsStore()

// 是否登录，通过 userStore 中的 userInfo 对象是否有数据来判断
const userStore = useUserStore()

// 获取 userInfo 对象所有属性名称的数组
const keys = Object.keys(userStore.userInfo)

// 若大于零，则表示用户已登录
const isLogined = ref(keys.length > 0)

// 退出登录
const logout = () => {
  userStore.logout()
  isLogined.value = false
  showMessage('退出登录成功')
}

const searchModal = ref(null)

const modalOptions = {
  placement: 'top-center', // 弹框位置
  backdrop: 'dynamic',
  backdropClasses:
      'bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40',
  closable: true,
  onHide: () => {
    console.log('modal is hidden');
  },
  onShow: () => {
    console.log('modal is shown');
  },
  onToggle: () => {
    console.log('modal has been toggled');
  },
};

// 文章搜索结果
const searchArticles = ref([])
// 当前页码，给了一个默认值 1
const current = ref(1)
// 总数据量，给了个默认值 0
const total = ref(0)
// 每页显示的数据量，给了个默认值 10
const size = ref(10)
// 总共多少页
const pages = ref(0)
// 搜索关键词
const searchWord = ref('')

// 侦听属性，监听 searchWord 变量变化
watch(searchWord, (newText, oldText) => {
  console.log(`新值: ${newText}, 老值: ${oldText}`)
  if (newText && newText !== oldText) { // 若搜索关键词不为空，且和之前的值不相同
    renderSearchArticles({ current: current.value, size: size.value, word: newText })
  } else if (newText == '') { // 搜索词为空
    // 置空
    searchArticles.value = []
  }
})

// 搜索 Loading
const searchLoading = ref(false)

// 请求后台检索接口
function renderSearchArticles(data) {
  // 显示加载 Loading
  searchLoading.value = true
  getArticleSearchPageList(data).then(res => {
    console.log(res)
    if (res.success) {
      searchArticles.value = res.data
      current.value = res.current
      size.value = res.size
      total.value = res.total
      pages.value = res.pages
    }
  }).finally(() => searchLoading.value = false) // 隐藏加载 Loading
}

// instance options object
const instanceOptions = {
  id: 'searchModalEl',
  override: true
};

// 初始化 flowbit 相关组件
onMounted(() => {
  initCollapses();
  initDropdowns();
  initModals();

  // 初始化
  const $modalElement = document.querySelector('#search-modal');
  searchModal.value = new Modal($modalElement, modalOptions, instanceOptions);


  // 注册键盘事件监听器
  window.addEventListener('keydown', handleKeyDown);
})

// 点击搜索框
const clickSearchBtn = () => {
  searchModal.value.show()
  // 激活搜索框
  searchInputRef.value.focus()
}


onBeforeUnmount(() => {
  // 在组件销毁前移除事件监听器，防止内存泄漏
  window.removeEventListener('keydown', handleKeyDown);
})

// 搜索输入框引用
const searchInputRef = ref(null)
// 键盘监听
const handleKeyDown = (event) => {
  // 检查是否按下了 Ctrl 键和 K 键
  if (event.ctrlKey && event.key === 'k') {
    // 阻止激活浏览器本身的搜索框
    event.preventDefault()
    console.log('ctrl k 被按了')

    searchModal.value.show()

    // 激活搜索框
    searchInputRef.value.focus()
  }
}

// 渲染下一页搜索结果
const nextPage = () => {
  renderSearchArticles({ current: current.value + 1, size: size.value, word: searchWord.value })
}

// 渲染上一页搜索结果
const prePage = () => {
  renderSearchArticles({ current: current.value - 1, size: size.value, word: searchWord.value })
}

// 点击搜索结果，跳转文章详情页
const jumpToArticleDetailPage = (articleId) => {
  // 隐藏搜索对话框
  searchModal.value.hide()
  // 路由跳转
  router.push('/article/' + articleId)
}
</script>