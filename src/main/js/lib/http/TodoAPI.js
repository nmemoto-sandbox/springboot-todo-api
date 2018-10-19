import Vue from 'vue'
import env from '../../config'
const FETCH_API = `${env.API_ENDPOINT}/todos`

export const findAll = async ()  => {
    try {
        let res = await Vue.http.get(FETCH_API)
        return res.data
    } catch (err) {
        console.err(err) 
        throw err 
    }
}

export const create = async todo =>  {
    try {
        let res = await Vue.http.post(FETCH_API, { ...todo })
        return res.data
    } catch (err) {
        console.err(err) 
        throw err 
    }
}

export const remove = async (id) => {
    try {
        return await Vue.http.delete(`${FETCH_API}/${id}`)
    } catch (err) {
        console.err(err) 
        throw err     
    }
}

export const patch = async (id, todo) => {
    try {
        let res = await Vue.http.patch(`${FETCH_API}/${id}`, {...todo})
        return res.data
    } catch (err) {
        console.err(err) 
        throw err 
    }
}