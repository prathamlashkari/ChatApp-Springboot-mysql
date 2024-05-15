import React, { useEffect, useState } from 'react';
import { BsArrowBarLeft } from 'react-icons/bs';
import ProgressBar from '../Component/ProgressBar';
import { stories } from '../assets/constant';
import { AiOutlineClose } from 'react-icons/ai';
import { useNavigate } from 'react-router-dom';
const StateViewer = () => {
  const [currentStoryIndex , setCurrentStoryIndex] = useState(0);
  const [activeIndex , setActiveIndex] = useState(0);

  const navigate = useNavigate();

  const handleNextStory =()=>{
    if(currentStoryIndex < stories.length - 1)
      {
          setCurrentStoryIndex(currentStoryIndex+1);
          setActiveIndex(activeIndex+1);
      }
      else{
        setCurrentStoryIndex(0);
        setActiveIndex(0);
      }
  }
  const handleNavigate =()=>{
      navigate(-1);
  }
  useEffect(()=>{
      const intervalid = setInterval(() => {
        handleNextStory();
      }, 2000);
        return ()=>clearInterval(intervalid)
  },[currentStoryIndex])
  return (
    <div> 
      <div className='relative flex justify-center items-center h-[100vh] bg-slate-900'>
        <div className='relative'>
          <img  
          className='max-h-[96vh] object-contain' 
          src={stories?.[currentStoryIndex].image} alt="" />
          <div className='absolute top-0 flex w-full'>
              {
                stories.map((item , ind) => <ProgressBar 
                key={ind} 
                duration={2000} 
                index={ind} 
                activeIndex={activeIndex}/> )
              }
          </div>
        </div>
        <div>
          <BsArrowBarLeft 
          onClick={handleNavigate} 
          className='text-white text-4xl cursor-pointer absolute top-0 left-10'/>

          <AiOutlineClose 
          onClick={handleNavigate} 
          className='text-white text-4xl cursor-pointer absolute top-0 right-10'/>

        </div>
      </div>
    </div>
  )
}

export default StateViewer