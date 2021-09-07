<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet"  type="text/css" href="/res/layui-v2.5.6/layui/css/layui.css">
    <script src="/res/layui-v2.5.6/layui/layui.js"></script>
</head>
<body>
<div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>注册</legend>
    </fieldset>
    <form class="layui-form" action="" onsubmit="return false" >

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="adminName"  class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="adminPwd"  class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">重复密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="adminPwdR"  class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">入职时间</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="adminTime" id="adminTime" placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
<%--                <input type="radio" name="sex" value="禁" title="禁用" disabled="">--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">爱好</label>
            <div class="layui-input-block"  >
                <input type="checkbox" name="hobby" value="抽烟" title="抽烟">
                <input type="checkbox" name="hobby" value="喝酒" title="喝酒">
                <input type="checkbox" name="hobby" value="烫头" title="烫头">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">就业城市</label>
            <div class="layui-input-inline">
                <select name="city" lay-filter="aihao">
                    <option value="">请选择</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="广州">广州</option>
                    <option value="深圳">深圳</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">是否专升本</label>
            <div class="layui-input-block">
 <input type="checkbox" checked="" name="type" lay-skin="switch" lay-filter="switchTest" lay-text="是|否"  >

            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="regBtn">立即注册</button>
                <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
            </div>
        </div>
    </form>

</div>

<script>
    layui.use(  ['form','layer','jquery','laydate'], function () {
        var form = layui.form;
        var layer=layui.layer;
        var $=layui.jquery;
        var laydate=layui.laydate;

        laydate.render({
            elem:"#adminTime"
            ,type:'datetime'
        });
        form.on('submit(regBtn)',function (data) {
           // layer.msg(JSON.stringify(data.field));
            var a =""
            $("input:checkbox[name='checkbox']:checked").each(function(i){
                a += $(this).val()+" ";
            });
            a.trim()
            data.field.checkbox = a;
            $.ajax({
               // url:'/api/admin/reg',
               //url:'/api/admin/regByBean',
                url:'/api/admin/regAll',
                type:'POST',
                data: data.field,
                dataType:'json',

                success:function (res) {
                    console.log(res)
                    if(res.code==0){
                         window.location.href=("/pages/login")
                       // layer.msg(" 注册成功 ")
                    }else if(res.code==4401){
                        layer.msg("两次密码输入不一致,注册失败")
                    }else {
                        layer.msg("你的注册表单需要填写完整")
                    }
                }
            })
        });

        //监听 指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
        });
    });
</script>




</body>
</html>

