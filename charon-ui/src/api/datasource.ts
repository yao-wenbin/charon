import {http} from '@/utils/http/axios';

//获取主控台信息
export function datasourcesApi() {
  return http.request({
    url: '/datasources',
    method: 'get',
  });
}
