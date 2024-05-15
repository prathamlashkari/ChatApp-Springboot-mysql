import React from 'react'
import { AiOutlineClose } from 'react-icons/ai'
import { imageurl } from '../assets/constant'

const SelectMember = ({handleRemoveMember , member}) => {


  return (
    <div className='flex items-center bg-slate-300 rounded-full'>
      <img
       className='w-7 h-7 rounded-full' 
       src={imageurl} 
       alt="" />
       <p className='px-2'>username</p>
       <AiOutlineClose 
       onClick={handleRemoveMember}
       className='pr-1 cursor-pointer' />

    </div>
  )
}

export default SelectMember