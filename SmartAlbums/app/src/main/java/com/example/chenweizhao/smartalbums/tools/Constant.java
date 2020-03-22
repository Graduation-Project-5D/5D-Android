package com.example.chenweizhao.smartalbums.tools;


//常量类
public class Constant {
    //回调码requestCode
    //申请相机权限
    public static final int REQUESTCAMERACODE = 1;
    //申请相册权限
    public static final int REQUESTALBUMCODE = 2;
    //打开相机
    public static final int OPENCAMERACODE = 3;
    //打开相册
    public static final int OPENALBUMCODE = 4;

    //服务器ip
    public static final String BaseUrl = "http://wanfanji.3322.org:13478/";

    //登录接口
    public static final String Login = "login";

    //图片上传接口
    public static final String UploadImage = "uploadimag";

    //人脸筛选
    public static final String ChooseFace  = "people_album/human_list";

    //人脸检测
    public static final String FaceDetection = "people_album/detector";

    //人脸验证
    public static final String FaceVerification = "people_album/recognize";

    //人脸聚类
    public static final String FaceClusting = "people_album/cluster";

    //相似图片择优
    public static final String ImageMerit = "image_chooser/img_best";

    //图像评分
    public static final String ImageScore = "image_chooser/img_score";

    //生成视频
    public static final String MakeVideo = "fancyTime/img2video";

    //滤镜效果
    public static final String ImageFilter = "fancyTime/image_filter";

    //镜头特写
    public static final String SpecialImage = "fancyTime/image_closeUp";

    //智能推荐
    public static final String ImageRecommond = "fancyTime/recommend";

}
