package com.mackstore.admin.cad_admin;

import java.util.ArrayList;

import org.displaytag.decorator.TableDecorator;

public class ListDecorator extends TableDecorator {
	Admin admin;
	
	public ListDecorator() {
		super();
	}
/*
	public String startRow() {
		String inicio;
		inicio = "";
//		if (getIndex() % 2 == 0) {
//			inicio = "<tr><td>";
//		}
//		else {
//			inicio = "<tr style='first'><td>";
//		}
		return inicio;
	}
	public String finishRow() {
		String fim;
		//String fim = "</td></tr>";
		fim = "";
		return fim;
	}
*/
	public <T> int getIndex(){  
        @SuppressWarnings("unchecked")
		ArrayList<T> lista = (ArrayList<T>) getDecoratedObject();  
        return lista.indexOf(this.getCurrentRowObject());  
    }
	
	public String getEmail() {
		admin = (Admin) getCurrentRowObject();
		String email = "<a href=\"mailto:"+admin.getEmail()+"\">"+admin.getEmail()+ "</a>";
		return email;
	}
}
