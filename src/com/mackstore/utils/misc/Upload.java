package com.mackstore.utils.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.mackstore.admin.cad_foto.Foto;
import com.mackstore.admin.cad_foto.FotoDAO;
import com.sun.jmx.snmp.Timestamp;

public class Upload {
	public static boolean enviaArquivo(String caminho, Foto foto) throws IOException {
		boolean enviou = false;
		if (foto.getFile() == null) {
			return enviou;
		}
		//CRIA NOME DO ARQUIVO BASEADO NO GETTIME DO OBJ DATE + NOME DO ARQUIVO + EXTENSO DO ARQUIVO
		String nomeArq = new Timestamp().getDate().getTime()+"-"+foto.getFile().getFileName();
		nomeArq = nomeArq.replaceAll(" ", "_");
		foto.setArquivo(nomeArq);
		caminho+="/"+nomeArq;
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(caminho));
			//getFileData() para arquivos pequenos
			//getInputStream() para arquivos grandes
			out.write(foto.getFile().getFileData());
			enviou = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return enviou;
	}

	public static boolean deletaArquivo(String caminho, long id) throws IOException {
		boolean apagou = false;
		Foto foto = new FotoDAO().get(id);
		if (foto == null || foto.getArquivo() == null || foto.getArquivo().equals("")) {
			return apagou;
		}
		caminho+="\\"+foto.getArquivo();
		File file = new File(caminho);
		file.delete();
		apagou = true;
		return apagou;
	}
}
