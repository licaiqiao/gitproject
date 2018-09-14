package com.xiaozhai.zegoexpress.testdemo;



import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author licaiqiao
 * @date 2018/9/14
 */
public interface RetrofitService {
    String BASE_URL="https://news-at.zhihu.com/api/4/";
    /**
     * 测试接口
     * @return
     */
    @GET("news/latest")
    Observable<TestBean> test();
}
