import React, { useEffect, useState } from 'react'
import {stories} from '../assets/constant'
import ProgressBar from '../Component/ProgressBar';
import { IoIosArrowBack } from 'react-icons/io';
const StateViewer = () => {
  const [currentStoryIndex , setCurrentStoryIndex] = useState(0);
  const [activeIndex , setActiveIndex] = useState(0);

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
  useEffect(()=>{
      const intervalid = setInterval(() => {
        handleNextStory();
      }, 2000);
        return ()=>clearInterval(intervalid)
  },[currentStoryIndex])
  return (
    <div> 
      <div className='flex justify-center items-center h-[100vh] bg-slate-900'>
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
          <IoIosArrowBack/>
        </div>
      </div>
    </div>
  )
}

export default StateViewer