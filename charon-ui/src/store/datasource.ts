import { defineStore} from 'pinia'

export interface DBState {
  collection: Array<DS>
  keys: Array<String>
}

export interface DS {
  key: String
  username: String
  url: String
  connected: boolean
}

export const useDbStore = defineStore({
  id:'db',
  state: (): DBState => {
    return {
      collection: [],
      keys: [],
    }
  },
  actions: {
    setCollection(collection: Array<DS>) {
     this.collection = collection;
     this.keys = collection.map(val => val.key)
    }
  },
  getters: {
    getKeys() {
      return this.keys;
    },
    getKeysForSelect() {
      return this.keys.map(key => {return {label: key, value: key}})
    },
  }
})
