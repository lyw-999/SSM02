
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Springmvc之 aja 和mvc接收参数 非常重要！！！！</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
        <div>
            <input type="button" value="ajax的01中传参数 K-结构 " id="ajax01">
            <input type="button" value="ajax的02中传参数 对象" id="ajax02">
            <input type="button" value="ajax的03中传参数 数组或者集合" id="ajax03">
            <input type="button" value="ajax的04中传参数 JSON对象" id="ajax04">
            <input type="button" value="ajax的05中传参数 多个对象" id="ajax05">
            <input type="button" value="ajax的06中传参数 批量对象传参" id="ajax06">
            <input type="button" value="ajax的07中传参数 Map传参" id="ajax07">
            <input type="button" value="ajax的07中 对象+常用类型 混合" id="ajax08">
        </div>

<script>
    $(function () {
        $("#ajax01").click(function () {
            $.ajax({
                url:"/api/admin/regByBean",
                type:"POST",
               data:{
                'adminName':'zhangsan',
                'adminPwd':'123123',
                'adminTime':'2011-11-11 11:11:11',
            },
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }

            });
        });
        $("#ajax02").click(function () {
            var adminInfo ={};
            adminInfo.adminName = 'zhangsan';
            adminInfo.adminPwd = '123123';
            adminInfo.adminTime = '2000-01-01 11:12:13';
            $.ajax({
                url:"/api/admin/regByBean",
                type:"POST",
               data: adminInfo,
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }

            });
        });
        // ajax 传数组 集合 应用范围是批量删除 比如 ids[] = {1,3,5,7}
        $("#ajax03").click(function () {
            var ids = new Array();
                ids.push(3);
                ids.push(6);
                ids.push(9);
                ids.push(77);
                // 把数组 使用ajax 传递
            $.ajax({
                url:"/api/admin/ajax03",
                type:"POST",
                data: {'ids':ids},
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }

            });
        });
        $("#ajax04").click(function () {
                // json 对象 浏览器中看到请求是带颜色
            var adminInfo={
                adminName:"谢欣欣",
                adminTime:"2001-11-11 11:11:11",
                adminName:"11111",
                loverList:[
                    {
                      name:"薛",
                      age:"20",
                    },
                    {
                        name:"张",
                        age:"20",
                    },
                    {
                        name:"赵",
                        age:"20",
                    }],
                hobby:[7,9,13]
            };
            // var 出来的对象, 他是个对象 如果直接传输，www-utlxxxx传递的 黑色
            // 因为普通的请求是多个 k-v结构. 后台收取特别麻烦，所以就需要把复杂的对象转换成成本json对象
            // 然后后台 接收就方便多了 前后端项目 一般都是用json传递！！！
            $.ajax({
                url:"/api/admin/ajax04",
                type:"POST",
             // data:adminInfo, //普通的k-v 结构请求方式是: Content- Type: application/x- www form-url encoded; charset=UTF-8
                data:JSON.stringify(adminInfo), //变为json对象后，就需要Content-Type 更改为application/json;charset=UTF-8
                contentType:"application/json;charset=UTF-8",
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }

            });
        });
        $("#ajax05").click(function () {  //不常用

            $.ajax({
                url:"/api/admin/ajax05",
                type:"POST",
                 data: {
                    'lover.name':"薛老师",
                    'lover.age':18,
                    'dog.dogId':1002,
                    'dog.dogSex':"男",
                 },
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }

            });
        });
        $("#ajax06").click(function () {
            var loverList =[];
            for (var i =0 ; i < 5 ;i++){
                var lover={
                    name:'张'+i,
                    age: 18
                }
                loverList.push(lover)
            }
            // 多个对象 复杂的  就用 json
            $.ajax({
                url:"/api/admin/ajax06",
              //  type:"GET",  get请求是 无法 传输 json协议的 和 json数据的！！！
                type:"POST",
                 data:JSON.stringify(loverList),
                dataType:'JSON',
                contentType: "application/json;charset=UTF-8",
                success:function (res) {
                    console.log(res)
                }

            });
        });
        $("#ajax07").click(function () {
                var map = {
                    'adminName':'zhangsan',
                    'adminPwd':'123123',
                    'adminTime':'2011-11-11 11:11:11',
                }
                $.ajax({
                    url:'/api/admin/ajax07',
                    type:'POST',
                    data:JSON.stringify(map),
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    },
                    contentType:"application/json;charset=UTF-8"
                });
        });
        $("#ajax08").click(function () {  //常见于 分页查询
                $.ajax({
                    url:'/api/admin/ajax08',
                    type:'POST',
                    data: {
                        'name':'zhangsan',
                        'age':18,
                        'pageSize':5,
                        'page':2,
                    },
                    dataType:'JSON',
                    success:function (r) {
                        console.log(r)
                    },
                });
        });

    });
</script>
</body>
</html>
