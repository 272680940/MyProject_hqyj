<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <!-- bootstrap必须写的标签 -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>入住</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>

</head>

<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">入住信息</strong></div>
    <div class="padding border-bottom">
        <ul class="search">
            <li>
                <form action="/uc/enterPage.do">
                    <input type="text" name="hId" placeholder="搜索房间号"/>
                    <input type="submit" value="查询" class="button border-blue icon-edit"
                           style="padding:5px 15px; margin:0 10px;"/>
                </form>
            </li>
            <button style="padding:5px 15px; margin:0 10px;" class="btn btn-default btn-info"
                    id="vacant_room_btn"> 入住登记
            </button>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <%--  表头信息  --%>
        <tr>
            <th>房间号</th>
            <th>房型</th>
            <th>单价</th>
            <th>预订人</th>
            <th>状态</th>
            <th>手机号码</th>
            <th>操作</th>
        </tr>

        <%--  数据展示  --%>
        <c:forEach items="${map.pageInfo}" var="info">

            <tr>
                <input type="hidden" name="eId" value="${info.eId}">
                <td>${info.house.hId}</td>
                <td>${info.house.hAmount==1?"大床房":"双床房"}</td>
                <td>${info.house.hPrice}￥</td>
                <td>${info.customer.cName}</td>
                <td><c:if test="${info.eState==1}">已预订</c:if></td>
                <td>${info.customer.cPhone}</td>
                <td>
                    <div class="button-group">
                        <c:if test="${info.eState==1}">
                            <button class="button border-gray enter_btn" type="button" onclick="enterRoom(${info.customer.cId});"><span>入住</span></button>
                        </c:if>
                        <a class="button border-green" href="info.html"><span>详情</span></a>
                    </div>
                </td>
            </tr>
        </c:forEach>


        <%--  分页信息--%>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <a href="/uc/enterPage.do?currentPage=1">首页</a>
                    <c:if test="${map.isHasPreviousPage}">
                        <a href="/uc/enterPage.do?currentPage=${map.prePage}">上一页</a>
                    </c:if>
                    <span style="color: blue">${map.pageNum}</span>
                    <c:if test="${map.isHasNextPage}">
                        <a href="/uc/enterPage.do?currentPage=${map.nextPage}">下一页</a>
                    </c:if>
                    <a href="/uc/enterPage.do?currentPage=2">尾页</a>
                </div>
            </td>
        </tr>

    </table>
</div>

<!-- 客房登记模态框 -->
<div class="modal fade" id="room_regist_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" style="text-align: center">客房信息登记</h3>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房间号</label>
                        <div class="col-sm-5">
                           <input type="text" class="form-control" name="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房型</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="">
                        </div>
                        <label class="col-sm-2 control-label">楼层</label>
                        <div class="col-sm-3">
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">价格(天/元)</label>
                        <div class="col-sm-3">
                            <%-- house表中获取价格，以下拉框显示 --%>
                            <input type="text" class="form-control" name="">
                        </div>
                        <label class="col-sm-2 control-label">押金(元)</label>
                        <div class="col-sm-3">
                            <label style="line-height:32px;">100.0￥</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="width: 108px;">入住时间</label>
                        <div class="col-sm-5">
                            <input type="date" class="form-control" name="startTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="width: 108px;">预定退房时间</label>
                        <div class="col-sm-5">
                            <input type="date" class="form-control" name="endTimeEstimate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">入住者信息</label>
                        <div class="col-sm-10">
                            <textarea type="password" class="form-control" placeholder="请填写入住者的基本信息"
                                      style="margin: 0px 3.32813px 0px 0px; height: 79px; width: 464px;" name="customerInfo"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房间状态</label>
                        <div class="col-sm-10">
                            <input type="radio" name="state" value="1">已预约&nbsp;&nbsp;
                            <input type="radio" name="state" value="2">已入住&nbsp;&nbsp;
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="width: 108px;">缴费金额(元)</label>
                        <div class="col-sm-2">
                            <input type="password" class="form-control" placeholder="50.0">
                        </div>
                        <label class="col-sm-2 control-label">预订人:</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房间详情</label>
                        <div class="col-sm-10">
                            <%--
                                resize: none;  禁止拉伸
                                border:none;  隐藏外边框
                                readonly  不可编辑，但显示文字和滚动条
                                disabled  不可编辑，灰色显示文字，不显示滚动条
                            --%>
                            <textarea type="password" class="form-control" readonly="readonly"
                                      style="border:none;resize: none;margin: 0px 5.32813px 0px 0px; height: 98px; width: 464px;">
                                空调、洗衣机等等
                            </textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</body>


<script>

    //空房登记按钮点击事件
    $("#vacant_room_btn").click(function () {
        window.location.href = "/uc/vacantRoomPage.do";
    });


    //入住按钮点击事件
    function enterRoom(cId) {
        //准备展示在模态框的数据
        $.ajax({
            url:"",
            data:{cId:cId},
            dataType:"json",
            type:"GET",
            success:function (result) {

            }
        });
        $("#room_regist_modal").modal();
    };


</script>
</html>

