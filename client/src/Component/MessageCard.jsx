import React from 'react'

const MessageCard = ({isReqMessage , content}) => {
  return (
    <div className={`py-2 px-2 rounded-ml max-w-[50%] ${isReqMessage ?" self-start bg-white":"self-end bg-[#d9fdd3]" }`}>
      <p>{content}</p>
    </div>
  )
}

export default MessageCard