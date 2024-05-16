import React, { useState } from 'react'

const Signin = () => {

  const [inputData , setInputData] = useState({email:"",password:""});
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
            type="email"
            placeholder='Enter your Email'
            onChange={handleChange}
            value={inputData.email}
            className='py-2 outline outline-green-600 w-full rounded-md border' />
          </div>
          <div>
            <p className='ab-2'>Email</p>
            <input 
            type="password"
            placeholder='Enter your password'
            onChange={handleChange}
            value={inputData.password}
            className='py-2 outline outline-green-600 w-full rounded-md border' />
          </div>
        </form>
      </div>
    </div>
  
   </div>
  )
}

export default Signin