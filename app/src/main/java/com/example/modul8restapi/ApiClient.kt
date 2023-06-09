import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL =
        "https://apitani.burunghantu.id/sub/restapi-slim/public/"
    val apiService : ApiService
        get(){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
