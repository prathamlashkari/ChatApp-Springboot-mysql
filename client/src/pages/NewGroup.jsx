import React, { useState } from 'react'
import {imageurl} from '../assets/constant'
import { Button, CircularProgress } from '@mui/material';
import { BsCheck2 } from 'react-icons/bs';
const NewGroup = () => {

  const [isImageUploading , setIsImageUploading] = useState(false);
  const [groupName , setGroupName] = useState("");
  return (
    <div className='w-full h-full'>
      <div className='flex items-center space-x-10 bg-[#008069] text-white pt-16 px-10 pb-5'>
       </div>

       <div className='flex flex-col justify-center items-center my-12'>
          <label 
          htmlFor="imgInput"
          className='relative' >
            <img src={imageurl} alt="" />
            {
              isImageUploading && 
              <CircularProgress 
              className='absolute top-[5rem] left-[6rem]' />
            }
          </label>
          <input 
          type="text"
          id='imgInput'
          className='hidden'
          onChange={()=>console.log("imageChange")} />
      </div>
      <div className='w-full flex justify-between items-center py-2 px-5'>
         <input
          type="text"
          className='w-full outline-none border-b-2 border-green-700 px-2 bg-transparent'
          onChange={(e)=>setGroupName(e.target.value)}
          placeholder='Group subject'
          value={groupName} />
      </div>
      {
        groupName && <div className='py-10 bg-slate-200 flex items-center justify-center'>
           <Button>
            {" "}
             <div className='bg-[#0c977d] rounded-full p-4'>
                <BsCheck2 className='text-white font-bold text-4xl'/>
             </div>
           </Button>
        </div>
      }
      
    </div>
  )
}

export default NewGroup