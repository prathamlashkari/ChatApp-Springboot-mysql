import { Button } from '@mui/material';
import { green } from '@mui/material/colors';
import React, { useState} from 'react'
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const Signin = () => {

  const [inputData , setInputData] = useState({email:"",password:""});
  const navigate = useNavigate();
  const handleSubmit =(e)=>{
    e.preventDefault();
    toast("Login Successfully")
    console.log("handle submit")
  }
  const handleChange = (e) => {
    const { name, value } = e.target;
    setInputData(prevState => ({
      ...prevState,
      [name]: value
    }));
  }
  return (
   <div>
     <div className='flex justify-center h-screen items-center'>
      <div className='w-[30%] p-10 shadow bg-white'>
        <form action="" className='space-y-5' onSubmit={(e)=>handleSubmit(e)}>
          <div>
            <p className='ab-2'>Email</p>
            <input 
            type="email"
            placeholder='Enter your Email'
            onChange={(e)=>handleChange(e)}
            value={inputData.email}
            name='email'
            className='py-2 outline outline-green-600 w-full rounded-md border' />
          </div>
          <div>
            <p className='ab-2'>Email</p>
            <input 
            type="password"
            placeholder='Enter your password'
            name='password'
            onChange={(e)=>handleChange(e)}
            value={inputData.password}
            className='py-2 outline outline-green-600 w-full rounded-md border' />
          </div>
          <div>
            <Button type='submit' 
            sx={{
              bgcolor:green[700],
              padding:".5rem 0rem"
            }} className='w-full bg-green-600' variant='contained' >SignIn</Button>
          </div>
        </form>

        <div className='flex space-x-3 items-center mt-5'>
            <p className=''>Create a New account</p>
            <Button variant="text" onClick={()=>navigate("/signup")}>SignUp</Button>
        </div>
      </div>
    </div>
  
   </div>
  )
}

export default Signin