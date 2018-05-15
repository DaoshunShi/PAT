package test.json;

//json = "[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101,0201\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101\",\"BASIC_ACTIVITYCONTENT\":\"基础\",\"EXPAND_ACTIVITYCONTENT\":\"\",\"MEMBERCOUNT\":12,\"COUNTS\":2222,\"DX\":222222,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201\",\"BASIC_ACTIVITYCONTENT\":\"\",\"EXPAND_ACTIVITYCONTENT\":\"扩展\",\"MEMBERCOUNT\":33333,\"COUNTS\":33333,\"DX\":33333,\"GZ\":3}]"
//json = "[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101,0201\",\"BASIC_ACTIVITYCONTENT\":\"基础\",\"EXPAND_ACTIVITYCONTENT\":\"扩展\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101\",\"BASIC_ACTIVITYCONTENT\":\"基础\",\"EXPAND_ACTIVITYCONTENT\":\"\",\"MEMBERCOUNT\":12,\"COUNTS\":2222,\"DX\":222222,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201\",\"BASIC_ACTIVITYCONTENT\":\"\",\"EXPAND_ACTIVITYCONTENT\":\"扩展\",\"MEMBERCOUNT\":33333,\"COUNTS\":33333,\"DX\":33333,\"GZ\":3}]"
public class Main {
	//json = "[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101,0201\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101\",\"BASIC_ACTIVITYCONTENT\":\"基础\",\"EXPAND_ACTIVITYCONTENT\":\"\",\"MEMBERCOUNT\":12,\"COUNTS\":2222,\"DX\":222222,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201\",\"BASIC_ACTIVITYCONTENT\":\"\",\"EXPAND_ACTIVITYCONTENT\":\"扩展\",\"MEMBERCOUNT\":33333,\"COUNTS\":33333,\"DX\":33333,\"GZ\":3}]"
	
	public static void main(String[] args) {
		System.out.println("hello");
//		String json = "[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101, 0103,0106,0201\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101\",\"BASIC_ACTIVITYCONTENT\":\"基础\",\"EXPAND_ACTIVITYCONTENT\":\"\",\"MEMBERCOUNT\":12,\"COUNTS\":2222,\"DX\":222222,\"GZ\":2}, {\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201\",\"BASIC_ACTIVITYCONTENT\":\"\",\"EXPAND_ACTIVITYCONTENT\":\"扩展\",\"MEMBERCOUNT\":33333,\"COUNTS\":33333,\"DX\":33333,\"GZ\":3}]";
		String json = "[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0101,0201\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\":2},{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0103\",\"MEMBERCOUNT\":8,\"COUNTS\":4,\"DX\":4,\"GZ\":4},{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201\",\"MEMBERCOUNT\":2,\"COUNTS\":1,\"DX\":1,\"GZ\":1},{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"ACTIVITYCONTENT\":\"0201,0205\",\"MEMBERCOUNT\":2,\"COUNTS\":1,\"DX\":1,\"GZ\":1},{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"四川北路街道\",\"ACTIVITYCONTENT\":\"0105,0205\",\"MEMBERCOUNT\":6,\"COUNTS\":1,\"DX\":5,\"GZ\":1}]";
		json = insertBasicExpandActivityContent(json);
		System.out.println(json);
	}
	
	/**
	 * 为现有Json格式数据添加basic_activityContent和expand_activityContent
	 * @param value
	 * @return
	 */
	private static String insertBasicExpandActivityContent(String value) {
		String result = "";
		
		String []values = value.split("ACTIVITYCONTENT\":\"");	//"[{\"AREANAME\":\"虹口区\",\"ORGANNAME\":\"虹口区\",\"        0101,0201\",\"MEMBERCOUNT\":12,\"COUNTS\":1,\"DX\":10,\"GZ\
		result = values[0];
		for (int i = 1; i < values.length; i++) {
			String[] temps = values[i].split("\"");
			String content = temps[0];
			String[] contents = getActivityContents(content);
			values[i] = "BASIC_ACTIVITYCONTENT\":\"" + contents[0] + "\",\"EXPAND_ACTIVITYCONTENT\":\"" + contents[1] + "\",\"ACTIVITYCONTENT\":\"" + values[i];
			result = result + values[i];
		}
		return result;
	}
	
	/**
	 * 用中文文本代替数字格式的活动内容
	 * @param activityContent
	 * @return result[0]为basic_activityContent, result[1]为expand_activityContent
	 */
	private static String[] getActivityContents(String activityContent) {
		String[] result = new String[2];
		result[0] = "";
		result[1] = "";
		String[] values = activityContent.split(",");
		for (int i=0; i<values.length; i++) {
			values[i]=values[i].replaceAll("\\s*", "");
			if (values[i].startsWith("01")) {
				result[0] = result[0] + ",B" + values[i];
			} else if (values[i].startsWith("02")) {
				result[1] = result[1] + ",E" + values[i];
			}
			
		}
		if (result[0].length() > 1)
			result[0] = result[0].substring(1);
		if (result[1].length() > 1) 
			result[1] = result[1].substring(1);
		
		return result;
	}
}
