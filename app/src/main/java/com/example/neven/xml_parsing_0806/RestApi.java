package com.example.neven.xml_parsing_0806;

import dataFromServer.note;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neven on 8.6.2016..
 */
public interface RestApi {

    @GET("note.xml")
    Call<note> getData();


}
