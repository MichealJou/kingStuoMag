/*
 *	History				Who				What
 *  2014-3-15			zwj			Created.
 */
package com.cn.demo.utils;

/**
 * Title: TRS ����Э��ƽ̨��TRS WCM�� <BR>
 * Description: <BR>
 * TODO <BR>
 * Copyright: Copyright (c) 2004-2014 �����ض�˼��Ϣ�����ɷ����޹�˾ <BR>
 * Company: www.trs.com.cn <BR>
 * 
 * @author zwj
 * @version 1.0
 */
public class CMyStr {
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0)))
                .append(s.substring(1)).toString();
    }

    /**
     * �ж��ַ����ı���
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    /**
     * �ж�ָ���ַ����Ƿ�Ϊ��
     * Add By Vincent on 2015-05-03
     * @param _string
     *            ָ�����ַ���
     * @return ���ַ���Ϊ�ն���_string==null����մ�������Ϊ0�����򷵻�true�����򣬷���false.
     */
    public static boolean isEmpty(String _string) {
        return ((_string == null) || (_string.trim().length() == 0));
    }

    /**
     * У���ַ����Ƿ�Ϊ�����ַ���
     * @param _string ��У���ַ���
     * @return У���Ƿ�ͨ��
     */
    public static boolean isNum(String _string){

        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match=pattern.matcher(_string);

        return match.matches();
    }

}
