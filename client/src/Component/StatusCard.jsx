import React from 'react'
import {imageurl} from "../assets/constant"
import { useNavigate } from 'react-router-dom'
const StatusCard = () => {


  const navigate = useNavigate();

  const handleNavigate =()=>{
    navigate("/status/{usrrId}");
  }
  return (
    <div  onClick={handleNavigate}  className='flex items-center p-3'>
      <div>
        <img 
          className='h-7 w-7 lg:h-10 rounded-full' 
          src={imageurl} alt="" />
      </div>
      <div className='ml-2 text-white'>
            <p>Pratham</p>
       </div>
    </div>
  )
}

export default StatusCard