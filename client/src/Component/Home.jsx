import React, { useState } from 'react'
import { AiOutlineSearch } from 'react-icons/ai'
import { BiCommentDetail } from 'react-icons/bi'
import { BsFilter } from 'react-icons/bs'
import { TbCircleDashed } from 'react-icons/tb'
import ChatCard from './ChatCard'
import dashimg from '../assets/dashimg.jpg'
const Home = () => {

  const [query,setQuery] = useState(null);
  const hadnleSearch =()=>{

  }
  return (
    <div className="relative">
      <div className="py-14 bg-[#00a884] w-full">
        <div className="flex bg-[#f0f2f5] h-[90vh] absolute top-6 left-6 w-full">
          
            <div className="left w-[30%] bg-[#e8e9ec] h-full">
              <div className="w-full">
              <div className="flex justify-between items-center p-3">
                  <div className="flex items-center space-x-3">
                  <img 
                  className="rounded-full w-10 h-10 cursor-pointer" 
                  src="https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="" />
                  <p>username</p>
                  </div>
                <div className="space-x-3 text-2xl flex"> 
                <TbCircleDashed/>
                <BiCommentDetail/></div>
              </div>
              <div className="relative flex justify-center items-center bg-white py-4 px-3">
                <input className="border-none outline-none bg-slate-200 rounded-md w-[93%] pl-9" type="text"
                placeholder="Search or start new chat"
                onChange={(e)=>{
                  setQuery(e.target.value)
                  hadnleSearch(e.target.value)
                }}
                value={query} />
                <AiOutlineSearch className="left-9 top-7 absolute"/>
                <div>
                  <BsFilter className="ml-4 text-3xl"/>
                </div>
              </div>
              {/* All users */}
              <div className="bg-white overflow-y-scroll h-[76.8vh] px-4">
              { [1,2,3,4,5].map((i)=> 
              <div> 
                <br/> 
              <ChatCard key={i}/>
              </div>)}
              </div>
              </div>
            </div>
                <div className="w-[70%] h-full flex flex-col items-center justify-center">
                 <div className="columns-1 w-full h-full border text-center">
                   <img className="m-auto mt-[3rem] h-[70%]" src={dashimg} alt="" />
                   <h1 className="text-4xl text-gray-600">Chat-App</h1>
                   <p className="my-9">Send and receive message</p>
                 </div>
              </div>
        </div>
      </div>
    </div>
  )
}

export default Home