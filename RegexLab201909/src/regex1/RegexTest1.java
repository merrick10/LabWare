package regex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {
	
	public static String REGEX1_time = "(?<Time1>(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d))";
	public static String REGEX1_start1 = "" + REGEX1_time + "\\h+?(Bbaa ccdd QU).*?\r\n.*?(eeff ddgg)" + "";//取
	public static String REGEX1_start2 =  REGEX1_time + "\\h+?(AABB CC CUN:)" ;//00:11:22 AABB CC://存

	public static void main(String[] args) {//**无取款关键字时需要进一步处理
		// TODO Auto-generated method stub
		//Vector<String> vt = new Vector<String>();
		Vector<String> vt1 = new Vector<String>();//取
		Vector<String> vt2 = new Vector<String>();//存
		testReg1(REGEX1_start1,DataEntity1.STR3,vt1,vt2);
		for(String kname:vt1) {//首次,取出单纯1,或混合
			System.out.println(kname   + "\r\n");			
		}
		System.out.println("--------------------------------------------------");
		for(String kname:vt2) {//首次,取出单纯1,或混合
			System.out.println(kname   + "\r\n");			
		}
	}
	
	public static void testReg1(String regex,String str,Vector<String> vt1,Vector<String> vt2) {	//第一次匹配	(提取withdrawal)
		
		int count = 0;
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(str);
		int index1 = -1;
		String tm1 = "";
		int index2 = -1;
		
		while(m1.find()) {		
			
			index1 = m1.start("Time1");
			tm1 = m1.group("Time1");
			//System.out.println(index1 + " ==> " + tm1);
			index1 = m1.start();
			if(count==0) {//
				//检索deposit
				String sec_top = str.substring(0, index1);
				testReg2(REGEX1_start2,sec_top,vt2);				
			}
			if(count > 0) {				
				//System.out.println(str.substring(index2,index1));
				String sec = str.substring(index2,index1);
				int idx_tmp = testReg3(REGEX1_start2,sec);
				if(idx_tmp>-1) {
					vt1.add(sec.substring(0, idx_tmp));
					vt2.add(sec.substring(idx_tmp));
				}else {
					vt1.add(sec);
				}
				
			}			
			++count;
			index2 = index1;			
		}
		if(index2>-1) {
			//System.out.println(str.substring(index2));
			//vt1.put(tm1,str.substring(index2));
			String sec = str.substring(index2);
			int idx_tmp = testReg3(REGEX1_start2,sec);
			if(idx_tmp>-1) {
				vt1.add(sec.substring(0, idx_tmp));
				vt2.add(sec.substring(idx_tmp));
			}else {
				vt1.add(sec);
			}			
		}else {//无取款关键字,作单笔交易?
			System.out.println(str);
			
		}
	}
	
	public static void testReg2(String regex,String str,Vector<String> vt2) {	//存		
				
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(str);
		int index1 = -1;
		String tm1 = "";	
		
		if(m1.find()) {			
			index1 = m1.start("Time1");
			tm1 = m1.group("Time1");
			//vt2.put(tm1, str.substring(index1));	
			vt2.add(str.substring(index1));
		}		
	}
	
	public static int testReg3(String regex,String str) {
		
		int res = -1;
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(str);
		int index1 = -1;
		//String tm1 = "";	
		
		if(m1.find()) {			
			index1 = m1.start("Time1");		
			res = index1;
		}	
		return res;
	}

}
