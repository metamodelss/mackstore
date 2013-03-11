package com.mackstore.utils.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateBeanConvert implements Converter   
{  
        @SuppressWarnings("rawtypes")
		public Object convert(Class arg0, Object arg1)   
    {  
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
          
        Date data = null;  
          
        try   
        {  
                        data = format.parse((String)arg1);  
                }   
        catch (ParseException e)   
        {  
            e.printStackTrace();  
        }  
          
        return data;  
    }  
  
}  
