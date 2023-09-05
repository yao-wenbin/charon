import {http} from '@/utils/http/axios';

//获取主控台信息
export function statisticsIndexApi() {
  return http.request({
    url: '/statistic/index',
    method: 'get',
  });
}
