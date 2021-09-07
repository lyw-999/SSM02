
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的农场</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
    <div align="center">
        <h1 >我的农场</h1>
        农场主id:<input type="text" name="id"> 金币:1000  <br>
        农场主名称:张三


    <table>

        <tr><h2>可购买的种子列表</h2> </tr>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>操作</td>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="水稻"></td>
            <td><input type="text" name="price" placeholder="100"></td>
            <td><input type="text" name="count"  value="1"></td>
            <td><input type="button" value="购买" id="buy1"></td>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="玉米"></td>
            <td><input type="text" name="price" placeholder="150"></td>
            <td><input type="text" name="count" value="1"></td>
            <td><input type="button" value="购买" id="buy2"></td>
        </tr>

        <tr>
            <td><input type="text" name="name" id="name" placeholder="马铃薯"></td>
            <td><input type="text" name="price" id="price" placeholder="200"></td>
            <td><input type="text" name="count" id="count"  value="1"></td>
            <td><input type="button" value="购买" id="buy3"></td>
        </tr>

<%--        <tr>--%>
<%--            <td><input type="text" name="name"   placeholder="马铃薯"></td>--%>
<%--            <td><input type="text" name="price"  placeholder="200"></td>--%>
<%--            <td><input type="text" name="count"   value="1"></td>--%>
<%--            <td><input type="button" value="购买2" onclick="buy()"></td>--%>
<%--        </tr>--%>
    </table>

    </div>


    <script>
        $(function () {
            $("#buy3").click(function () {
            var name =$("#name").val();
            var price =$("#price").val();
            var count =$("#count").val();
            var map= {
                'name':name,
                'price':price,
                'count':count,
            }
            $.ajax({
                url:'/farm/buy',
                type:'POST',
                data:JSON.stringify(map),
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                },
                contentType:"application/json;charset=UTF-8"
            });
        })
        });
        $(function () {
            $("#buy1").click(function () {
                ("#buy1").parent.next.val()
                $.ajax({
                    url:'/farm/buy',
                    type:'POST',
                    data:JSON.stringify(map),
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    },
                    contentType:"application/json;charset=UTF-8"
                });
            });
            $("#buy2").click(function () {

                var map = {
                    'name':'玉米',
                    'price':150,
                    'count':1,
                }
                $.ajax({
                    url:'/farm/buy',
                    type:'POST',
                    data:JSON.stringify(map),
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    },
                    contentType:"application/json;charset=UTF-8"
                });
            });


            $("document").ready(function(){
                $("table").children().children().val();
            });
        });


    </script>
</body>
</html>
