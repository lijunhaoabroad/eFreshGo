package com.example.lijunhao.testapplication;

/**
 * Created by win8 on 2017-07-18.
 */

public class DataProduct {
//    private String pCategory;
    private String pName;
    private String pDesc;
//    private String pDiscount;
    private String pImage;
    private String pPrice;
    public DataProduct(){

    }
//    public String getpCategory(){
//        return pCategory;
//    }
    public String getpName(){
        return pName;
    }
    public String getpDesc(){
        return pDesc;
    }
//    public String getpDiscount(){
//        return pDiscount;
//    }
    public String getpImage(){
        return pImage;
    }
    public String getpPrice(){
        return pPrice;
    }

//    public void setpCategory(String category){this.pCategory=category;}
    public void setpName(String name){this.pName=name;}
    public void setpDesc(String desc){this.pDesc=desc;}
//    public void setpDiscount(String discount){this.pDiscount=discount;}
    public void setpImage(String path){this.pImage=path;}
    public void setpPrice(String price){this.pPrice=price;}
}
