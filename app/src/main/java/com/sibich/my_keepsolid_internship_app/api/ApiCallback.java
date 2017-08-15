package com.sibich.my_keepsolid_internship_app.api;


import com.sibich.my_keepsolid_internship_app.models.TimesIndiaErrorItem;

import retrofit2.Callback;

/*
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
*/

public abstract class ApiCallback<T> implements Callback<T> {

    public abstract void failure(TimesIndiaErrorItem timesIndiaError);
/*
    @Override
    public void failure(RetrofitError error) {

        TimesIndiaErrorItem timesIndiaError = null;

        try {
            timesIndiaError = (TimesIndiaErrorItem) error.getBodyAs(TimesIndiaErrorItem.class);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        if (timesIndiaError != null) {
            failure(timesIndiaError);
        } else {
            Response errorResponse = error.getResponse();
            if (error.getKind() == RetrofitError.Kind.NETWORK) {
                failure(new TimesIndiaErrorItem("Cant connect to network", "http://internet.com"));
            } else {
                failure(new TimesIndiaErrorItem("Error code: " + String.valueOf(errorResponse.getStatus()), "http://internet.com"));
            }
        }
    }*/
}
