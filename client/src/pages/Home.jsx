import React, { useState } from 'react'
import { AiOutlineSearch } from 'react-icons/ai'
import { BiCommentDetail } from 'react-icons/bi'
import { BsEmojiSmile, BsFilter, BsMicFill, BsThreeDotsVertical } from 'react-icons/bs'
import { TbCircleDashed } from 'react-icons/tb'
import dashimg from '../assets/dashimg.jpg'
import ChatCard from '../Component/ChatCard'
import MessageCard from '../Component/MessageCard'
import { ImAttachment } from 'react-icons/im'
import "../index.css"
import Profile from './Profile'
import { useNavigate } from 'react-router-dom'
const Home = () => {

  const [query,setQuery] = useState("dd");
  const [content,setContent] = useState("");
  const navigate = useNavigate();
  const [isProfile,setIsProfile] = useState(false);
  const [currentChat , setCurrentChat] = useState(false);

  const handleChat =()=>{
    setCurrentChat(true);
  }
  
  const hadnleSearch =()=>{}

  const handleCreateMessage =()=>{}

  const handleNaviagetion=()=>
  {
    setCurrentChat(false)
    setIsProfile((prev)=>!prev)
  }

  return (
    <div className="relative">
      <div className="py-14 bg-[#00a884] w-full"></div>
        <div className="flex bg-[#f0f2f5] h-[90vh] absolute top-[5vh] left-[2vw] w-[90vw]">
          
            <div className="left w-[30%] bg-[#e8e9ec] h-full">

                   {/* profile */}
                   {isProfile && <Profile handleCloseProfile={handleNaviagetion}/>}

                              {/* Home */}
     {!isProfile && <div className="w-full">
             <div className="flex justify-between items-center p-3">
                   <div onClick={handleNaviagetion} 
                  className="flex items-center space-x-3">
                  <img 
                  className="rounded-full w-10 h-10 cursor-pointer" 
                  src="https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="" />
                  <p>username</p>
                  </div>
                <div className="space-x-3 text-2xl flex"> 
                  <TbCircleDashed  
                   className='cursor-pointer'
                   onClick={()=>navigate("/status")}/>
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
                <AiOutlineSearch className="left-5 top-6 absolute"/>
                <div>
                  <BsFilter className="ml-4 text-3xl"/>
                </div>
              </div>
              {/* All users */}
              <div className="bg-white overflow-y-scroll h-[76.8vh] px-4">
              { query && [1,2,3,4,5].map((i)=> 
              <div 
              key={i} 
              className="cursor-pointer mb-2"
              onClick={() =>handleChat()}> 
               <hr /> 
              <ChatCard />
              </div>)}
              </div>
              </div>}
            </div>
              {!currentChat && <div className="w-[70%] h-full flex flex-col items-center justify-center">
                 <div className="columns-1 w-full h-full border text-center">
                   <img className="m-auto mt-[3rem] h-[70%]" src={dashimg} alt="" />
                   <h1 className="text-4xl text-gray-600">Chat-App</h1>
                   <p className="my-9">Send and receive message</p>
                 </div>
              </div>}
              {/* Message part */}
              {
                currentChat && <div className="w-[70%] relative">
                    <div className="header absolute top-0 w-full bg-[#f0f2f5]">
                      <div className="flex justify-between">
                        <div className="py-3 flex space-x-4 items-center px-3"> 
                           <img
                           className="w-10 h-10 rounded-full" 
                           src="https://png.pngtree.com/png-vector/20220707/ourmid/pngtree-chatbot-robot-concept-chat-bot-png-image_5632381.png" alt="" />
                           <p>username</p>
                        </div>
                        <div className="py-3 flex space-x-4 items-center px-3">
                          <AiOutlineSearch/>
                          <BsThreeDotsVertical/>
                        </div>
                      </div>
                    </div>
                    {/* message sections */}
                    <div className="px-10 h-[85vh] overflow-y-scroll bg-blue-200">
                        <div className="space-y-1 flex flex-col justify-center  mt-20 py-2">
                          {[1,2,3,4,5].map((item,ind)=><MessageCard isReqMessage={ind%2==0} content={"messsagess"} />)}
                        </div>
                    </div>
                    {/* Footer part */}
                    <div className="footer bg-[#f0f2f5] bottom-0 w-full py-3 text-2xl">

                    <div className="flex justify-between item-center px-5 relative">
               
                            <BsEmojiSmile className="cursor-pointer"/>
                            <ImAttachment/>
                            <input type="text"
                            className="py-2 outline-none border-none bg-white pl-4 rounded-md w-[85%]" 
                            onChange={(e)=>setContent(e.target.value)}
                            value={content}
                            placeholder="Type Message"
                            onKeyPress={(e)=>{
                              if(e.key === "Enter")
                                {
                                  handleCreateMessage();
                                  setContent("")
                                }
                            }} />
                            <BsMicFill/>
                    </div>
                      
                    </div>
                </div>
              }
        </div>
      </div>
  )
}

export default Home