package com.scriptphp.client;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {

    Context context;

    public CORE CORE = new CORE();

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler(Context context) {
        this.context = context;
    }

    public String GET(String reqUrl) {
        String response = "";
        if (CORE.checkInternetConnection(context)) {
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                httpConnection.setRequestMethod("GET");
                InputStream stream = new BufferedInputStream(httpConnection.getInputStream());
                response = convertStreamToString(stream);
            }
            catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            }
            catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            }
            catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            }
            catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }
        return response;
    }

    public String POST(String reqUrl, String postData) {
        String response = "";
        if (CORE.checkInternetConnection(context)) {
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                httpConnection.setInstanceFollowRedirects(true);
                httpConnection.setRequestMethod("POST");
                httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                postData = (postData == null) ? "" : postData;
                byte[] postDataBytes = postData.getBytes("UTF-8");
                httpConnection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                httpConnection.getOutputStream().write(postDataBytes);
                InputStream stream = new BufferedInputStream(httpConnection.getInputStream());
                response = convertStreamToString(stream);
            }
            catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            }
            catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            }
            catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            }
            catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
