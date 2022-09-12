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

<stripes:layout-render name="/WEB-INF/views/layout/layout.jsp">

    <!-- nav -->
    <stripes:layout-component name="nav">
        <stripes:layout-render name="/WEB-INF/views/layout/nav.jsp"/>
    </stripes:layout-component>

    <!-- content -->
    <stripes:layout-component name="contents">
        <div id="layoutSidenav">

            <jsp:include page="side.jsp" flush="true" />

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">지도 보기</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> 공영주차장 > 지도 보기</li>
                        </ol>

                        <div class="row">
                            지도
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </stripes:layout-component>

    <!-- javascript -->
    <stripes:layout-component name="javascript">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<%=contextPath%>/resources/js/scripts.js"></script>
        <script src="<%=contextPath%>/resources/js/datatables-simple-demo.js"></script>
        <script src="<%=contextPath%>/resources/assets/demo/chart-area-demo.js"></script>
        <script src="<%=contextPath%>/resources/assets/demo/chart-bar-demo.js"></script>
    </stripes:layout-component>

</stripes:layout-render>