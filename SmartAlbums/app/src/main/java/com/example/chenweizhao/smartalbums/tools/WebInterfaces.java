package com.example.chenweizhao.smartalbums.tools;


//Retrofir网络请求接口

import com.example.chenweizhao.smartalbums.data.DataFaceClusingRequest;
import com.example.chenweizhao.smartalbums.data.DataFaceClusingResponse;
import com.example.chenweizhao.smartalbums.data.DataFaceDetectionRequest;
import com.example.chenweizhao.smartalbums.data.DataFaceDetectionResponse;
import com.example.chenweizhao.smartalbums.data.DataFaceMeritRequest;
import com.example.chenweizhao.smartalbums.data.DataFaceMeritResponse;
import com.example.chenweizhao.smartalbums.data.DataFaceVerificationRequest;
import com.example.chenweizhao.smartalbums.data.DataFaceVerificationResponse;
import com.example.chenweizhao.smartalbums.data.DataImageFilterRequest;
import com.example.chenweizhao.smartalbums.data.DataImageFilterResponse;
import com.example.chenweizhao.smartalbums.data.DataImageRecommondRequest;
import com.example.chenweizhao.smartalbums.data.DataImageRecommondResponse;
import com.example.chenweizhao.smartalbums.data.DataImageScoreResponse;
import com.example.chenweizhao.smartalbums.data.DataLogin;
import com.example.chenweizhao.smartalbums.data.DataLoginResponse;
import com.example.chenweizhao.smartalbums.data.DataMakeVideoRequest;
import com.example.chenweizhao.smartalbums.data.DataMakeVideoResponse;
import com.example.chenweizhao.smartalbums.data.DataSpecialImageRequest;
import com.example.chenweizhao.smartalbums.data.DataSpecialImageResponse;
import com.example.chenweizhao.smartalbums.data.DataUploadImageRequest;
import com.example.chenweizhao.smartalbums.data.DataUploadImageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WebInterfaces {

    //登录请求
    @FormUrlEncoded
    @POST(Constant.Login)
    Call<DataLoginResponse> getToken(@Body DataLogin dataLogin);

    //上传图片
    @FormUrlEncoded
    @POST(Constant.UploadImage)
    Call<DataUploadImageResponse> uploadImage(@Body DataUploadImageRequest dataUploadImageRequest);

    //过滤照片


    //1
    //人脸检测
    @FormUrlEncoded
    @POST(Constant.FaceDetection)
    Call<DataFaceDetectionResponse> doFaceDetection(@Body DataFaceDetectionRequest dataFaceDetectionRequest);

    //人脸验证
    @FormUrlEncoded
    @POST(Constant.FaceVerification)
    Call<DataFaceVerificationResponse> doFaceVerification(@Body DataFaceVerificationRequest dataFaceVerificationRequest);

    //人脸聚类
    @FormUrlEncoded
    @POST(Constant.FaceClusting)
    Call<DataFaceClusingResponse> doFaceClusing(@Body DataFaceClusingRequest dataFaceClusingRequest);



    //2
    //图像择优
    @FormUrlEncoded
    @POST(Constant.ImageMerit)
    Call<DataFaceMeritResponse> doImageMerit(@Body DataFaceMeritRequest dataFaceMeritRequest);

    //图像评分
    @FormUrlEncoded
    @POST(Constant.ImageScore)
    Call<DataImageScoreResponse> doImageScore(@Body DataImageScoreResponse dataImageScoreResponse);



    //3
    //生成视频
    @FormUrlEncoded
    @POST(Constant.MakeVideo)
    Call<DataMakeVideoResponse> doMakeVideo(@Body DataMakeVideoRequest dataMakeVideoRequest);

    //滤镜效果
    @FormUrlEncoded
    @POST(Constant.ImageFilter)
    Call<DataImageFilterResponse> doImageFilter(@Body DataImageFilterRequest dataImageFilterRequest);

    //镜头特写
    @FormUrlEncoded
    @POST(Constant.SpecialImage)
    Call<DataSpecialImageResponse> doSpecialImage(@Body DataSpecialImageRequest dataSpecialImageRequest);

    //智能推荐
    @FormUrlEncoded
    @POST(Constant.SpecialImage)
    Call<DataImageRecommondResponse> doImageRecommond(@Body DataImageRecommondRequest dataImageRecommondRequest);


}
