package com.mackstore.utils.misc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {
	private String assunto, mensagem;
	private HostEmail host;
	private ArrayList<ContatoEmail> remetentes = new ArrayList<ContatoEmail>();
	private ArrayList<ContatoEmail> destinatarios = new ArrayList<ContatoEmail>();
	private ArrayList<AnexoEmail> anexos = new ArrayList<AnexoEmail>();

	public EnviaEmail(String assunto, String mensagem, ArrayList<ContatoEmail> destinatarios,
			HostEmail host) {
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.destinatarios = destinatarios;
		this.host = host;
	}
	
	public EnviaEmail(String assunto, String mensagem, ContatoEmail destinatario,
			HostEmail host) {
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.destinatarios.add(destinatario);
		this.host = host;
	}

	public boolean adicionaDestinatario(ContatoEmail destinatario) {
		return destinatarios.add(destinatario);
	}

	public boolean adicionaDestinatario(ArrayList<ContatoEmail> destinatarios) {
		return this.destinatarios.addAll(destinatarios);
	}
	
	public boolean adicionaRemetente(ContatoEmail remetente) {
		return remetentes.add(remetente);
	}

	public boolean adicionaRemetente(ArrayList<ContatoEmail> remetentes) {
		return this.remetentes.addAll(remetentes);
	}

	public boolean adicionaAnexo(AnexoEmail anexo) {
		return anexos.add(anexo);
	}

	/**
	 * envia email simples(somente texto)
	 * 
	 * @throws EmailException
	 */
	public void enviaEmailSimples() throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName(host.getNome()); // o servidor SMTP para envio do
											// e-mail
		for (int i = 0; i < destinatarios.size(); i++) {
			email.addTo(destinatarios.get(i).getEmail(), destinatarios.get(i)
					.getNome()); // destinatrio
		}
		for (int i = 0; i < remetentes.size(); i++) {
			email.setFrom(remetentes.get(i).getEmail(), remetentes.get(i)
					.getNome()); // remetente
		}
		email.setSubject(assunto); // assunto do e-mail
		email.setMsg(mensagem); // conteudo do
								// e-mail
		email.setAuthentication(host.getUsuario(), host.getSenha());
		email.setSmtpPort(host.getPorta());
		email.setSSL(host.isSsl());
		email.setTLS(host.isTls());
		email.send();
	}

	/**
	 * envia email com arquivo anexo
	 * 
	 * @throws EmailException
	 */
	public void enviaEmailComAnexo() throws EmailException {
		EmailAttachment anexosEnvio[] = new EmailAttachment[anexos.size()];
		for (int i = 0; i < anexos.size(); i++) {
			anexosEnvio[i].setDisposition(EmailAttachment.ATTACHMENT);
			anexosEnvio[i] = new EmailAttachment();
			anexosEnvio[i].setPath(anexos.get(i).getCaminho());
			anexosEnvio[i].setName(anexos.get(i).getNome());
		}

		// configura o email
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(host.getNome()); // o servidor SMTP para envio do
											// e-mail
		for (int i = 0; i < destinatarios.size(); i++) {
			email.addTo(destinatarios.get(i).getEmail(), destinatarios.get(i)
					.getNome()); // destinatrio
		}
		for (int i = 0; i < remetentes.size(); i++) {
			email.setFrom(remetentes.get(i).getEmail(), remetentes.get(i)
					.getNome()); // remetente
		}
		email.setSubject(assunto); // assunto do e-mail
		email.setMsg(mensagem); // conteudo do
								// e-mail
		email.setAuthentication(host.getUsuario(), host.getSenha());
		email.setSmtpPort(host.getPorta());
		email.setSSL(host.isSsl());
		email.setTLS(host.isTls());
		email.send();

		for (int i = 0; i < anexosEnvio.length; i++) {
			email.attach(anexosEnvio[i]);
		}
		// envia o email
		email.send();
	}
	public void enviaEmailFormatoHtml() throws EmailException,
			MalformedURLException {

		HtmlEmail email = new HtmlEmail();

		// adiciona uma imagem ao corpo da mensagem e retorna seu id
		URL url = new URL("http://www.kapcon.com.br/Kapcon/site/images/logo.png");
		String cid = email.embed(url, "Kapcon");

		StringBuilder msg = new StringBuilder();
		// configura a mensagem para o formato HTML
		msg.append("<html>");
		msg.append("<br />");
		msg.append("<br />");
		msg.append(mensagem);
		msg.append("<br />");
		msg.append("<br />");
		msg.append("<img style='width:150px;height:71px;' src=\"cid:");
		msg.append(cid);
		msg.append("\">");
		msg.append("<br />");
		msg.append("<br />");
		msg.append("<center><b>E-mail gerado automaticamente, <u>NO  NECESSRIO RESPOND-LO</u></b></center>");
		msg.append("</html>");
		email.setHtmlMsg(msg.toString());

		// configure uma mensagem alternativa caso o servidor no suporte HTML
		email.setTextMsg("Seu servidor de e-mail no suporta mensagem HTML");

		email.setHostName(host.getNome()); // o servidor SMTP para envio do e-mail

		for (int i = 0; i < destinatarios.size(); i++) {
			email.addTo(destinatarios.get(i).getEmail(), destinatarios.get(i)
					.getNome()); // destinatrio
		}
		for (int i = 0; i < remetentes.size(); i++) {
			email.setFrom(remetentes.get(i).getEmail(), remetentes.get(i)
					.getNome()); // remetente
		}
		email.setSubject(assunto); // assunto do e-mail
//		email.setMsg(mensagem); // conteudo
																		// do
																		// e-mail
		email.setAuthentication(host.getUsuario(), host.getSenha());
		email.setSmtpPort(host.getPorta());
		email.setSSL(host.isSsl());
		email.setTLS(host.isTls());
		// envia email
		email.send();
	}
	public void enviaEmailFormatoHtmlComAnexo() throws EmailException,
	MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		//ANEXOS
		EmailAttachment anexosEnvio[] = new EmailAttachment[anexos.size()];
		for (int i = 0; i < anexos.size(); i++) {
			anexosEnvio[i] = new EmailAttachment();
			anexosEnvio[i].setPath(anexos.get(i).getCaminho());
			anexosEnvio[i].setName(anexos.get(i).getNome());
		}
		for (int i = 0; i < anexosEnvio.length; i++) {
			email.attach(anexosEnvio[i]);
		}
		
		// adiciona uma imagem ao corpo da mensagem e retorna seu id
		URL url = new URL("http://www.kapcon.com.br/Kapcon/site/images/logo.png");
		String cid = email.embed(url, "Kapcon");
		
		StringBuilder msg = new StringBuilder();
		// configura a mensagem para o formato HTML
		msg.append("<html>");
		msg.append("<br />");
		msg.append("<br />");
		msg.append(mensagem);
		msg.append("<br />");
		msg.append("<br />");
		msg.append("<img style='width:150px;height:71px;' src=\"cid:");
		msg.append(cid);
		msg.append("\">");
		msg.append("<br />");
		msg.append("<br />");
		msg.append("<center><b>E-mail gerado automaticamente, <u>NO  NECESSRIO RESPOND-LO</u></b></center>");
		msg.append("</html>");
		email.setHtmlMsg(msg.toString());
		
		// configure uma mensagem alternativa caso o servidor no suporte HTML
		email.setTextMsg("Seu servidor de e-mail no suporta mensagem HTML");
		
		email.setHostName(host.getNome()); // o servidor SMTP para envio do e-mail
		
		for (int i = 0; i < destinatarios.size(); i++) {
			email.addTo(destinatarios.get(i).getEmail(), destinatarios.get(i)
					.getNome()); // destinatrio
		}
		for (int i = 0; i < remetentes.size(); i++) {
			email.setFrom(remetentes.get(i).getEmail(), remetentes.get(i)
					.getNome()); // remetente
		}
		email.setSubject(assunto); // assunto do e-mail
		//email.setMsg(mensagem); // conteudo
																		// do
																		// e-mail
		email.setAuthentication(host.getUsuario(), host.getSenha());
		email.setSmtpPort(host.getPorta());
		email.setSSL(host.isSsl());
		email.setTLS(host.isTls());
		// envia email
		email.send();
		}
}
