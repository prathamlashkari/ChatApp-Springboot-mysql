import React, { useState } from 'react'
import { BsArrowLeft } from 'react-icons/bs'
import SelectMember from '../Component/SelectMember';

const GroupCard = () => {
  
  const[newGroup , setNewGroup] = useState();
  const[groupMember , setGroupMember] = useState(new Set());


  const handleRemoveMember =(item)=>{
    groupMember.delete(item);
    setGroupMember(groupMember);
  }

  return (
    <div className='w-full h-full'>
      {
        !newGroup && (<div>

          <div className='flex items-center space-x-10 bg-[#008069] text-white pt-16 px-10 pb-5'>
            <BsArrowLeft
            className='cursor-pointer text-2xl font-bold'/>
            <p className='text-xl font-semibold'>Add Group Participant</p>
         </div>
          <div className='relative bg-white py-4 px-3'>
            <div className='flex space-x-2 flex-wrap space-y-1'>
              {
                  groupMember.size > 0 && 
                  Array.from(groupMember).map(
                    (item)=><SelectMember  
                    handleRemoveMember={()=>handleRemoveMember(item)}
                    member={item} />)
              }
            </div>
          </div>


         </div> 
      )}
    </div>
  )
}

export default GroupCard