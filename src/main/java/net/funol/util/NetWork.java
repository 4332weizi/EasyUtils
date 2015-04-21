package net.funol.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by DZY-ZWW on 10-10.
 */
public class NetWork {

    private NetWork() {

    }

    /**
     * 网络是否已连接
     * @param context 上下文
     * @return boolean
     */
    public static boolean isConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null && info.isConnected()) {
            if (info.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Gps是否打开
     *
     * @param context 上下文
     * @return boolean
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * wifi是否打开
     *
     * @param context 上下文
     * @return boolean
     */
    public static boolean isWifiEnabled(Context context) {
        ConnectivityManager mgrConn = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager mgrTel = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
                .getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel
                .getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
    }

    /**
     * 判断当前网络是否是wifi网络
     * if(activeNetInfo.getType()==ConnectivityManager.TYPE_MOBILE) { //判断3G网
     *
     * @param context
     * @return boolean
     */
    public static boolean isWifi(Context context) {
        return getType(context) == Type.WIFI;
    }

    /**
     * 判断当前网络是否是3G网络
     *
     * @param context
     * @return boolean
     */
    public static boolean is4G(Context context) {
        return getType(context) == Type.G4;
    }

    /**
     * 判断当前网络是否是3G网络
     *
     * @param context
     * @return boolean
     */
    public static boolean is3G(Context context) {
        return getType(context) == Type.G3;
    }

    /**
     * 判断当前网络是否是2G网络
     *
     * @param context
     * @return boolean
     */
    public static boolean is2G(Context context) {
        return getType(context) == Type.G2;
    }

    /**
     * 获取NetWorkInfo
     * @param context
     * @return NetworkInfo
     */
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * 获取网络连接类型
     * @param context
     * @return boolean
     */
    public static Type getType(Context context) {

        Type type = Type.NONE;
        NetworkInfo ni = getActiveNetworkInfo(context);
        if (ni != null && ni.isConnectedOrConnecting()) {
            switch (ni.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    type = Type.WIFI;
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    switch (ni.getSubtype()) {
                        case TelephonyManager.NETWORK_TYPE_GPRS: //联通2g
                        case TelephonyManager.NETWORK_TYPE_CDMA: //电信2g
                        case TelephonyManager.NETWORK_TYPE_EDGE: //移动2g
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                            type = Type.G2;
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_A: //电信3g
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                            type = Type.G3;
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE:
                            type = Type.G4;
                            break;
                        default:
                            type = Type.OTHER;
                            break;
                    }
                    break;
                default:
                    type = Type.OTHER;
            }
        }
        return type;
    }

    /**
     * 网络连接类型
     */
    public static enum Type {
        WIFI, G2, G3, G4, OTHER, NONE;
    }
}
