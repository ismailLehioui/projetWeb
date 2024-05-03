package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import tn.enicarthage.plateforme.entities.Notification;


@Controller
public class NotificationController {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/demande")
	@SendTo("/responsable/demande")
	public void envoyerNotificationDemande(@Payload Notification notification) {
	
		simpMessagingTemplate.convertAndSend(notification);
		
	}

}
