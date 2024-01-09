import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getBookTypeOne = (params) => {
    return getRequest('/bookType/getOne', params)
}
export const getBookTypeList = (params) => {
    return getRequest('/bookType/getByPage', params)
}
export const getBookTypeCount = (params) => {
    return getRequest('/bookType/count', params)
}
export const addBookType = (params) => {
    return postRequest('/bookType/insert', params)
}
export const editBookType = (params) => {
    return postRequest('/bookType/update', params)
}
export const addOrEditBookType = (params) => {
    return postRequest('/bookType/insertOrUpdate', params)
}
export const deleteBookType = (params) => {
    return postRequest('/bookType/delByIds', params)
}