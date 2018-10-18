package br.ce.igormicael.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataUtils {
	
	public static Date obterDataComDiferencaDias(int dias) {
		LocalDate localDate = LocalDate.now().plusDays(dias);
		
		Date dataRetorno = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return dataRetorno;
		
	}
	
	public static String obterDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		return format.format(data);
	}

}
