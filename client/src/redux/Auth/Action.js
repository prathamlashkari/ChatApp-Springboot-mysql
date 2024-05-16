import {SERVER} from '../../config/api'
import {REGISTER} from './ActionType'


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
      dispatch({type:REGISTER , payload:resData})
  } catch (error) {
    console.log(error)
  }
}