package com.sarmag.neobyte.makeup;
/**
 * Created by neobyte on 2/14/2016.
 */
public final class soltemp {
    private static String[] kdtemp = new String[5];
    private static String[] ciri=new String[5];
    private static int[] pil=new int[6];

    public static String getkode(int pos){
        return kdtemp[pos];
    }
    public static void setkode(int pos,String kode){
        soltemp.kdtemp[pos] = kode;
    }

    public static String getciri(int pos){
        return ciri[pos];
    }
    public static void setciri(int pos,String ciri2){
        soltemp.ciri[pos] = ciri2;
    }

    public static int getpil(int pos) {
        return pil[pos];
    }
    public static void setpil(int pos, int nilai){
        soltemp.pil[pos]=nilai;
    }
}
