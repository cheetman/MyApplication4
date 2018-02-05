package com.example.sychiprpclibmcc.bean;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * Title: BeanInvoke<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class BeanInvoke {
  
   
    public static Map<String, Object> getFieldValueMap(Object bean, String parentName, Map<String, Object> valueMap) {  
        if(bean == null){
        	return new HashMap<String, Object>(); 
        }
    	Class<?> cls = bean.getClass();   
        if(parentName == null){
        	parentName = "";  
        }
        if(valueMap == null){
        	valueMap = new HashMap<String, Object>();  
        }
        // 取出bean里的扄1�7有方泄1�7  
        Method[] methods = cls.getMethods();
        List<Field> listFld = new  ArrayList<Field>();
//        Field[] fields = cls.getDeclaredFields();  
//        for (Field field : fields) {  
//        	listFld.add(field);
//        }
  
        for (;!cls.equals(Object.class); cls = cls
                .getSuperclass()) {
            Field[] field = cls.getDeclaredFields();
            for(Field f : field){
            	listFld.add(f);
            }
        }
        cls = bean.getClass();  
        for (Field field : listFld) {  
            try {  
                String fieldType = field.getType().getSimpleName();  
                String fieldGetName = parGetName(field.getName()); 
                if (!checkGetMet(methods, fieldGetName) && !checkGetMet(methods, fieldGetName.replace("get", "is"))) {  
                    continue;  
                }  
                Method fieldGetMet;
                Object fieldVal;
                if ("boolean".equals(fieldType)){
                      fieldGetMet = cls.getMethod(fieldGetName.replace("get", "is"), new Class[] {});  
                      fieldVal = fieldGetMet.invoke(bean, new Object[] {});  
                }else{
                      fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});  
                      fieldVal = fieldGetMet.invoke(bean, new Object[] {});  
                }
                String result = null;  
                if ("Date".equals(fieldType)) {  
                    result = fmtDate((Date) fieldVal);  
                  String key =  field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    valueMap.put(parentName+".get"+key+"()", result);  
                } else if ("boolean".equals(fieldType) || "int".equals(fieldType) || "long".equals(fieldType) || "Integer".equals(fieldType) || "String".equals(fieldType)) {   
                    if (null != fieldVal) {  
                        result = String.valueOf(fieldVal);  
                    }  
                  String key =  field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    valueMap.put(parentName+".get"+key+"()", result); 
                }else if ("List".equals(fieldType)) {  
                	if(fieldVal == null){

                        String key =  field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                          valueMap.put(parentName+".get"+key+"()", null); 
                       
                	}else{

                    	@SuppressWarnings("unchecked")
						List<Object> list = (List<Object>) fieldVal;
                        String key =  field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    	for(int i = 0 ; i < list.size() ; i ++){
                    		Object obj = list.get(i);
                    		if (obj instanceof Integer || obj instanceof String) {  
                    			list.toString();
                                valueMap.put(parentName+".get"+key+"()", list.toString()); 
                               break;
                            }else{
                            	getFieldValueMap(obj,parentName+".get"+key+"("+i+")",valueMap );
                            }
                    	}
                	}
                }else{
                    String key =  field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                	
                	getFieldValueMap(fieldVal,parentName+".get"+key+"()",valueMap );
                }
            } catch (Exception e) {  
                continue;  
            }  
        }  
        return valueMap;  
  
    }  
  
    public static void setFieldValue(Object bean, Map<String, String> valMap) {  
        Class<?> cls = bean.getClass();  
        Method[] methods = cls.getDeclaredMethods();  
        Field[] fields = cls.getDeclaredFields();  
  
        for (Field field : fields) {  
            try {  
  
                String fieldSetName = parSetName(field.getName());  
                if (!checkSetMet(methods, fieldSetName)) {  
                    continue;  
                }  
                Method fieldSetMet = cls.getMethod(fieldSetName, field  
                        .getType());  
                String value = valMap.get(field.getName());  
                if (null != value && !"".equals(value)) {  
                    String fieldType = field.getType().getSimpleName();  
                    if ("String".equals(fieldType)) {  
                        fieldSetMet.invoke(bean, value);  
                    } else if ("Date".equals(fieldType)) {  
                        Date temp = parseDate(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Integer".equals(fieldType)  
                            || "int".equals(fieldType)) {  
                        Integer intval = Integer.parseInt(value);  
                        fieldSetMet.invoke(bean, intval);  
                    } else if ("Long".equalsIgnoreCase(fieldType)) {  
                        Long temp = Long.parseLong(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Double".equalsIgnoreCase(fieldType)) {  
                        Double temp = Double.parseDouble(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Boolean".equalsIgnoreCase(fieldType)) {  
                        Boolean temp = Boolean.parseBoolean(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else {  
//                        System.out.println("not supper type" + fieldType);  
                    }  
                }  
            } catch (Exception e) {  
                continue;  
            }  
        }  
  
    }  
  
    public static Date parseDate(String datestr) {  
        if (null == datestr || "".equals(datestr)) {  
            return null;  
        }  
        try {  
            String fmtstr = null;  
            if (datestr.indexOf(':') > 0) {  
                fmtstr = "yyyy-MM-dd HH:mm:ss";  
            } else {  
  
                fmtstr = "yyyy-MM-dd";  
            }  
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);  
            return sdf.parse(datestr);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    public static String fmtDate(Date date) {  
        if (null == date) {  
            return null;  
        }  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  
                    Locale.US);  
            return sdf.format(date);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {  
        for (Method met : methods) {  
            if (fieldSetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {  
        for (Method met : methods) {  
            if (fieldGetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
    public static String parGetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "get" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }  
  
    public static String parSetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "set" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }  
  

}
