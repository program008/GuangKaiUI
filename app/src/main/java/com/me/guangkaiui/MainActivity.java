package com.me.guangkaiui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private ViewFlipper viewFlipper;

        private ViewFlipper viewFlipper2;

        private String[] images;

        private List<String> words;

        private RelativeLayout layoutAdvert;

        private RelativeLayout layoutGuiding;

        private GridView gvGuiding;

        private RelativeLayout layoutScene;

        private ImageView mBackHomepage;

        private ImageView mBtnPre;

        private ImageView mBtnNext;

        private TextView mSpeakText;

        private TextView mScreenShowText;

        private LinearLayout mLlBottomsBtn;

        private String[] btnBottoms;

        private LinearLayout mLiCenterImages;

        private String[] centerImages;

        private int[] centerBtn = {R.mipmap.action_week01_press, R.mipmap.action_week06_press, R.mipmap.action_week01_press, R.mipmap.action_week01_press};

        private LinearLayout mLiCenterBtns;

        private int index;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                initView();
                initData();
//                loadAdvertLayout();
//                loadGuidingLayout();
//                loadSceneLayout();

        }

        private void initView() {
                //广告页
                viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
                viewFlipper2 = (ViewFlipper) findViewById(R.id.viewFlipper2);
                layoutAdvert = (RelativeLayout) findViewById(R.id.layout_advert);
                //引导页
                layoutGuiding = (RelativeLayout) findViewById(R.id.layout_guiding);
                gvGuiding = (GridView) findViewById(R.id.gv_guiding);
                //标准富文本页(具体的内容页)
                layoutScene = (RelativeLayout) findViewById(R.id.layout_scene);
                mBackHomepage = (ImageView) findViewById(R.id.iv_scene_back_homepage);//返回首页
                mBtnPre = (ImageView) findViewById(R.id.iv_scene_btnPre);//上一页
                mBtnNext = (ImageView) findViewById(R.id.iv_scene_btnNext);//下一页
                mSpeakText = (TextView) findViewById(R.id.tv_scene_question);//交互的文本
                mScreenShowText = (TextView) findViewById(R.id.tv_scene_screenShow);//显示的字幕screenShow
                mLlBottomsBtn = (LinearLayout) findViewById(R.id.ll_btn_bottoms);//底部按钮,有则显示,可为多个
                mLiCenterImages = (LinearLayout) findViewById(R.id.ll_scene_center_images);//中间图片显示的容器布局
                //中间按钮的显示的容器布局
                mLiCenterBtns = (LinearLayout) findViewById(R.id.ll_scene_center_btns);
        }

        private void initData() {
                images = new String[2];
                String image1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503662932075&di=b113ee387beb74eb4a1272005fe5ea1e&imgtype=0&src=http%3A%2F%2Fsrc.leju.com%2Fimp%2Fimp%2Fdeal%2Fc3%2F6c%2F5%2F55998920e009290bcf8e899a9c0_p24_mk24.png";
                images[0] = image1;
                images[1] = image1;

                //主界面引导语数据加载
                words = new ArrayList<>();
                words.add("存款利率是多少？");
                words.add("怎么办粤通卡？");
                words.add("有哪些理财产品？");
                words.add("信用卡挂失");
                words.add("怎么开通云闪付？");
                words.add("开通龙支付");
                words.add("有没有免费的WIFI？");
                words.add("手机银行购买理财");
                words.add("你叫什么名字？");
                words.add("你会做什么？");

                //具体的内容界面

                btnBottoms = new String[]{"手机银行购买", "呼叫大堂经理", "理财产品取号"};

                centerImages = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503727766220&di=8f489249aeab56d2cf7b978551ab0421&imgtype=0&src=http%3A%2F%2Fimg.sccnn.com%2Fbimg%2F337%2F15384.jpg"
                        , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503727766219&di=c226cde57809071b2e46060925cda4b8&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0184b4554210750000019ae9f5adc2.jpg"};

        }

        /**
         * 加载广告布局
         * "richType": "advert"
         */
        private void loadAdvertLayout() {
                //显示广告页,隐藏其他界面
                displayScene(true, false, false);
                for (int i = 0; i < 2; i++) {
                        TextView view = new TextView(this);
                        view.setText("您可以这样问我：怎么购买鸡年金钞/介绍一下理财产品/有什么理财产品");
                        view.setPadding(0, 20, 20, 20);
                        view.setTextSize(20);
                        view.setTextColor(Color.GRAY);
                        viewFlipper.addView(view);
                }

                for (int i = 0; i < images.length; i++) {
                        ImageView imageView = new ImageView(this);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        App.instance.displayImage(images[i], imageView);
                        viewFlipper2.addView(imageView);
                }
        }

        /**
         * 加载主界面引导语
         * "richType": "guiding"
         */
        private void loadGuidingLayout() {
                //显示主界面引导语,隐藏其他界面
                displayScene(false, true, false);
                ArrayAdapter guidingAdapter = new ArrayAdapter(this, R.layout.item_guiding, words);
                gvGuiding.setAdapter(guidingAdapter);

                gvGuiding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(MainActivity.this, words.get(i), Toast.LENGTH_SHORT).show();
                                // TODO: 2017/8/26 引导语点击,发送请求
                        }
                });

        }

        /**
         * 富文本标准答案类型
         * 具体布局绘制由返回的json数据决定
         * "richType": "scene"
         */
        private void loadSceneLayout() {
                //显示具体界面，隐藏其他界面
                displayScene(false, false, true);

                /*
                 <!--<Button-->
                <!--android:layout_width="300dp"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:text="手机银行购买"-->
                <!--android:layout_margin="30dp"-->
                 <!--/>-->
                 */
                //绘制底部按钮
                for (int i = 0; i < btnBottoms.length; i++) {
                        Button btn = new Button(this);
                        btn.setText(btnBottoms[i]);
                        final int finalI = i;
                        btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                        Toast.makeText(MainActivity.this, btnBottoms[finalI], Toast.LENGTH_SHORT).show();
                                        // TODO: 2017/8/26  底部按钮点击发送请求
                                }
                        });
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.setMargins(30, 30, 30, 30);
                        mLlBottomsBtn.addView(btn, layoutParams);
                }

//                for (int i = 0; i < centerImages.length; i++) {
//                        ImageView iv = new ImageView(this);
//                        App.instance.displayImage(centerImages[i], iv);
//                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                        layoutParams.setMargins(10,10,10,10);
//                        mLiCenterImages.addView(iv,layoutParams);
//                }

                for (int i = 0; i < centerBtn.length; i++) {
                        ImageView iv = new ImageView(this);
                        iv.setImageDrawable(getResources().getDrawable(centerBtn[i]));
                        iv.setClickable(true);
                        final int finalI = i;
                        iv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                        Toast.makeText(MainActivity.this, "点击了" + centerBtn[finalI], Toast.LENGTH_SHORT).show();
                                        // TODO: 2017/8/26 中间按钮的点击事件 点击后发起请求
                                }
                        });
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.setMargins(10, 10, 10, 10);
                        mLiCenterBtns.addView(iv, layoutParams);
                }


        }

        /**
         * 根据富文本类型richType,显示或者隐藏相应的布局
         *
         * @param advert  是否显示广告页
         * @param guiding 是否显示引导页
         * @param scene   是否显示具体内容页
         */
        private void displayScene(boolean advert, boolean guiding, boolean scene) {
                if (advert) {
                        layoutAdvert.setVisibility(View.VISIBLE);
                        viewFlipper.startFlipping();
                        viewFlipper2.startFlipping();
                }
                else {
                        layoutAdvert.setVisibility(View.GONE);
                        viewFlipper.stopFlipping();
                        viewFlipper2.stopFlipping();
                }

                if (guiding) {
                        layoutGuiding.setVisibility(View.VISIBLE);
                }
                else {
                        layoutGuiding.setVisibility(View.GONE);
                }

                if (scene) {
                        layoutScene.setVisibility(View.VISIBLE);
                }
                else {
                        layoutScene.setVisibility(View.GONE);
                        mLiCenterBtns.removeAllViews();
                        mLlBottomsBtn.removeAllViews();
                        mLiCenterImages.removeAllViews();

                }
        }

        /**
         * 切换界面 测试用
         *
         * @param view
         */
        public void open(View view) {
                index = index % 3;
                switch (index) {
                        case 0:
                                loadAdvertLayout();
                                index++;
                                break;
                        case 1:
                                loadGuidingLayout();
                                index++;
                                break;
                        case 2:
                                loadSceneLayout();
                                index++;
                                break;
                        default:
                                break;
                }
        }
}
