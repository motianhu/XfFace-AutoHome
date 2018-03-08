package com.webservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.utils.biz.CryptoTools;

public class MainTestClient {

	private static final String PG = "NS201803060302";

	private static final boolean VRE_DEBUG_21 = true;
	private static final boolean VRE_DEBUG_22 = false;
	private static final boolean VRE_DEBUG_03 = false;
	private static final boolean VRE_DEBUG_FILE_PIC = false;
	private static final boolean VRE_DEBUG_FILE_PDF = false;
	private static final boolean VRE_DEBUG_FILE = VRE_DEBUG_FILE_PIC
			|| VRE_DEBUG_FILE_PDF;

	private static final boolean VRE_DEBUG_INVOKE = true;
	private static final boolean VRE_DEBUG_DECODE = false;

	public static void main(String args[]) {
		WebServiceImplService service = new WebServiceImplService();
		WebServiceImpl helloProxy = service.getWebServiceImplPort();
		CryptoTools tools = CryptoTools.getTools();
		String t = null;
		try {
			// t = tools.encode("xfsoft");
			t = tools.encode("hysoft");
			if (VRE_DEBUG_21) {
				vreBusinessFor21(helloProxy, tools, t);
			}
			if (VRE_DEBUG_22) {
				vreBusinessFor22(helloProxy, tools, t);
			}
			if (VRE_DEBUG_03) {
				vreBusinessFor03(helloProxy, tools, t);
			}
			if (VRE_DEBUG_FILE) {
				downloadFile(helloProxy, tools, t);
			}
			if (VRE_DEBUG_INVOKE) {
				doInvokeXianfeng(t);
			}
			if (VRE_DEBUG_DECODE) {
				decode(tools);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void vreBusinessFor21(WebServiceImpl helloProxy,
			CryptoTools tools, String t) throws Exception {
		String data = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime><Business id=\"21\">"
						+ "<pgdh>" + PG + "_alias</pgdh></Business></Request>");
		String hello = helloProxy.vreBusiness(t, data);
		try {
			hello = tools.decode(hello);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=======vreBusinessFor21===1====");
		System.out.println(hello);
		System.out.println("=======vreBusinessFor21====1===");
		data = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime><Business id=\"21\">"
						+ "<pgdh>" + PG + "</pgdh></Business></Request>");
		hello = helloProxy.vreBusiness(t, data);
		try {
			hello = tools.decode(hello);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=======vreBusinessFor21===2====");
		System.out.println(hello);
		System.out.println("=======vreBusinessFor21====2===");
	}

	private static void vreBusinessFor22(WebServiceImpl helloProxy,
			CryptoTools tools, String t) throws Exception {
		String data = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime><Business id=\"22\">"
						+ "<row><pgdh>"
						+ PG
						+ "</pgdh></row></Business></Request>");
		String hello = helloProxy.vreBusiness(t, data);
		try {
			hello = tools.decode(hello);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=======vreBusinessFor22=======");
		System.out.println(hello);
		System.out.println("=======vreBusinessFor22=======");
	}

	private static void vreBusinessFor03(WebServiceImpl helloProxy,
			CryptoTools tools, String t) throws Exception {
		String pic = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime><Business id=\"3\">"
						+ "<pgdh>" + PG + "</pgdh>" + "</Business></Request>");
		String data = pic;

		String hello = helloProxy.vreBusiness(t, data);
		try {
			hello = tools.decode(hello);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=======vreBusinessFor03=======");
		System.out.println(hello);
		System.out.println("=======vreBusinessFor03=======");
	}

	private static void downloadFile(WebServiceImpl helloProxy,
			CryptoTools tools, String t) throws Exception {
		String pic = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime>"
						+ "<pgdh>"
						+ PG
						+ "</pgdh><picname>source/upload/users/7/2016/03/05/szqf020/PG201603030039/56da4f385e1a2.jpg</picname></Request>");

		String pdf = tools
				.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><ID>24380003-6594-4059-847c-898989898</ID>"
						+ "<RequestTime>20150618092953</RequestTime>"
						+ "<pgdh>"
						+ PG
						+ "</pgdh><picname/><ReportType>pdf</ReportType></Request>");

		String data = VRE_DEBUG_FILE_PDF ? pdf : pic;

		byte[] bytes = helloProxy.downloadFile(t, data);

		System.out.println("=======downloadFile=======");
		System.out.println("=======bytes=======" + bytes);
		System.out.println("=======downloadFile=======");
		File outputFile = new File("PG201603030039.pdf");
		FileOutputStream outputFileStream = null;
		try {
			outputFileStream = new FileOutputStream(outputFile);
			outputFileStream.write(bytes);
			outputFileStream.flush();
			outputFileStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void doInvokeXianfeng(String sign) throws IOException {
		String link = "http://116.228.89.14:8066/XFTM/dfylServlet1?pgbh=" + PG
				+ "_alias&sige=" + sign;
		URL url = new URL(link);
		HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();
		httpClient.setDoOutput(true);
		httpClient.setRequestProperty("Content-type",
				"application/x-java-serialized-object");
		httpClient.setUseCaches(false);

		httpClient.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpClient.getInputStream()));
		System.out.println(" ============================= ");
		System.out.println(sign + "; Result: " + reader.readLine());
		System.out.println(" ============================= ");
		String lines;
		while ((lines = reader.readLine()) != null) {
			System.out.println(lines);
		}
		reader.close();

	}

	private static void decode(CryptoTools tools) {
		String str = "HwDUY8apiNlE4NYpiVkgcLLXAKjkuDqiKENv5yCPV9dwMAkKXsZIcx0c6VNarZAqHOzjn023LfVvXQ54ZWu9tDxvA6WPeB/6Or+H/I2YAeIkEw+csvGX258M6wZ1rFcus+wkFk3g1OUXHSAH0G0nif0GFy1bFCumhq7cgoWyqiJ2zPuKKBahxIKPkIK8cmCtwpOiNfPSOiapovBzlhK1Dlq/KHBe92IUo9qEi8LtyKaRE5wGu6R53mYBcjcgBrg9mpU4Xqtx9zgnFGZSQw1z/HdVqesR1w/MwKKJayiu3EHepHxAz7MtT/G8ARmKAzl3MEW5+8VujGShwaKU5GFSHPKDz7DsjfotigaKjz9XpraydC7Ac9LftPejbih6w+5QbhCvdrIgK90YR2/EEkQp/E6b+YctXvEaF1wJUyc2PWxmivB/2KwqjlmWkCV500Xa2q9IEJFO8fB9wwfGlMFSiwclg625QJ/AzmVALwrj/2+o7aUkbMX/cMkup6arQUv49bCVFiCwFmy/DbCTK12W7DLSBRAHitikILs4AMNxgW9fILlcj0QAfLkeR9H3z88u1qw3WE89TIka0yeb2W2Od2C1OTTFqbePjgdJNR/A6eQzbQpnlmZ68h4Ifz4wUfqO3dOuHehUGKVPKeHwVHTPjpHfEyWPhe1Pz3WKcKdeDcl7j8Sz4iW903NlHoUSQwdxsq1Ytt2EbLTYAdMUCS3GZelxMIQEDo+FViikM8MGsleqq8FGyX7QLXhptFZXguW4oGnCf14T/VLteq2uM+7YJGcMhoZV+obDCa5f9WRw6RioZYVuiipgG2o1c5QqmEnmbZwozDVjCFC15ujSu0vxXDXo/e5m7bLezM4UQfkIELcb6guEyR+spbyGwDLa042pjriciJeFRcFD+JJ04v2kLzRXSlW8De2T8uFLubvKflxnMuCLBfPq7cV0XSP9XE4yCAhWaxlGbwMo/EI2PiOwC+WW8luQ0kNIBtXt9Pxg6+PaLv/ENKNEvxRn5oWCscXfxHsiuM5B1DJFDEmoVHiXazDH0sktrC88kupet6MRLL1BdWJO6ZAhJu5KYJfZbo8woVBI2RVFd62y/IPKwZ7o1WCiFJn8dhuHRB4QqU5Pcf5C64/gI60cGGhOqqE4XVO/ak/V5DI/TZsXhZkwNVK8rfgpP64YaG+nd+qQfnRLsqKI53p2UwIHkBjMEDYjzWC5ve8P+okK8CLX83NL4TZJaI0xAjvJNRP8TNH+IxiFz3oXfkfesBsyfPya12yDigq7vJ4RY2AB9Xh/QbOkR/4wv4oMW2ouKl4AZIF/5eQGy7M9KxgHLzaDHTKXrWTuVTyMkfioW8ab+Q97i20aYeRZHIh0JJzMLuC2z40926EUrPeDGSw0XDjH+XlKp8SpidWR5TQSAy5uTIRDx/o1wR8HUOIg10i7+zBDMfh1An5MOQt5WbFT1TStBvRtMzMwcDERR6jCBmSHS6zehnwmoX3lzuymHidWzyXKwjoyNHhqvnEiWHa0nVToyMrrNB3U70GKK5Y/f1s8csg34mt4N2hYtpL0pmFVA4SGdueLGcR536JneIETZEedKirvYYW3iQEgmsV0lDsjPL3vUDUxrfGlyUBPnSzhy+64BMlqcwVYlWZl1nEazrwKOIbUMH+5hForUbIHDeB0OSB5zpZ13OGjlPVHNQDz5LhW1vrAU9mk3I8=";
		try {
			System.out.println(tools.decode(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
