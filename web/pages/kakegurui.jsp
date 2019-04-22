<%--
  Created by IntelliJ IDEA.
  User: sagit
  Date: 2019-04-20
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
%>
<%
    response.addHeader("Access-Control-Allow-Origin","*");
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>赌神加柯南？</title>
    <%@ include file="../component/common/js.jspf" %>
    <%@ include file="../component/common/css.jspf" %>
    <link rel="shortcut icon" href="https://book.ourfor.top/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="../css/layout/kakegurui.css" />
</head>
<body>

<div class="container">

    <h3>狂赌之渊 · 真人版</h3>

<section>
    <a data-fancybox="gallery" href="https://ws1.sinaimg.cn/large/005GQrpLgy1g286hybif8j308c0bs0tw.jpg">
        <img src="https://ws1.sinaimg.cn/large/005GQrpLgy1g286hybif8j308c0bs0tw.jpg">
    </a>
    <a data-fancybox="gallery" href="https://ws1.sinaimg.cn/large/005GQrpLgy1g286ikmvkdj308c0bsgmw.jpg">
        <img src="https://ws1.sinaimg.cn/large/005GQrpLgy1g286ikmvkdj308c0bsgmw.jpg">
    </a>
    <a data-fancybox="gallery" href="https://ws1.sinaimg.cn/large/005GQrpLgy1g286ldj2mij308c0bs3zu.jpg">
        <img src="https://ws1.sinaimg.cn/large/005GQrpLgy1g286ldj2mij308c0bs3zu.jpg">
    </a>
</section>

<p name="description">
    我也是一个偶然的机会再Netflix上面看到的这部真人版的日剧，我怀着好奇的心态尝试着看这部风格迥异的漫改剧，可能是被剧中营造的氛围所吸引，<br>
    也可能是被女主流露出来的气质所吸引，总之看了一集就入坑了，就这样一个星期四的下午就看完了第一季，然而第二季从今年3月19号开始在日本的几个电视台播出<br>
    目前网上已经更新到了第3集，整部剧是讲一个刚转学的百花园学园(中文翻译应该叫学院吧,当是学园听起来更好)的可爱的女学生蛇喰梦子，她是一个
    赌狂，不为金钱所动，享受赌的过程中带来的心理上的刺激。百花园学园是一所成立了122年的普通贵族学校，这所学校的风气就是赌博，赌技高超的
    人会受到追捧，赌输了还不了债交不了缴纳金给学生会，就会被冠以家畜的称号，男的叫蠢狗，女的叫杂猫。作为家畜是要服从人的命令的。
</p>

    <h3>魔性的主题曲</h3>
    <div class="aplayer"
         id="aplayer"
         data-id="544000472"
         data-server="netease"
         data-type="song"
         data-autoplay="true"
         data-listmaxheight="500px"
    ></div>

    <h3>一些预告片花</h3>
<section class="video">
    <div id="dplayer"></div>
</section>

    <div id="more-video">
        <span>
            <span class="button" poster="https://file.ourfor.top/source/kakegurui/main.jpg" href="https://file.ourfor.top/source/kakegurui/%E3%80%90%E5%85%AC%E5%BC%8F%E3%80%91%E3%80%8E%E6%98%A0%E7%94%BB%20%E8%B3%AD%E3%82%B1%E3%82%B0%E3%83%AB%E3%82%A4%E3%80%8F%E3%80%805.3%EF%BC%88%E9%87%91%E3%83%BB%E7%A5%9D%EF%BC%89%E5%85%AC%E9%96%8B%EF%BC%8F%E6%9C%AC%E4%BA%88%E5%91%8A-xwS01_Ei7TM.mkv">第一季预告</span>
            <span class="button" poster="https://file.ourfor.top/source/kakegurui/kv_pc.jpg" href="https://file.ourfor.top/source/kakegurui/%E3%83%89%E3%83%A9%E3%83%9E%E3%80%8C%E8%B3%AD%E3%82%B1%E3%82%B0%E3%83%AB%E3%82%A4%E3%80%8D%E7%AC%AC1%E8%A9%B1%E3%82%AA%E3%83%BC%E3%83%97%E3%83%8B%E3%83%B3%E3%82%B0%E6%98%A0%E5%83%8F%E3%80%90%E3%82%AA%E3%83%BC%E3%83%97%E3%83%8B%E3%83%B3%E3%82%B0%E3%83%86%E3%83%BC%E3%83%9E%EF%BC%9A%E3%80%8C%E4%B8%80%E3%81%8B%E5%85%AB%E3%81%8B%E3%80%8D_Re%20-versed%E3%80%91-R81_Ioxa7H8.mkv">第二季预告</span>
            <span class="button" poster="https://file.ourfor.top/source/kakegurui/logo.png" href="https://file.ourfor.top/source/kakegurui/%E3%83%89%E3%83%A9%E3%83%9E%E3%80%8C%E8%B3%AD%E3%82%B1%E3%82%B0%E3%83%AB%E3%82%A4%E3%80%8D%E3%80%80%E6%9C%80%E7%B5%82%E8%A9%B1%E3%80%80%E3%81%94%E6%8C%A8%E6%8B%B6-QSNdmp0U4wE.mkv">片花</span>
        </span>
    </div>

</div>
<div class="gap"></div>

<nav>
    <img src="https://file.ourfor.top/source/kakegurui/main.jpg">
    <img src="https://file.ourfor.top/source/kakegurui/kv_pc.jpg">
    <img src="https://file.ourfor.top/source/kakegurui/logo.png">
</nav>

<div class="author">
    本文作者: ourfor, 转载请注明出处
</div>
</body>
<script>
    const dp = new DPlayer({
        container: document.getElementById('dplayer'),
        screenshot: true,
        video: {
            url: 'https://file.ourfor.top/source/kakegurui/%E3%80%90%E5%85%AC%E5%BC%8F%E3%80%91%E3%83%89%E3%83%A9%E3%83%9E%E3%80%8C%E8%B3%AD%E3%82%B1%E3%82%B0%E3%83%AB%E3%82%A4%20season2%E3%80%8D%E4%BA%88%E5%91%8A%E7%B7%A8%E6%98%A0%E5%83%8F%EF%BC%88%EF%BC%93%EF%BC%90%E7%A7%92%EF%BC%892019%E5%B9%B43%E6%9C%88%E6%9C%AB%E3%82%88%E3%82%8AMBS%E3%80%81TBS%E6%B7%B1%E5%A4%9C%E6%9E%A0%E3%81%BB%E3%81%8B%20%E3%81%AB%E3%81%A6%E6%94%BE%E9%80%81%E3%82%B9%E3%82%BF%E3%83%BC%E3%83%88%EF%BC%81-hARjy3s7Kmc.mkv',
            pic: 'https://file.ourfor.top/source/kakegurui/kv_pc.jpg',
            thumbnails: 'https://file.ourfor.top/source/kakegurui/kv_pc.jpg'
        }
    });
</script>
<script>
        let videoList = document.getElementsByClassName("button");
        for (let i = 0; i < videoList.length; i++) {
            videoList[i].onclick = replace;
        }
        function replace(){
            let oTarget = (window.event) ? window.event.srcElement:event.target;
            // alert(oTarget.getAttribute("href"));
            let src = oTarget.getAttribute("href");
            let poster = oTarget.getAttribute("poster");
            let play = document.getElementById("dplayer");
            play = play.getElementsByTagName('video');
            play = play[0];
            play.setAttribute("src",src);
            play.setAttribute("poster",poster);
        }
</script>
</html>
