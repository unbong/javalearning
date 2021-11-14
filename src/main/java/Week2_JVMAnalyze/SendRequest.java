package Week2_JVMAnalyze;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 *
 * 写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub。
 *作业6 必做
 *
 */
public class SendRequest {

    public static void main(String[] args) throws IOException {

        Request request = new Request.Builder()
                .url("http://www.google.com")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response resppnse = client.newCall(request).execute();

        String bodyContent = resppnse.body().string();

        System.out.println(bodyContent);
    }
}
