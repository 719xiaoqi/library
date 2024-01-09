import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getBookOne = (params) => {
    return getRequest('/book/getOne', params)
}
export const getBookList = (params) => {
    return getRequest('/book/getByPage', params)
}
export const getBookCount = (params) => {
    return getRequest('/book/count', params)
}
export const addBook = (params) => {
    return postRequest('/book/insert', params)
}
export const editBook = (params) => {
    return postRequest('/book/update', params)
}
export const addOrEditBook = (params) => {
    return postRequest('/book/insertOrUpdate', params)
}
export const deleteBook = (params) => {
    return postRequest('/book/delByIds', params)
}
export const getBookTypeList = (params) => {
    return getRequest('/bookType/getAll', params)
}
export const getLibraryList = (params) => {
    return getRequest('/library/getAll', params)
}