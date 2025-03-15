package com.example.api_retrofit2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIService {
    @GET("categories.php")
    Call<List<Category>> getCategoriesAll();

}
