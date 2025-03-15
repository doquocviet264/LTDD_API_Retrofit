package com.example.api_retrofit2;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    RecyclerView rcCate;
    CategoryAdapter categoryAdapter;
    APIService apiService;
    List<Category> categoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        AnhXa();
        GetCategory(); // Load dữ liệu cho category
    }

    private void AnhXa() {
        rcCate = findViewById(R.id.rc_category);
    }

    private void GetCategory() {
        // Gọi APIService
        apiService = RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getCategoriesAll().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    categoryList = response.body(); // Nhận danh sách dữ liệu
                    // Khởi tạo Adapter
                    categoryAdapter = new CategoryAdapter(RetrofitActivity.this, categoryList);
                    rcCate.setHasFixedSize(true);

                    // Cấu hình LayoutManager
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                            getApplicationContext(),
                            LinearLayoutManager.HORIZONTAL,
                            false
                    );
                    rcCate.setLayoutManager(layoutManager);
                    rcCate.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                } else {
                    int statusCode = response.code();
                    // Xử lý lỗi dựa vào statusCode
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("Lỗi", t.getMessage());
            }
        });
    }


}

