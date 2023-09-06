import {http} from '@/utils/http/axios';

//获取主控台信息
export function unindexedSqlAp(params) {
  return http.request({
    url: '/monitor/unindexedSqls',
    method: 'get',
    params
  });
}
