package xrayToken;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TokenFailV2 {
    public static void main(String[] args) throws IOException {
        String endpoint = "https://xray.cloud.getxray.app/api/v1/import/execution";
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJmNTBmMTdjOC00OTIyLTMwZjQtOGY1Mi0zYzc3MzcwODMxODAiLCJhY2NvdW50SWQiOiI2M2Y0YTIwNGUyYzRjNjkyYzk3Nzk5NGYiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY3ODg4MzUyOSwiZXhwIjoxNjc4OTY5OTI5LCJhdWQiOiJDRTRCRTEzNDlGNjc0QUMxQjQ0OUY1M0NERjI1Rjk1OCIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IkNFNEJFMTM0OUY2NzRBQzFCNDQ5RjUzQ0RGMjVGOTU4In0.TLk4EDPc45pc3jrSCrKGYIFNOfj2dljM_B4eRU6_-dQ";

        JSONObject requestBody = createRequestBody();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS) // Bağlantı zaman aşımı süresi
                .readTimeout(30, TimeUnit.SECONDS)    // Okuma zaman aşımı süresi
                .writeTimeout(30, TimeUnit.SECONDS)   // Yazma zaman aşımı süresi
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(endpoint)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        JSONObject jsonResponse = new JSONObject(responseBody);

        if (response.isSuccessful()) {
            System.out.println("Test execution created with key: " + jsonResponse.getString("key"));
        } else {
            System.out.println("Error creating test execution: " + jsonResponse.getString("error"));
        }
    }

    private static JSONObject createRequestBody() {
        JSONObject requestBody = new JSONObject();
        JSONObject info = createInfo();
        requestBody.put("info", info);
        JSONArray tests = createTests();
        requestBody.put("tests", tests);

        return requestBody;
    }

    private static JSONObject createInfo() {
        JSONObject info = new JSONObject();
        info.put("summary", "Execution of automated tests for release");
        info.put("description", "This execution is automatically created when importing execution results from an external source");
        info.put("startDate", "2023-09-03T11:37:00+03:00");
        info.put("finishDate", "2023-09-04T11:50:00+03:00");

        return info;
    }

    private static JSONArray createTests() {
        JSONArray tests = new JSONArray();
        for (int i = 2; i <= 24; i++) {
            tests.put(createTest(i));
        }
        return tests;
    }

    private static JSONObject createTest(int testNumber) {
        JSONObject test = new JSONObject();
        test.put("testKey", "UP-" + testNumber);
        test.put("start", "2023-09-03T11:37:00+03:00");
        test.put("finish", "2023-09-04T11:50:00+03:00");
        test.put("comment", "Successful execution" + (testNumber - 1));
        test.put("status", "FAILED");

        return test;
    }
}