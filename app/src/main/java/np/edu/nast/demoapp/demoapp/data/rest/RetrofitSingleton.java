package np.edu.nast.demoapp.demoapp.data.rest;

import np.edu.nast.demoapp.demoapp.data.ApiService;
import np.edu.nast.demoapp.demoapp.urlhelper.UrlHelper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static RetrofitSingleton retrofitSingleton = null;
    private static Retrofit retrofit = null;
    private static ApiService apiService = null;

    private RetrofitSingleton() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        if (retrofitSingleton == null) {
            retrofitSingleton = new RetrofitSingleton();
        }
        return apiService;
    }

    public static Retrofit getRetrofit() {
        if (retrofitSingleton == null) {
            retrofitSingleton = new RetrofitSingleton();
        }
        return retrofit;
    }
}
