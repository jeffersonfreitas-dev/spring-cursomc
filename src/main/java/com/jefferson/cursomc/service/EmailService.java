package com.jefferson.cursomc.service;

import org.springframework.mail.SimpleMailMessage;

import com.jefferson.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	void sendEmail(SimpleMailMessage msg);

}
