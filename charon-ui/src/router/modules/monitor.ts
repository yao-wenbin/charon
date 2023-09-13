import {RouteRecordRaw} from 'vue-router';
import {Layout} from '@/router/constant';
import {TableOutlined} from '@vicons/antd';
import {renderIcon} from '@/utils/index';

/**
 * @param name 路由名称, 必须设置,且不能重名
 * @param meta 路由元信息（路由附带扩展信息）
 * @param redirect 重定向地址, 访问这个路由时,自定进行重定向
 * @param meta.disabled 禁用整个菜单
 * @param meta.title 菜单名称
 * @param meta.hide 是否隐藏
 * @param meta.icon 菜单图标
 * @param meta.keepAlive 缓存该路由
 * @param meta.sort 排序越小越排前
 *
 * */
const routes: Array<RouteRecordRaw> = [
  {
    path: '/monitor',
    name: 'Monitor',
    redirect: '/monitor/unindexed-sqls',
    component: Layout,
    meta: {
      title: '监控列表',
      icon: renderIcon(TableOutlined),
      sort: 2,
    },
    children: [
      {
        path: '/monitor/unindexed-sqls/:key?',
        name: 'UnindexedSqls',
        meta: {
          title: '无索引查询',
        },
        component: () => import('@/views/monitor/unindexed-sqls/index.vue'),
      },
      {
        path: '/monitor/mysql-threads/:key?',
        name: 'MysqlThreads',
        meta: {
          title: 'MySQL线程',
        },
        component: () => import('@/views/monitor/mysql-threads/index.vue'),
      },
    ],
  },
];

export default routes;
