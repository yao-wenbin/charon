import {http} from '@/utils/http/axios';

//获取table
export function getTableList(params) {
  return http.request({
    url: '/monitor/list',
    method: 'get',
    params,
  });
}
