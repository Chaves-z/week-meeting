package com.hirain.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;

/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author zhengchangwei
 *
 */
public class Common {

	/**
	 * 获取前端传来的参数
	 * 
	 * @return
	 */

	public static HashMap<String, Object> getParams() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Enumeration<String> en = request.getParameterNames();
		HashMap<String, Object> map = new HashMap<>();

		while (en.hasMoreElements()) {
			// 获取参数名
			String name = en.nextElement();

			// 单个参数
			String value = request.getParameter(name);
			if (!Common.isEmpty(value)) {
				map.put(name, value);
			}
		}

		return map;
	}

	/**
	 * 给T重新赋值
	 * 
	 * @param t
	 *            实体类
	 * 
	 * @param params
	 *            T属性名和值对应的键值对
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <T> T flushObject(T t, Map<String, Object> params) throws IllegalArgumentException, IllegalAccessException {

		if (params != null && t != null) {
			for (Class<? extends Object> clazz = t.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {

				// getFields()只能获取public的字段，包括父类的。而getDeclaredFields()只能获取自己声明的各种字段，包括public，protected，private。
				Field[] fields = clazz.getDeclaredFields();

				for (int i = 0; i < fields.length; ++i) {

					String name = fields[i].getName();
					String[] split = fields[i].getType().getName().split("\\.");
					Object value = params.get(name);

					if (value != null && !"".equals(value)) {
						fields[i].setAccessible(true);// AccessibleTest类中的成员变量为private,故必须进行此操作
						if (split[split.length - 1].equals("Integer")) {
							value = Integer.valueOf(value.toString());
						}
						fields[i].set(t, value);
					}
				}

			}

			return t;
		} else {
			return t;
		}
	}

	/**
	 * 判断一个字符串是否为空
	 * 
	 * @param s
	 *            字符串
	 * 
	 * @return
	 */
	public static boolean isEmpty(String s) {

		return s == null || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s);
	}

	public static double convertSourData(String dataStr) throws Exception {

		if (dataStr != null && !"".equals(dataStr)) {
			return Double.valueOf(dataStr).doubleValue();
		} else {
			throw new NumberFormatException("convert error!");
		}
	}

	public static boolean isNotEmpty(String s) {

		return s != null && !"".equals(s) && !"".equals(s.trim()) && !"null".equalsIgnoreCase(s);
	}

	public static String fromUsage(long free, long total) {

		Double d = Double.valueOf((new BigDecimal(free * 100L / total)).setScale(1, 4).doubleValue());
		return String.valueOf(d);
	}

	public static String formatDouble(Double b) {

		BigDecimal bg = new BigDecimal(b.doubleValue());
		return bg.setScale(2, 4).toString();
	}

	public static String fromDateH() {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(new Date());
	}

	public static String fromDateY() {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(new Date());
	}

	public static List<String> removeSameItem(List<String> list) {

		ArrayList<String> difList = new ArrayList<>();
		Iterator<String> arg2 = list.iterator();

		while (arg2.hasNext()) {
			String t = (String) arg2.next();
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}

		return difList;
	}

	public static String toIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	public static String generateFileName(String fileName) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = (new Random()).nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	public static String getInputHtmlUTF8(String urlStr) {

		URL url = null;

		try {
			url = new URL(urlStr);
			HttpURLConnection e = (HttpURLConnection) url.openConnection();
			e.setRequestMethod("GET");
			e.setConnectTimeout(5000);
			e.connect();
			if (e.getResponseCode() == 200) {
				InputStream inputStream = e.getInputStream();
				String data = readHtml(inputStream, "UTF-8");
				inputStream.close();
				return data;
			} else {
				return null;
			}
		} catch (Exception arg4) {
			return null;
		}
	}

	public static String getInputHtmlGBK(String urlStr) {

		URL url = null;

		try {
			url = new URL(urlStr);
			HttpURLConnection e = (HttpURLConnection) url.openConnection();
			e.setRequestMethod("GET");
			e.setConnectTimeout(5000);
			e.connect();
			if (e.getResponseCode() == 200) {
				InputStream inputStream = e.getInputStream();
				String data = readHtml(inputStream, "GBK");
				inputStream.close();
				return data;
			} else {
				return null;
			}
		} catch (Exception arg4) {
			arg4.printStackTrace();
			return null;
		}
	}

	public static String readHtml(InputStream inputStream, String uncode) throws Exception {

		InputStreamReader input = new InputStreamReader(inputStream, uncode);
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();

		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line);
		}

		return contentBuf.toString();
	}

	public static byte[] readInputStream(InputStream inputStream) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];

		try {
			int len1;
			while ((len1 = inputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, len1);
			}

			return byteArrayOutputStream.toByteArray();
		} catch (IOException arg12) {
			arg12.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException arg11) {
				arg11.printStackTrace();
				return null;
			}
		}

		return null;
	}

	public static String findUserSessionId(HttpServletRequest request) {

		Object obj = request.getSession().getAttribute("userSessionId");
		return obj != null ? obj.toString() : null;
	}

	public static Object findUserSession(HttpServletRequest request) {

		return request.getSession().getAttribute("userSession");
	}

	public static double sub(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static double div(double v1, double v2) {

		return div(v1, v2, 10);
	}

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		} else {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.divide(b2, scale, 4).doubleValue();
		}
	}

	// public static String trimComma(String para) {
	// return StringUtils.isNotBlank(para) ? (para.endsWith(",") ?
	// para.substring(0, para.length() - 1) : para) : "";
	// }

	public static String htmltoString(String content) {

		if (content == null) {
			return "";
		} else {
			String html = content.replace("\'", "&apos;");
			html = html.replaceAll("&", "&amp;");
			html = html.replace("\"", "&quot;");
			html = html.replace("\t", "&nbsp;&nbsp;");
			html = html.replace(" ", "&nbsp;");
			html = html.replace("<", "&lt;");
			html = html.replaceAll(">", "&gt;");
			return html;
		}
	}

	public static String stringtohtml(String content) {

		if (content == null) {
			return "";
		} else {
			String html = content.replace("&apos;", "\'");
			html = html.replaceAll("&amp;", "&");
			html = html.replace("&quot;", "\"");
			html = html.replace("&nbsp;&nbsp;", "\t");
			html = html.replace("&nbsp;", " ");
			html = html.replace("&lt;", "<");
			html = html.replaceAll("&gt;", ">");
			return html;
		}
	}

	public static boolean isNumeric1(String str) {

		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static Set<Class<?>> getClasses(String pack) {

		LinkedHashSet<Class<?>> classes = new LinkedHashSet<>();
		boolean recursive = true;
		String packageName = pack;
		String packageDirName = pack.replace('.', '/');

		try {
			Enumeration<?> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

			while (true) {
				label65: while (dirs.hasMoreElements()) {
					URL e = (URL) dirs.nextElement();
					String protocol = e.getProtocol();
					if ("file".equals(protocol)) {
						String jar1 = URLDecoder.decode(e.getFile(), "UTF-8");
						findAndAddClassesInPackageByFile(packageName, jar1, recursive, classes);
					} else if ("jar".equals(protocol)) {
						try {
							JarFile jar = ((JarURLConnection) e.openConnection()).getJarFile();
							Enumeration<?> e1 = jar.entries();

							while (true) {
								JarEntry entry;
								String name;
								int idx;
								do {
									do {
										if (!e1.hasMoreElements()) {
											continue label65;
										}

										entry = (JarEntry) e1.nextElement();
										name = entry.getName();
										if (name.charAt(0) == 47) {
											name = name.substring(1);
										}
									} while (!name.startsWith(packageDirName));

									idx = name.lastIndexOf(47);
									if (idx != -1) {
										packageName = name.substring(0, idx).replace('/', '.');
									}
								} while (idx == -1 && !recursive);

								if (name.endsWith(".class") && !entry.isDirectory()) {
									String className = name.substring(packageName.length() + 1, name.length() - 6);

									try {
										classes.add(Class.forName(packageName + '.' + className));
									} catch (ClassNotFoundException arg14) {
										arg14.printStackTrace();
									}
								}
							}
						} catch (IOException arg15) {
							arg15.printStackTrace();
						}
					}
				}

				return classes;
			}
		} catch (IOException arg16) {
			arg16.printStackTrace();
			return classes;
		}
	}

	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {

		File dir = new File(packagePath);
		if (dir.exists() && dir.isDirectory()) {
			File[] dirfiles = dir.listFiles(new FileFilter() {

				public boolean accept(File file) {

					return recursive && file.isDirectory() || file.getName().endsWith(".class");
				}
			});
			File[] arg8 = dirfiles;
			int arg7 = dirfiles.length;

			for (int arg6 = 0; arg6 < arg7; ++arg6) {
				File file = arg8[arg6];
				if (file.isDirectory()) {
					findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
				} else {
					String className = file.getName().substring(0, file.getName().length() - 6);

					try {
						classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
					} catch (ClassNotFoundException arg11) {
						arg11.printStackTrace();
					}
				}
			}

		}
	}

	/**
	 * 判断传入参数,如果是Null或者空值，返回false，不为空返回true
	 * @author three
	 * @param checkAll   True:所有的为空才返回,False:只要有一个为空返回
	 * @param strings
	 * @return
	 */
	public static Boolean checkIsStrOrNull(Boolean checkAll, Object... objects) {

		Boolean ret = true;
		if (objects == null)
			return false;
		for (Object s : objects) {
			if (null == s || ("").equals(s.toString().trim()) || ("null").equals(s.toString().trim()) || ("NULL").equals(s.toString().trim())) {
				if (!checkAll)
					return false;
				else {
					ret = false;
				}
			}
		}
		return ret;
	}

	public static String readFileByLines(String fileName) {

		File file = new File(fileName);
		BufferedReader br = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 一次读一个字节
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String tempbyte;
			while ((tempbyte = br.readLine()) != null) {
				buffer.append(tempbyte);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
				}
			}
		}
		return buffer.toString();
	}

	public static void writePlace(String fileName, String content) {

		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
