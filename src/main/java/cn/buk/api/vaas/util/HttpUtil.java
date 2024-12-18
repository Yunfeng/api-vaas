package cn.buk.api.vaas.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.net.URLEncodedUtils;
import org.apache.hc.core5.util.Timeout;

/**
 * @author yfdai
 */
public class HttpUtil extends BaseHttpClient {


    public static String getUrl(String url, List<NameValuePair> params) {
        String uri = url;
        if (params != null) uri += URLEncodedUtils.format(params, StandardCharsets.UTF_8);

//        logger.debug(uri);

        CloseableHttpClient httpClient = createHttpClient();
        RequestConfig requestConfig = RequestConfig.custom().build();

        HttpGet httpGet = new HttpGet(uri);
        httpGet.setConfig(requestConfig);
        String rs = null;

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);

            Header h = response.getFirstHeader("Content-Type");
            if (h == null) {
                rs = unZipIt(response.getEntity().getContent());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));

                StringBuffer result = new StringBuffer();
                String line = null;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                rs = result.toString();
            }

            response.close();
        } catch (Exception ex) {
//            logger.error(ex.getMessage());
        }

        return rs;
    }

    public static void saveZipFile(CloseableHttpResponse response) throws IOException {
            //                assertStatus(response);//判断返回的code是否为200
            HttpEntity entity = response.getEntity();//从response里获取数据实体
            InputStream in = entity.getContent();//获取数据流
            Charset c = Charset.forName("UTF-8");
            ZipInputStream zin = new ZipInputStream(in, c);//封装成zip输入流
            BufferedOutputStream bos = null;
            ZipEntry ze;

            //文件存放地址
            String path = System.getProperty("java.io.tmpdir");
            File file = null;
            List<File> listFile = new ArrayList<>();
            try {
                while((ze = zin.getNextEntry()) != null) {//循环zip输入流，获取每一个文件实体
                    file = new File(path + ze.getName());//生成file（如果文件路径不存在，先创建）
                    FileOutputStream fos = new FileOutputStream(file);
                    int len;
                    byte [] bytes = new byte[2048];
                    bos = new BufferedOutputStream(fos,2048);
                    while((len = zin.read(bytes, 0, 2048)) != -1) {
                        bos.write(bytes, 0, len);
                    }
                    bos.flush();
                    bos.close();
                }
                zin.close();//关闭输入流
            } catch (Exception e) {
//                logger.error("异常 " + e);
            }
    }

//    public String unZipIt(String body) {
    public static String unZipIt(InputStream in) {
        byte[] buffer = new byte[2048];
        try {
//            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(body.getBytes()));
            ZipInputStream zis = new ZipInputStream(in);
            ZipEntry entry = zis.getNextEntry();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (entry != null) {
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }
                entry = zis.getNextEntry();
                baos.flush();
                baos.close();
            }
            zis.close();

            if (baos.toByteArray().length > 0)
                return new String(baos.toByteArray(), StandardCharsets.UTF_8);
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postUrl(final String url, final String content) {
        CloseableHttpClient httpClient = createHttpClient();

        RequestConfig requestConfig = RequestConfig.custom().build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        String rs = "";

        try {
            StringEntity entity = new StringEntity(content, StandardCharsets.UTF_8);
//            entity.setContentType("application/json");
            httpPost.setEntity(entity);



            CloseableHttpResponse response = httpClient.execute(httpPost);


            if (response.getCode() == HttpStatus.SC_OK) {
                rs = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

            response.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public static String postUrl(final String url, List<NameValuePair> nvps) {
        CloseableHttpClient httpClient = createHttpClient();

        RequestConfig requestConfig = RequestConfig.custom().build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        String rs = "";

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));


            CloseableHttpResponse response = httpClient.execute(httpPost);


            if (response.getCode() == HttpStatus.SC_OK) {
                rs = EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                rs = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

            response.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rs;
    }

}
