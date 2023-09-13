<template>
  <n-card :bordered="false" class="proCard">
    <BasicForm @register="register" @submit="handleSubmit" @reset="handleReset">
      <template #statusSlot="{ model, field }">
        <n-input v-model:value="model[field]" />
      </template>
    </BasicForm>

    <BasicTable
      :columns="columns"
      :request="loadDataTable"
      :row-key="(row:UnindexedSql) => row.threadId"
      ref="actionRef"
      :scroll-x="1090"
    >
      <template #toolbar>
        <n-button type="primary" @click="reloadTable">刷新数据</n-button>
      </template>
    </BasicTable>
  </n-card>
</template>

<script lang="ts" setup>
import {ref, onMounted} from 'vue';
import {BasicTable} from '@/components/Table';
import {BasicForm, FormSchema, useForm} from '@/components/Form/index';
import {unindexedSqlAp} from '@/api/monitor';
import {columns, UnindexedSql} from './columns';
import {useRouter, useRoute} from 'vue-router';
import {useDbStore} from "@/store/datasource";

const dbStore = useDbStore()

const router = useRouter();
const route = useRoute();
const currentDb = route.params.key;
const initParams = {
  'key': currentDb,
}
const schemas: FormSchema[] = [
  {
    field: 'key',
    component: 'NSelect',
    label: '数据库名',
    componentProps: {
      options: dbStore.getKeysForSelect,
      onUpdateValue: (e: any) => {
        console.log(getFieldsValue())
      },
    },
  },
];


const [register, { getFieldsValue, setFieldsValue }] = useForm({
  gridProps: { cols: '1 s:1 m:2 l:3 xl:4 2xl:4' },
  labelWidth: 80,
  schemas,
});

  onMounted(() => {
    setFieldsValue(initParams)
  })



const formRef: any = ref(null);
const actionRef = ref();



const loadDataTable = async (res) => {
  let result = await unindexedSqlAp({ ...getFieldsValue(), ...res });
  return {'list': result};
};

function reloadTable() {
  actionRef.value.reload();
}

function handleSubmit(values: Recordable) {
  console.log(values);
  reloadTable();
}

function handleReset(values: Recordable) {
  console.log(values);
}
</script>

<style lang="less" scoped></style>
