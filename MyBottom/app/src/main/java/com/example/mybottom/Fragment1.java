package com.example.mybottom;


import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;

public class Fragment1 extends Fragment {

    private static final String TAG = Fragment1.class.getSimpleName();


    //나의 관심목록 사용할 인스턴스 생성
    RecyclerView mRecyclerView = null ;
    MyInterestRecyclerAdapter mAdapter = null ;
    ArrayList<MyInterestRecyclerItem> mList = new ArrayList<MyInterestRecyclerItem>();

    //나의 관심단지 사용할 인스턴스 생성
    RecyclerView recyclerView = null;
    MyInterestRecyclerAdapter adapter = null;
    ArrayList<MyInterestRecyclerItem> list = new ArrayList<MyInterestRecyclerItem>();

    //나의 관심단지 사용할 인스턴스 생성
    RecyclerView recyclerView2 = null;
    SellInfoRecyclerAdapter sellInfoAdapter = null;
    ArrayList<SellInfoRecyclerItem> SellInfoItemList = new ArrayList<SellInfoRecyclerItem>();

    //추천 콘텐츠 인스턴스 생성
    PostRecyclerAdapter postRecyclerAdapter = null;
    ArrayList<PostRecyclerItem> postRecyclerItemArrayList = new ArrayList<PostRecyclerItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        new HttpAsyncTask().execute("13.125.230.124/users/2/interest-regions");

        //나의 관심 목록

        //fragment 인플레이트 해서 rootView 객체 만듬
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        //fregment1.xml에서 리싸이클러 뷰 찾아서 mRecyclerView에 저장
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.myinterestRecycler) ;

        // 리사이클러뷰에 MyInterestRecyclerAdapter 객체 지정.
        mAdapter = new MyInterestRecyclerAdapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (HORIZONTAL)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)) ;

        // 아이템 추가.
        addInterestItem(R.drawable.daechidong,
                "대치동", "원룸,투ㆍ쓰리룸,오피스텔","23개의 방") ;
        // 두 번째 아이템 추가.
        addInterestItem(R.drawable.kangnamstation,
                "강남역", "원룸,투ㆍ쓰리룸,오피스텔","300개의 방") ;
        // 세 번째 아이템 추가.
        addInterestItem(R.drawable.samsungdong,
                "삼성동", "원룸,투ㆍ쓰리룸,오피스텔","30개의 방") ;

        mAdapter.notifyDataSetChanged() ;

        //나의 관심 단지

        recyclerView = rootView.findViewById(R.id.myComplexRecycler);

        adapter = new MyInterestRecyclerAdapter(list);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));

        addComplexItem(R.drawable.inhaari,"인하아리스타","오피스텔,372세대,2017.12","214개의 방");

        addComplexItem(R.drawable.tjsfmd,"선릉역롯데골드로즈","오피스텔,198세대,2003.10","1개의 방");

        addComplexItem(R.drawable.tkaghks,"삼환아르노부2차","오피스텔,101세대,2004.09","8개의 방");

        addComplexItem(R.drawable.wkatlf,"잠실M타워","오피스텔,248세대,2018.12","5개의 방");

        adapter.notifyDataSetChanged() ;

        //분양 정보

        recyclerView2 = rootView.findViewById(R.id.sellInfoRecycler);

        sellInfoAdapter = new SellInfoRecyclerAdapter(SellInfoItemList);

        recyclerView2.setAdapter(sellInfoAdapter);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));

        addSellInfoItem(R.drawable.dmctpsxm,"분양중","20.08.13 특별공급","DMC 센틀럴자이");

        addSellInfoItem(R.drawable.tkstjddur,"분양중","20.08.11 특별공급","산성역 자이 푸르지오");

        sellInfoAdapter.notifyDataSetChanged() ;

        //추천 콘텐츠

        recyclerView = rootView.findViewById(R.id.postRecycler);

        postRecyclerAdapter = new PostRecyclerAdapter(postRecyclerItemArrayList);

        recyclerView.setAdapter(postRecyclerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));

        addPostItem(R.drawable.post1,"청년맞춤'전월세 대학생","조회 117738");

        addPostItem(R.drawable.post2,"LH청년-신혼 매입임대방법","조회 49761");

        addPostItem(R.drawable.post2,"방 계약가능 여부 미리 알아보기","조회 79728");

        addPostItem(R.drawable.post2,"이사 준비한다면 필독!","조회 46211");

        addPostItem(R.drawable.post2,"방 구하기 전, 매물 확인","조회 87965");

        sellInfoAdapter.notifyDataSetChanged() ;

        return rootView;

    }


    public void addInterestItem(int regionImg, String title, String subTitle, String homeNum) {

        MyInterestRecyclerItem item = new MyInterestRecyclerItem();

        item.setRegionDrawable(regionImg);
        item.setTitle(title);
        item.setSubTitle(subTitle);
        item.setHomeNum(homeNum);

        mList.add(item);
    }

    public void addComplexItem(int regionImg, String title, String subTitle, String homeNum) {

        MyInterestRecyclerItem item = new MyInterestRecyclerItem();

        item.setRegionDrawable(regionImg);
        item.setTitle(title);
        item.setSubTitle(subTitle);
        item.setHomeNum(homeNum);

        list.add(item);
    }

    public void addSellInfoItem(int sellInfoImg, String selling, String sellInfo, String sellInfoName) {

        SellInfoRecyclerItem item = new SellInfoRecyclerItem();

        item.setSellInfoImg(sellInfoImg);
        item.setSelling(selling);
        item.setSellInfo(sellInfo);
        item.setSellInfoName(sellInfoName);

        SellInfoItemList.add(item);
    }

    public void addPostItem(int postImg, String postTitle, String postView) {

        PostRecyclerItem item = new PostRecyclerItem();

        item.setPostImg(postImg);
        item.setPostTitle(postTitle);
        item.setPostView(postView);

        postRecyclerItemArrayList.add(item);
    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, String>{

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];

            try {
                Request request = new Request.Builder()
                        .url(strUrl)
                        .build();

                Response response = client.newCall(request).execute();
                Log.d(TAG,"doInBackground : " + response.body().string());
            } catch (IOException e){
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            if (s != null){
                Log.d(TAG,s);
            }
        }

    }



}