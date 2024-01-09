import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getLibraryOne = (params) => {
    return getRequest('/library/getOne', params)
}
export const getLibraryList = (params) => {
    return getRequest('/library/getByPage', params)
}
export const getLibraryCount = (params) => {
    return getRequest('/library/count', params)
}
export const addLibrary = (params) => {
    return postRequest('/library/insert', params)
}
export const editLibrary = (params) => {
    return postRequest('/library/update', params)
}
export const addOrEditLibrary = (params) => {
    return postRequest('/library/insertOrUpdate', params)
}
export const deleteLibrary = (params) => {
    return postRequest('/library/delByIds', params)
}