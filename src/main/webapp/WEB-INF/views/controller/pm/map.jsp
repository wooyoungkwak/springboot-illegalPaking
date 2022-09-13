<%--
  Created by IntelliJ IDEA.
  User: zilet
  Date: 2022-03-02
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<% String contextPath = request.getContextPath(); %>

<stripes:layout-render name="/WEB-INF/views/layout/navHtmlLayout.jsp">

    <!-- nav -->
    <stripes:layout-component name="nav">
        <stripes:layout-render name="/WEB-INF/views/layout/component/navLayout.jsp"/>
    </stripes:layout-component>

    <!-- side -->
    <stripes:layout-component name="side">
        <jsp:include page="side.jsp" flush="true"/>
    </stripes:layout-component>

    <!-- content -->
    <stripes:layout-component name="contents">
        <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">지도 보기</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> ${subTitle} > 지도 보기</li>
                        </ol>

                        <div class="row">
                            지도
                        </div>
                    </div>
                </main>
    </stripes:layout-component>

    <!-- javascript -->
    <stripes:layout-component name="javascript">
        <script src="<%=contextPath%>/resources/js/pm/map-scripts.js"></script>
    </stripes:layout-component>

</stripes:layout-render>