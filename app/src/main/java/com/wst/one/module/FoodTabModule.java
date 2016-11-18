package com.wst.one.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 11:21
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:菜谱分类接口，http://www.tngou.net/api/cook/classify
 */

public class FoodTabModule implements Serializable {


    /**
     * status : true
     * tngou : [{"cookclass":0,"description":"美容","id":1,"keywords":"美容","name":"美容","seq":0,"title":"美容"},{"cookclass":0,"description":"减肥","id":10,"keywords":"减肥","name":"减肥","seq":0,"title":"减肥"},{"cookclass":0,"description":"保健养生","id":15,"keywords":"保健养生","name":"保健养生","seq":0,"title":"保健养生"},{"cookclass":0,"description":"人群","id":52,"keywords":"人群","name":"人群","seq":0,"title":"人群"},{"cookclass":0,"description":"时节","id":62,"keywords":"时节","name":"时节","seq":0,"title":"时节"},{"cookclass":0,"description":"餐时","id":68,"keywords":"餐时","name":"餐时","seq":0,"title":"餐时"},{"cookclass":0,"description":"器官","id":75,"keywords":"器官","name":"器官","seq":0,"title":"器官"},{"cookclass":0,"description":"调养","id":82,"keywords":"调养","name":"调养","seq":0,"title":"调养"},{"cookclass":0,"description":"肠胃消化","id":98,"keywords":"肠胃消化","name":"肠胃消化","seq":0,"title":"肠胃消化"},{"cookclass":0,"description":"孕产哺乳","id":112,"keywords":"孕产哺乳","name":"孕产哺乳","seq":0,"title":"孕产哺乳"},{"cookclass":0,"description":"其他","id":132,"keywords":"其他","name":"其他","seq":0,"title":"其他"},{"cookclass":0,"description":"经期","id":147,"keywords":"经期","name":"经期","seq":0,"title":"经期"},{"cookclass":0,"description":"女性疾病","id":161,"keywords":"女性疾病","name":"女性疾病","seq":0,"title":"女性疾病"},{"cookclass":0,"description":"呼吸道","id":166,"keywords":"呼吸道","name":"呼吸道","seq":0,"title":"呼吸道"},{"cookclass":0,"description":"血管","id":182,"keywords":"血管","name":"血管","seq":0,"title":"血管"},{"cookclass":0,"description":"心脏","id":188,"keywords":"心脏","name":"心脏","seq":0,"title":"心脏"},{"cookclass":0,"description":"肝胆脾胰","id":192,"keywords":"肝胆脾胰","name":"肝胆脾胰","seq":0,"title":"肝胆脾胰"},{"cookclass":0,"description":"神经系统","id":197,"keywords":"神经系统","name":"神经系统","seq":0,"title":"神经系统"},{"cookclass":0,"description":"口腔","id":202,"keywords":"口腔","name":"口腔","seq":0,"title":"口腔"},{"cookclass":0,"description":"肌肉骨骼","id":205,"keywords":"肌肉骨骼","name":"肌肉骨骼","seq":0,"title":"肌肉骨骼"},{"cookclass":0,"description":"皮肤","id":212,"keywords":"皮肤","name":"皮肤","seq":0,"title":"皮肤"},{"cookclass":0,"description":"男性","id":218,"keywords":"男性","name":"男性","seq":0,"title":"男性"},{"cookclass":0,"description":"癌症","id":227,"keywords":"癌症","name":"癌症","seq":0,"title":"癌症"}]
     */

    private boolean status;
    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        /**
         * cookclass : 0    //菜谱分类 0 位顶级
         * description : 美容
         * id : 1
         * keywords : 美容
         * name : 美容
         * seq : 0          //排序 从0。。。。10开始s
         * title : 美容
         */

        private int cookclass;//上级分类ID，0为顶级
        private String description;//分类的描述（网页显示的标题）
        private int id;//分类id，需要查询该类下的列表就需要传入才参数
        private String keywords;//分类的关键词（网页显示的标题）
        private String name;//分类名称
        private int seq;//分类的排序，从小到大的递增排序
        private String title;//分类的标题（网页显示的标题）

        public int getCookclass() {
            return cookclass;
        }

        public void setCookclass(int cookclass) {
            this.cookclass = cookclass;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
