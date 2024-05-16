import React, { useState } from 'react'

const Signin = () => {

  const [inputData , setInputData] = useState();
  const handleSubmit =()=>{
    console.log("handle submit")
  }
  const handleChange =()=>{}

  return (
   <div>
     <div className='flex justify-center h-screen items-center'>
      <div className='w-[30%] p-10 shadow bg-white'>
        <form action="" className='space-y-5'>
          <div>
            <p className='ab-2'>Email</p>
            <input 
            type="text"
            placeholder='Enter your Email'
            onChange={handleChange}
            className='py-2 outline outline-green-600 w-full rounded-md border' />
          </div>
        </form>
      </div>
    </div>
  
   </div>
  )
}

export default Signin