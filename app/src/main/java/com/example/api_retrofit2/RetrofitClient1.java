package com.example.api_retrofit2;

import static com.example.api_retrofit2.BaseClient.createService;

public class RetrofitClient1 {
    private static final String BASE_URL = "http://app.iotstar.vn/appfoods/";
    private static APIService apiService;

    public static APIService getInstance() {
        if (apiService == null) {
            apiService = createService(APIService.class, BASE_URL);
        }
        return apiService;
    }
}
