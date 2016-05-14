package com.apkfuns.jsbridge.sample;

import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;

import com.apkfuns.jsbridge.JsModule;
import com.apkfuns.jsbridge.JSCallback;
import com.apkfuns.jsbridge.JsReturn;

/**
 * Created by pengwei on 16/5/6.
 */
public class ServiceModule implements JsModule {

    @Override
    public String getModuleName() {
        return "service";
    }

    public static String setTitleBackground(MainActivity activity, String param) {
        activity.setTitle("黑猫警长" + param);
        return JsReturn.appleSuccess("success");
    }

    public static String addNavIcon(MainActivity activity, final String param, final JSCallback callback) {
        activity.addMenu(param, new Runnable() {
            @Override
            public void run() {
                callback.apply(param);
            }
        });
        return JsReturn.appleSuccess("success");
    }

    public static void getTicket(WebView webView, final String object, final JSCallback callback) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return object;
            }

            @Override
            protected void onPostExecute(String s) {
                callback.apply(s);
            }
        }.execute();
    }

    public static String getName(WebView webView, String option) {
        return JsReturn.appleSuccess("1234");
    }

//    public static void getTicket(WebView webView, JSONObject object, final JSCallback callback) {
//        final JSONObject jsonObject = new JSONObject();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                    jsonObject.put("ticket", "aaa+bcd");
//                    callback.applySuccess(jsonObject);
//                } catch (JSONException | InterruptedException e) {
//                    callback.applyError(jsonObject);
//                }
//            }
//        }).start();
//    }
//
//    public static void getData(WebView webView, JSONObject object, final JSCallback callback) {
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... params) {
//                return "abcdefg";
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                try {
//                    callback.applySuccess(new JSONObject().put("data", s));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.execute();
//    }
//
//    public static void alertDialog(WebView webView, JSONObject object, final JSCallback callback) {
//        AlertDialog.Builder builder = null;
//        try {
//            builder = new AlertDialog.Builder(webView.getContext())
//                    .setMessage("这是android弹出的提示框哟\n内容为:")
//                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            callback.applySuccess(null);
//                        }
//                    })
//                    .setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            callback.applyError(null);
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        builder.create().show();
//    }
//
//    public static String getA(WebView webView, JSONObject object) {
//        return Build.MODEL;
//    }
}
