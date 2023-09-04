import {BasicColumn} from '@/components/Table';

export interface ListData {
  threadId: number;
  sqlText: string;
  currentSchema: string;
  execTimeMs: number;
  noIndexUsed: number;
}
export const columns: BasicColumn<ListData>[] = [
  // {
  //   title: 'id',
  //   key: 'id',
  //   width: 100,
  // },
  {
    title: '线程ID',
    key: 'threadId',
    width: 100,
  },
  {
    title: 'SQL',
    key: 'sqlText',
    width: 100,
  },
  {
    title: '执行库',
    key: 'currentSchema',
    width: 150,
  },
  {
    title: '执行时长（ms）',
    key: 'execTimeMs',
    width: 160,
  },
  {
    title: '未使用索引',
    key: 'noIndexUsed',
    width: 160,
  },
];
