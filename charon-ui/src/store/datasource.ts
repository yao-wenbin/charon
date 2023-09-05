import { defineStore} from 'pinia'

export interface DBState {
  key: String;
}

export const useDbStore = defineStore({
  id:'db',
  state: (): DBState => {
    return {
      key: '',
    }
  },
  actions: {
    setDb(key: String) {
     this.key = key;
    }
  }
})
