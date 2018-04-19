package com.zhouhe.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Before;
import org.junit.Test;

public class HttpTest {
	private static String saleReportServiceUrl = "http://192.168.12.233:8080/ReportServer/print";
	
	private static String request = "{\"pdfPath\":\"0012/100120000001\",\"dataSourceKey\":\"XSD00120000524_saleListOem20180319152349185122\",\"jasperFile\":\"saleListOem\",\"printData\":{\"status\":102,\"orderId\":\"XSD00120000524\",\"customerDepName\":\"南京大可实业有限公司_大可(123)\",\"customerName\":\"联系人\",\"customerAddress\":\"江苏省南京市下关区233\",\"telephone\":\"025-88888888\",\"saleTime\":\"2018-03-19 15:23:14\",\"saleDate\":null,\"promotionInfo\":null,\"comment\":null,\"saleAddress\":\"南京市江宁区友谊路116-17/18号\",\"phone\":\"025-85306152\",\"fax\":\"\",\"salesManName\":\"系统管理员\",\"departmentPrintname\":\"康众汽配连锁出库单\",\"aggregateAmount\":null,\"resultAmount\":\"15.55\",\"resultAmountALL\":\"15.55\",\"amountUpperChange\":\"壹拾伍圆伍角伍分\",\"amountUpperChangeALL\":\"壹拾伍圆伍角伍分\",\"expressExpense\":\"0.00\",\"packageExpense\":\"0.00\",\"url\":null,\"isPrintReport\":0,\"isHidePrice\":0,\"printOEM\":1,\"isPrint\":0,\"rightWrongStatus\":0,\"creditLimitUseableTag\":0,\"payStyle\":\"挂账\",\"customerId\":\"100120000001\",\"storageId\":\"0012\",\"storageNm\":\"南京中心仓库 \",\"storeSn\":null,\"loginUserDepId\":null,\"loginUserType\":null,\"sumCnt\":1,\"oneBarcodeUrl\":null,\"sidx\":\"create_time\",\"sord\":\"desc\",\"isErpPrint\":true,\"isPayAfter\":0,\"oemOrCy\":\"OEM\",\"toCheckSaleDetailListJsonStrList\":null,\"discountType\":0,\"discountValue\":\"\",\"discountFS\":\"\",\"promotionCount\":0,\"sumexpressExpense\":null,\"sumpackageExpense\":null,\"updateUserId\":null,\"qRCodeUrl\":null,\"printTime\":\"2018-03-19 15:23:47\",\"nickName\":null,\"accIdList\":null,\"promotionAccList\":null,\"storeSaleAccDetailList\":[{\"id\":6041113,\"orderId\":null,\"accId\":\"000005\",\"orderAmount\":1,\"promotionAmount\":0,\"checkAmount\":0,\"salePrice\":null,\"orderPrice\":15.55,\"itemAggregateAmount\":null,\"initPrice\":15.55,\"costPrice\":0.00,\"createDate\":null,\"createUserId\":null,\"updateDate\":null,\"updateUserId\":null,\"realCostPrice\":5.00,\"accountPriceType\":0,\"returnCount\":0,\"vehicleSystem\":\"雪佛兰Captiva [科帕奇]3.2,雪佛兰Captiva [科帕奇]2.4,欧宝Antara [安德拉]2.4,雪佛兰科帕奇2.4,欧宝Antara [安德拉]3.2,欧宝Antara [安德拉]2.0TD\",\"saleType\":0,\"no\":1,\"accName\":\"后刹车盘\",\"nickName\":\"测试哈哈哈哈\",\"accPp\":\"3M\",\"unitMin\":\"组\",\"totalPrice\":15.55,\"isUse\":\"1\",\"cyAccNo\":\"0986AB2838\",\"position\":\"A01-01-01\",\"oem\":\"cccc115\",\"remark\":null}],\"tableList\":null,\"giftList\":null,\"outerPrint\":false,\"lowPriceLimit\":true}}";
	private PoolingHttpClientConnectionManager cm  = null;

	@Before
	public void getPool() {
		cm = new PoolingHttpClientConnectionManager();
	    // 将最大连接数增加到200
	    cm.setMaxTotal(200);
	    // 将每个路由基础的连接增加到20
	    cm.setDefaultMaxPerRoute(20);
	    //将目标主机的最大连接数增加到50
	    //HttpHost localhost = new HttpPost(host)
	    //cm.setMaxPerRoute(new HttpRoute(localhost), 50);

	    CloseableHttpClient httpClient = HttpClients.custom()
	            .setConnectionManager(cm)
	            .build();
	}
	
	/**
	 * 使用连接池的
	 */
	@Test
	public void testUsePool() {
		
	}
	
	@Test
	public void testNotPool() throws IOException {
		HttpURLConnection urlConn = null;
		InputStream inStrm = null;
		try {
			System.out.println("销售打印服务器地址:" + saleReportServiceUrl);
			URL url = new URL(saleReportServiceUrl);
			urlConn = (HttpURLConnection) url.openConnection();
			// http请求连接参数
			urlConn.setConnectTimeout(10 * 1000);
			urlConn.setDoOutput(true);
			urlConn.setRequestMethod("POST");
			urlConn.setUseCaches(false);
			urlConn.setRequestProperty("contentType", "application/json");
			// 请求参数封装
			String value = request;
			long time1 = System.currentTimeMillis();
			urlConn.getOutputStream().write(value.getBytes());
			inStrm = urlConn.getInputStream();
			// 读取返回值内容
			BufferedReader br = new BufferedReader(new InputStreamReader(inStrm, "utf-8"));
			System.out.println(br.readLine());
			long time2 =System.currentTimeMillis();
			System.out.println(time2 - time1);
		
		} catch (Exception e) {
		} finally {
			if(inStrm != null){
				inStrm.close();
				inStrm = null;
			}

			if(urlConn != null){
				urlConn.disconnect();
				urlConn = null;
			}

		}
	}
}
