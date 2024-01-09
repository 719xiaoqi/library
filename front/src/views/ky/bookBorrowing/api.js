import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getBookBorrowingOne = (params) => {
    return getRequest('/bookBorrowing/getOne', params)
}
export const getBookBorrowingList = (params) => {
    return getRequest('/bookBorrowing/getByPage', params)
}
export const getBookBorrowingCount = (params) => {
    return getRequest('/bookBorrowing/count', params)
}
export const addBookBorrowing = (params) => {
    return postRequest('/bookBorrowing/insert', params)
}
export const editBookBorrowing = (params) => {
    return postRequest('/bookBorrowing/update', params)
}
export const addOrEditBookBorrowing = (params) => {
    return postRequest('/bookBorrowing/insertOrUpdate', params)
}
export const deleteBookBorrowing = (params) => {
    return postRequest('/bookBorrowing/delByIds', params)
}
export const getBookList = (params) => {
    return getRequest('/book/getAll', params)
}
export const reBookBorrowing = (params) => {
    return getRequest('/bookBorrowing/re', params)
}