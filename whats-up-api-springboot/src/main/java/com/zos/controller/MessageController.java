package com.zos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zos.controller.mapper.MessageDtoMapper;
import com.zos.dto.MessageDto;
import com.zos.exception.ChatException;
import com.zos.exception.MessageException;
import com.zos.exception.UserException;
import com.zos.modal.Message;
import com.zos.modal.User;
import com.zos.request.SendMessageRequest;
import com.zos.response.ApiResponse;
import com.zos.service.MessageService;
import com.zos.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<MessageDto> sendMessageHandler(@RequestHeader("Authorization")String jwt,  @RequestBody SendMessageRequest req) throws UserException, ChatException{
		
		User reqUser=userService.findUserProfile(jwt);
		
		req.setUserId(reqUser.getId());
		
		Message message=messageService.sendMessage(req);
		
		MessageDto messageDto=MessageDtoMapper.toMessageDto(message);
		
		return new ResponseEntity<MessageDto>(messageDto,HttpStatus.OK);
	}
	
	@GetMapping("/chat/{chatId}")
	public ResponseEntity<List<MessageDto>> getChatsMessageHandler(@PathVariable Integer chatId) throws ChatException{
		
		List<Message> messages=messageService.getChatsMessages(chatId);
		
		List<MessageDto> messageDtos=MessageDtoMapper.toMessageDtos(messages);
		
		return new ResponseEntity<List<MessageDto>>(messageDtos,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{messageId}")
	public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId) throws MessageException{
		
		messageService.deleteMessage(messageId);
		
		ApiResponse res=new ApiResponse("message deleted successfully",true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
