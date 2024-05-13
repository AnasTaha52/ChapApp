//package com.example.chatapp.network;
//
//import retrofit2.Retrofit;
//
//public class ApiClient {
//
//    public static Retrofit retrofit = null;
//    private static Retrofit getClient(){
//        if (retrofit == null){
//            retrofit  = new Retrofit.Builder()
//                    .baseUrl("https://fcm.googleapis.com/fcm/")
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}
