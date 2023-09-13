import {BasicColumn} from '@/components/Table';

export interface UnindexedSql {
  threadId: number;
  sqlText: string;
  currentSchema: string;
  execTimeMs: number;
  noIndexUsed: number;
}
export const columns: BasicColumn<UnindexedSql>[] = [
  {
    title: '线程ID',
    key: 'threadId',
    width: 50,
  },
  {
    title: '执行库',
    key: 'currentSchema',
    width: 50,
  },
  {
    title: '执行时长（ms）',
    key: 'execTimeMs',
    width: 50,
  },
  {
    title: '未使用索引',
    key: 'noIndexUsed',
    width: 50,
  },
  {
    title: 'SQL',
    key: 'sqlText',
    width: 200,
  },

];
