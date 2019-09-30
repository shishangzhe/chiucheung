package cn.chiucheung.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	public static void main(String[] args) {
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");  
		//String c = "(1+2)*3";
		String c = "4升/3桶";
		String pur = "3";
		String use = "5";
		String purUnit = "桶";
		String useUnit = "升";
		c = c.replace(purUnit, "");
		c = c.replaceAll(useUnit, "");
		String c1 = pur + "*" + c;
		String c2 = use + "/" + c;
		
		try {
			System.out.println(new BigDecimal(jse.eval(c1).toString()).setScale(2, RoundingMode.HALF_DOWN).toString());
			System.out.println(new BigDecimal(jse.eval(c2).toString()).setScale(2, RoundingMode.HALF_DOWN).toString());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		/*try {
			System.out.println(jse.eval(c));
		} catch (ScriptException e) {
			e.printStackTrace();
		}*/
	}
}
