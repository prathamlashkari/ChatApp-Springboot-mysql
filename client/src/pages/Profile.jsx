import React, { useState } from 'react'
import { BsArrowLeft, BsCheck2, BsPencil } from 'react-icons/bs'
import { useNavigate } from 'react-router-dom'

const Profile = ({handleCloseProfile}) => {

   const [flag , setFlag] = useState(false);
   const [username , setUserName] = useState("");

   const navigate = useNavigate();

    const handlePencil =()=>{
      setFlag(true)
    }
    const handleCheckHandler =()=>{
      setFlag(false)
    }
    const handleUserName =(e)=>{
      setUserName(e.target.value)
    }


  return (
    <div>
      <div className="flex items-center space-x-10 bg-[#008069] text-white pt-16 px-10 pb-5">
        <BsArrowLeft className="cursor-pointer text-2xl font-bold" 
        onClick={handleCloseProfile} />
        <p className="cursor-pointer font-semibold">Profile</p>
      </div>

      {/* update profile pic section */}
      <div className="flex flex-col justify-center items-center my-12">
        <label htmlFor="imgInput">
          <img className="rounded-full w-[15vw] h-[15vw] cursor-pointer" 
          src="https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="" />
        </label>
        <input type="file" id="imgInput" className="hidden" />
      </div>

      {/* name section */}
      <div className="bg-white px-3">
        <p className="py-3">Your Name</p>
        {
          !flag &&  <div className="w-full flex           justify-between items-center">
            <p className="py-3">{username|| "username" }</p>
            <BsPencil onClick={handlePencil} className="cursor-pointer"/>
          </div>
        }
        {
          flag && <div className=' flex justify-center w-full text-center py-2'>
            <input 
            onChange={(e)=>handleUserName(e)}
            className='w-[80%] outline-none border-b-2 border-blue-700 p-2'
            placeholder='Enter your name'
             type="text" />
             <BsCheck2  onClick={handleCheckHandler} className='cursor-pointer text-2xl'/>
          </div>
        }

      </div>
      <div className="px-3 my-5">
          <p className="py-10">This is not your username , This name will be visible to your whatapp contacts</p>
      </div>
    </div>
  )
}

export default Profile