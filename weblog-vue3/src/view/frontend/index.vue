<template>
  <Header></Header>

  <!-- 主内容区域 -->
  <main class="container max-w-screen-xl mx-auto p-4">
    <!-- grid 表格布局，分为 4 列，元素间隔为 gap-4  -->
    <div class="grid grid-cols-4 gap-4">
      <!-- 左边栏，md（桌面屏）时占用 3 列  ，适配移动端，小于md时直接占满-->
      <div class="col-span-4  md:col-span-3 mb-3">
        <!-- 文章列表，grid 表格布局，分为 2 列 -->
        <div class="grid grid-cols-2 gap-4">
          <div class="col-span-2 md:col-span-1 ">
            <div class="bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
              <!-- 文章封面 -->
              <a href="#">
                <img class="rounded-t-lg h-50 w-full"
                     src="http://127.0.0.1:9000/weblog/52ec6419d1ec483bb337b3366bca348b.jpg"
                     alt="" />
              </a>
              <div class="p-5">
                <!-- 标签 -->
                <div class="mb-3">
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                  >Vue3
                  </span>
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                  >Blog3
                  </span>
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                  >项目3
                  </span>
                </div>

                <!-- 文章标题 -->
                <a href="#">
                  <h2 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">Vue前端</h2>
                </a>
                <!-- 文章摘要 -->
                <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">Here are order.</p>

                <!-- 文章发布时间、所属分类 -->
                <p class="flex items-center font-normal text-gray-400 text-sm dark:text-gray-400">
                  <!-- 发布时间 -->
                  <svg class="inline w-3 h-3 mr-2 text-gray-400 dark:text-white" aria-hidden="true"
                       xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M5 1v3m5-3v3m5-3v3M1 7h18M5 11h10M2 3h16a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1Z" />
                  </svg>
                  2023-10-22

                  <!-- 所属分类 -->
                  <svg class="inline w-3 h-3 ml-5 mr-2 text-gray-400 dark:text-white" aria-hidden="true"
                       xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 18">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M1 5v11a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1H1Zm0 0V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H1Z" />
                  </svg>
                  <a href="#" class="text-gray-400 hover:underline">Java</a>
                </p>

              </div>
            </div>
          </div>
          <div class="col-span-2 md:col-span-1">
            <div class=" bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
              <!-- 文章封面 -->
              <a href="#">
                <img class="rounded-t-lg h-50 w-full"
                     src="http://127.0.0.1:9000/weblog/52ec6419d1ec483bb337b3366bca348b.jpg"
                     alt="" />
              </a>
              <div class="p-5">
                <!-- 标签 -->
                <div class="mb-3">
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                    >Vue
                  </span>
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                    >Blog
                  </span>
                  <span class="cursor-pointer bg-green-100 text-green-800
                               text-xs font-medium mr-2 px-2.5 py-0.5 rounded
                               hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300"
                    >项目
                  </span>
                </div>
                <!-- 文章标题 -->
                <a href="#">
                  <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">blog构建</h5>
                </a>
                <!-- 文章摘要 -->
                <p class="mb-3 font-normal text-gray-700 dark:text-gray-400"> order.</p>
                <!-- 文章发布时间、所属分类 -->
                <p class="flex items-center font-normal text-gray-400 text-sm dark:text-gray-400">
                  <!-- 发布时间 -->
                  <svg class="inline w-3 h-3 mr-2 text-gray-400 dark:text-white" aria-hidden="true"
                       xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M5 1v3m5-3v3m5-3v3M1 7h18M5 11h10M2 3h16a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1Z" />
                  </svg>
                  2023-10-22

                  <!-- 所属分类 -->
                  <svg class="inline w-3 h-3 ml-5 mr-2 text-gray-400 dark:text-white" aria-hidden="true"
                       xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 18">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                          stroke-width="2"
                          d="M1 5v11a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1H1Zm0 0V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H1Z" />
                  </svg>
                  <a href="#" class="text-gray-400 hover:underline">Java</a>
                </p>

              </div>
            </div>
          </div>
        </div>
        <!-- 分页 -->
        <nav aria-label="Page navigation example" class="mt-10 flex justify-center">
          <ul class="flex items-center -space-x-px h-10 text-base">
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 ml-0 leading-tight text-gray-500 bg-white border border-gray-300 rounded-l-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                <span class="sr-only">Previous</span>
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                     viewBox="0 0 6 10">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                        stroke-width="2" d="M5 1 1 5l4 4" />
                </svg>
              </a>
            </li>
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">1</a>
            </li>
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">2</a>
            </li>
            <li>
              <a href="#" aria-current="page"
                 class="z-10 flex items-center justify-center px-4 h-10 leading-tight text-blue-600 border border-blue-300 bg-blue-50 hover:bg-blue-100 hover:text-blue-700 dark:border-gray-700 dark:bg-gray-700 dark:text-white">3</a>
            </li>
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">4</a>
            </li>
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">5</a>
            </li>
            <li>
              <a href="#"
                 class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 bg-white border border-gray-300 rounded-r-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                <span class="sr-only">Next</span>
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                     viewBox="0 0 6 10">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                        stroke-width="2" d="m1 9 4-4-4-4" />
                </svg>
              </a>
            </li>
          </ul>
        </nav>
      </div>
      <!-- 右边侧边栏，占用一列 -->
      <aside class="col-span-4 md:col-span-1">
        <!-- 博主信息 -->
        <div class="w-full py-5 px-2 mb-3 bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
          <div class="flex flex-col items-center">
            <!-- 博主头像 -->
            <img class="w-24 h-24 mb-3 rounded-full shadow-lg" src="http://127.0.0.1:9000/weblog/avter.jpg" alt="Bonnie image"/>
            <!-- 博主昵称 -->
            <h5 class="mb-1 text-xl font-medium text-gray-900 dark:text-white">Bonnie Green</h5>
            <!-- 介绍语 -->
            <span class="text-sm text-gray-500 dark:text-gray-400">Visual Designer</span>
            <!-- 第三方平台主页跳转（如 GitHub 等） -->
            <div class="flex justify-center mt-5 gap-2">
              <!-- GitHub -->
              <svg t="1698029949662"
                   data-tooltip-target="github-tooltip-bottom"
                   data-tooltip-placement="bottom"
                   class="icon w-7 h-7"
                   viewBox="0 0 1024 1024"
                   version="1.1"
                   xmlns="http://www.w3.org/2000/svg"
                   p-id="1447"
                   width="200"
                   height="200"
              >
                <path d="M512 512m-512 0a512 512 0 1 0 1024 0 512 512 0 1 0-1024 0Z" fill="#4186F5" p-id="1448" />
                <path d="M611.944 302.056c0-15.701 2.75-30.802 7.816-44.917a384.238
                          384.238 0 0 0-186.11 2.956c-74.501-50.063-93.407-71.902-107.975-39.618a136.243 136.243
                          0 0 0-3.961 102.287 149.515 149.515 0 0 0-39.949 104.806c0 148.743 92.139 181.875 179.961
                          191.61a83.898 83.898 0 0 0-25.192 51.863c-40.708 22.518-91.94 8.261-115.181-32.058a83.117
                          83.117 0 0 0-60.466-39.98s-38.871-0.361-2.879 23.408a102.97 102.97 0 0 1 43.912 56.906s23.398
                          75.279 133.531 51.863v65.913c0 10.443 13.548 42.63 102.328 42.63 71.275 0 94.913-30.385
                          94.913-42.987V690.485a90.052 90.052 0 0 0-26.996-72.03c83.996-9.381 173.328-40.204
                          179.6-176.098a164.706 164.706 0 0 1-21.129 1.365c-84.07 0-152.223-63.426-152.223-141.666z"
                      fill="#FFFFFF"
                      p-id="1449"
                />
                <path d="M743.554 322.765a136.267 136.267 0 0 0-3.961-102.289s-32.396-10.445-107.979 39.618a385.536
                         385.536 0 0 0-11.853-2.956 132.623 132.623 0 0 0-7.816 44.917c0 78.24 68.152 141.667
                         152.222 141.667 7.171 0 14.222-0.472 21.129-1.365 0.231-5.03 0.363-10.187
                         0.363-15.509a149.534 149.534 0 0 0-42.105-104.083z"
                      fill="#FFFFFF"
                      opacity=".4"
                      p-id="1450"
                />
              </svg>
              <!-- GitHub Tooltip -->
              <div id="github-tooltip-bottom"
                   role="tooltip"
                   class="absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white
                          bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700"
              >
                我的 GitHub
                <div class="tooltip-arrow" data-popper-arrow></div>
              </div>
              <!-- Gitee -->
              <svg t="1698030969736" data-tooltip-target="gitee-tooltip-bottom" data-tooltip-placement="bottom" class="icon w-7 h-7" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2438" width="200" height="200"><path d="M512 1024C229.222 1024 0 794.778 0 512S229.222 0 512 0s512 229.222 512 512-229.222 512-512 512z m259.149-568.883h-290.74a25.293 25.293 0 0 0-25.292 25.293l-0.026 63.206c0 13.952 11.315 25.293 25.267 25.293h177.024c13.978 0 25.293 11.315 25.293 25.267v12.646a75.853 75.853 0 0 1-75.853 75.853h-240.23a25.293 25.293 0 0 1-25.267-25.293V417.203a75.853 75.853 0 0 1 75.827-75.853h353.946a25.293 25.293 0 0 0 25.267-25.292l0.077-63.207a25.293 25.293 0 0 0-25.268-25.293H417.152a189.62 189.62 0 0 0-189.62 189.645V771.15c0 13.977 11.316 25.293 25.294 25.293h372.94a170.65 170.65 0 0 0 170.65-170.65V480.384a25.293 25.293 0 0 0-25.293-25.267z" fill="#C71D23" p-id="2439"></path></svg>
              <div id="gitee-tooltip-bottom" role="tooltip" class="absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700">
                我的 Gitee
                <div class="tooltip-arrow" data-popper-arrow></div>
              </div>
              <!-- QQ -->
              <svg t="1747374100544"
                   class="icon w-7 h-7"
                   data-tooltip-target="qq-tooltip-bottom"
                   data-tooltip-placement="bottom"
                   viewBox="0 0 1024 1024"
                   version="1.1"
                   xmlns="http://www.w3.org/2000/svg"
                   p-id="12108"
                   width="200"
                   height="200"
              >
                <path d="M512 0C229.003636 0 0 229.003636 0 512s229.003636 512 512 512 512-229.003636
                         512-512S794.996364 0 512 0z m210.385455 641.396364c-7.447273
                         9.309091-26.996364-1.861818-41.89091-32.581819-3.723636 13.963636-13.032727
                         36.305455-34.443636 64.232728 35.374545 8.378182 44.683636 42.821818 33.512727
                         61.44-8.378182 13.032727-26.996364 24.203636-59.578181 24.203636-58.647273
                         0-83.781818-15.825455-95.883637-26.996364-1.861818-2.792727-5.585455-3.723636-10.24-3.723636-4.654545
                         0-7.447273 0.930909-10.24 3.723636-11.170909 11.170909-37.236364 26.996364-95.883636
                         26.996364-32.581818 0-52.130909-11.170909-59.578182-24.203636-12.101818-18.618182-1.861818-53.061818
                         33.512727-61.44-20.48-27.927273-29.789091-50.269091-34.443636-64.232728-13.963636
                         30.72-34.443636 42.821818-41.890909 32.581819-5.585455-8.378182-8.378182-26.065455-7.447273-38.167273
                         3.723636-46.545455 34.443636-85.643636 53.061818-106.123636-2.792727-5.585455-8.378182-40.029091
                         14.894546-63.301819v-1.861818c0-92.16 65.163636-158.254545 148.014545-158.254545 81.92 0 148.014545
                         66.094545 148.014546 158.254545v1.861818c23.272727 23.272727 17.687273 57.716364 14.894545 63.301819
                         17.687273 20.48 49.338182 59.578182 53.061818 106.123636 0.930909 12.101818-0.930909 29.789091-7.447272
                         38.167273z"
                      fill="#30A5DD"
                      p-id="12109"
                 />
              </svg>
              <div id="qq-tooltip-bottom" role="tooltip" class="absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700">
                我的 QQ
                <div class="tooltip-arrow" data-popper-arrow></div>
              </div>
              <!-- WX -->
              <svg t="1747374493104"
                   class="icon w-7 h-7"
                   data-tooltip-target="wechat-tooltip-bottom"
                   data-tooltip-placement="bottom"
                   viewBox="0 0 1024 1024"
                   version="1.1"
                   xmlns="http://www.w3.org/2000/svg"
                   p-id="16209"
                   width="200"
                   height="200">
                <path d="M337.387283 341.82659c-17.757225 0-35.514451 11.83815-35.514451 29.595375s17.757225
                         29.595376 35.514451 29.595376 29.595376-11.83815
                         29.595376-29.595376c0-18.49711-11.83815-29.595376-29.595376-29.595375zM577.849711
                         513.479769c-11.83815 0-22.936416 12.578035-22.936416 23.6763 0 12.578035 11.83815
                         23.676301 22.936416 23.676301 17.757225 0 29.595376-11.83815
                         29.595376-23.676301s-11.83815-23.676301-29.595376-23.6763zM501.641618 401.017341c17.757225
                         0 29.595376-12.578035 29.595376-29.595376 0-17.757225-11.83815-29.595376-29.595376-29.595375s-35.514451
                         11.83815-35.51445 29.595375 17.757225 29.595376 35.51445 29.595376zM706.589595
                         513.479769c-11.83815 0-22.936416 12.578035-22.936416 23.6763 0 12.578035 11.83815
                         23.676301 22.936416 23.676301 17.757225 0 29.595376-11.83815 29.595376-23.676301s-11.83815-23.676301-29.595376-23.6763z"
                      fill="#28C445"
                      p-id="16210"
                />
                <path d="M510.520231 2.959538C228.624277 2.959538 0 231.583815 0 513.479769s228.624277 510.520231
                         510.520231 510.520231 510.520231-228.624277 510.520231-510.520231-228.624277-510.520231-510.520231-510.520231zM413.595376
                         644.439306c-29.595376 0-53.271676-5.919075-81.387284-12.578034l-81.387283 41.433526
                         22.936416-71.768786c-58.450867-41.433526-93.965318-95.445087-93.965317-159.815029 0-113.202312
                         105.803468-201.988439 233.803468-201.98844 114.682081 0 216.046243 71.028902 236.023121
                         166.473989-7.398844-0.739884-14.797688-1.479769-22.196532-1.479769-110.982659 1.479769-198.289017
                         85.086705-198.289017 188.67052 0 17.017341 2.959538 33.294798 7.398844 49.572255-7.398844
                         0.739884-15.537572 1.479769-22.936416 1.479768z m346.265896 82.867052l17.757225
                         59.190752-63.630058-35.514451c-22.936416 5.919075-46.612717 11.83815-70.289017 11.83815-111.722543
                         0-199.768786-76.947977-199.768786-172.393063-0.739884-94.705202 87.306358-171.653179
                         198.289017-171.65318 105.803468 0 199.028902 77.687861 199.028902 172.393064 0 53.271676-34.774566
                         100.624277-81.387283 136.138728z"
                      fill="#28C445"
                      p-id="16211"
                />
              </svg>
              <div id="wechat-tooltip-bottom" role="tooltip" class="absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700">
                我的微信
                <div class="tooltip-arrow" data-popper-arrow></div>
              </div>
            </div>
          </div>
        </div>
        <!-- 分类     -->
        <div class="w-full mt-4 p-5 mb-3 bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
          <!--          -->
          <h2 class="mb-2 font-bold text-gray-900 uppercase ">分类</h2>
          <div class="w-full text-gray-900 bg-white rounded-lg dark:bg-gray-700 dark:text-white">
            <a href="#"
               class="flex items-center w-full px-4 py-2
               rounded-t-lg hover:bg-gray-100 hover:text-blue-700 focus:z-10 focus:ring-2 focus:ring-blue-700
               focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600
               dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white
">
              <svg class="w-3.5 h-3.5 mr-1.5 dark:text-white" aria-hidden="true"
                   xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 21 18">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M2.539 17h12.476l4-9H5m-2.461 9a1 1 0 0 1-.914-1.406L5 8m-2.461 9H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H16a1 1 0 0 1 1 1v2H5" />
              </svg>
              Vue
            </a>
            <a href="#"
               class="flex items-center w-full px-4 py-2 rounded-lg border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white">
              <svg class="w-3.5 h-3.5 mr-1.5 dark:text-white" aria-hidden="true"
                   xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 21 18">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M2.539 17h12.476l4-9H5m-2.461 9a1 1 0 0 1-.914-1.406L5 8m-2.461 9H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H16a1 1 0 0 1 1 1v2H5" />
              </svg>
              React
            </a>
            <a href="#"
               class="flex items-center w-full px-4 py-2 rounded-lg cursor-pointer hover:bg-gray-100 hover:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white">
              <svg class="w-3.5 h-3.5 mr-1.5 dark:text-white" aria-hidden="true"
                   xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 21 18">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M2.539 17h12.476l4-9H5m-2.461 9a1 1 0 0 1-.914-1.406L5 8m-2.461 9H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H16a1 1 0 0 1 1 1v2H5" />
              </svg>
              CSS
            </a>
          </div>

        </div>
        <!-- 标签     -->
        <div class="w-full mt-4 p-5 mb-3 bg-white border border-gray-200 rounded-lg dark:bg-gray-800 dark:border-gray-700">
          <!--          -->
          <h2 class="mb-2 font-bold text-gray-900 uppercase ">标签</h2>
          <span class="inline-block mb-1 cursor-pointer bg-green-100 text-green-800
                       text-xs font-medium mr-2 px-2.5 py-0.5 rounded hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300">标签</span>
          <span class="inline-block mb-1 cursor-pointer bg-green-100 text-green-800
                       text-xs font-medium mr-2 px-2.5 py-0.5 rounded hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300">标签</span>
          <span class="inline-block mb-1 cursor-pointer bg-green-100 text-green-800
                       text-xs font-medium mr-2 px-2.5 py-0.5 rounded hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300">标签</span>
          <span class="inline-block mb-1 cursor-pointer bg-green-100 text-green-800
                       text-xs font-medium mr-2 px-2.5 py-0.5 rounded hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300">标签</span>
          <span class="inline-block mb-1 cursor-pointer bg-green-100 text-green-800
                       text-xs font-medium mr-2 px-2.5 py-0.5 rounded hover:bg-green-200 hover:text-green-900 dark:bg-green-900 dark:text-green-300">标签</span>
        </div>
      </aside>
    </div>

  </main>
</template>

<script setup>
import Header from '@/layouts/frontend/components/Header.vue'
import { initTooltips } from 'flowbite'
import { onMounted } from 'vue'

// initialize components based on data attribute selectors
onMounted(() => {
  initTooltips();
})
</script>
