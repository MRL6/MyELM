package com.bwie.myelm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.myelm.adapter.MyListViewErAdapter;
import com.bwie.myelm.adapter.MyListViewYiAdapter;
import com.bwie.myelm.bean.Meau;
import com.bwie.myelm.core.DataCall;
import com.bwie.myelm.core.MyView;
import com.bwie.myelm.presenter.RequestPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataCall{

        String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
    String getUrl = "{\n" +
            "msg: \"请求成功\",\n" +
            "code: \"0\",\n" +
            "data: [\n" +
            "{\n" +
            "list: [ ],\n" +
            "sellerName: \"\",\n" +
            "sellerid: \"0\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-14T21:48:08\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 11,\n" +
            "pid: 11,\n" +
            "price: 8989,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 4,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家4\",\n" +
            "sellerid: \"4\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-03T23:43:53\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 1,\n" +
            "pid: 13,\n" +
            "price: 465,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 6,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家6\",\n" +
            "sellerid: \"6\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 11800,\n" +
            "createtime: \"2017-10-14T21:38:26\",\n" +
            "detailUrl: \"https://mitem.jd.hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg\",\n" +
            "num: 3,\n" +
            "pid: 63,\n" +
            "price: 10000,\n" +
            "pscid: 40,\n" +
            "selected: 0,\n" +
            "sellerid: 7,\n" +
            "subhead: \"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）\",\n" +
            "title: \"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家7\",\n" +
            "sellerid: \"7\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 399,\n" +
            "createtime: \"2017-10-03T23:53:28\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/1439822107.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t5887/201/859509257/69994/6bde9bf6/59224c24Ne854e14c.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5641/233/853609022/57374/5c73d281/59224c24N3324d5f4.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5641/233/853609022/57374/5c73d281/59224c24N3324d5f4.jpg!q70.jpg\",\n" +
            "num: 1,\n" +
            "pid: 87,\n" +
            "price: 888,\n" +
            "pscid: 85,\n" +
            "selected: 0,\n" +
            "sellerid: 8,\n" +
            "subhead: \"满2件，总价打6.50折\",\n" +
            "title: \"Gap男装 休闲舒适简约水洗五袋直筒长裤紧身牛仔裤941825 深灰色 33/32(175/84A)\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 3455,\n" +
            "createtime: \"2017-10-03T23:53:28\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg\",\n" +
            "num: 2,\n" +
            "pid: 52,\n" +
            "price: 666,\n" +
            "pscid: 39,\n" +
            "selected: 0,\n" +
            "sellerid: 8,\n" +
            "subhead: \"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机\",\n" +
            "title: \"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家8\",\n" +
            "sellerid: \"8\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 11800,\n" +
            "createtime: \"2017-10-14T21:48:08\",\n" +
            "detailUrl: \"https://mitem.jd.hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg\",\n" +
            "num: 3,\n" +
            "pid: 65,\n" +
            "price: 12000,\n" +
            "pscid: 40,\n" +
            "selected: 0,\n" +
            "sellerid: 9,\n" +
            "subhead: \"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）\",\n" +
            "title: \"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 2999,\n" +
            "createtime: \"2017-10-14T21:48:08\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/2385655.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t2068/298/2448145915/157953/7be197df/56d51a42Nd86f1c8e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2437/128/1687178395/117431/bcc190c1/56d3fcbaNb2963d21.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2467/222/2263160610/95597/927b8a2f/56d3eafeNdecebeb6.jpg!q70.jpg\",\n" +
            "num: 2,\n" +
            "pid: 53,\n" +
            "price: 777,\n" +
            "pscid: 39,\n" +
            "selected: 0,\n" +
            "sellerid: 9,\n" +
            "subhead: \"Super AMOLED三星双曲面2K 屏，支持无线充电！\",\n" +
            "title: \"三星 Galaxy S7 edge（G9350）4GB+32GB 铂光金 移动联通电信4G手机 双卡双待\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-14T21:39:05\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 1,\n" +
            "pid: 16,\n" +
            "price: 199,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 9,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家9\",\n" +
            "sellerid: \"9\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 11800,\n" +
            "createtime: \"2017-10-14T21:38:26\",\n" +
            "detailUrl: \"https://mitem.jd.hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg\",\n" +
            "num: 3,\n" +
            "pid: 66,\n" +
            "price: 13000,\n" +
            "pscid: 40,\n" +
            "selected: 0,\n" +
            "sellerid: 10,\n" +
            "subhead: \"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）\",\n" +
            "title: \"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 159,\n" +
            "createtime: \"2017-10-14T21:49:15\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/5061723.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t8716/197/1271594444/173291/2f40bb4f/59b743bcN8509428e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8347/264/1286771527/92188/5cf5ec04/59b7420fN65378e9e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7363/165/3000956253/190883/179a372/59b743bfNd0c79d93.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7399/112/2935531768/183594/b77c7d4a/59b7441aNc3d40133.jpg!q70.jpg\",\n" +
            "num: 5,\n" +
            "pid: 99,\n" +
            "price: 2100,\n" +
            "pscid: 112,\n" +
            "selected: 0,\n" +
            "sellerid: 10,\n" +
            "subhead: \"针织针织闪闪闪亮你的眼\",\n" +
            "title: \"维迩旎 2017秋冬新款长袖针织连衣裙韩版气质中长款名媛包臀A字裙 zx179709 黑色 XL\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-03T23:53:28\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 2,\n" +
            "pid: 17,\n" +
            "price: 299,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 10,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家10\",\n" +
            "sellerid: \"10\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 159,\n" +
            "createtime: \"2017-10-14T21:49:15\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/5061723.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t8716/197/1271594444/173291/2f40bb4f/59b743bcN8509428e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8347/264/1286771527/92188/5cf5ec04/59b7420fN65378e9e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7363/165/3000956253/190883/179a372/59b743bfNd0c79d93.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7399/112/2935531768/183594/b77c7d4a/59b7441aNc3d40133.jpg!q70.jpg\",\n" +
            "num: 1,\n" +
            "pid: 100,\n" +
            "price: 2200,\n" +
            "pscid: 112,\n" +
            "selected: 0,\n" +
            "sellerid: 11,\n" +
            "subhead: \"针织针织闪闪闪亮你的眼\",\n" +
            "title: \"维迩旎 2017秋冬新款长袖针织连衣裙韩版气质中长款名媛包臀A字裙 zx179709 黑色 XL\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 22.9,\n" +
            "createtime: \"2017-10-14T21:38:26\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg\",\n" +
            "num: 5,\n" +
            "pid: 34,\n" +
            "price: 9,\n" +
            "pscid: 2,\n" +
            "selected: 0,\n" +
            "sellerid: 11,\n" +
            "subhead: \"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》\",\n" +
            "title: \"三只松鼠 坚果炒货 零食奶油味 碧根果225g/袋\"\n" +
            "},\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-14T21:48:08\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 2,\n" +
            "pid: 18,\n" +
            "price: 399,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 11,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家11\",\n" +
            "sellerid: \"11\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-14T21:39:05\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 3,\n" +
            "pid: 19,\n" +
            "price: 499,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 12,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家12\",\n" +
            "sellerid: \"12\"\n" +
            "},\n" +
            "{\n" +
            "list: [\n" +
            "{\n" +
            "bargainPrice: 111.99,\n" +
            "createtime: \"2017-10-14T21:39:05\",\n" +
            "detailUrl: \"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends\",\n" +
            "images: \"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg\",\n" +
            "num: 3,\n" +
            "pid: 1,\n" +
            "price: 118,\n" +
            "pscid: 1,\n" +
            "selected: 0,\n" +
            "sellerid: 17,\n" +
            "subhead: \"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下\",\n" +
            "title: \"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g\"\n" +
            "}\n" +
            "],\n" +
            "sellerName: \"商家17\",\n" +
            "sellerid: \"17\"\n" +
            "}\n" +
            "]\n" +
            "}";
    private ListView listView01;
    private ListView listView02;
    private List<Meau.DataBean> list = new ArrayList<>();
    private List<Meau.DataBean.ListBean> list1 = new ArrayList<>();
    private MyListViewYiAdapter adapter;
    private MyListViewErAdapter adapter1;
    private List<Meau.DataBean.ListBean> beans;
    private List<Meau.DataBean> data;
    private TextView zongjia;
    private RequestPresenter requestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView01 = findViewById(R.id.listview01);
        listView02 = findViewById(R.id.listview02);
        zongjia = findViewById(R.id.zongjia);
        requestPresenter = new RequestPresenter(this);
        requestPresenter.getRequest(url);
        adapter = new MyListViewYiAdapter(list, this);
        adapter1 = new MyListViewErAdapter(list1, this);
        //点击商铺切换商品
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Meau.DataBean.ListBean> beans1 = data.get(position).getList();
                list1.clear();
                adapter1.notifyDataSetChanged();
                list1.addAll(beans1);
                adapter.notifyDataSetChanged();
                adapter1.notifyDataSetChanged();
            }
        });
        adapter1.setOnNumListener(new MyListViewErAdapter.OnNumListener() {
            @Override
            public void onNum() {
                calculatePrice(data);
            }
        });
        listView01.setAdapter(adapter);
        listView02.setAdapter(adapter1);
    }

    @Override
    public void requestSuccess(Meau meau) {
        data = meau.getData();
        Log.i("abc", data.toString());
        calculatePrice(data);
        list.addAll(data);
        beans = data.get(1).getList();
        list1.addAll(beans);
        adapter.notifyDataSetChanged();
        adapter1.notifyDataSetChanged();
        Toast.makeText(this, "成功" + meau.getData(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void requestFail(Meau meau) {
        Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
    }
    /**
     * @author dingtao
     * @date 2018/12/18 7:01 PM
     * 计算总价格
     */
    private void calculatePrice(List<Meau.DataBean> shopList){
        double totalPrice=0;
        int totalNum = 0;
        for (int i = 0; i < shopList.size(); i++) {//循环的商家
            Meau.DataBean shop = shopList.get(i);
            for (int j = 0; j < shop.getList().size(); j++) {
                Meau.DataBean.ListBean goods = shop.getList().get(j);
                //计算价格
                totalPrice = totalPrice + goods.getNum() * goods.getPrice();
                totalNum+=goods.getNum();//计数
            }
        }
        zongjia.setText("价格："+totalPrice+"个数:"+totalNum);
    }
    //防止内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //调用一下
        new RequestPresenter(this).unBindCall();
    }
}
