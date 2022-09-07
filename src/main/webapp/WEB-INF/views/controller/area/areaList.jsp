<%--
  Created by IntelliJ IDEA.
  User: zilet
  Date: 2022-03-02
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="/WEB-INF/tags" prefix="component" %>--%>
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
                        <h1 class="mt-4">공영 주차장</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">공영 주자창 등록 정보입니다. </li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                주차장 정보
                            </div>
                            <div class="card-body">
                                <div class="row mb-3" >
                                    <div class="col-2">
                                        <select class="form-select" aria-label="Default select example">
                                            <option value="1" selected>10</option>
                                            <option value="2">25</option>
                                            <option value="3">50</option>
                                        </select>
                                    </div>
                                    <div class="col-5">
                                    </div>
                                    <div class="col-5">
                                        <form class="d-flex">
                                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>
                                </div>
                                <table class="table table-hover table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">First</th>
                                            <th scope="col">Second</th>
                                            <th scope="col">Third</th>
                                            <th scope="col">Fourth</th>
                                            <th scope="col">Fifth</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach begin="1" end="10" varStatus="status">
                                            <tr>
                                                <td>${status.index}</td>
                                                <td>asldfj</td>
                                                <td>asdlfj</td>
                                                <td>alkdjf</td>
                                                <td>alskdjflas</td>
                                                <td>alskdjflas</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-5"></div>
                                    <div class="col-5"></div>
                                    <div class="col-2">
                                        <nav aria-label="Page navigation example">
                                            <ul class="pagination">
                                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
<%--                                <component:pageTag pageNumber="1" begin="1" end="3" isBeginOver="false" isEndOver="false"/>--%>
                            </div>
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