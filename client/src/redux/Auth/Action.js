import {SERVER} from '../../config/api'
import {LOGIN, REGISTER, REQ_USER, SEARCH_USER, UPDATE_USER} from './ActionType'


export const register =(data)=>async(dispatch)=>{
  try {
    const res = await fetch(`${SERVER}/auth/signup`,
      {
        method :"POST",
        headers:{
          "Content-type" : "application/json",
        },
        body:JSON.stringify(data)
      })
      const resData = await res.json();
      console.log(`register ` , resData);
      dispatch({type:REGISTER , payload:resData})
  } catch (error) {
    console.log(error)
  }
}

export const login =(data)=>async(dispatch)=>{
  try {
    const res = await fetch(`${SERVER}/auth/signin`,
      {
        method :"POST",
        headers:{
          "Content-type" : "application/json",
        },
        body:JSON.stringify(data)
      })
      const resData = await res.json();
      console.log(`register ` , resData);
      dispatch({type:LOGIN , payload:resData})
  } catch (error) {
    console.log(error)
  }
}

export const currentUser =(token)=>async(dispatch)=>{
  try {
    const res = await fetch(`${SERVER}/auth/signin`,
      {
        method :"GET",
        headers:{
          "Content-type" : "application/json",
           Authorization : `Bearer ${token}`
        }
      })
      const resData = await res.json();
      console.log(`register ` , resData);
      dispatch({type:REQ_USER , payload:resData})
  } catch (error) {
    console.log(error)
  }
}

export const searchUser =(data)=>async(dispatch)=>{
  try {
    const res = await fetch(`${SERVER}/users/search?name=${data.keyword}`,
      {
        method :"GET",
        headers:{
          "Content-type" : "application/json",
           Authorization : `Bearer ${data.token}`
        }
      })
      const resData = await res.json();
      console.log(`register ` , resData);
      dispatch({type:SEARCH_USER , payload:resData})
  } catch (error) {
    console.log(error)
  }
}


export const updateUser =(token)=>async(dispatch)=>{
  try {
    const res = await fetch(`${SERVER}/users/update/${data.id}`,
      {
        method :"PUT",
        headers:{
          "Content-type" : "application/json",
           Authorization : `Bearer ${token}`
        }
      })
      const resData = await res.json();
      console.log(`register ` , resData);
      dispatch({type:UPDATE_USER , payload:resData})
  } catch (error) {
    console.log(error)
  }
}