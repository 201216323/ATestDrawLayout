package com.wst.one.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 11:28
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public class FoodListModule implements Serializable{

    /**
     * status : true
     * total : 585
     * tngou : [{"count":16874,"description":"7）加盖，置于蒸锅内，隔水以文火炖2个小时，以表面呈现少量泡沫，有点沸腾、粘稠感和蛋清香味为蒸好的标准","fcount":0,"food":"干血燕燕窝,冰糖","id":183,"images":"","img":"/cook/150802/1340f07baad474a757825191701d5e1e.jpg","keywords":"燕窝 纯净水 膨胀 冰糖 清洗 ","name":"冰糖燕窝","rcount":0}]
     */

    private boolean status;
    private int total;
    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean implements Serializable{
        /**
         * count : 16874
         * description : 7）加盖，置于蒸锅内，隔水以文火炖2个小时，以表面呈现少量泡沫，有点沸腾、粘稠感和蛋清香味为蒸好的标准
         * fcount : 0
         * food : 干血燕燕窝,冰糖
         * id : 183
         * images :
         * img : /cook/150802/1340f07baad474a757825191701d5e1e.jpg
         * keywords : 燕窝 纯净水 膨胀 冰糖 清洗
         * name : 冰糖燕窝
         * rcount : 0
         */

        private int count;//访问次数
        private String description;//描述
        private int fcount;//收藏数
        private String food;//食物
        private int id;//ID编码
        private String images;//多图，中间由 ， 隔开
        private String img;//图片
        private String keywords;//关键字
        private String name;//名称
        private int rcount;//评论读数

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }
    }
}
