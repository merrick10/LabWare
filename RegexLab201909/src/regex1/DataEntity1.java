package regex1;

public class DataEntity1 {
	
	public static String STR1 = "==> 2019-09-05 11:11:11 TTTTT 1234\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:56 Bbaa ccdd QU\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"******************************\r\n" + 
			"12:34:57 Bbaa ccdd QU\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"*************************************\r\n" + 
			"00:11:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"***********************\r\n" + 
			"12:34:58 Bbaa ccdd QU\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"PPPPPPPPPPPPPPPPPPPPPPPPPP\r\n" + 
			"13:45:00 The End";
	
	public static String STR2 = "==>2019-09-05 11:11:12 TTTTT 1235\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"13:45:01 The End" + 
			"";

	public static String STR3 = "==>2019-09-05 11:11:12 TTTTT 1235\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"13:45:01 The End"; 
	
	public static String STR4 = "==>2019-09-05 11:11:12 TTTTT 1236\r\n"+
			"13:45:01 The End";
	public static String STR5 = "==>2019-09-05 11:11:12 TTTTT 1235\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU1\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj2\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj3\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU4\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU5\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj6\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU7\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU8\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"13:45:01 The End";
	
	public static String STR6 = "==>2019-09-05 11:11:12 TTTTT 1235\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU1\r\n" + 
			"	eeff ddgg failed\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj2\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj3\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU4\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU5\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj6\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU7\r\n" + 
			"	eeff ddgg failed\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"12:34:50 Bbaa ccdd QU8\r\n" + 
			"	eeff ddgg\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"XXXXX ZZZZZ\r\n" + 
			"11:22:33 NNNN MMM\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj9\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj10\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"12:34:50 Bbaa ccdd QU13\r\n" + 
			"	eeff ddgg failed\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"00:23:22 AABB CC CUN:failed\r\n" + 
			"fffffffffff jjjjjjjjjj11\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"12:34:50 Bbaa ccdd QU14\r\n" + 
			"	eeff ddgg failed\r\n" + 
			"XXXXX	XXXXXX YYYY\r\n" + 
			"00:23:22 AABB CC CUN:\r\n" + 
			"fffffffffff jjjjjjjjjj12\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"00:23:22 AABB CC CUN:failed\r\n" + 
			"fffffffffff jjjjjjjjjj12\r\n" + 
			"xxxxxxxxx\r\n" + 
			"00:12:11 UUUUUUU\r\n" + 
			"13:45:01 The End";
}
