    $(".indicator ul li").click(function(){
        $(".indicator ul li").removeClass("active");
        $(this).addClass("active");
        var i = $(this).index()+1;
        $(".slideshow img").removeClass("active");
        $(".slideshow").find("img:nth-child("+i+")").addClass("active");
        });
        $(function($){
            var lis = $(".slideshow>img");
            var menu  = $(".indicator ul>li");
            ch = 0;
            setInterval(function() {
            ch = (ch + 1) % lis.length;
            lis.removeClass("active").eq(ch).addClass("active");
            menu.removeClass("active").eq(ch).addClass("active");
        },3000);
});