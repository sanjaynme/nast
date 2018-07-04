package np.edu.nast.demoapp.demoapp.data;

import java.util.List;

import np.edu.nast.demoapp.demoapp.data.rest.RetrofitSingleton;
import retrofit2.Call;
import retrofit2.http.GET;

public class ApiService {

    private static final String BASE_URL = "http://www.mocky.io/";

    public static RetrofitInterface getServiceClass() {
        return RetrofitAPI.getRetrofit(BASE_URL)
                .create(RetrofitInterface.class);
    }

    public interface RetrofitInterface {
        @GET("v2/5a96abc232000057005e2ed7")
        public Call<List<ApiObject>> getAllPost();
    }
}
